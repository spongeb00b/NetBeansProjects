import java.io.*;
import java.awt.*;
import java.net.*;
//import prominence.msg.*;

public class CollabTool extends Frame {
  protected static int id = 0;

  public CollabTool (InputStream i, OutputStream o) {
    super ("Collaborative Tool " + (id ++));
    setResizable(false);
    Whiteboard wb = new Whiteboard ();
    Chatboard cb = new Chatboard ();
    setLayout (new GridLayout (2, 1));
    add (wb);
    add (cb);
    resize (400, 500);

    MessageOutputStream mO = new MessageOutputStream (o);
    MessageInputStream mI = new MessageInputStream (i);

    cb.setMessageOutput (new MultiplexOutputStream (mO, "chat"));
    wb.setMessageOutput (new MultiplexOutputStream (mO, "wb"));

    Demultiplexer d = new Demultiplexer (new MultiplexInputStream (mI));
    d.register ("chat", cb.getMessageOutput ());
    d.register ("wb", wb.getMessageOutput ());
    d.start ();
  }

  static public void main (String args[]) throws IOException {
  
  Socket socket = new Socket(args[0], 8888);
  
    new CollabTool (socket.getInputStream(),socket.getOutputStream()).show ();
  }
}

