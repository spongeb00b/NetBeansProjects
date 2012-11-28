/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio23sett2007server;

import java.net.*;
import java.io.*;

/**
 *
 * @author raffaele
 */
public class Main {

    static final int NUM_PORTA = 8888;
    static final int MAX_CONNECTIONS = 5;
    static final String nomeFile = "prova";
    public static int conta = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(NUM_PORTA);


            while (true) {

                if (Thread.activeCount() < MAX_CONNECTIONS + 1) {
                    Socket inAscolto = server.accept();
                    System.out.println(inAscolto.getInetAddress() + " Si è appena collegato al Server");
                    conta++;
                    ServerThread thread = new ServerThread(inAscolto, nomeFile + conta + ".txt");
                    thread.start();
                }


            }



        } catch (IOException ex) {
            System.out.println("Errore: " + ex.getMessage());
        }
    }
}
