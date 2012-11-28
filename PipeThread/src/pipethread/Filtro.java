/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pipethread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author raffaele
 */
public class Filtro extends Thread {

    private DataInputStream ingresso;
    private DataOutputStream uscita;
    private double totale = 0;
    private int cont = 0;

    public Filtro(InputStream is, OutputStream os) {
        ingresso = new DataInputStream(is);
        uscita = new DataOutputStream(os);
    }

    public void run() {
        for (;;) {
            try {
                double x = ingresso.readDouble();
                totale += x;
                cont++;
                if (cont != 0) {
                    uscita.writeDouble(totale / cont);
                }
            } catch (IOException e) {
                System.out.println("Errore: " + e);
            }
        }
    }
}



