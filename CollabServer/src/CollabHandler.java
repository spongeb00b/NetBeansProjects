import java.net.*;
import java.io.*;
import java.util.*;
//import prominence.msg.*;

public class CollabHandler extends Thread {

  protected static Vector handlers = new Vector();
  protected Socket socket;
  protected MessageInputStream is;
  protected MessageOutputStream os;

//--------------------------------------------------

  public CollabHandler(Socket socket) throws IOException {

    this.socket = socket;
    is = new MessageInputStream(socket.getInputStream());
    os = new MessageOutputStream(socket.getOutputStream());
  }

//--------------------------------------------------

  public void run() {

    try {
      handlers.addElement(this); //e' un metodo sincronizzato
      while (true) {
        is.receive();
        byte[] buffer = new byte[is.available()];
        is.readFully(buffer);
        broadcast(this, buffer);
      }
    } catch(IOException ex) {
      ex.printStackTrace();
    } finally {
      handlers.removeElement(this); //e' un metodo sincronizzato
      try {
        socket.close();
      } catch(Exception ex) {
        ex.printStackTrace();
      }
    }
  }

//--------------------------------------------------

  protected static void broadcast(CollabHandler sender, byte[] buffer) {

    synchronized (handlers) { //ora nessuno puo' aggiungersi o abbandonare 
      Enumeration e = handlers.elements();
      while (e.hasMoreElements()) {
        CollabHandler c = (CollabHandler) e.nextElement();
        if (c != sender) {
          try {
            c.os.write(buffer);
            c.os.send();
          } catch(Exception ex) {
            c.stop();
          }
        }
      }
    }
  }
}

