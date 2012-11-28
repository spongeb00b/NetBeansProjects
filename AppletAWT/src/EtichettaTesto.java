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
public class EtichettaTesto extends Applet {

    /**
     * Initialization method that will be called after the applet is loaded
     * into the browser.
     */
    public void init() {
       setFont(new Font("Helvetica",Font.BOLD,14));
       setLayout(new GridLayout(3,1));
       add(new Label("SINISTRA",Label.LEFT));
       add(new Label("CENTRO",Label.CENTER));
       add(new Label("DESTRA",Label.RIGHT));
    }

    // TODO overwrite start(), stop() and destroy() methods
}
