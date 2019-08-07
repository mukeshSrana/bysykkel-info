package no.oslo.bysykkel.status;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import no.oslo.bysykkel.status.klient.HttpKlientErrorHandler;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
        restTemplate.setErrorHandler(new HttpKlientErrorHandler());
        return restTemplate;
    }

    private SimpleClientHttpRequestFactory getClientHttpRequestFactory() {
        int timeout = 10_000;

        SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(timeout);
        clientHttpRequestFactory.setReadTimeout(timeout);

        return clientHttpRequestFactory;
    }
}
