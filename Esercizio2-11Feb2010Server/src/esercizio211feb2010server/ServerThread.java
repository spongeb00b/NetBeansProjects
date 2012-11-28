/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio211feb2010server;

import java.io.*;
import java.net.*;



/**
 *
 * @author raffaele
 */
public class ServerThread extends Thread {

    private Socket incoming;
    private Accumulatore a;

    ServerThread(Socket incoming, Accumulatore a) {
        this.incoming = incoming;
        this.a = a;
    }

    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
            String temp;
            int i;
            boolean done = false;
            while (!done) {
                temp = input.readLine();
                if(!temp.equals("BYE")){
                    i = Integer.parseInt(temp);
                    if (i % 2 == 0) 
                        synchronized (a) {
                            a.incrementa();
                            System.out.println("Ho ricevuto il valore " + i + " il numero di valori pari arrivati fino ad ora è: " + a.leggiAcc());
                        }
                    
                }else done = true;
                
            }
            incoming.close();
            input.close();
        }
        catch (NumberFormatException e){try {
                System.out.println(e);
                incoming.close();
                incoming.close();
            } catch (IOException ex) {System.out.println(ex);

            }
}
        catch (IOException ex) {
            System.out.println(ex);
        }

    }
}
