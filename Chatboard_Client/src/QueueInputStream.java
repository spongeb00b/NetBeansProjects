/* Copyright (c) 1996, 1997 Prominence Dot Com, Inc.        *
 * See the file legal.txt in the txt directory for details. */

//package prominence.msg;

import java.io.*;
//import prominence.util.Queue;

/**
 * A <tt>MessageInput</tt> that reads messages from a <tt>Queue</tt> of
 * byte arrays.
 *
 * @version 1.0 1 Nov 1996
 * @author Merlin Hughes
 * @see prominence.msg.QueueOutputStream
 */
public class QueueInputStream extends MessageInput {
  /**
   * The <tt>Queue</tt> of messages.
   */
  protected Queue q;

  /**
   * Creates a new <tt>QueueInputStream</tt>.
   * @param q A <tt>Queue</tt> out of which messages will be read
   */
  public QueueInputStream (Queue q) {
    super (null);
    this.q = q;
  }

  /**
   * A buffer containing the most recently received message.
   * <p>This variable is exposed to permit potential optimizations.
   */
  byte[] buffer;

  /**
   * Extracts a message from the attached <tt>Queue</tt> and makes
   * it available to read through the usual superclass <tt>read()</tt>
   * methods.
   */
  public void receive () {
    buffer = (byte[]) q.remove ();
    in = new ByteArrayInputStream (buffer);
  }
}

