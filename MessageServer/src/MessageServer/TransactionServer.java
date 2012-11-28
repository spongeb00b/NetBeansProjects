/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author raffaele
 *//* Copyright (c) 1996, 1997 Prominence Dot Com, Inc.        *
 * See the file legal.txt in the txt directory for details. */
package MessageServer;

import java.io.*;
import java.util.*;
import java.net.*;



public class TransactionServer implements Runnable {
  protected Hashtable h;
  protected InputStream i;
  protected OutputStream o;

  public TransactionServer (InputStream i, OutputStream o) {
    this.i = i;
    this.o = o;
    h = new Hashtable ();
  }
  public void run () {
    MessageInputStream mI = new MessageInputStream (i);
    MessageOutputStream mO = new MessageOutputStream (o);
    try {
      while (true) {
        mI.receive ();
        try {
          Thread.sleep (1000);
        } catch (InterruptedException ex) {
        }
        String cmd = mI.readUTF ();
 System.out.println (Thread.currentThread () + ": command " + cmd);
        if (cmd.equals ("get")) {
          get (mI, mO);
        } else if (cmd.equals ("put")) {
          put (mI);
        }
      }
    } catch (IOException ex) {
      ex.printStackTrace ();
    }
  }

  void get (DataInputStream dI, MessageOutput mO) throws IOException {
    String attr = dI.readUTF ();
    mO.writeUTF (attr);
    if (h.containsKey (attr))
      mO.writeUTF ((String) h.get (attr));
    else
      mO.writeUTF ("null");
    mO.send ();
  } 

  void put (DataInputStream dI) throws IOException {
    String attr = dI.readUTF ();
    String value = dI.readUTF ();
    h.put (attr, value);
  }

  static public void main (String args[]) throws IOException {
    if (args.length != 2)
      throw new RuntimeException ("Syntax: TransactionServer <port> <threads>");
    ServerSocket server = new ServerSocket (Integer.parseInt (args[0]));
    Socket s = server.accept ();
    server.close ();
    InputStream i = s.getInputStream ();
    OutputStream o = s.getOutputStream ();
    TransactionServer t = new TransactionServer (i, o);
    int n = Integer.parseInt (args[1]);
    for (int j = 0; j < n; ++ j)
      new Thread (t).start ();
  }
}