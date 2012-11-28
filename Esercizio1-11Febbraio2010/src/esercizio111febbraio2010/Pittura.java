/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio111febbraio2010;

/**
 *
 * @author raffaele
 */
public class Pittura extends Opera {


    double superfice;

Pittura(String autore, int anno, double superfice){
    super(autore,anno);
    this.superfice = superfice;
}

double costoRestauro(){
    return superfice + 3000 - anno;
}

}
