/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio111febbraio2010;

/**
 *
 * @author raffaele
 */
public class Scultura extends Opera{
    double peso;

Scultura(String autore, int anno, double peso){
    super(autore,anno);
    this.peso = peso;
}

double costoRestauro(){
   return Math.abs(peso*1.5 - anno);
}


}
