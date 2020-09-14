package exceptions;

public class InvalidZipCodeException extends RuntimeException {
    public InvalidZipCodeException() {
    }

    public InvalidZipCodeException(String message) {
        super(message);
    }
}
