import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;


    public Library(){
        books = new ArrayList<>();



    }

    public void addBooks(Book b){
        books.add(b);

    }

    public int findBookIndex(String isbn){
        for(int i =0; i<books.size(); i++){
            if(books.get(i).getIsbn().equalsIgnoreCase(isbn))
                return i;
        }

        return -1;

    }

    public Book loanBook(Book remover){
        for(int i = 0; i<books.size();i++){
            if(books.get(i).equals(remover)){
                books.remove(remover);

            }
        }
        return null;
    }

    public void returnBook(Book bc){
        books.add(bc);

    }
    public static void main(String [] args){
        Library library = new Library();

        Book book1 = new Book("Muhammad","Ibn Abdullah","Ab11228", 1400);
        library.addBooks(book1);

//        Member m1 =


    }
}
