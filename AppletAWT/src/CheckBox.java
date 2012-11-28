/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.applet.Applet;

/**
 *
 * @author raffaele
 */
public class CheckBox extends Applet {

    /**
     * Initialization method that will be called after the applet is loaded
     * into the browser.
     */
    public void init() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(new Checkbox("Chiavi"));
        add(new Checkbox("Portafogli"));
        add(new Checkbox("Cellulare"));
        add(new Checkbox("Accendino"));
        add(new Checkbox("Tabacco",true));

    }

    // TODO overwrite start(), stop() and destroy() methods
}
