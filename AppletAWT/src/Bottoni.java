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
public class Bottoni extends Applet {

    /**
     * Initialization method that will be called after the applet is loaded
     * into the browser.
     */
    public void init() {
       Button rewind = new Button("Rewind");
       add(rewind);
       add(new Button("Play"));
       add(new Button("Fast Forward"));
       add(new Button("Stop"));
   }

    // TODO overwrite start(), stop() and destroy() methods
}
