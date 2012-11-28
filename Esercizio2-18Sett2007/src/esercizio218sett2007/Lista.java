/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio218sett2007;
import java.io.*;

/**
 *
 * @author raffaele
 */
public class Lista {

    private Elemento testa = null;
    private int n;
    FileWriter output;

    Lista(int n) {
        this.n = n;
        for (int i = 0; i < n; i++) {
            Elemento corrente = new Elemento((int) (Math.random() * 1000), testa);
            testa = corrente;
        }

    }

    void visualizza() {
        int count = 1;
        for (Elemento i = testa; i != null; i = i.next) {
            System.out.println(count + ") " + i.valore);
            count++;
        }
    }


void scriviFile(String fileName){
        try {
            File file = new File(fileName);
            output = new FileWriter(file);
            int somma = 0;
            for (Elemento i = testa; i != null; i = i.next){
                somma+=i.valore;
                output.write(""+i.valore+"\n");
            }
            double media = somma/n;
            output.write("La media dei vaori è: "+(Math.round((media)*Math.pow(2, 10))/Math.pow(2, 10)));
            output.flush();
            System.out.println("Scrittura file eseguita correttamente");

        } catch (IOException ex) { System.out.println(ex);

        }




}




}








