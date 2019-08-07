package no.oslo.bysykkel.status.klient;

public abstract class AbstractStatusCodeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final int statusCode;

    protected AbstractStatusCodeException(int statusCode, String message) {
        super(message, null, true, false);
        this.statusCode = statusCode;
    }

    protected AbstractStatusCodeException(int statusCode, String message, Throwable cause) {
        super(message, cause, true, false);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
