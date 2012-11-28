/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package serverindovina;
import java.io.IOException;
import java.net.*;

/**
 *
 * @author raffaele
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ServerSocket inAscolto = null;
        try {
            inAscolto = new ServerSocket(3000);
            for(;;){
             new ServerThread(inAscolto.accept());
             System.out.println(inAscolto.getInetAddress()+" Si è appena collegato!!");
            }




        } catch (IOException ex) {
            System.err.println("Errore di rete: "+ex.getMessage());
        }

    }

}
