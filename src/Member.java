public class Member extends Thread {
    private Library library;
    private String isbn;

    public Member() {
        library = new Library();
        isbn = "Ab11228";

    }

    public Member(Library l1) {
        this.library = l1;
        isbn = "Ab11228";
    }

    public void run() {

        Book b = null;

        int i = library.findBookIndex(isbn);
        System.out.println("book is at position: " + i);

//
            if( i != -1){
                 b =library.loanBook(i);     //library.loanBook(library.findBookIndex(isbn)); You can also do it in this way
                System.out.println("book:" + b);
            }



//            System.out.println("Book not been found");

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

