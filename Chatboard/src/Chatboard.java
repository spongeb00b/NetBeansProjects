/* Copyright (c) 1996, 1997 Prominence Dot Com, Inc.        *
 * See the file legal.txt in the txt directory for details. */

import java.io.*;
import java.awt.*;

public class Chatboard extends Panel implements Runnable {
  protected TextArea output;
  protected TextField input;
  protected Queue q;
  protected Thread exec;

  public Chatboard () {
    setLayout (new BorderLayout ());
    add ("Center", output = new TextArea ());
    output.setEditable (false);
    add ("South", input = new TextField ());
    q = new Queue ();
    exec = new Thread (this);
    exec.start ();
  }

  protected MessageOutput o;

  public void setMessageOutput (MessageOutput o) {
    this.o = o;
  }

  public MessageOutput getMessageOutput () {
    return new QueueOutputStream (q);
  }

  public boolean action (Event e, Object arg) {
    if (e.target == input) {
      try {
        o.writeUTF (input.getText ());
        o.send ();
      } catch (IOException ex) {
        ex.printStackTrace ();
      }
      output.appendText (input.getText () + "\n");
      input.setText ("");
      return true;
    }
    return super.action (e, arg);
  }

  public void sendMessage (String s) {
      try {
        o.writeUTF (s);
        o.send ();
      } catch (IOException ex) {
        ex.printStackTrace ();
      }
  }

  public void run () {
    QueueInputStream qI = new QueueInputStream (q);
    while (true) {
      try {
        qI.receive ();
        String msg = qI.readUTF ();
        output.appendText ("-- " + msg + "\n");
      } catch (IOException ex) {
        ex.printStackTrace ();
      }
    }
  }
}
