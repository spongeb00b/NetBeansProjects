/* Copyright (c) 1996, 1997 Prominence Dot Com, Inc.        *
 * See the file legal.txt in the txt directory for details. */

import java.io.*;
import java.awt.*;
//import prominence.msg.*;

public class Whiteboard extends Canvas implements Recipient {
  public Whiteboard () {
    setBackground (new Color (255, 255, 204));
  }

  protected MessageOutput o;

  public void setMessageOutput (MessageOutput o) {
    this.o = o;
  }

  public boolean mouseDown (Event e, int x, int y) {
    transmit (x, y);
    return super.mouseDown (e, x, y);
  }
public boolean mouseClick (Event e, int x, int y) {
    //transmit (x, y);
	setBackground (new Color (0, 255, 204));
    return super.mouseDown (e, x, y);
  }

  public boolean mouseDrag (Event e, int x, int y) {
    scribble (x, y);
    transmit (x, y);
    return super.mouseDrag (e, x, y);
  }

  public boolean mouseUp (Event e, int x, int y) {
    scribble (x, y);
    transmit (x, y);
    try {
      o.send ();
    } catch (IOException ex) {
      ex.printStackTrace ();
    }
    return super.mouseUp (e, x, y);
  }

  protected int oX, oY;

  protected void transmit (int x, int y) {
    try {
      o.writeInt (x);
      o.writeInt (y);
    } catch (IOException ex) {
      ex.printStackTrace ();
    }
    oX = x;
    oY = y;
  }

  protected void scribble (int x, int y) {
    Graphics g = getGraphics ();
    g.drawLine (oX, oY, x, y); 
    g.dispose ();
  }

  public MessageOutput getMessageOutput () {
    return new DeliveryOutputStream (this);
  }

  public void receive (DataInputStream dI) {
    Graphics g = getGraphics ();
    try {
      int x0 = dI.readInt (), y0 = dI.readInt ();
      while (dI.available () > 0) {
        int x1 = dI.readInt (), y1 = dI.readInt ();
        g.drawLine (x0, y0, x1, y1);
        x0 = x1;
        y0 = y1;
      }
    } catch (IOException ex) {
      ex.printStackTrace ();
    }
    g.dispose ();
  }
}

