/* Copyright (c) 1996, 1997 Prominence Dot Com, Inc.        *
 * See the file legal.txt in the txt directory for details. */

//package prominence.msg;

import java.io.*;

/**
 * A <tt>MessageInput</tt> that attaches to an existing <tt>MessageInput</tt>
 * and strips the multiplexing label from each message that is received.
 * <p>The label is made publicly accessible in the <tt>label</tt> variable.
 *
 * @version 1.0 1 Nov 1996
 * @author Merlin Hughes
 * @see prominence.msg.MultiplexOutputStream
 */
public class MultiplexInputStream extends MessageInput {
  /**
   * The multiplexing label of the most recently received message.
   */
  public String label;
  /**
   * The <tt>MessageInput</tt> to which this is attached.
   */
  protected MessageInput i;

  /**
   * Creates a new <tt>MultiplexInputStream</tt>.
   * @param i The <tt>MessageInput</tt> from which messages should
   * be received
   */
  public MultiplexInputStream (MessageInput i) {
    super (i);
    this.i = i;
  }

  /**
   * Receives a new message from <tt>i</tt> and strips the multiplexing
   * label. The label is accessible in the <tt>label</tt> variable; the
   * contents of the message can be read through the usual superclass
   * <tt>read()</tt> methods.
   * @exception IOException Occurs if there is a problem receiving a
   * message or extracting the multiplexing label.
   */
  public void receive () throws IOException {
    i.receive ();
    label = i.readUTF ();
  }
}

