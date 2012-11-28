/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pipethread;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 *
 * @author raffaele
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            PipedOutputStream pout1 = new PipedOutputStream();
            PipedInputStream pin1 = new PipedInputStream(pout1);
            PipedOutputStream pout2 = new PipedOutputStream();
            PipedInputStream pin2 = new PipedInputStream(pout2);
            Produttore prod = new Produttore(pout1);
            Filtro filt = new Filtro(pin1, pout2);
            Consumatore cons = new Consumatore(pin2);

            prod.start();
            filt.start();
            cons.start();
        } catch (IOException e) {
        }
    }
}
