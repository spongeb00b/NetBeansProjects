/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio23sett2007server;

import java.net.*;
import java.io.*;


/**
 *
 * @author raffaele
 */
public class ServerThread extends Thread {

    BufferedReader inputFile;
    BufferedReader input;
    PrintWriter output;
    Socket socket;
    String nomeFile;

    ServerThread(Socket socket, String nomeFile) {
        this.socket = socket;
        this.nomeFile = nomeFile;
    }

    public void run() {
        try {
            inputFile = new BufferedReader(new FileReader(nomeFile));
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
            String lettoFile;
            while ((lettoFile = inputFile.readLine()) != null) {
                System.out.println("Ho appena letto dal file " + nomeFile + " il valore " + lettoFile + ", tasmissione a " + socket.getInetAddress() + " in corso...");
                output.println(lettoFile);
            }
            
            output.println("BYE");
            if(Main.conta == 5)
                    Main.conta = 0;
            inputFile.close();
            input.close();
            output.close();
            socket.close();



        } catch (Exception ex) {
            System.out.println("Errore: " + ex.getLocalizedMessage()+ " Disconnessione in corso..");
            try {
                Main.conta--;
                if(inputFile != null)
                    inputFile.close();
                output.close();
                socket.close();
            } catch (IOException ex1) {
                System.out.println("Errore: " + ex.getLocalizedMessage());
            }
        }

    }
}
