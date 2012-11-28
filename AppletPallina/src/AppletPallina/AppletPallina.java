/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AppletPallina;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;




/**
 *
 * @author raffaele
 */
public class AppletPallina extends Applet implements Runnable, KeyListener { //MouseListener{
    Pallina p;
    Thread t;
   
   Image offscreenImg;
   Graphics offscreenG;
   

 public void init(){

    offscreenImg = createImage(this.getSize().width, this.getSize().height);
    offscreenG = offscreenImg.getGraphics();
    p = new Pallina(0,0,5,5,20,Color.BLACK);
    addKeyListener(this);
    addMouseListener(new MouseWatch(this));
    
    
    
    
}

public void run(){
    while(true){
    p.rimbalza(getWidth(),getHeight());
    p.muovi();
    repaint();
            try {
                t.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                //break;
            }

    }

}


public void start(){
        if(t == null){
            t = new Thread(this);
            t.start();
        }
      
}



public void stop(){
    if(t != null){
        t.interrupt();
        t = null;
    }
}


public void update(Graphics g){
    paint(g);
}



public void paint(Graphics g){
    offscreenG.setColor(Color.WHITE);
    offscreenG.fillRect(0, 0, getWidth(), getHeight());
    offscreenG.setColor(p.c);
    offscreenG.fillOval(p.x, p.y, p.dim, p.dim);
    g.drawImage(offscreenImg,0,0,this);

}

public void destroy(){
    offscreenG.dispose();
}


    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch(code){
            case KeyEvent.VK_DOWN: p.vely++; break;
            case KeyEvent.VK_UP: p.vely--; break;
            case KeyEvent.VK_LEFT: p.velx--; break;
            case KeyEvent.VK_RIGHT: p.velx++; break;
            default: break;
        }


    }

    public void keyReleased(KeyEvent e) {

    }

}