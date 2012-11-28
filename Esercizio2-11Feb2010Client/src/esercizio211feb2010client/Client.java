/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio211feb2010client;

import java.io.*;
import java.net.*;


/**
 *
 * @author raffaele
 */
public class Client {

    Client(int n) {
        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            for (int i = 0; i < n; i++) {
                if (i == n - 1) {
                    System.out.println("Disconnessione dal Server in corso...");
                    output.println("BYE");
                } else {
                    int invia = (int) ((Math.random() * 10000) + 1);
                    output.println(invia);
                    System.out.println("Ho appena inviato al server il numero: " + invia);

                }
            }

            socket.close();
            output.close();


        } catch (Exception ex) {
            System.out.println(ex);
        }




    }
}