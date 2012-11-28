/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eserciziothread;

/**
 *
 * @author raffaele
 */
public class SimpleRunnable extends Thread {
    public void run(){
        System.out.println("Thread: "+Thread.currentThread().getName());
    }

}
