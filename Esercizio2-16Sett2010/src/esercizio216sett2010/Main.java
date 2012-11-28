/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio216sett2010;

/**
 *
 * @author raffaele
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lista lista = new Lista(10);
        lista.stampaLista();
        System.out.println("\n"+lista.conta(300));
    }

}
