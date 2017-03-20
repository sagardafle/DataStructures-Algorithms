/**
 * If you make a method synchronized, you are locking on the intrinsic lock of the object; 
 * this means there's only one lock so the program can only do one thing at a time, 
 * meaning there is no chance for stageOne and stageTwo to execute simultaneously.
 * In short, even if t1 is running stageOne(), t2 cannot run stageTwo() as t1 has acquired the intrinsic lock on the entire class object.
 * To overcome this limitation, we make use of synchronized blocks.
 */
import java.util.*;

public class SynchronizedBlock {
    private Random random = new Random();
    private List < Integer > list1 = new ArrayList < > ();
    private List < Integer > list2 = new ArrayList < > ();


    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void stageOne() {
        synchronized(lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(random.nextInt(100));
        }
    }

    public void stageTwo() {
        synchronized(lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(random.nextInt(100));
        }
    }

    public void process() {
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    public static void main(String[] args) {

        SynchronizedBlock obj = new SynchronizedBlock();
        System.out.println("Starting");
        Long start = System.currentTimeMillis();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                obj.process();
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                obj.process();
            }
        });
        t2.start();


        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Long end = System.currentTimeMillis();


        System.out.println("Time taken " + (end - start));
        System.out.println("List1 " + obj.list1.size());
        System.out.println("List2 " + obj.list2.size());

    }
}