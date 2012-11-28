/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package holiday;

/**
 *
 * @author raffaele
 */
public abstract class Vacanza {
    int partecipanti;
    String meta;

    Vacanza(int partecipanti, String meta){
        this.partecipanti = partecipanti;
        this.meta = meta;
    }
abstract int costo();

}
