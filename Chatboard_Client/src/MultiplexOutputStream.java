/* Copyright (c) 1996, 1997 Prominence Dot Com, Inc.        *
 * See the file legal.txt in the txt directory for details. */

//package prominence.msg;

import java.io.*;

/**
 * A <tt>MessageOutput</tt> that attaches to an existing <tt>MessageOutput</tt>
 * and attaches a multiplexing label to the header of each message that
 * is transmitted.
 * <p>The label is specified in the constructor and so one stream always
 * attaches the same label.
 *
 * @version 1.0 1 Nov 1996
 * @author Merlin Hughes
 * @see prominence.msg.MultiplexInputStream
 */
public class MultiplexOutputStream extends MessageOutput {
  /**
   * The <tt>MessageOutput</tt> to which this is attached.
   */
  protected MessageOutput o;
  /**
   * A <tt>ByteArrayOutputStream</tt> used to buffer the current message
   * contents.
   */
  protected ByteArrayOutputStream byteO;
  /**
   * The multiplexing label.
   */
  protected String label;

  /**
   * Creates a new <tt>MultiplexOutputStream</tt>.
   * @param o The <tt>MessageOutput</tt> to which to send messages
   * @param label The multiplexing label to be used by this stream
   */
  public MultiplexOutputStream (MessageOutput o, String label) {
    super (new ByteArrayOutputStream ());
    byteO = (ByteArrayOutputStream) out;
    this.o = o;
    this.label = label;
  }

  /**
   * Sends the current message with a multiplexing label header to the
   * attached <tt>MessageOutput</tt>.
   * @exception IOException Occurs if there is a problem sending the
   * message.
   */
  public void send () throws IOException {
    synchronized (o) {
      o.writeUTF (label);
      byteO.writeTo (o); 
      o.send ();
    }
    byteO.reset ();
  }

  /**
   * Sends the current message with a multiplexing label header to the
   * attached <tt>MessageOutput</tt>.
   * <p>If the attached <tt>MessageOutput</tt> supports targeted sending
   * then this method will succeed; otherwise an appropriate
   * <tt>IOException</tt> will be thrown.
   * @param dst The list of intended recipients
   * @exception IOException Occurs if there is a problem sending the
   * message or the targeted <tt>send()</tt> method is not supported by
   * the attached <tt>MessageOutput</tt>.
   */
  public void send (String[] dst) throws IOException {
    synchronized (o) {
      o.writeUTF (label);
      byteO.writeTo (o); 
      o.send (dst);
    }
    byteO.reset ();
  }
}

