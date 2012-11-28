/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package alberi;

/**
 *
 * @author raffaele
 */
public class AlberoRicerca extends Albero {


    public void inserisci(int n){
        if(radice == null)
            radice = new Nodo(n);
        else
            inserisci(radice,n);
    }


    private void inserisci(Nodo n, int valore){
        if(n.valore > valore){
            if(n.sinistro == null)
                n.sinistro = new Nodo(valore);
            else
                inserisci(n.sinistro, valore);
        }else{
            if(n.destro == null)
                n.destro = new Nodo(valore);
            else
                inserisci(n.destro,valore);
        }
    }


 public boolean RicercaValore(int num){
    return ricercaValore(radice, num);
 }

 private boolean ricercaValore(Nodo n, int num){
    if(n == null)
        return false;
    if(n.valore == num)
        return true;
    if(n.valore > num)
        return ricercaValore(n.sinistro, num);
    return ricercaValore(n.destro, num);
    }

 void stampaRisultatoRicerca(int n){
     if(RicercaValore(n))
         System.out.println("Elemento "+n+" presente nell'albero");
     else
         System.out.println("Elemento "+n+" non presente nel'albero");
 }







}






