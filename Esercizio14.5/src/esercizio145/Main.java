/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio145;

/**
 *
 * @author raffaele
 *
 14.5 Si definisca una applicazione che contiene un metodo che dato il nome di un file ed un numero
intero n restituisce il numero di volte che n è presente nel file.
Si supponga che il file sia un file di caratteri contenente un numero intero per ogni riga.
Nel metodo main dell’applicazione si richiami il metodo per cercare quante volte il numero 10
compare nel file “esame.txt” e si trascriva a video il risultato
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int n = 10;
       String file = "esame.txt";
       CercaNumeri cerca = new CercaNumeri(n,file);
       System.out.println("Il numero "+n+" compare nel file "+file+" "+cerca.nuberSearch()+" volte");
       }

}
