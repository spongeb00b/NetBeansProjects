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
public class MenuScelta extends Applet {

    /**
     * Initialization method that will be called after the applet is loaded
     * into the browser.
     */
    public void init() {
        
    Choice menu = new Choice();

    
    menu.add("Nuovo");
    menu.add("Salva");
    menu.add("Apri");
    menu.add("Stampa");
    menu.add("Chiudi");
    add(menu);
    


    }

    // TODO overwrite start(), stop() and destroy() methods
}
