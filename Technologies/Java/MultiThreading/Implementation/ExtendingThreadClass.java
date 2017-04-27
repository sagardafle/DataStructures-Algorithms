// We will get interleaved outputs from both  the threads, as both will be running simultaneously.
class Runner extends Thread{
          public void run(){
                    for(int i=0; i<10; i++)
                              System.out.println("Hello "+i+ " ");
                    try{
                              Thread.sleep(1000);    
                    } catch (InterruptedException e){
                              e.printStackTrace();
                    }
          }
}

public class ExtendingThreadClass {
          public static void main(String[] args){
                    Runner runner1 = new Runner();
                    System.out.println("Starting Thread-1");
                    runner1.start();
                    
                    try{
                              runner1.join(); //will make sure that Thread 2 will start only after the execution of thread1.
                    }catch(Exception e){
                              e.printStackTrace();
                    }
                    
                    //Create another Thread
                    Runner runner2 = new Runner();
                    System.out.println("Starting Thread-2");
                    runner2.start();
          }
}