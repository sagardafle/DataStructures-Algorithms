/**
 * If we dont use 'volatile' keyword, the below program would behave diffrently in some implementation of Java Version.
 * The runner thread keeps a cache of the private variable(running) and might not see the changes that are made to this variable from an external thread(or main thread). 
 * To make the runner thread aware of these changes, we keep the variable "Volatile".
 * The value of this variable will never be cached thread-locally: all reads and writes will go straight to "main memory";
 */

import java.util.*;
class Processor extends Thread {
          private boolean running = true;
          public void run(){
                    while(running){
                              System.out.println("Hello ");
                               try{
                              Thread.sleep(1000);    
                              } catch (InterruptedException e){
                                        e.printStackTrace();
                              }
                    }
          }
          
          public void shutdown(){
                    running = false;
          }
}
          
          public class Volatile{
                    public static void main(String[] args){
                              Processor proc1 = new Processor();
                              proc1.start();
                              System.out.println("Press return to stop - 1" );
                              Scanner scanner = new Scanner(System.in);
                              scanner.nextLine();
                              proc1.shutdown();
                              
                              //The value for the volatile keyword will also change for proc2.
                              Processor proc2 = new Processor();
                              proc2.start();
                              System.out.println("Press return to stop - 2" );
                              proc2.shutdown();
                              
                              
                    }
          }
