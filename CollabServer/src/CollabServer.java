import java.net.*;
import java.io.*;
import java.util.*;

public class CollabServer {

//--------------------------------------------------

  public CollabServer() throws IOException {
  
    ServerSocket server = new ServerSocket(8888);
    System.out.println ("Accepting connections...");
    while(true) {
      Socket client = server.accept();
      System.out.println ("Accepted from " + client.getInetAddress());
      new CollabHandler(client).start();
    }
  }

//--------------------------------------------------

  public static void main(String args[]) throws IOException {
  
    new CollabServer();
  }

}

