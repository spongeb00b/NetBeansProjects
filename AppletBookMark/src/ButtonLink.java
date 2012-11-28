
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author raffaele
 */
public class ButtonLink extends java.applet.Applet implements ActionListener {

    BookMark bmlist[] = new BookMark[3];

    public void init() {
        bmlist[0] = new BookMark("Wikipedia", "http://it.wikipedia.org");
        bmlist[1] = new BookMark("Estudium", "http://estudium.unipg.it/newscienze");
        bmlist[2] = new BookMark("Google", "http://www.google.it");

        setLayout(new GridLayout(bmlist.length, 1, 10, 10));
        for (int i = 0; i < bmlist.length; i++) {
            Button b = new Button(bmlist[i].name);
            b.addActionListener(this);
            add(b);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Button) {
            linkTo(((Button) e.getSource()).getLabel());
        }
    }

    void linkTo(String name) {
        URL theUrl = null;
        for (int i = 0; i < bmlist.length; i++) {
            if (name.equals(bmlist[i].name)) {
                theUrl = bmlist[i].url;
            }
            if (theUrl != null) {
                getAppletContext().showDocument(theUrl);
            }

        }

    }
}

