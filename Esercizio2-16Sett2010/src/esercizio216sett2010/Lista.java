/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio216sett2010;

/**
 *
 * @author raffaele
 */
public class Lista {

Elemento testa = null;


Lista(int n){
    for(int i = 0; i < n; i++){
        Elemento successivo = new Elemento((int)((Math.random()*10)+1),testa);
        testa = successivo;
    }
}

void stampaLista(){
    int conta = 0;
    for(Elemento i = testa; i != null; i = i.next){
        System.out.println((conta+1)+") Elemento: "+i.valore);
        conta++;
    }
}

int conta(int n){
    int somma = 0, conta = 1;
    for(Elemento i = testa; i != null; i = i.next){
        somma += i.valore;
        if(somma > n)
            return conta;
        conta++;
    }
    return -1;
}

}
