/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package alberi;

/**
 *
 * @author raffaele
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        AlberoRicerca albero = new AlberoRicerca();
        int [] array = {30,7,8,24,5,4,57,45,10,6,15,3,32,2,11,74,};
        for(int i = 0; i < array.length; i++)
            albero.inserisci(array[i]);
        //albero.visitaAnticipata();
        //albero.visitaPosticipata();
        albero.visitaSimmetrica();
        albero.stampaRisultatoRicerca(75);
        System.out.println("L'altezza massima dell'albero è: "+albero.altezza());
}




}
