public class NumberException extends Exception {
    ErrorCode code;

    public NumberException(String message, ErrorCode code) {
        super(message);
        this.code = code;
    }

    public NumberException(String message) {
        super(message);
    }

    public NumberException(String message, Throwable cause) {
        super(message, cause);
    }
}
