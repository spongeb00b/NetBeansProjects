/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio22mar2011;

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
            ServerSocket server = new ServerSocket(8888);
            while (true) {
                Socket accetta = server.accept();
                System.out.println(accetta.getInetAddress()+" Si appena connesso al server!");
                ServerThread evvai = new ServerThread(accetta);
                evvai.start();
            }


        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
