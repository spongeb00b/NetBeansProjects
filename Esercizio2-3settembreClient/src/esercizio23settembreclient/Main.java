/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio23settembreclient;

import java.io.*;
import java.net.*;

/**Si definisca una applicazione client server basata su socket. Il server, utilizzando i thread,
deve poter rispondere contemporaneamente a piu' client.

Il server ha un campo nome (una stringa), il cui valore viene assegnato nel costruttore.
Il server apre il file che si chiama nome e che supponiamo contenga un intero per ogni riga.
Il server invia ai client i valori contenuti nel file.

Il server segnala il termine della trasmissione dei valori mandando il messagio "BYE".
Il client deve restituire la somma dei valori mandati dal server.
 *
 * @author raffaele
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.2.103", 8881);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String temp;
            int i, somma = 0;
            while ((temp = input.readLine()) != null) {
                if (!temp.equals("BYE")) {
                    System.out.println(temp);
                    i = Integer.parseInt(temp);
                    somma += i;
                }
                
                else{ System.out.println(temp); break;}
            }
            System.out.println("La somma dei valori letti del server è: " + somma);
        } catch (Exception ex) {
            System.out.println(ex);
        }



    }
}
