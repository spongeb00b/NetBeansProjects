/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication7;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.applet.Applet;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author raffaele
 */
public class Letters extends Applet implements KeyListener{

    char letteracorrente;
    int xcorrente;
    int ycorrente;
    Image current;
     ImageObserver o;
    /**
     * Initialization method that will be called after the applet is loaded
     * into the browser.
     */
    public void init() {
        // TODO start asynchronous download of heavy resources
    
        xcorrente = (this.getSize().width/2)-8;
        ycorrente = (this.getSize().height)-16;
        setBackground(Color.WHITE);
        ImageObserver o = null;
        try {
            current = getImage(new URL("http://dazero.sourceforge.net/img/linux.gif"));
        } catch (MalformedURLException ex) {}
        addKeyListener(this);
    
    }
    
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
    
    
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch(key) {
            case KeyEvent.VK_DOWN:  ycorrente += 5; break;
            case KeyEvent.VK_UP:    ycorrente -= 5; break;
            case KeyEvent.VK_LEFT:  xcorrente -= 5; break;
            case KeyEvent.VK_RIGHT: xcorrente += 5; break;
            default:                letteracorrente  = e.getKeyChar();
        }
        repaint();
    }
    public void paint(Graphics g){
        if(letteracorrente != 0)
            g.drawImage(current, xcorrente, ycorrente, o );

    }









}

    // TODO overwrite start(), stop() and destroy() methods

