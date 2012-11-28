/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio116022001;

/**
 *
 * @author raffaele
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Magazzino magazzino = new Magazzino(5,10);
        magazzino.visualizzaMagazzino();
        System.out.println("La media di costo per la Marca1 è: "+magazzino.media("Marca1")+" Euro");
    }

}
