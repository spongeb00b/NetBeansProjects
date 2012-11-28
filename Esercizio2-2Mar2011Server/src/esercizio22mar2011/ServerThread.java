/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio22mar2011;

import java.net.*;
import java.io.*;


/**
 *
 * @author raffaele
 */
public class ServerThread extends Thread {

    Socket socket;
    BufferedReader input;
    PrintWriter output;

    ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
            String leggi = input.readLine();
            System.out.println(socket.getInetAddress()+" Ti ha appena mandato il numero "+leggi);
            int num = Integer.parseInt(leggi);
            for (int i = 0; i < num; i++) {
                output.println((int) (Math.random() * 10000));
            }
            input.close();
            output.close();
            socket.close();





        } catch (NumberFormatException e) {
            output.println("DATO ERRATO CHIUSURA IN CORSO!!");
            try {
                output.close();
                input.close();
                socket.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
