/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio141;

/**
 *
 * @author raffaele
 14.1 Si definisca una lista concatenata tramite puntatori a partire dalle classi:
Elemento, che contiene i campi: valore (di tipo intero) e successivo (di classe Elemento);
Lista, che contiene il campo testa (di classe Elemento), che rappresenta il riferimento al primo
elemento della lista.
Nella classe Lista si definisca:
il costruttore che dato un intero n genera una lista di n elementi casuali.
il metodo scriviFile che, dati come parametro una stringa che rappresenta il nome di un file
di caratteri ed un intero N, scriva nel file gli elementi della lista più piccoli di N (un valore
per ogni riga) e nell’ultima riga del file la somma dei valori presenti nelle righe precedenti
del file.
Si realizzi infine una applicazione che: costruisce un oggetto di classe lista e richiama il metodo
scriviFile.



 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lista lista = new Lista(10);
        lista.visualizzaLista(lista.getTesta());
        lista.scriviFile(50,"prova");

    }

}
