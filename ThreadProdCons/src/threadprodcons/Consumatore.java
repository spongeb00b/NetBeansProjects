/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package threadprodcons;




/**
 *
 * @author raffaele
 */
public class Consumatore extends Thread {

ThreadProdCons main;
int somma = 0;
int letti = 0;

Consumatore(ThreadProdCons main){
    this.main = main;

}

public void run(){
    
    boolean done = false;
    this.setPriority(MIN_PRIORITY);
    int i = 0;
    synchronized(main){
             while(!done){
                somma += main.v[i];
                letti++;
                i++;
                if(main.v[i] == -1){
                    done = true;
                }
            }
    }
    System.out.println("Ciao sono "+Thread.currentThread().getName()+" ho letto da 0 a "+(i-1));
    System.out.println("Valori letti: "+letti+" Somma: "+somma);
       
    

    
    
  }


}


