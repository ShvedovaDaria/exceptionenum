// InvalidYearException.java
public class InvalidYearException extends LibraryException {
    public InvalidYearException() {
        super(ErrorCode.INVALID_YEAR, "Invalid year of publication.");
    }
}