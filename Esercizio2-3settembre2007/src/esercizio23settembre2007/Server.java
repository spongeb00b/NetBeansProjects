/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio23settembre2007;

import java.io.*;
import java.net.*;
;

/**
 *
 * @author raffaele
 */
public class Server extends Thread {

    private String nomeFile;
    private Socket incoming;



    public Server(String file, Socket s) {
        nomeFile = file;
        incoming = s;
    }

    public void run(){
        try {
            BufferedReader input = new BufferedReader(new FileReader(nomeFile));
            PrintWriter out = new PrintWriter(incoming.getOutputStream(),true);
            String temp ;
            while((temp = input.readLine()) != null)
                out.println(temp);
            out.println("BYE");
            incoming.close();
        } catch (Exception ex) { System.out.println("Errore: "+ex); }

    }



}
