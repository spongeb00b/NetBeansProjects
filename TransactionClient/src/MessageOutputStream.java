

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author raffaele
 */

/* Copyright (c) 1996, 1997 Prominence Dot Com, Inc.        *
 * See the file legal.txt in the txt directory for details. */

//package prominence.msg;

import java.io.*;

/**
 * A <tt>MessageOutput</tt> that writes messages to an attached
 * <tt>OutputStream</tt>.
 *
 * @version 1.0 1 Nov 1996
 * @author Merlin Hughes
 * @see prominence.msg.MessageInputStream
 */
public class MessageOutputStream extends MessageOutput {
  /**
   * The attached <tt>OutputStream</tt>.
   */
  protected OutputStream o;
  /**
   * A <tt>DataOutputStream</tt> attached to <tt>o</tt>.
   */
  protected DataOutputStream dataO;
  /**
   * A <tt>ByteArrayOutputStream</tt> used to buffer the current message.
   */
  protected ByteArrayOutputStream byteO;

  /**
   * Creates a new <tt>MessageOutputStream</tt>. Message data is
   * buffered internally until <tt>send()</tt> is called.
   * @param o The <tt>OutputStream</tt> to which to write messages
   */
  public MessageOutputStream (OutputStream o) {
    super (new ByteArrayOutputStream ());
    byteO = (ByteArrayOutputStream) out;
    this.o = o;
    dataO = new DataOutputStream (o);
  }

  /**
   * Sends a message to the attached stream. The message body length
   * is written as an <tt>int</tt>, followed by the message body itself;
   * the internal message buffer is then reset.
   * <p>This method synchronizes on the attached stream.
   * @exception IOException Occurs if there is a problem writing to
   * the attached stream.
   */
  public void send () throws IOException {
    synchronized (o) {
      dataO.writeInt (byteO.size ());
      byteO.writeTo (o);
    }
    byteO.reset ();
    o.flush ();
  }
}


