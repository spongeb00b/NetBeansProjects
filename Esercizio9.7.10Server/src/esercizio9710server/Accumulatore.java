/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio9710server;

/**
 *
 * @author raffaele
 */
public class Accumulatore {

    private int cont = 0;

    public void sostituisci(int n) {
        cont = Math.abs(n);
    }

    int leggiValore() {
        return cont;
    }
}

