/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 *
 * @author raffaele
 */
import java.io.*;
import java.net.*;
import java.lang.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleServer {
//--------------------------------------------------

    public static void main(String args[]) {
        ServerSocket server;
        Socket client;
        String inputLine;
        DataInputStream is = null;
        PrintStream os = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        
        
        while (true) {
            try {
                server = new ServerSocket(8888);
                
                System.out.println("[" + dateFormat.format(new Date()) + "]" + " Accepting one connection...");
                client = server.accept();
                server.close();
                String ipAdd = ((client.getInetAddress()).toString()).substring(1);
                System.out.println("]" + dateFormat.format(new Date())+ "]" + " Connection from " + ipAdd + " accepted.");
                is = new DataInputStream(client.getInputStream());
                os = new PrintStream(client.getOutputStream());
                os.println("From SimpleServer: Welcome!");
                System.out.println("[" + dateFormat.format(new Date()) + "]" + " I've just sent a Welcome message to the client");
                try{
                while ((inputLine = is.readLine()) != null) {
                    System.out.println("[" + dateFormat.format(new Date()) + "]" + " Received: " + inputLine);
                    os.println("From SimpleServer: " + inputLine);
                    System.out.println("[" + dateFormat.format(new Date()) + "]" + " I've just sent "+ inputLine +" to the client\n");
                }
                }catch(SocketException s){
                    System.out.println("[" + dateFormat.format(new Date()) + "]" + " Error: " + s.getMessage() + "\n");
                }
                is.close();
                os.close();
                client.close();
                System.out.println("[" + dateFormat.format(new Date()) + "]" + " Connection with "+ ipAdd +" closed.\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
