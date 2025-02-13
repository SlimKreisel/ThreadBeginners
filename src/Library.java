import javax.swing.*;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;


    public Library() {
        books = new ArrayList<>();


    }

    public void addBooks(Book b) {
        books.add(b);

    }

    public int findBookIndex(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equalsIgnoreCase(isbn))
                return i;
        }

        return -1;

    }

    public Book loanBook(int index) {

        if (index == -1)
            return null;
        books.get(index);

        return books.remove(index);

    }

    public void returnBook(Book bc) {
        books.add(bc);

    }

    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Muhammad SAW", "Ibn Abdullah", "Ab11228", 1400);
        library.addBooks(book1);

        Member m1 = new Member();
        Member m2 = new Member();

        m1.start();
        m2.start();


    }
}
