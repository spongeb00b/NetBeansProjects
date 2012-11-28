/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio216022011;

/**
 *
 * @author raffaele
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Lista lista = new Lista();
       lista.riempiLista();
       lista.stampaLista();
       String confronto = "prova"; //cambiare il valore di confronto per confrontare con altre stringhe
       System.out.println("\nCi sono "+lista.conta(confronto)+" stringhe che in ordine alfabetico vengono prima di: "+confronto);
    }

}
