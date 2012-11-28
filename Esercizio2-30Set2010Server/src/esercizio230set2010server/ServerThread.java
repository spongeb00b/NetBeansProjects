/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio230set2010server;

import java.net.*;
import java.io.*;


/**
 *
 * @author raffaele
 */
public class ServerThread extends Thread {

    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;

    ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {

        try {
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
            int n = (int) ((Math.random() * 1000) + 1), cont = 0;
            double somma = 0;
            String leggi;
            output.println(n);
            System.out.println("Ho appena inviato da "+socket.getInetAddress()+" il numero: " + n);
            while (cont < n) {
                leggi = input.readLine();
                System.out.println("Ho appena ricevuto il valore "+leggi+" da "+socket.getInetAddress());
                somma += Double.parseDouble(leggi);
                cont++;
            }
            System.out.println("La media dei valori ricevuti dal client " + socket.getInetAddress() + " è: " + Math.round(somma / n * Math.pow(10, 2)) / Math.pow(10, 2));
            input.close();
            output.close();
            socket.close();


        } catch (NumberFormatException ex) {
            output.println("VALORE NUMERICO ERRATO DISCONNESSIONE IN CORSO...");
            try {
                input.close();
                output.close();
                socket.close();
            } catch (IOException ex1) {
                System.out.println(ex1);

            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
