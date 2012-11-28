/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package videoteca;

/**
 *
 * @author raffaele
 */
class Videoteca {
    Film catalogo[];


public Videoteca(int n){
    catalogo = new Film[n];
    for(int i = 0; i < catalogo.length; i++)
        if(i%2 == 0)
            catalogo[i] = new Commedia("Titolo"+(i+1),(int)(Math.random()*66)+1945,"Regista"+(int)((Math.random()*15)+1));
        else
            catalogo[i] = new Dramma("Titolo"+(i+1), (int)(Math.random()*66)+1945, (int)(Math.random()*11));
}


void stampaOrdine(){
    System.out.println("\nElenco copie richieste: \n");
    int conta = 0;
    for(int i = 0; i < catalogo.length; i++){
        conta += catalogo[i].copie();
        System.out.println("Titolo"+(i+1)+": "+catalogo[i].copie());
    }
    System.out.println("\nSi devono ordinare in totale "+conta+" copie\n");

}



void visualizzaCatalogo(){
    for(int i = 0; i < catalogo.length; i++)
        catalogo[i].mostra();
        
        
}

}


