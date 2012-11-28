/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio141;
import java.io.*;

/**
 *
 * @author raffaele
 */
public class Lista {

    private Elemento testa = null;
    private int numelementi;

    Lista(int numelementi){
        for(int i = 0; i < numelementi; i++){
            Elemento next = new Elemento((int)(Math.random()*101),testa);
            testa = next;
        }
    }

Elemento getTesta(){
    return testa;
}


void visualizzaLista(Elemento testa){
    Elemento i;
    int count = 0;
    for(i = testa; i != null; i = i.successivo){
        if(i == testa)
            System.out.println("Testa: "+i.valore);
        else{
            count++;
            System.out.println("Elemento "+count+": "+i.valore);

        }
    }
}

void scriviFile(int n, String nomeFile){
    int somma = 0;
    String path = "/home/raffaele/Scrivania/";
    File finale = new File(path + nomeFile + ".txt");
    FileWriter output = null;
        try {
            output = new FileWriter(finale);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    if(output != null){
        BufferedWriter bw = new BufferedWriter(output);
        for(Elemento i = testa; i != null; i = i.successivo){
            if(i.valore < n){
                    try {
                        somma += i.valore;
                        bw.write("" + i.valore);
                        bw.newLine();
                        bw.flush();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
            }
        }
            try {
                bw.write("Somma totale: " + somma);
                bw.flush();
                bw.close();
                System.out.println("File "+nomeFile+" creato nella posizione "+path);
            } catch (IOException ex) {
               ex.printStackTrace();
            }
       



    }


}




}