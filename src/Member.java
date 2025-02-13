public class Member extends Thread {
    private Library l1;
    private String isbn;

    public Member() {
        l1 = new Library();
        isbn = "Ab11228";

    }

    public Member(Library l1) {
        this.l1 = l1;

    }

    public void run() {
        System.out.println(l1.findBookIndex(isbn));

        int i = l1.findBookIndex(isbn);

        System.out.println(l1.loanBook(i));
        Book b =l1.loanBook(i);//       l1.loanBook(l1.findBookIndex(isbn)); You can also do it in this way
        try {
            Thread.sleep(2000);

            l1.returnBook(b);
            System.out.println(b);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

