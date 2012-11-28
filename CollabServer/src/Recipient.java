/* Copyright (c) 1996, 1997 Prominence Dot Com, Inc.        *
 * See the file legal.txt in the txt directory for details. */

//package prominence.msg;

import java.io.*;

/**
 * The interface through which the <tt>DeliveryOutputStream</tt> delivers
 * messages.
 *
 * @version 1.0 1 Nov 1996
 * @author Merlin Hughes
 * @see prominence.msg.DeliveryOutputStream
 */
public interface  Recipient{
  /**
   * Delivers a new message to the recipient.
   * @param in A <tt>DataInputStream</tt> from which the message contents can
   * be read
   */
  public void receive (DataInputStream in);
}

