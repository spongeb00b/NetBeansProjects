/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio9710client;

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
            Socket socket = new Socket("192.168.2.103", 8080);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
            int i = 0;
            while(i < 10){
                int n = (int)((Math.random()*1000)+1);
                System.out.println("ho generato il numero "+n+" invio al server in corso..");
                output.write(n+"\n");
                output.flush();
                int max = Integer.parseInt(input.readLine());
                System.out.println("il massimo dei valori inviati al server per adesso è "+max);
                i++;
            }

        } catch (Exception ex) {System.out.println(ex);}
    }

}
