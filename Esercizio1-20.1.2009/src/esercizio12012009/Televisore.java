/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio12012009;

/**
 *
 * @author raffaele
 */
public class Televisore extends Elettrodomestico{

    int pollici;
    double canone;

    Televisore(String colore, double potenza, int pollici, double canone){
        super(colore,potenza);
        this.pollici = pollici;
        this.canone = canone;
    }

double costo(){
    return canone + (potenza*pollici);
}


}
