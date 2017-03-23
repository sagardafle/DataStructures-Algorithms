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
                    runner1.start();
                    
                    //Create another Thread
                    Runner runner2 = new Runner();
                    runner2.start();
          }
}