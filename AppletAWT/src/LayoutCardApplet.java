/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.awt.*;

/**
 *
 * @author raffaele
 */
public class LayoutCardApplet extends Applet implements Runnable {
CardLayout cl1 = new CardLayout();
Label etichetta1 = new Label("UNO");
Label etichetta2 = new Label("DUE");
Label etichetta3 = new Label("TRE");
Thread vai;/**
     * Initialization method that will be called after the applet is loaded
     * into the browser.
     */
    public void init() {
        setLayout(cl1);
        Panel uno = new Panel(); add("Primo",uno); uno.add(etichetta1);
        Panel due = new Panel(); add("Secondo",due); due.add(etichetta2);
        Panel tre = new Panel(); add("Terzo",tre); tre.add(etichetta3);
    }



    public void start(){
        if(vai == null)
            vai = new Thread(this);
            vai.start();

        //cl1.previous(this);
        //cl1.next(this);
        //cl1.first(this);
        //cl1.last(this);
    }

    public void run() {
        while(true){
            cl1.next(this);
            try {
                vai.sleep(500);
            } catch (InterruptedException ex) {
                break;
            }


        }
    }
}
