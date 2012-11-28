import java.io.*;
import java.net.*;

public class SimpleServer   {
//--------------------------------------------------
    public static void main(String args[]) {
        ServerSocket server;
        Socket client;
        String inputLine;
        DataInputStream is = null;
        PrintStream os = null;
        while (true) {
	try {
            server = new ServerSocket(8888);
            System.out.println("Accepting one connection...");
            client = server.accept();
            server.close();
            System.out.println("Connection from one client accepted.");
            is = new DataInputStream(client.getInputStream());
            os = new PrintStream(client.getOutputStream());
            os.println("From SimpleServer: Welcome!");
            while ((inputLine = is.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                os.println("From SimpleServer: " + inputLine);
            }
            is.close();
            os.close();
            client.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {
            e.printStackTrace();        
        }
    }
}
}

