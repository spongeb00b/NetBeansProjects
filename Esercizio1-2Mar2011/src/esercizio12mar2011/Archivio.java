/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio12mar2011;

/**
 *
 * @author raffaele
 */
public class Archivio {

    Oscar V[];
    int n;

    Archivio(int n) {
        this.n = n;
        V = new Oscar[n];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                V[i] = new Comico("nome" + (int) ((Math.random() * 10) + 1), (int) ((Math.random() * 85) + 1), (int) ((Math.random() * 60) + 1), (float) (Math.random() * 1000000000) + 500000000);
            } else {
                V[i] = new Drammatico("nome" + (int) ((Math.random() * 10) + 1), (int) ((Math.random() * 85) + 1), (int) ((Math.random() * 60) + 1), (int) (Math.random() * 60));
            }
        }
    }

    String nomeAttore(int num) {
        for (int i = 0; i < n; i++) {
            if (V[i].calcolaProb() > num) {
                return V[i].nome;
            }
        }
        return "";
    }

    void stampaArchivio() {
        for (int i = 0; i < n; i++) {
            if (V[i] instanceof Comico) {
                System.out.println(V[i].getClass().getSimpleName()+" "+V[i].nome + " Età:" + V[i].eta + " Numero Film:" + V[i].numFilm + " Somma Incasso:" + ((Comico) V[i]).sommaInc + " Probabilià vittoria: " + V[i].calcolaProb());
            } else {
                System.out.println(V[i].getClass().getSimpleName()+" "+V[i].nome + " Età:" + V[i].eta + " Numero Film:" + V[i].numFilm + " Numero Nomination" + ((Drammatico) V[i]).numNomination + " Probabilià vittoria: " + V[i].calcolaProb());
            }
        }
    }
}
