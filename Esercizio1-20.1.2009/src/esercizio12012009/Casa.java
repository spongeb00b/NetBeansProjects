/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio12012009;

/**
 *
 * @author raffaele
 */
public class Casa {

    Elettrodomestico[] V;
    int n;
    int m;

    Casa(int n, int m) {
        this.n = n;
        this.m = m;
        V = new Elettrodomestico[n + m];
        for (int i = 0; i < n + m; i++) {
            if (i < n) {
                V[i] = new Frigorifero("Colore" + (int) (Math.random() * 9) + 1, (Math.random() * 500) + 200, (int) (Math.random() * 5) + 1);
            } else {
                V[i] = new Televisore("Colore" + (int) (Math.random() * 9) + 1, (Math.random() * 500) + 200, (int) (Math.random() * 50) + 10, (Math.random() * 20) + 100);
            }
        }


    }

    void stampaEleDom() {
        for (int i = 0; i < n + m; i++) {
            if (V[i] instanceof Frigorifero) {
                System.out.println("Frigo " + (i + 1) + ": " + "Colore: " + V[i].colore + " Potenza: " + V[i].potenza + " Capienza: " + ((Frigorifero) V[i]).capienza);
            } else {
                System.out.println("Tv " + (i - n + 1) + ": " + "Colore: " + V[i].colore + " Potenza: " + V[i].potenza + " Pollici: " + ((Televisore) V[i]).pollici + " Canone: " + ((Televisore) V[i]).canone);
            }
        }
        System.out.println("Il costo totale degli elettrodomestici è: " + calcolaTotale());
    }

    double calcolaTotale() {
        double totale = 0;
        for (int i = 0; i < n + m; i++) {
            totale += V[i].costo();
        }
        return totale;
    }
}
