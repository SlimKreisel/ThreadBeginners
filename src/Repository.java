public class Repository {
    private int number;
    boolean newValue;


    public Repository(int value){
        this.number=value;
    }
    public int getNumber(){
        return number;
    }

    public void setNumber(int value){
        this.number=value;
    }
    public static void main(String [] args){

        Repository repository = new Repository(0);

        Counter count = new Counter(repository);
        Publisher publish = new Publisher(repository);

        count.start();
        publish.start();

    }
}


class Counter extends Thread{
    private Repository repo ;

    public Counter(Repository repo){
        this.repo = repo;
    }
    public void run() {
int count =0;
        while (true) {


            try {
                repo.setNumber(count);
                Thread.sleep(400);
                count++;


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}


class Publisher extends Thread{
    private Repository repository ;

    public Publisher(Repository repo){
        this.repository = repo;
    }

    public void run(){

        while(true){
            int value = repository.getNumber();
            System.out.println("The current value is: "+value);

            try{

                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }


    }
}


