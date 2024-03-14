// DuplicateBookException.java
public class DuplicateBookException extends LibraryException {
    public DuplicateBookException() {
        super(ErrorCode.DUPLICATE_BOOK, "Book with the same ISBN already exists in the library.");
    }
}

