/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio116022001;

/**
 *
 * @author raffaele
 */
public class Bianchi extends Elettrodomestico{
    int classeEcologica;

    Bianchi(String nome, String marca, double potenza, int classe){
        super(nome,marca,potenza);
        classeEcologica = classe;
    }

double costo(){
    return (5*potenza)+(50*classeEcologica);
}


}
