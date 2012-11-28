/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eserciziolista;

/**
 *
 * @author biloange
 */
public class Lista {

    Elemento testa = null;

Lista(int n){
    Elemento temp;
    for(int i = 0; i < n; i++){
        temp = new Elemento((int)((Math.random()*10))+1, testa); //+1 include anche 10
        testa = temp;
    }
}

Lista(){
    testa = null;
}

void visualizza(){
    int n = 0;
    for(Elemento i = testa ; i != null; i = i.successivo){
        n++;
        System.out.println("Elemento "+n+" -> "+i.valore);
    }

}
void incrementa(int n){
    Elemento i = testa;
    while(i != null){
        i.valore += n;
        i = i.successivo;
    }
}
    
int contaElementi(){
    int temp = 0;
    for(Elemento i = testa ; i != null; i = i.successivo)
        temp++;
    return temp;
    
}

private int contaElementiRic(Elemento i){
    if(i == null)
        return 0;
    return 1+contaElementiRic(i.successivo);
    }



public int contaElementiRic(){
    return contaElementiRic(testa);
}



int conta(int n){
    int temp = 0;
    for(Elemento i = testa ; i != null; i = i.successivo)
        if(i.valore == n)
        temp++;
    return temp;
    }

void separaRiga(){
    System.out.println();
}

private void visualizzaR(int i, Elemento attuale){
    if(attuale != null){
        System.out.println("Elemento "+i+" -> "+attuale.valore);
        visualizzaR(i+1, attuale.successivo);
    }
}
void visualizzaR(){
    visualizzaR(1 , testa);
}

double media(){
    int temp = 0, somma = 0;
    for(Elemento i = testa ; i != null; i = i.successivo){
        somma+=i.valore;
        ++temp;
    }
return (double)somma/temp;
}

int somma(){
    int somma = 0;
    for(Elemento i = testa; i != null; i = i.successivo)
        somma+=i.valore;
    return somma;
}

int massimo(){
    Elemento i = testa;
    int max = i.valore;
    for(i = testa; i != null; i = i.successivo) {
        if(i.valore > max) {
            max = i.valore;
        }
    }
    return max;
}

int minimo(){
    Elemento i = testa;
    int min = i.valore;
    for(i = testa; i != null; i = i.successivo) {
        if(i.valore < min) {
            min = i.valore;
        }
    }
    return min;
}

int moda(){
    
    int conta = 0, moda = 0, contamoda = 0;
    for(Elemento i = testa; i != null; i = i.successivo){
        for(Elemento k = i; k != null; k = k.successivo) {
            if(i.valore == k.valore) {
                conta++;
            }
        }
        if(conta > contamoda){
             moda = i.valore;
             contamoda = conta;
            }
    conta = 0;
    }
    return moda;
    
}

void ordina(){
    int temp = 0;
    for(Elemento i = testa; i != null; i = i.successivo)
        for(Elemento k = i.successivo; k != null; k = k.successivo)
            if(k.valore < i.valore){
                temp = i.valore;
                i.valore = k.valore;
                k.valore = temp;
            }
}
int contaMinori(int n){
    int conta = 0;
    for(Elemento i = testa; i != null; i = i.successivo)
        if(i.valore < n)
            conta++;
        else break;
   return conta;
}

Elemento concatenaLista(Elemento lista1, Elemento lista2){
    Elemento i = lista1;
    for(i = testa; i.successivo != null; i = i.successivo)
        i.successivo = lista2;
    return i;
}
void aggiungiElemento(int n){
    Elemento nuovo = new Elemento(n, testa);
    testa = nuovo;
}

}


