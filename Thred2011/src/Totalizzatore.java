/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author raffaele
 */
public class Totalizzatore {


    private int totale = 0;


    synchronized public void incrementa(int n){
        totale += n;


    }

    public int getTotale() {
        return totale;
    }


}
