/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vettore;

/**
 *
 * @author raffaele
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Quicksort v = new Quicksort(20);
        v.riempiCasuale();
        System.out.println();
        v.stampa();
        v.ordinaQuick();
        System.out.println();
        v.stampa();
    }
}


