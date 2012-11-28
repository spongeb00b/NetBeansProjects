/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio116022001;

/**
 *
 * @author raffaele
 */
public abstract class Elettrodomestico {
    String nome;
    String marca;
    double potenza;

Elettrodomestico(String nome, String marca, double potenza){
    this.nome = nome;
    this.marca = marca;
    this.potenza = potenza;
}

abstract double costo();
}
