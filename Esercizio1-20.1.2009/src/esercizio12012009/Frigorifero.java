/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio12012009;

/**
 *
 * @author raffaele
 */
public class Frigorifero extends Elettrodomestico{

    int capienza;

    Frigorifero(String colore, double potenza, int capienza){
        super(colore, potenza);
        this.capienza = capienza;
    }

    double costo(){
        return potenza*capienza;
    }

}
