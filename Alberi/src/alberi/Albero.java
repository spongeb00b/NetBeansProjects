/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package alberi;

/**
 *
 * @author raffaele
 */
public class Albero {
    Nodo radice = null;
    
    
    
    private String rientra(int s){
        String temp = " ";
        for(int i=0; i < s; i++)
            temp+=" ";
        return temp;
    }

    
    private void visitaAnticipata(Nodo n, int conta){
    if(n != null){
        System.out.println(rientra(conta)+n.valore);
        conta+=5;
        visitaAnticipata(n.sinistro, conta);
        visitaAnticipata(n.destro, conta);
        
    }
}
    void visitaAnticipata(){
        visitaAnticipata(radice,0);
}

    private void visitaPosticipata(Nodo n, int conta){
        if(n != null){
        conta+=5;
        visitaPosticipata(n.sinistro, conta);
        visitaPosticipata(n.destro, conta);
        System.out.println(rientra(conta)+n.valore);
        }
   }
    
    
    void visitaPosticipata(){
        visitaPosticipata(radice,0);
    }

    void visitaSimmetrica(){
        visitaSimmetrica(radice,0);
    }

    private void visitaSimmetrica(Nodo n, int conta){
        if(n != null){
            conta+=5;
            visitaSimmetrica(n.sinistro,conta);
            System.out.println(rientra(conta-5)+n.valore);
            visitaSimmetrica(n.destro,conta);
        }

    }

public int altezza(){
    return altezza(radice);
}

private int altezza(Nodo n){
    if(n != null){
        int maxSx = altezza(n.sinistro), maxDx = altezza(n.destro);
        if(maxSx > maxDx)
            return ++maxSx;
        return ++maxDx;
    }
    return 0;
}

}