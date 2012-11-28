/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;


import java.net.*;
import java.io.*;
import java.util.*;

    public class ChatServer {
//--------------------------------------------------
    public ChatServer() throws IOException {
        ServerSocket server = new ServerSocket(8888);
        System.out.println ("Accepting connections...");
        while(true) {
            Socket client = server.accept();
            String ipAdd = ((client.getInetAddress()).toString()).substring(1);
            System.out.println ("Accepted from " + ipAdd);
            new ChatHandler(client).start();
        }
    }
//--------------------------------------------------
    public static void main(String args[]) throws IOException {
        new ChatServer();
    }
}
