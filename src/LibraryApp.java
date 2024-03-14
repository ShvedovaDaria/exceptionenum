import java.util.List;
import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();

        // Добавление книг в библиотеку
        library.addBook("Java Programming", "John Doe", 2020, "1234567890");
        library.addBook("Python Basics", "Jane Smith", 2019, "0987654321");
        library.addBook("JavaScript Fundamentals", "David Johnson", 2021, "2468135790");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Find Book By ISBN");
            System.out.println("4. Find Books By Author");
            System.out.println("5. Find Books By Year");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    try {
                        library.addBook(title, author, year, isbn);
                        System.out.println("Book added successfully.");
                    } catch (DuplicateBookException | InvalidYearException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Enter ISBN of the book to remove: ");
                    String isbnToRemove = scanner.nextLine();
                    try {
                        library.removeBook(isbnToRemove);
                        System.out.println("Book removed successfully.");
                    } catch (BookNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Enter ISBN of the book to find: ");
                    String isbnToFind = scanner.nextLine();
                    try {
                        Book foundBook = library.findBookByIsbn(isbnToFind);
                        System.out.println("Book found: " + foundBook.getTitle());
                    } catch (BookNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Enter author name: ");
                    String authorToSearch = scanner.nextLine();
                    List<Book> booksByAuthor = library.findBooksByAuthor(authorToSearch);
                    if (booksByAuthor.isEmpty()) {
                        System.out.println("No books found by this author.");
                    } else {
                        System.out.println("Books found by author " + authorToSearch + ":");
                        for (Book book : booksByAuthor) {
                            System.out.println(book.getTitle());
                        }
                    }
                    break;
                case 5:
                    System.out.print("Enter year: ");
                    int yearToSearch = scanner.nextInt();
                    List<Book> booksByYear = library.findBooksByYear(yearToSearch);
                    if (booksByYear.isEmpty()) {
                        System.out.println("No books found in the year " + yearToSearch + ".");
                    } else {
                        System.out.println("Books found in the year " + yearToSearch + ":");
                        for (Book book : booksByYear) {
                            System.out.println(book.getTitle());
                        }
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
