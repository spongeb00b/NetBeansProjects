/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vettore;

import java.io.*;
/**
 *
 * @author raffaele
 */
public class Vettore {
    BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
    int v[];

    Vettore(int n){
    v = new int[n];
}

void stampa(){
    System.out.print("v  = [ ");
    System.out.print(v[0]);
    for(int i = 1; i < v.length; i++){
        System.out.print(" , ");
        System.out.print(v[i]);
    }
    System.out.println(" ]");
}

void riempiTastiera(){
    String Letto = null;
    for(int i = 0; i < v.length; i++){
        try{
            System.out.print("Inserisci il "+(i+1)+"o Elemento: ");
            Letto = tastiera.readLine();
            v[i] = Integer.parseInt(Letto);
            System.out.println();
        }
        catch(IOException ecc){}
        catch(NumberFormatException ecc){
            System.out.println("Formato Errato!");
            i--;
        }
    }
}

void riempiCasuale(){
    for(int i = 0; i < v.length; i++)
        v[i] = (int)(Math.random()*10+1);
}
}






