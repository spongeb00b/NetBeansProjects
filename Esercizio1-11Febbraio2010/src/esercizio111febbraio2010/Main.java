/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio111febbraio2010;

/**
 *
 * @author raffaele
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Museo museo = new Museo(50);
        museo.visualizzaOpere();
        System.out.println("\nIl costo di restauro maggiore per le opere elencate è: "+museo.maxCosto()+" Euro\n");
    }

}
