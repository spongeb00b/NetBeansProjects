/* Copyright (c) 1996, 1997 Prominence Dot Com, Inc.        *
 * See the file legal.txt in the txt directory for details. */

//package prominence.msg;

import java.io.*;
import java.util.*;
/**
 * A class that reads messages from a <tt>MultiplexInputStream</tt>
 * and forwards them on to the <tt>MessageOutput</tt> identified by the
 * message label.
 *
 * @version 1.0 1 Nov 1996
 * @author Merlin Hughes
 * @see prominence.msg.MessageCopier
 */
public class Demultiplexer extends Thread {
  /**
   * The <tt>MultiplexInputStream</tt> from which messages are read.
   */
  protected MultiplexInputStream i;
  /**
   * The message routing table. Maps from message labels to
   * <tt>MessageOutput</tt>s.
   */
  protected Hashtable routes;

  /**
   * Current <tt>Demultiplexer</tt> ID.
   */
  static private int plexerNumber;
  /**
   * Assigns unique <tt>Demultiplexer</tt> ID's.
   * @return An unique <tt>Demultiplexer</tt> ID.
   */
  static private synchronized int nextPlexerNum () { return plexerNumber ++; }

  /**
   * Creates a new <tt>Demultiplexer</tt> reading from a specified
   * stream.
   * @param i The <tt>MultiplexInputStream</tt> from which mess. should be read
   */
  public Demultiplexer (MultiplexInputStream i) {
    super ("Demultiplexer-" + nextPlexerNum ());
    this.i = i;
    routes = new Hashtable ();
  }

  /**
   * Registers a <tt>MessageOutput</tt> as the destination for messages
   * with a particular label.
   * @param label The message label that is to be routed
   * @param o The destination for such messages
   */
  public void register (String label, MessageOutput o) {
    routes.put (label, o);
  }

  /**
   * Deregisters a particular message label.
   * @param label The label that is to be deregistered
   */
  public void deregister (String label) {
    routes.remove (label);
  }

  /**
   * Routes messages from the <tt>MultiplexInputStream</tt> to the
   * <tt>MessageOutput</tt> identified by their labels. <pre>This method
   * is called by a
   * new thread when the superclass <tt>start()</tt> method is called.
   * @see java.lang.Thread#start
   */
  public void run () {
    try {
      while (true) {
        i.receive ();
        MessageOutput o = (MessageOutput) routes.get (i.label);
        if (o != null) {
          byte[] message = new byte[i.available ()];
          i.readFully (message);
          synchronized (o) {
            o.write (message);
            o.send ();
          }
        }
      }
    } catch (IOException ex) {
      ex.printStackTrace ();
    }
  }
}

