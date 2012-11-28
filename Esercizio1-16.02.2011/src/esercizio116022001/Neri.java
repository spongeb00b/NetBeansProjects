/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio116022001;

/**
 *
 * @author raffaele
 */
public class Neri extends Elettrodomestico {
    boolean digitale;

Neri(String name, String marca, double potenza, boolean digitale){
    super(name,marca,potenza);
    this.digitale = digitale;
}

double costo(){
    if(digitale)
        return (10*potenza)+50;
    return 10*potenza;
}


}
