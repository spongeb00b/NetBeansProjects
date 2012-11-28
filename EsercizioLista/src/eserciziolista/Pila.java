/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eserciziolista;

/**
 *
 * @author raffaele
 */
public class Pila extends Lista {
    
    
Elemento estrai(){
    Elemento temp = testa;
    if(temp != null) { //controlla se la testa vuota
        testa = testa.successivo;
        temp.successivo = null;
    }
    return temp;
}
    




}

