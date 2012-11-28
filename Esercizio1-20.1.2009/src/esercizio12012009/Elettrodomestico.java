/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio12012009;

/**
 *
 * @author raffaele
 */
public abstract class Elettrodomestico {

String colore;
double potenza;

Elettrodomestico(String colore, double potenza){
    this.colore = colore;
    this.potenza = potenza;
}


abstract double costo();


}
