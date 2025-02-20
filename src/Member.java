
public class Member extends Thread {
    private Library library;
    private String isbn;

    public Member() {
        library = new Library();
        isbn = "Ab11228";// Hardwired ISBN

    }

    public Member(Library l1) {
        this.library = l1;
        isbn = "Ab11228";
    }

    // this mehtod perfroms the book loan and return methods
    //It will execute as soon as the thread active
    public void run() {

        Book b = null;
//Find the index of the book with the hardwired ISBN
        int i = library.findBookIndex(isbn);
        System.out.println("book is at position: " + i);

// if the book is found, loan it from the list
        if (i != -1) {
            b = library.loanBook(i);     //library.loanBook(library.findBookIndex(isbn)); You can also do it in this way
            System.out.println("book:" + b);
        }


//            System.out.println("Book not been found");
        //Pauses execution before returning the book
        try {
            Thread.sleep(2000);
            System.out.println("returning book:" + b);
            library.returnBook(b);


            //System.out.println(b);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

