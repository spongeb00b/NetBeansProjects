/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio12mar2011;

/*Esercizio 1 (15 punti)
Si definisca una gerarchia di classi per rappresentare gli attori partecipanti agli Oscar.
Gli attori sono di due tipi: comici e drammatici. Per ogni attore si rappresenti:
nome, età , numero di film a cui ha partecipato.
Per gli attori drammatici si rappresenti inoltre il numero di nomination ricevute in passato,
per gli attori comici la somma incassata dall’ultimo film girato.
Per i due tipi di attori si definisca un metodo che calcola la probabilità di vittoria agli Oscar;
per gli attori drammatici la probabilità è data dal numero di nomination moltiplicato per
l’età, diviso il numero di film a cui si è partecipato,
mentre per gli attori comici è data dall’incasso dell’ultimo film diviso per l’età.
Si definisca una classe Archivio che contiene come campo un array V in cui è possibile
inserire sia attori comici che drammatici.
Si definisca inoltre un costruttore della classe Archivio che ha un parametro n e che
instanzia il vettore V con n elementi inserendo metà (circa) di comici e metà (circa) di
drammatici. Si definiscano i campi degli oggetti in modo casuale.
Si definisca infine un metodo della classe Archivio che dato un parametro numerico N
restituisce il nome di un attore la cui probabilità di vittoria sia maggiore di N, la stringa
nulla se tale attore non è presente.
*/
/**
 *
 * @author raffaele
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Archivio archivio = new Archivio(10);
        archivio.stampaArchivio();
        int numProb = 40;
        System.out.println("L'attore con probabilità maggiore di "+numProb+" é: "+archivio.nomeAttore(numProb));
    }

}
