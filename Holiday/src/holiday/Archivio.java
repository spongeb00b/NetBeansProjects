/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package holiday;

/**
 *
 * @author raffaele
 */
public class Archivio {
    Vacanza v[];


Archivio(int n, int m){
    v = new Vacanza[n+m];
    for(int i = 0; i < n; i++)
        v[i] = new Crociera((int)(Math.random()*100),"Destinazione"+i,(int)(Math.random()*15));
    for(int i = n; i < n+m; i++)
        v[i] = new Escursione((int)(Math.random()*100),"Destinazione"+i,(int)(Math.random()*10));
}

String costoMinore(int n){
    int temp = v[0].costo();
    for(int i = 1; i < v.length; i++)
        if(v[i].costo() < n)
            temp = i;
    if(temp != 0)
        return v[temp].meta;
    return "";
}

void stampaArchivio(){
    for(int i = 0; i < v.length; i++)
        System.out.println("Il costo di "+v[i].meta+" è "+v[i].costo());
}

}
