/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio141;

/**
 *
 * @author raffaele
 */
public class Elemento {
    int valore;
    Elemento successivo;


    Elemento(int valore, Elemento successivo){
        this.successivo = successivo;
        this.valore = valore;
    }


}
