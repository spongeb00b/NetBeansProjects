/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eserciziolista;

/**
 *
 * @author biloange
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Pila pila = new Pila();
        for(int i = 0; i <= 10; i++)
            pila.aggiungiElemento(i);
        for(int i = 0; i <= 10; i++)
            System.out.println(pila.estrai().valore);
        */
        Coda coda = new Coda();
        for(int i = 0; i <= 10; i++)
            coda.aggiungiElemento(i);
        coda.visualizza();
        System.out.println();
        System.out.println("Ci sono: "+coda.contaElementi()+" elementi nella coda");
        System.out.println("Ci sono: "+coda.contaElementiRic()+" elementi nella coda calcolati ricorsivamente!!");
        
         /*Lista lista = new Lista(20);
        lista.visualizza();
        lista.separaRiga();
        System.out.println("Ci sono "+lista.conta(10)+" elementi uguali a 10");
        lista.incrementa(1);
        lista.separaRiga();
        System.out.println("Incremento la Lista di 1");
        lista.separaRiga();
        lista.visualizza();
        lista.separaRiga();
        System.out.println("Ci sono "+lista.conta(10)+" elementi uguali a 10");
        lista.separaRiga();
        System.out.println("La media dei valori presenti nella lista e' "+lista.media());
        lista.separaRiga();
        System.out.println("La somma dei valori presenti nella lista è "+lista.somma());
        lista.separaRiga();
        System.out.println("L'elemento che compare più frequentemente della lista è "+lista.moda());
        lista.ordina();
        lista.separaRiga();
        lista.visualizza();
        lista.separaRiga();
        System.out.println("Gli elementi della lista minori di 7 sono: "+lista.contaMinori(7));
        Lista lista2 = new Lista(15);
        /*Pila pila = new Pila(10);
        pila.visualizza();
        pila.separaRiga();
        pila.inserisci(7);
        pila.separaRiga();
        pila.visualizza();
        pila.separaRiga();
        System.out.println("L'elemento estratto con logica LIFO è -> "+pila.estrai());
        pila.separaRiga();
        pila.visualizza();
        pila.separaRiga();
        System.out.println("L'elemento estratto con logica LIFO è -> "+pila.estrai());
        pila.separaRiga();
        pila.visualizza();
        pila.separaRiga();
        System.out.println("L'elemento estratto con logica LIFO è -> "+pila.estrai());
        pila.separaRiga();
        pila.visualizza();
        Coda coda = new Coda(10);
        coda.visualizza();
        coda.separaRiga();
        coda.inserisci(7);
        coda.separaRiga();
        coda.visualizza();
        coda.separaRiga();
        System.out.println("L'elemento estratto con logica FIFO è -> "+coda.estrai2());
        coda.separaRiga();
        coda.visualizza();
        coda.separaRiga();
        System.out.println("L'elemento estratto con logica FIFO è -> "+coda.estrai2());
        coda.separaRiga();
        coda.visualizza();
        coda.separaRiga();
        System.out.println("L'elemento estratto con logica FIFO è -> "+coda.estrai2());
        coda.separaRiga();
        coda.visualizza();
        coda.separaRiga(); */
    }
}


