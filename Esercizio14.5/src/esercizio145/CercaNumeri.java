/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio145;

import java.io.*;


/**
 *
 * @author raffaele
 */
public class CercaNumeri {

int numero;
String file;


    CercaNumeri(int numero, String file){
        this.numero = numero;
        this.file = file;
    }


int nuberSearch(){
    BufferedReader lettoreFile = null;
    int count = 0;
    String temp;
        try {
            lettoreFile = new BufferedReader(new FileReader(file));
            while((temp = lettoreFile.readLine()) !=  null){
                if(Integer.parseInt(temp) == numero)
                    count++;

            }
            
            } catch (FileNotFoundException ex) {ex.printStackTrace();}
              catch (IOException e){e.printStackTrace();}
    return count;
}




}
