/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio230set2010client;
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
            Socket socket = new Socket("192.168.0.5", 8888);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
            int num = Integer.parseInt(input.readLine());
            System.out.println("ho appena ricevuto dal server "+socket.getInetAddress()+" il valore: "+num);
            for(int i = 0; i < num; i++){
                int random = (int)((Math.random()*6000)+1);
                System.out.println((i+1)+") Ho appena generato il numero causale "+random+" invio al server "+socket.getInetAddress()+" in corso..");
                output.println(random);
            }
        System.out.println("Trasmissione valori al server "+socket.getInetAddress()+" conclusa correttamente");
        }catch (UnknownHostException ex) {
            System.out.println("Host sconosciuto hai inserito correttamente il suo indirizzo??");
        } catch (IOException ex) {
            System.out.println("Errore: "+ex.getMessage());
        }
    }

}
