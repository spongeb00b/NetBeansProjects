/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AppletPallina;

/**
 *
 * @author raffaele
 */
import java.awt.Color;


public class Pallina {
    int x, y, velx, vely, dim;
    Color c;


    Pallina(int x, int y, int velx,int vely,int dim, Color c){
        this.x = x;
        this.y = y;
        this.velx = velx;
        this.vely = vely;
        this.dim = dim;
        this.c = c;
    }

    public void muovi(){
        x += velx;
        y += vely;
    }

    void rimbalza(int l, int h) {
        if(x <= 0 && velx < 0){
           c = cambiaColore();
            velx = -velx;
        }
         if(x + dim >= l && velx > 0){
            c = cambiaColore();
             velx = -velx;
         }
        if(y <= 0 && vely < 0){
            c = cambiaColore();
            vely = -vely;
        }
        if(y + dim >= h && vely > 0){
            c = cambiaColore();

            vely = -vely;
    }
    }
     Color cambiaColore(){
        int r = (int)(Math.random()*256);
        int g = (int)(Math.random()*256);
        int b = (int)(Math.random()*256);
        return new Color(r,g,b);
    }


}



