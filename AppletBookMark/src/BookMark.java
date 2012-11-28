/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.net.MalformedURLException;


/**
 *
 * @author raffaele
 */
public class BookMark {

    String name;
    URL url;

    BookMark(String name, String theUrl) {
        this.name = name;
        try {
            this.url = new URL(theUrl);
        } catch (MalformedURLException ex) {
            System.out.println("Bad URL: " + theUrl);
        }
    }
}
