/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio22012009;

/**
 *
 * @author raffaele
 */
public class Lista {
    Elemento testa = null;
    int n;



    Lista(int n){
        this.n = n;
        for(int i = 0; i < n; i++){
            Elemento nuovo = new Elemento((int)(Math.random()*10)+1,testa);
            testa = nuovo;
        }
    }
 int contaValori(int n){
    int somma = 0;
    for(Elemento indice = testa; indice != null; indice = indice.next){
        if(indice.valore == n)
            somma+=n;
    }
    return somma;
}

void stampaValori(){
    int index = 1;
    for(Elemento indice = testa; indice != null; indice = indice.next){
        System.out.println("Elemento"+index+": "+indice.valore);
        index++;
    }
}

}
