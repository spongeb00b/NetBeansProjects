/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio9710server;

import java.net.*;
import java.io.*;

/**
 *
 * @author raffaele
 */
public class ServerThread extends Thread {

    private Socket incoming;
    private Accumulatore a;

    public ServerThread(Socket incoming, Accumulatore a) {
        this.incoming = incoming;
        this.a = a;
    }

    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
            PrintWriter output = new PrintWriter(incoming.getOutputStream(), true);
            int i;
            String temp;
            while ((temp = input.readLine()) != null) {
                if (temp.equals("azzera")) {
                    synchronized (a) {
                        a.sostituisci(0);
                        System.out.println("Il massimo per adesso è: " + a.leggiValore());
                    }
                } else {
                    i = Integer.valueOf(temp);
                    System.out.println("ho ricevuto dal client " + incoming.getInetAddress() + " il numero: " + i);
                    synchronized (a) {
                        if (i > a.leggiValore()) {
                            a.sostituisci(i);
                        }
                        System.out.println("Il massimo per adesso è: " + a.leggiValore());
                        output.write(+a.leggiValore() + "\n");
                        output.flush();

                    }
                }

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
