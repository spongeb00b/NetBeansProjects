/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eserciziothread;


/**
 *
 * @author raffaele
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimpleRunnable threadTest = new SimpleRunnable();

        for(;;){
            Thread t = new Thread(threadTest);
            System.out.println("Nuovo Thread "+(t == null ? "fallito" : "creato"));
            Thread t2 = new Thread(threadTest);
            System.out.println("Nuovo Thread "+(t2 == null ? "fallito" : "creato"));
            t.start();
            t2.start();
            try {
                t.join();//aspetta che il thread appena creato finisca il suo metodo run()
                t.yield();
            } catch (InterruptedException ex) {}
        }

    }

}
