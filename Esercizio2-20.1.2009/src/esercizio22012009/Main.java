/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio22012009;

/**
 *
 * @author raffaele
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Lista lista = new Lista(40);
     lista.stampaValori();
     int numValori = lista.contaValori(1);
     if(numValori != 0)
         System.out.println("Ci sono "+numValori+" elemento/i nella lista uguale/i a 1");
     else
         System.out.println("Nessun un elemento della lista è uguale a 1");
    }

}
