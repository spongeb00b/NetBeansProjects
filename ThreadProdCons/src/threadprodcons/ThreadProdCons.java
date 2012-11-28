/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package threadprodcons;

/**
Si scriva una applicazione che prevede un thread produttore e piu' thread consumatori.
I thread comunicano utilizzando una struttura dati comune, un vettore della classe principale.
Il produttore genera una serie di numeri interi, (per semplicità tutti uguali ad 1)
ed alla fine della sequenza scrive il valore -1 per segnalare la fine della fase di produzione.
I consumatori leggono i valori prodotti.
Alla fine ciascun consumatore scrive a video il proprio nome, il numero dei valori letti e la loro somma.
Vengono proposte 3 soluzioni:
la prima fa una sincronizzazione implicita, introducendo dei tempi di
attesa dopo ogni scrittura del produttore e ogni lettura dei consumatori;
la seconda non usa sincronizzazioni;
la terza sincronizza in modo corretto effettuando l'accesso
alle strutture dati comuni in mutua esclusione.
 * 
 */
public class ThreadProdCons {
int v[] = new int[100];
int index = 0;
Produttore producer;
Consumatore [] vettoreConsumer = new Consumatore[100];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        ThreadProdCons theApp = new ThreadProdCons();
        theApp.producer = new Produttore(theApp);
        for(int i = 0; i < theApp.vettoreConsumer.length; i++)
            theApp.vettoreConsumer[i] = new Consumatore(theApp);
        theApp.producer.start();
        for(int i = 0; i < theApp.vettoreConsumer.length; i++)
            theApp.vettoreConsumer[i].start();

        }



    }

