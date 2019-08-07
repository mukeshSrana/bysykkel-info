package no.oslo.bysykkel.status.klient;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.REQUEST_TIMEOUT;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.lang.NonNull;
import org.springframework.web.client.ResponseErrorHandler;

public class HttpKlientErrorHandler implements ResponseErrorHandler {

    private static final Logger logger = LoggerFactory.getLogger(HttpKlientErrorHandler.class);
    private static final int KILO = 1024;

    @Override
    public void handleError(@NonNull ClientHttpResponse clientHttpResponse) {
        // Denne skal ikke kalles hvis man implementerer handleError(URI, HttpMethod, ClientHttpResponse)
    }

    @Override
    public boolean hasError(@NonNull ClientHttpResponse clientHttpResponse) throws IOException {
        return
            Arrays.asList(BAD_REQUEST, UNAUTHORIZED, FORBIDDEN, NOT_FOUND, REQUEST_TIMEOUT)
                .contains(clientHttpResponse.getStatusCode())
            || clientHttpResponse.getStatusCode().is5xxServerError();
    }

    @Override
    public void handleError(URI url, HttpMethod metode, @NonNull ClientHttpResponse clientHttpResponse)
        throws IOException {

        if (clientHttpResponse.getStatusCode().is5xxServerError()) {
            logger.info("Serveren feiler med status i 500-serien. status={}, meldingskropp={}",
                clientHttpResponse.getStatusCode(), parseBody(clientHttpResponse));
        } else if (clientHttpResponse.getStatusCode().is4xxClientError()) {
            switch (clientHttpResponse.getStatusCode()) {
            case BAD_REQUEST:
                logger
                    .error("Formatet på meldingen er feil. meldingskropp={}", parseBody(clientHttpResponse));
                break;
            case UNAUTHORIZED:
            case FORBIDDEN:
                logger.error("Vi blir stoppet i tilgangskontrollen. status={}, meldingskropp={}",
                    clientHttpResponse.getStatusCode(), parseBody(clientHttpResponse));
                break;
            case NOT_FOUND:
                logger.error("Finner ikke noe i andre enden av URL-en. Serveren melder 404.");
                break;
            case REQUEST_TIMEOUT:
                logger.info("Timeout på kall. meldingskropp={}", parseBody(clientHttpResponse));
                break;
            default:
                logger.error("statuskode={} treffer default switch case. meldingskropp={}",
                    clientHttpResponse.getStatusCode(), parseBody(clientHttpResponse));
            }
        }
        throw new HttpException(clientHttpResponse.getRawStatusCode(), url.toURL(), clientHttpResponse.getStatusText());
    }

    private String parseBody(ClientHttpResponse response) throws IOException {
        InputStream inputStream = response.getBody();
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[KILO];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        return result.toString("UTF-8");
    }
}
