/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package holiday;

/**
 *
 * @author raffaele
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Archivio lista = new Archivio(25,30);
    lista.stampaArchivio();
    System.out.println("\nLa vacanza con il costo minore è :"+lista.costoMinore(3));
    }

}
