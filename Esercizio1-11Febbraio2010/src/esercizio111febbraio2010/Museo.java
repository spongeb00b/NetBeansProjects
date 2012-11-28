/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizio111febbraio2010;

/**
 *
 * @author raffaele
 */
public class Museo {
    Opera V[];
    int dimensione;

Museo(int dimensione){
    this.dimensione = dimensione;
    V = new Opera[dimensione];
    //if(dimensione > 2)
        for(int i = 0; i < dimensione; i++){
            if(i < 2*dimensione/3)
                V[i] = new Pittura("Autore"+(int)(Math.random()*10)+1,(int)(Math.random()*560)+1450,Math.random()*10);
            else
                V[i] = new Scultura("Autore"+(int)(Math.random()*10)+1,(int)(Math.random()*1011)+1000,(Math.random()*5000));
        }
}


void visualizzaOpere(){
    if(V != null){
        for(int i = 0; i < dimensione; i++){
            if(V[i] instanceof Pittura)
                System.out.println(V[i].getClass().getSimpleName()+" "+(i+1)+" "+V[i].autore+" Anno:"+V[i].anno+" Superfice (mq): "+Math.round((((Pittura)V[i]).superfice)*Math.pow(10, 2))/Math.pow(10, 2)+" Costo (Euro): "+Math.round(V[i].costoRestauro()*Math.pow(10, 2))/Math.pow(10,2));
            else
                System.out.println(V[i].getClass().getSimpleName()+" "+(i+1)+" "+V[i].autore+" Anno:"+V[i].anno+" Peso (Kg): "+Math.round((((Scultura)V[i]).peso)*Math.pow(10, 2))/Math.pow(10, 2)+" Costo (Euro): "+Math.round(V[i].costoRestauro()*Math.pow(10, 2))/Math.pow(10,2));
        }

    }

}

double maxCosto(){
    double costo = 0;
    for(int i = 0; i < dimensione; i++){
        if(V[i].costoRestauro() > costo)
            costo = V[i].costoRestauro();
   }
   return Math.round((costo)*Math.pow(10,2))/Math.pow(10,2);

}



}
