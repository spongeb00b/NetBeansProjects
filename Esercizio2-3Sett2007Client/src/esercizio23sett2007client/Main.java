/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio23sett2007client;

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
            Socket socket = new Socket("127.0.0.1", 8888);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
            String leggi;
            int somma = 0;
            while(!(leggi = input.readLine()).equals("BYE")){
                System.out.println("Ho ricevuto da "+socket.getInetAddress()+" il valore "+leggi);
                somma+=Integer.parseInt(leggi);
            }

            
            System.out.println("La somma dei valori ricevuti è: "+somma);


        } catch (UnknownHostException ex) {System.out.println("Host sconosciuto.. sicuro di averlo digitato bene??");

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

}
