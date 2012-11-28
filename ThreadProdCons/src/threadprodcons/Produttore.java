/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package threadprodcons;








/**
 *
 * @author raffaele
 */
public class Produttore extends Thread {

ThreadProdCons main;



Produttore(ThreadProdCons main){
    this.main = main;
}

public void run(){
    this.setPriority(MAX_PRIORITY);
    
    
        
        synchronized(main.v){
            int n = 0;
            n = (int)((Math.random()*97)+1); //genera un numero casuale da 1 a 10
            int somma = 0;
            for(int j = 0; j < n; j++){
                    main.v[j] = (int)(Math.random()*100+1);
                    if(j == n-1){
                        main.v[j] = -1;
                    }
                    else somma += main.v[j];
            }

            System.out.println("Ciao sono il Thread Produttore ho scritto valori casuali da 0 a "+(n-1));
            try {
                this.sleep(40);
            } catch (InterruptedException ex) {ex.printStackTrace();}
            System.out.println("(Thread PRODUTTORE):   ----------- La loro somma è: "+somma+" -----------");


        }

}

}
    
   
