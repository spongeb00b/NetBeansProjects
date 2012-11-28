
import java.net.MalformedURLException;
import java.net.URL;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author raffaele
 */
public class UrlAddress {

    private URL theUrl;
    NavigationBar applet;

    UrlAddress(String address, NavigationBar applet) {
        this.applet = applet;
        try {
            theUrl = new URL(address);
        } catch (MalformedURLException ex) {
            this.applet.status.setText("Bad address " + address);
        }
    }

    public URL getAddress() {
        return theUrl;
    }
}
