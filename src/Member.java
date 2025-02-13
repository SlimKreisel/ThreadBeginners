public class Member extends Thread{
    private Library l1;
    private String isbn;

    public Member(){
        l1 = new Library();
        isbn = "Ab11228";

    }
    public Member(Library l1){
        this.l1 = l1;

    }
}
