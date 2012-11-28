/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eserciziolista;

/**
 *
 * @author raffaele
 */
public class Coda extends Lista {
    Elemento ultimo = null;



    void inserisci(int n){
        Elemento temp = new Elemento(n, null);
        if(testa == null){
            ultimo = temp;
            testa  = temp;
        }
        else{    
            ultimo.successivo = temp;
            ultimo = temp;
        }
  }
  Elemento estrai(){
      Elemento temp = testa;
      if(testa != null){
          testa = testa.successivo;
          temp.successivo = null;
      }
      else
          return null;
      if(testa == null) //se nel primo if abbiamo prodotto una coda vuota
          ultimo = null;
      return temp;
  }
}
        





