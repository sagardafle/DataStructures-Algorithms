// We will get interleaved outputs from both  the threads, as both will be running simultaneously.
class Runner implements Runnable{
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

public class ImplementingRunnableInterface {
          public static void main(String[] args){
                    Thread t1 = new Thread(new Runner());
                    Thread t2 = new Thread(new Runner());
          
                    t1.start();
                    t2.start();
          }
}