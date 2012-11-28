
import java.applet.Applet;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author raffaele
 */
public class NavigationBar extends Applet implements ActionListener {

    JLabel status;
    JButton go;
    JPanel addressBar;
    TextField addressArea;

    public void init() {
        setLayout(new BorderLayout());
        addressBar = new JPanel();
        addressBar.setLayout(new GridLayout(2, 1, 10, 10));
        addressArea = new TextField("http://");
        go = new JButton("GO!");
        go.addActionListener(this);
        addressBar.add(addressArea);

        addressBar.add(go);
        this.add("Center", addressBar);
        addressBar.setVisible(true);
        status = new JLabel("Ready!");
        status.setSize(this.getWidth(), 30);
        this.add("South", status);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            UrlAddress address = new UrlAddress(addressArea.getText(), this);
            if (address != null) {
                getAppletContext().showDocument(address.getAddress());
            }


        }
    }
}
