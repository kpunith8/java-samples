package main.com.java.example.solid;

// A class should only have one responsibility and should only have one reason to change.
public class SingleResponsibility {

    public static void main(String[] args) {
        Book book = new Book("Sapiens", "Yuval", "History of human kind");
        String replacedString = book.replaceWordInText("human", "Human");
        BookPrinter bookPrinter = new BookPrinter(book);

        System.out.println("Print the book content:");
        bookPrinter.printTextToConsole();
        System.out.println("replacedString: " + replacedString);
    }
}

class Book {
    private String name;
    private String author;
    private String text;

    public Book(String name, String author, String text) {
        this.name = name;
        this.author = author;
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String replaceWordInText(String word, String replacementString) {
        return text.replaceAll(word, replacementString);
    }

    public boolean isWordInText(String word) {
        return text.contains(word);
    }
}

// Instead of adding printTextToConsole or printToOtherMedia to Book class,
// we should create a new class BookPrinter and implement the same in that class,
// so that Book class is meant to do what it is intended to (single responsibility)
class BookPrinter {
    Book book;

    // Dependency Injection through constructor
    public BookPrinter(Book book) {
        this.book = book;
    }

    public void printTextToConsole() {
        System.out.println(book.getText());
    }

    // Add other methods related to print here to separate the responsibilities.
}