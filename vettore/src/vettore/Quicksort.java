/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vettore;

/**
 *
 * @author raffaele
 */
public class Quicksort extends Vettore {

    Quicksort(int n){
        super(n);
    }

public void ordinaQuick(){
    quicks(v,0,v.length-1);
}

private void quicks(int v[], int inf, int sup){
    if(inf < sup){
        int mid = partition(v, inf, sup);
        quicks(v, inf, mid-1);
        quicks(v, mid+1, sup);
    }
}
int partition(int v[], int inizio, int fine){
    int pivot = v[inizio];
    do{
        while(inizio < fine && v[fine] >= pivot)
            fine--;
        if(inizio < fine)
            v[inizio] = v[fine];
        
        while(inizio < fine && v[inizio] <= pivot)
            inizio++;
        if(inizio < fine)
            v[fine] = v [inizio];
        
    }while(inizio < fine);
    v[inizio] = pivot;
    return inizio;

}
}



