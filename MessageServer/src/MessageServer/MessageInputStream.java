package MessageServer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author raffaele
 *//* Copyright (c) 1996, 1997 Prominence Dot Com, Inc.        *
 * See the file legal.txt in the txt directory for details. */

//package prominence.msg;

import java.io.*;

/**
 * A <tt>MessageInput</tt> that reads messages from an
 * attached <tt>InputStream</tt>.
 *
 * @version 1.0 1 Nov 1996
 * @author Merlin Hughes
 * @see prominence.msg.MessageOutputStream
 */
public class MessageInputStream extends MessageInput {
  /**
   * The attached <tt>InputStream</tt>.
   */
  protected InputStream i;
  /**
   * A <tt>DataInputStream</tt> attached to <tt>i</tt>.
   */
  protected DataInputStream dataI;

  /**
   * Creates a new <tt>MessageInputStream</tt>.
   * @param i The <tt>InputStream</tt> from which to read messages.
   */
  public MessageInputStream (InputStream i) {
    super (null);
    this.i = i;
    dataI = new DataInputStream (i);
  }

  /**
   * A buffer containing the most recently received message.
   * <p>This variable is exposed to permit potential optimizations.
   */
  byte[] buffer;

  /**
   * Receives a message from the attached stream. An <tt>int</tt>
   * header is read, which indicates the length of the message body.
   * The message body is then read and made available through the
   * usual superclass <tt>read()</tt> methods.
   * <p>This method synchronizes on the attached stream.
   * @exception IOException Occurs if there is a problem reading
   * from the attached stream.
   */
  public void receive () throws IOException {
    synchronized (i) {
      int n = dataI.readInt ();
      buffer = new byte[n];
      dataI.readFully (buffer);
    }
    in = new ByteArrayInputStream (buffer);
  }
}
