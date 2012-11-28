/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package videoteca;

/**
 *
 * @author raffaele
 */
class Dramma extends Film {
    int premi;

Dramma(String titolo, int anno, int premi){
    super(titolo, anno);
    this.premi = premi;
}

int copie(){
    return premi+1;
}

void mostra(){
    System.out.println("Film: "+titolo+" Anno: "+anno+" Oscar: "+premi+" Genere: "+getClass().getSimpleName());
}
}
