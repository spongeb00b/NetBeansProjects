
 /* To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio23settembre2007;

import java.net.*;




/**
 *
 * @author raffaele
 * Esercizio 2 (10 punti)

Si definisca una applicazione client server basata su socket. Il server, utilizzando i thread,
deve poter rispondere contemporaneamente a piu' client.

Il server ha un campo nome (una stringa), il cui valore viene assegnato nel costruttore.
Il server apre il file che si chiama nome e che supponiamo contenga un intero per ogni riga.
Il server invia ai client i valori contenuti nel file.

Il server segnala il termine della trasmissione dei valori mandando il messagio "BYE".
Il client deve restituire la somma dei valori mandati dal server.
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            GeneraFile casuale = new GeneraFile("prova.txt");
            casuale.genera();
            ServerSocket s = new ServerSocket(8881);
            while(true){
                Socket incoming = s.accept();
                System.out.println(""+incoming.getInetAddress()+" Si è appena collegato!");
                new Server("prova.txt",incoming).start();
            }
       } catch (Exception ex) {System.out.println(ex);}

        }
    }


