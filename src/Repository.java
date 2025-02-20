
public class Repository {
    private int number;
    boolean newValue = false;// Flag to track new vaue


    public Repository(int value) {
        this.number = value;
    }

    // This method retrieves the current number and is synchronized
    public synchronized int getNumber() {
        // waits until new value
        while (!newValue) {
            try {
                wait();// Release the lock and waits for notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        newValue = false;
        notify();//Notify that the value is changed

        return number;
    }

    // this method is synchronized and set a new number
    public synchronized void setNumber(int value) {
        //waits until last value is chnaged
        while (newValue) {
            try {
                wait();// Release the lock and waits for notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.number = value;
        newValue = true;

        notify();//Notify that the value is changed
    }
//Main method creates and start the Counter and Publisher threads

    public static void main(String[] args) {

        Repository repository = new Repository(0);//Initialse repository to start with the value 0

        Counter count = new Counter(repository); //Create a Counter Thread
        Publisher publish = new Publisher(repository);//Create a Publisher Thread

        count.start(); //Start the counter Thread
        publish.start();//Start the publsiher thread

    }
}


class Counter extends Thread {
    private Repository repo;

    public Counter(Repository repo) {
        this.repo = repo;
    }

    public void run() {
        int count = 0;
        while (true) {


            repo.setNumber(count);
            count++;


        }
    }
}


class Publisher extends Thread {
    private Repository repository;

    public Publisher(Repository repo) {
        this.repository = repo;
    }

    public void run() {

        while (true) {
            int value = repository.getNumber();


                System.out.println("The current value is: " + value);




        }


    }
}


