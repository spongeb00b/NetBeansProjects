/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package holiday;

/**
 *
 * @author raffaele
 */
public class Escursione extends Vacanza {
    int chilometri;

Escursione(int partecipanti, String meta, int chilometri){
    super(partecipanti,meta);
    this.chilometri = chilometri;
}


int costo(){
    return chilometri*10 + partecipanti;
}

}
