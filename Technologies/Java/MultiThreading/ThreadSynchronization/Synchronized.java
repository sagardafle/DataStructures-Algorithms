/**
 * 
 * JOIN : 1. When a thread calls join,the current thread(main thread in below example) will not execute unless 
 *           the thread you have called (t1 and t2) join is finished. 
 *        2. This ensures that "System.out.println("Count: "+count);" 
 *           will be executed by the main method only when the t1 and t2 thread have completed their execution
 * 
 * SYNCHRONIZED: 1. Synchronized methods enable a simple strategy for preventing thread interference and memory consistency errors.
 *                  If an object is visible to more than one thread, all reads or writes to that object's variables are done through synchronized methods.
 *               2. When you have two threads that are reading and writing to the same 'resource', 
 *                  say a variable named 'count', you need to ensure that these threads access the variable in an atomic way. 
 *                  Without the synchronized keyword, your thread 1 may not see the change thread 2 made to count, or worse, it may only be half changed. 
 *                  This would not be what you logically expect.
 * 
 * */

public class Synchronized{
          private int count =0;
          public static void main(String[] args){
                  Synchronized sync = new Synchronized();
                  sync.doWork();
          }
          
          public synchronized void increment(){
                    count++;
          }
          
          public void doWork(){
                    Thread t1 = new Thread(new Runnable(){
                            public void run(){
                                      for(int i=0;i<10000;i++){
                                               increment();
                                      }
                            }  
                    });
                    
                     Thread t2 = new Thread(new Runnable(){
                            public void run(){
                                      for(int i=0;i<10000;i++){
                                               increment();
                                      }
                            }  
                    });
                    
                    t1.start();
                    t2.start();
                    
                    /* Join makes sure that the count will be displyaed only after t1 and t2 are done with their execution*/
                    try{
                              t1.join();
                              t2.join();    
                    } catch (InterruptedException e){
                            e.printStackTrace();  
                    }
                    
                    System.out.println("Count: "+count);
          }
}