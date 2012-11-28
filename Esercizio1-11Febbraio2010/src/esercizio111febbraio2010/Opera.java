/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio111febbraio2010;

/**
 *
 * @author raffaele
 */
public abstract class Opera {
    String autore;
    int anno;

    Opera(String autore, int anno){
        this.autore = autore;
        this.anno = anno;
    }


abstract double costoRestauro();
}