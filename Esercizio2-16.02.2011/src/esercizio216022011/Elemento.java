/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio216022011;

/**
 *
 * @author raffaele
 */
public class Elemento {
    String valore;
    Elemento successivo;

    Elemento(String valore, Elemento successivo){
        this.valore = valore;
        this.successivo = successivo;
    }

}
