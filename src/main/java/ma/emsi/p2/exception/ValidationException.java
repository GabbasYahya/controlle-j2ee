package ma.emsi.p2.exception;



public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}