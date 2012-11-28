

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
 * The superclass for all message input streams.
 * <p>Extends <tt>DataInputStream</tt> and adds a <tt>receive()</tt>
 * method that receives a new message from the attached channel.
 *
 * @version 1.0 1 Nov 1996
 * @author Merlin Hughes
 * @see prominence.msg.MessageOutput
 */
public abstract class MessageInput extends DataInputStream {
  /**
   * Creates a new <tt>MessageInput</tt>.
   * @param in Stream from which to read message data
   */
  public MessageInput (InputStream in) {
    super (in);
  }

  /**
   * Receives a new message from the attached channel and makes
   * it available to read through the standard <tt>DataInputStream</tt>
   * methods.
   * <p>Subclasses will extend this class and implement this method
   * as appropriate for a particular communications channel.
   * @exception IOException Occurs if there is a problem receiving
   * a new message.
   */
  public abstract void receive () throws IOException;
}

