/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pipethread;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author raffaele
 */
public class Consumatore extends Thread {

    private double vecchiaMedia = 0;
    private DataInputStream ingresso;

    public Consumatore(InputStream is) {
        ingresso = new DataInputStream(is);

    }

    public void run() {
        for (;;) {
            try {
                double media = ingresso.readDouble();
                if (Math.abs(media - vecchiaMedia) > 0.001) {
                    System.out.println("Media corrente è: " + media);
                    vecchiaMedia = media;
                }
            } catch (IOException e) {
                System.out.println("Errore: " + e);
            }
        }
    }
}
