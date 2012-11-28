/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio22mar2011client;

import java.net.*;
import java.io.*;

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
            int randomNum = (int) ((Math.random() * 100) + 1);
            Socket server = new Socket("127.0.0.1", 8888);
            BufferedReader input = new BufferedReader(new InputStreamReader(server.getInputStream()));
            PrintWriter output = new PrintWriter(server.getOutputStream(), true);
            String leggi;
            int total = 0;
            output.println(randomNum);
            while ((leggi = input.readLine()) != null) {
                System.out.println("Valore letto: "+leggi);
                total += Integer.parseInt(leggi);
            }
            System.out.println("Somma dei valori ricevuti dal Server: " + total);
            if (total % 2 == 0) {
                System.out.println("PARI");
            } else {
                System.out.println("DISPARI");
            }

        } catch (UnknownHostException ex) {
            System.out.println("Errore indirizzo sconosciuto:" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
