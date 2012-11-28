/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio218sett2007;

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
        lista.visualizza();
        lista.scriviFile("esame.txt");
        
    }

}
