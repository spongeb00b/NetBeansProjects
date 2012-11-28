/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package videoteca;

/**
 *
 * @author raffaele
 */
class Commedia extends Film {
String regista;

Commedia(String titolo, int anno, String regista){
    super(titolo, anno);
    this.regista = regista;
    
}

int copie(){
    int differenza = anno - 2000;
    if(differenza >= 0)
        return differenza;
    return 1;


}

void mostra(){
    System.out.println("Film: "+titolo+" Anno: "+anno+" Regista: "+regista+" Genere: "+getClass().getSimpleName());
}

}