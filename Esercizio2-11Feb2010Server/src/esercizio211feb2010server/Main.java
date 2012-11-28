/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio211feb2010server;

import java.io.*;
import java.net.*;

/**
 *
 * @author raffaele
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Accumulatore a = new Accumulatore();
        try {
            ServerSocket server = new ServerSocket(8888);
            while (true) {
                Socket incoming = server.accept();
                System.out.println(incoming.getInetAddress() + " Si è appena collegato al server!");
                new ServerThread(incoming, a).start();

            }
        } catch (IOException ex) {
            System.out.println(ex);
        }





    }
}
