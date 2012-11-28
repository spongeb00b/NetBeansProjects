/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio116022001;

/**
 *
 * @author raffaele
 */
public class Magazzino {

    Elettrodomestico V[];
    int n;
    int m;

    Magazzino(int n, int m) {
        this.n = n;
        this.m = m;
        V = new Elettrodomestico[n + m];
        for (int i = 0; i < n + m; i++) {
            if (i < n) {
                V[i] = new Bianchi("Nome" + (int) ((Math.random() * 4) + 1), "Marca" + (int) ((Math.random() * 2) + 1), (Math.random() * 500) + 500, (int) ((Math.random() * 4) + 1));
            } else {
                int casuale = (int) (Math.random() * 100) + 1;
                boolean digital;
                if (casuale % 2 == 0) {
                    digital = true;
                } else {
                    digital = false;
                }
                V[i] = new Neri("Nome" + (int) ((Math.random() * 4) + 1), "Marca" + ((int) (Math.random() * 2) + 1), (Math.random() * 500) + 500, digital);
            }
        }
    }

    double media(String marca) {
        double costo = 0;
        int num = 0;
        for (int i = 0; i < n + m; i++) {
            if (V[i].marca.equals(marca)) {
                costo += V[i].costo();
                num++;
            }
        }
        if (num != 0) {
            return Math.round(costo / num * Math.pow(10, 2)) / Math.pow(10, 2);
        }
        return 0;
    }

    void visualizzaMagazzino() {
        for (int i = 0; i < n + m; i++) {
            if (V[i] instanceof Bianchi) {
                System.out.println(V[i].nome + " " + V[i].marca + " Potenza: " + Math.round(V[i].potenza * Math.pow(10, 2)) / Math.pow(10, 2) +" Watt  Classe: " + ((Bianchi) V[i]).classeEcologica + " Costo: " + Math.round(V[i].costo() * Math.pow(10, 2)) / Math.pow(10, 2)+" Euro");
            } else {
                String digital;
                if (((Neri) V[i]).digitale) {
                    digital = "SI";
                } else {
                    digital = "NO";
                }
                System.out.println(V[i].nome + " " + V[i].marca + " Potenza: " + Math.round(V[i].potenza * Math.pow(10, 2)) / Math.pow(10, 2) + " Watt Digitale: " + digital + " Costo: " + Math.round(V[i].costo() * Math.pow(10, 2)) / Math.pow(10, 2)+" Euro");

            }


        }



    }
}


