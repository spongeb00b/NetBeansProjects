/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package holiday;

/**
 *
 * @author raffaele
 */
public class Crociera extends Vacanza {
    int porti;

Crociera(int partecipanti, String meta, int porti){
    super(partecipanti,meta);
    this.porti = porti;
}

int costo(){
    return partecipanti*porti;
}


}
