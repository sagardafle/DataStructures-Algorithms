/**
 * Created by Sagar on 4/5/2017.
 */

/**
 * PROBLEM STATEMENT:
 *Please write a program that does the following:
     1. A Producer class produces a randomly generated number
     2. The Producer class stores this number into a DataStore class
     3. A consumer class consumes a number from the DataStore class and displays it to System.out.
  The program should run until the Producer produces 100 numbers. 
  The Producer and Consumer should be running in parallel, in other words, the Consumer should be able to consume numbers before the Producer is done producing all 100 numbers.
 */

/**
 * <u>SOLUTION</u>:
 * The infamous traditional Producer-Consumer problem:
 * Producer-Consumer problem is a multi-process synchronization problem. Here producer and consumer works on a shared buffer(usually a Queue).
 * The producer adds the data onto the queue while the consumer pops the data and consumes the data.
 * However, problems arises when :
 * 1. Producer tries to produce (insert) the data when the Queue has reached its capacity.
 * 2. Consumer is trying to consume (read) the data when the Queue is empty.
 *
 * In order to handle this problem, it is of utmost importance that both the producer and the consumers shall avoid inserting and consuming data at certain times.
 * This is achieved via the inter-thread communication method 'notifyAll()'.
 * Basically, when the producer thread finishes working on the queue(adding the data to the queue), it notifies the consumer thread it can access that queue.
 * So, both the producer and consumer work in synchronization and appear to run in a parallel way.
 *
 * NOTE: In the below example, instead of a queue we have used a dummy DataStore class that acts as a buffer to store the data.
 */
import java.util.Random;

/**
 *  ParallelProducerConsumer is a class that illustrates the working of a Producer thread and a Consumer thread in a parallel fashion.
 This indirectly allows the consumer to work with the producer by eradicating the problem of deadlock.
 So, we can run a consumer without having it to wait for the producer to finish its job.

 */
public class ParallelProducerConsumer {
    /**
     * Main method initializes i.e creates new instances of the: DataStore class as well as the Producer and consumer class.
     * Once we have the instances of the producers and the consumers, we can start the respective threads.
     * @param args
     */
    public static void main(String[] args) {
        DataStore d = new DataStore();
        Producer p1 = new Producer(d);
        Consumer c1 = new Consumer(d);
        p1.start();
        c1.start();
    }
}

/**
 * A class that acts a Data storage between the consumer and a producer.
 * The producer is responsible for setting the data into the datastore
 * while the consumer is responsible to consume the data from the data store.
 */
class DataStore {

    /* The actual data that is to be produced and consumed. */
    private int contents;

    /* Whether or not the buffer(datastore) is available to work on. */
    private boolean available = false;

    /**
     * Gets the value within the datastore. If the datastore is unavailable, the wait() method is called.
     * @return the current contents within the datastore.
     */
    public synchronized int get() {
        while (available == false) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        available = false;
        /* Notify all the threads in the waiting list. (The Producer thread) */
        notifyAll();
        return contents;
    }

    /**
     * Sets the value in the datastore with the value passed into it. The value will be added to datastore only when the consumer thread is NOT using it.
     * @param value value that shall set into datastore.
     */
    public synchronized void put(int value) {
        while (available == true) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        contents = value;
        /* Set the datastore available to use after producer has added the data. */
        available = true;
        /* Notify all the threads in the waiting list. (The Consumer thread) */
        notifyAll();
    }
}

/**
 * Consumer class is a thread that is responsible for consuming the data within the datastore.
 */
class Consumer extends Thread {
    private DataStore datastore;

    /**
     * Receives the datastore instance
     * @param d The DataStore instance that will be used to set the consumer's datastore.
     */
    public Consumer(DataStore d) {
        this.datastore = d;
    }

    /**
     * The main function for the consumer thread.
     * This function executes when we execute the start() method on the consumer thread's instance.
     * It reads the data withing the datastore and prints it.
     */
    public void run() {
        int value;
        for (int i = 0; i < 100; i++) {
            value = datastore.get();
            System.out.println("Consumer got: " + value);
        }
    }
}

/**
 * Producer class is a thread that is responsible for producing (and setting) the data into the datastore.
 */
class Producer extends Thread {
    private DataStore dataStore;

    /**
     * Receives the datastore instance
     * @param d The DataStore instance that will be used to set the producer's datastore.
     */

    public Producer(DataStore d) {
        this.dataStore = d;
    }

    /**
     * The main function for the producer thread.
     * This function executes when we execute the start() method on the producer thread's instance.
     * It produces data with the help of the Math.random() function and adds that data into the datastore.
     */

    public void run() {
        /* creates at most 100 random elements */
        for (int i = 0; i < 100; i++) {
            /* The random number range is 1 to 101 */
            int randomnumber = new Random().nextInt(101) + 1;
            dataStore.put(randomnumber);
            System.out.println("Producer produced: " + randomnumber);
            try {
                /* causes the thread to sleep from 1 to 100 milliseconds. */
                sleep((int)(Math.random() * 101));
            } catch (InterruptedException e) {
                /* Prints the error stack trace when the sleep method throws an exception*/
                e.printStackTrace();
            }
        }
    }
}