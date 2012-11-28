/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio12mar2011;

/**
 *
 * @author raffaele
 */
public class Comico extends Oscar{
   double sommaInc;

Comico(String nome, int eta, int numFilm, float sommaInc){
    super(nome,eta,numFilm);
    this.sommaInc = sommaInc;
}


double calcolaProb(){
    return  sommaInc/eta;
}



}
