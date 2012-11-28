/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientindovina;

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
        Socket socket = null;
        BufferedReader input = null;
        BufferedReader tastiera = null;
        PrintWriter output = null;
        //args[0] = "127.0.0.1";
        //args[1] = "3000";
        try {
            if (args.length == 2) {
                socket = new Socket(args[0], Integer.parseInt(args[1]));
                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                output = new PrintWriter(socket.getOutputStream(), true);
                tastiera = new BufferedReader(new InputStreamReader(System.in));
                String letto = "";
                while (true) {
                    letto = input.readLine();
                    if (letto != null) {
                        System.out.println("->" + letto);
                        if (letto.substring(0, 2).equals("Hai")) {
                            break;
                        } else {
                            output.println(tastiera.readLine());
                        }
                    } else {
                        break;
                    }
                }


            }



        } catch (UnknownHostException ex) {
            System.err.println("Host sconosciuto");
        } catch (IOException ex) {
            System.err.println("Errore: " + ex);
        } finally {
            try {
                if (output != null) {
                    output.close();
                }
                if (input != null) {
                    input.close();
                }
                if (tastiera != null) {
                    tastiera.close();
                }
                if (socket != null) {
                    socket.close();
                }

            } catch (IOException ex) {
                System.err.println("Errore: " + ex);
            }
        }

    }
}
