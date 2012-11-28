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
public class RadioButtons extends Applet {

    /**
     * Initialization method that will be called after the applet is loaded
     * into the browser.
     */
    public void init() {
        
        setBackground(Color.blue);
        setForeground(Color.yellow);
        setLayout(new GridLayout(4,1));
        CheckboxGroup radio = new CheckboxGroup();
        add(new Checkbox("Studente",true,radio));
        add(new Checkbox("Lavoratore dipendente",false,radio));
        add(new Checkbox("Libero Professionista",false,radio));
        add(new Checkbox("Pensionato",false,radio));
    }

    // TODO overwrite start(), stop() and destroy() methods
}
