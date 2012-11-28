/* Copyright (c) 1996, 1997 Prominence Dot Com, Inc.        *
 * See the file legal.txt in the txt directory for details. */

//package prominence.msg;

import java.io.*;

/**
 * The superclass for all message output streams.
 * <p>Extends <tt>DataOutputStream</tt> and adds <tt>send()</tt>
 * methods that send the current message to the attached channel.
 *
 * @version 1.0 1 Nov 1996
 * @author Merlin Hughes
 * @see prominence.msg.MessageInput
 */
public abstract class MessageOutput extends DataOutputStream {
  /**
   * Creates a new <tt>MessageOutput</tt>.
   * @param out Stream to which to write message data.
   */
  public MessageOutput (OutputStream out) {
    super (out);
  }

  /**
   * Sends the current message to the attached channel.
   * <p>Subclasses will extend this class and implement this
   * method as appropriate for a particular communications
   * channel.
   * @exception IOException Occurs if there is a problem sending
   * a message.
   */
  public abstract void send () throws IOException;

  /**
   * Sends the current message to the attached channel with
   * a routing header that indicates a list of recipients.
   * <p>Subclasses that support this method will override it
   * with an appropriate implementation. The default implementation
   * is to throw an exception.
   * @param dst The list of intended recipients
   * @exception IOException Occurs if there is a problem sending
   * a message or this method is not supported.
   */
  public void send (String[] dst) throws IOException {
    throw new IOException ("send[] not supported");
  }

  /**
   * Sends the current message to the attached channel with
   * a routing header that indicates a single recipient.
   * <p>The default implementation of this method calls the
   * previous method with a single-element array.
   * @param dst The intended recipient
   * @exception IOException Occurs if there is a problem sending
   * a message or targeted sending is not supported.
   */
  public void send (String dst) throws IOException {
    String[] dsts = { dst };
    send (dsts);
  }
}

 
