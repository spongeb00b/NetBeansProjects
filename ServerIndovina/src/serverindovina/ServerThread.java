/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serverindovina;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raffaele
 */
public class ServerThread extends Thread {

    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;

    public ServerThread(Socket socket) {
        this.socket = socket;
        start();
    }

    public void run() {
        try {
            output = new PrintWriter(socket.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            int n = (int) ((Math.random() * 100) + 1);
            boolean continua = true;
            output.println("Ciao ho appena pensato un numero prova ad indovinarlo!!");
            int cont = 0;
            while (continua) {
                int tentativo = Integer.parseInt(input.readLine());
                if (tentativo > n) {
                    output.println("Troppo grande!!");
                    cont++;
                } else if (tentativo < n) {
                    output.println("Troppo piccolo!!");
                    cont++;
                } else {
                    cont++;
                    continua = false;

                }
            }
            output.println("Hai indovinato!! ci hai messo " + cont + " Tentativi!");
        } catch (IOException ex) {
            System.out.println("Errore: " + ex.getMessage());
        } finally {
            try {
                output.close();
                input.close();
            } catch (IOException ex) {
                System.out.println("Errore: " + ex.getMessage());
            }
        }



    }
}
