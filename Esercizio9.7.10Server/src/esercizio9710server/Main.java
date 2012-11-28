/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio9710server;

import java.net.*;


/**Esercizio 2 (10 punti)
Si definisca un’applicazione client server basata su socket. Il server,
utilizzando i thread, deve poter rispondere contemporaneamente a piu' client.
Il client invia al server un intero casuale positivo.
Il server invia al client il massimo valore ricevuto finora dai vari client.
Il client stampa a video il valore ricevuto.
Se necessario si gestiscano le problematiche di sincronizzazione.

 *
 * @author raffaele
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Accumulatore acc = new Accumulatore();
        try {
            ServerSocket server = new ServerSocket(8080);
            while(true){
                Socket incoming = server.accept();
                System.out.println(""+incoming.getInetAddress()+" Si è appena collegato!");
                new ServerThread(incoming,acc).start();

            }
        } catch (Exception ex) {System.out.println(ex);}

    }

}
