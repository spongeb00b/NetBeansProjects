import java.net.*;
import java.io.*;
import java.util.*;

public class ChatHandler extends Thread {
  protected static Vector handlers = new Vector();
  protected String userName;
  protected Socket socket;
  protected DataInputStream is;
  protected PrintStream os;
//--------------------------------------------------
  public ChatHandler(Socket socket) throws IOException {
    this.socket = socket;
    is = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
    os = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
  }
//--------------------------------------------------
  public void run() {
    try {
      userName = is.readLine();
      os.println("Salve " + userName + ", benvenuto nella chatline di Reti II");
      os.flush();
      broadcast(this, "Salve a tutti! Ci sono anch'io.");
      handlers.addElement(this); //e' un metodo sincronizzato
      while (true) {
        String msg = is.readLine();
        if (msg != null) broadcast(this, msg);
        else break;
      }
    } catch(IOException ex) {
      ex.printStackTrace();
    } finally {
      handlers.removeElement(this); //e' un metodo sincronizzato
      broadcast(this, "Arrivederci a presto.");
      try {
        socket.close();
      } catch(Exception ex) {
        ex.printStackTrace();
      }
    }
  }
//--------------------------------------------------
  protected static void broadcast(ChatHandler sender, String message) {
    synchronized (handlers) { //ora nessuno puo' aggiungersi o abbandonare 
      Enumeration e = handlers.elements();
      while (e.hasMoreElements()) {
        ChatHandler c = (ChatHandler) e.nextElement();
        try {
          c.os.print("Da " + sender.userName);
          c.os.print("@" + sender.socket.getInetAddress().getHostName() + ": ");
          c.os.println(message);
          c.os.flush();
        } catch(Exception ex) {
          c.stop();
        }
      }
    }
  }
}