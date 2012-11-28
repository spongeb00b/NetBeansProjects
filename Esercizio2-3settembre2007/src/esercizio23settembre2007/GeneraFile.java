/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio23settembre2007;

import java.io.*;


/**
 *
 * @author raffaele
 */
public class GeneraFile {
private String nomeFile;

public GeneraFile(String nomeFile){
    this.nomeFile = nomeFile;
}

public void genera(){
        try {
            File f = new File(nomeFile);
            PrintWriter out = new PrintWriter(new FileWriter(f));
            int n = (int)((Math.random()*10)+10);//genera un numero casuale per le iterazioni da 10 a 19
            for(int i = 0; i < n; i++){
                out.println(""+(int)((Math.random()*99)+1));//genera un numero casuale da 1 a 99
                out.flush();
            }
        } catch (IOException ex) {System.out.println(ex);}
}

}
