


import java.util.ArrayList;

// Library class that allows users to add, find, loan , and  return book in the library
public class Library {
    private ArrayList<Book> books;


    public Library() {
        books = new ArrayList<>();


    }

    //The book object added to the list
    public void addBooks(Book bookDetails) {
        books.add(bookDetails);

    }

    // Search for a book and return index of that book
    public int findBookIndex(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equalsIgnoreCase(isbn))
                return i;
        }

        return -1;

    }

    //Loans abook by removing it form the list
    public Book loanBook(int index) {

        if (index == -1)
            return null;
        books.get(index);

        return books.remove(index);// Remove and returns the book form the list

    }
//Returns a book to the library list
    public void returnBook(Book bc) {
        books.add(bc);

    }

    // Main method adds, loans, return book in the library
    //Creates Library and member objects, and then start member threads interact with library
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Muhammad SAW", "Ibn Abdullah", "Ab11228", 1400);
        library.addBooks(book1);
//        System.out.println(" The book is : "+book1);
        //Creates two member threads
        Member member1 = new Member(library);
        Member member2 = new Member(library);

        //start both threads
        member1.start();
        member2.start();


    }
}
