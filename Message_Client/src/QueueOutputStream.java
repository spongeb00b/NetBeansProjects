/* Copyright (c) 1996, 1997 Prominence Dot Com, Inc.        *
 * See the file legal.txt in the txt directory for details. */

//package prominence.msg;

import java.io.*;
//import prominence.util.Queue;

/**
 * A <tt>MessageOutput</tt> that inserts messages into a <tt>Queue</tt>
 * of byte arrays.
 *
 * @version 1.0 1 Nov 1996
 * @author Merlin Hughes
 * @see prominence.msg.QueueInputStream
 */
public class QueueOutputStream extends MessageOutput {
  /**
   * A <tt>ByteArrayOutputStream</tt> used to buffer the current message
   * contents.
   */
  protected ByteArrayOutputStream byteO;
  /**
   * The <tt>Queue</tt> of messages.
   */
  protected Queue q;

  /**
   * Creates a new <tt>QueueOutputStream</tt>.
   * @param q A <tt>Queue</tt> into which messages will be written
   */
  public QueueOutputStream (Queue q) {
    super (new ByteArrayOutputStream ());
    byteO = (ByteArrayOutputStream) out;
    this.q = q;
  }

  /**
   * Inserts the current message buffer into the <tt>Queue</tt>.
   */
  public void send () {
    byte[] buffer = byteO.toByteArray ();
    byteO.reset ();
    q.add (buffer);
  }
}

