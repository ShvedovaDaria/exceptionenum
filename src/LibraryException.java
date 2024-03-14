// LibraryException.java
public abstract class LibraryException extends RuntimeException {
    private final ErrorCode errorCode;

    public LibraryException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
