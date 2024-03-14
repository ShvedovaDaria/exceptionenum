// BookNotFoundException.java
public class BookNotFoundException extends LibraryException {
    public BookNotFoundException() {
        super(ErrorCode.BOOK_NOT_FOUND, "Book not found in the library.");
    }
}