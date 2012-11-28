/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package threadyield;

/**
 *
 * @author raffaele
 */
public class ComplexThread extends Thread {
    ComplexThread(String name) {super(name);}

    public void run(){
        while(true){
            System.out.println(Thread.currentThread().getName());
            Thread.yield();
        }
    }

}
