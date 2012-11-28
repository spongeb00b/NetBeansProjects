/* Copyright (c) 1996, 1997 Prominence Dot Com, Inc.        *
 * See the file legal.txt in the txt directory for details. */

//package prominence.msg;

import java.io.*;

/**
 * A <tt>MessageOutput</tt> that immediately delivers its
 * contents to a recipient specified in the constructor when
 * send() is called.
 * <p>The message is delivered through the <tt>Recipient</tt> interface.
 *
 * @version 1.0 1 Nov 1996
 * @author Merlin Hughes
 * @see prominence.msg.Recipient
 */
public class DeliveryOutputStream extends MessageOutput {
  /**
   * A <tt>ByteArrayOutputStream</tt> used to buffer the message contents.
   */
  protected ByteArrayOutputStream byteO;
  /**
   * The recipient of messages sent to this stream.
   */
  protected Recipient r;

  /**
   * Creates a new <tt>DeliveryOutputStream</tt> with a specified recipient.
   * @param r The recipient for messages sent to this stream.
   */
  public DeliveryOutputStream (Recipient r) {
    super (new ByteArrayOutputStream ());
    byteO = (ByteArrayOutputStream) out;
    this.r = r;
  } 

  /**
   * Delivers the current message contents to the designated recipient.
   */
  public void send () {
    byte buffer[] = byteO.toByteArray ();
    ByteArrayInputStream bI = new ByteArrayInputStream (buffer);
    r.receive (new DataInputStream (bI));
    byteO.reset ();
  }
}

