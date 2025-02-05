
public class SRP {
    // Class responsible for holding book details

    static class Book {

        private String title;
        private String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }
    }

// Class responsible for printing book details
    static class BookPrinter {

        public void printBook(Book book) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor());
        }
    }

    static class BookPersistence {

        public void saveToFile(Book book, String filename) {
            // Logic to save book details to a file
        }
    }

// Main Class to test the implementation
    public static void main(String[] args) {
        Book book = new Book("Clean Code", "Robert C. Martin");

        BookPrinter printer = new BookPrinter();
        printer.printBook(book); // Responsible for printing

        BookPersistence persistence = new BookPersistence();
        persistence.saveToFile(book, "book.txt"); // Responsible for saving
    }

}
