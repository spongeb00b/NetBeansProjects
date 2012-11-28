/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pipethread;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.Random;

/**
 *
 * @author raffaele
 */
public class Produttore extends Thread {

    private DataOutputStream uscita;
    private Random random = new Random();

    public Produttore(OutputStream os) {
        uscita = new DataOutputStream(os);
    }

    public void run() {
        while (true) {
            try {
                double casuale = random.nextDouble();
                uscita.writeDouble(casuale);
                uscita.flush();
                sleep(Math.abs(random.nextInt() % 1000));
            } catch (Exception e) {
                System.out.println("Errore: " + e);
            }
        }
    }
}
