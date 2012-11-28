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
public class Main {
static final int NUM_PORTA = 8888;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(NUM_PORTA);
            while(true){
                Socket inAscolto = server.accept();
                System.out.println(inAscolto.getInetAddress()+" Si è appena collegato al server");
                ServerThread thread = new ServerThread(inAscolto);
                thread.start();
            }


        } catch (IOException ex) {
           System.out.println(ex);
        }
    }

}
