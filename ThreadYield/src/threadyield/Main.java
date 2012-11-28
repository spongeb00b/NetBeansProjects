/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package threadyield;

/**
 *
 * @author raffaele
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ComplexThread("Thread 1").start();
        new ComplexThread("Thread 2").start();
    }

}
