package no.oslo.bysykkel.status.klient;

import java.net.URL;

public class HttpException extends AbstractStatusCodeException {

    private static final long serialVersionUID = 1L;

    public HttpException(int statuskode, URL url, String errorMessage) {
        super(statuskode, "url=" + url + ", statuskode=" + statuskode + ", feilmelding=" + errorMessage);
    }
}
