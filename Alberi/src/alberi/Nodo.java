/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package alberi;

/**
 *
 * @author raffaele
 */
public class Nodo {
    Nodo sinistro = null;
    Nodo destro = null;
    int valore = 0;


    Nodo(int value){
        valore = value;
        sinistro = null;
        destro = null;
    }
}
