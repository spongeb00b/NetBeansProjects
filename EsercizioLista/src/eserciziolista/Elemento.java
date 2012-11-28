/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eserciziolista;

/**
 *
 * @author biloange
 */
public class Elemento {
int valore;
Elemento successivo;

Elemento(int valore, Elemento successivo){
    this.valore = valore;
    this.successivo = successivo;
}    
}
