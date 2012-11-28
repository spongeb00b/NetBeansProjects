/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio12mar2011;

/**
 *
 * @author raffaele
 */
public class Drammatico extends Oscar{
    int numNomination;


Drammatico(String nome, int eta, int numFilm, int numNom){
    super(nome,eta,numFilm);
    numNomination = numNom;
}


double calcolaProb(){
    return numNomination*eta;
}

}
