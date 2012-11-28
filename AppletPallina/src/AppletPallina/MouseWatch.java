/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AppletPallina;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author raffaele
 */
public class MouseWatch extends MouseAdapter {
   AppletPallina a;
   boolean running;

   MouseWatch(AppletPallina a){
        this.a = a;
        running = true;


    }

    public void mousePressed(MouseEvent e){
           if(e != null){
                if(running)
                    a.t.suspend();
                else
                    a.t.resume();
                running = !running;
           }
   }

}
