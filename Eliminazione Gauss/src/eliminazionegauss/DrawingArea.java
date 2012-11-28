/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eliminazionegauss;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


/**
 *
 * @author raffaele
 */
public class DrawingArea extends Canvas {

Frazione corrente;
int max;

public  DrawingArea(Frazione corrente, int max){
    this.corrente = corrente;
    this.max = max;
    setBackground(Color.WHITE);
    if(max > 2)
        this.setSize(45+10*(max-2),45+10*(max-2));
    else
        this.setSize(45,45);

    }


  public void paint(Graphics g){
        g.setFont(new Font("TimesNewRoman", Font.PLAIN, 12));
        //g.drawRect(0, 0, getHeight(), getWidth());
        if(corrente.denominatore == 1)
            if(corrente.segno)
                g.drawString(""+corrente.numeratore, (this.getHeight()/2)-(2+(calcolaCifreDecimali(corrente.numeratore))), (this.getWidth()/2)+3);
            else
                g.drawString(""+corrente.numeratore*(-1), (this.getHeight()/2)-(2*(calcolaCifreDecimali(corrente.numeratore)+2)), (getWidth()/2)+3);
        else{
        int metaX = getHeight()/2, metaY = getWidth()/2, ampiezzaX = (3*calcolaCifreDecimali(calcolaMax(corrente))+3);
            if(corrente.segno){
                g.drawLine(metaX-ampiezzaX-1, metaY, metaX+ampiezzaX+1, metaY);
                g.drawString(""+corrente.numeratore,  (this.getHeight()/2)-(3*(calcolaCifreDecimali(corrente.numeratore))), metaY-3);
                g.drawString(""+corrente.denominatore,(this.getHeight()/2)-(3*(calcolaCifreDecimali(corrente.denominatore))), metaY+12);
            }
            else{
                g.drawLine(metaX-ampiezzaX-8, metaY, metaX-ampiezzaX-5, metaY);
                g.drawLine(metaX-ampiezzaX-1, metaY, metaX+ampiezzaX+1, metaY);
                g.drawString(""+corrente.numeratore,  (this.getHeight()/2)-(3*(calcolaCifreDecimali(corrente.numeratore))), metaY-3);
                g.drawString(""+corrente.denominatore,(this.getHeight()/2)-(3*(calcolaCifreDecimali(corrente.denominatore))), metaY+12);
            }
        }
  }
        int calcolaCifreDecimali(long a){
            int cifre = 0;
            while(a > 0){
                a /= 10;
                cifre++;
            }
            return cifre;
        }
        long calcolaMax(Frazione a){
            if(a.numeratore > a.denominatore)
                return a.numeratore;
            return a.denominatore;
        }


}
