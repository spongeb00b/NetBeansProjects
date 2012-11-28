
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author raffaele
 */
import java.awt.*;
import java.io.*;
import java.net.*;



public class TransactionClient extends Frame implements Runnable {
  protected MessageInputStream mI;
  protected MessageOutputStream mO;
  protected Button get, put;
  protected TextField attr, value;

  public TransactionClient (InputStream i, OutputStream o) {
    super ("Transaction Client");
    mI = new MessageInputStream (i);
    mO = new MessageOutputStream (o);
    attr = new TextField (24);
    value = new TextField (24);
    get = new Button ("get");
    put = new Button ("put");
    setLayout (new GridLayout (2, 2));
    add (attr);
    add (value);
    add (get);
    add (put);
    pack ();
    show ();
  }

  public void run () {
    while (true) {
      try {
        mI.receive ();
        System.out.print ("attr: " + mI.readUTF ());
        System.out.println (" value: " + mI.readUTF ());
      } catch (IOException e) {
         e.printStackTrace();
      }
    }
  }

  public boolean handleEvent (Event e) {
    if ((e.id == e.ACTION_EVENT) && (e.target instanceof Button)) {
      try {
        if (e.target == get) {
          mO.writeUTF ("get");
          mO.writeUTF (attr.getText ());
        } else if (e.target == put) {
          mO.writeUTF ("put");
          mO.writeUTF (attr.getText ());
          mO.writeUTF (value.getText ());
        }
        mO.send ();
      } catch (IOException ex) {
        ex.printStackTrace ();
      }
    }
    return super.handleEvent (e);
  }

  static public void main (String args[]) throws IOException {
    if (args.length != 2)
      throw new RuntimeException ("Syntax: TransactionClient <server> <port>");
    Socket s = new Socket (args[0], Integer.parseInt (args[1]));
    InputStream i = s.getInputStream ();
    OutputStream o = s.getOutputStream ();
    TransactionClient c = new TransactionClient (i, o);
    //c.listen ();
    new Thread(c).start();
  }
}
