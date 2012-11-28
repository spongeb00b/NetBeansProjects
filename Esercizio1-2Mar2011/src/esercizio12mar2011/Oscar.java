/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio12mar2011;

/**
 *
 * @author raffaele
 */
public abstract class Oscar {
    String nome;
    int eta;
    int numFilm;

Oscar(String nome, int eta, int numFilm){
    this.nome = nome;
    this.eta = eta;
    this.numFilm = numFilm;
}

abstract double calcolaProb();

}
