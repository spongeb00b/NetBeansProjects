/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prova;

/**
 *
 * @author raffaele
 */
import java.awt.*;
import java.lang.*;
import java.io.*;
import java.net.*;

public class BaseTConn implements Runnable {
    TextArea commandArea, responseArea;
    Socket socket = null;
    PrintStream os = null;
    DataInputStream is = null;
//--------------------------------------------------
    public BaseTConn(String host, String port,
                     TextArea commandArea, TextArea responseArea) {
        this.commandArea = commandArea;
        this.responseArea = responseArea;
        try {
            socket = new Socket(host, Integer.parseInt(port));
            os = new PrintStream(socket.getOutputStream());
            is = new DataInputStream(socket.getInputStream());
            responseArea.appendText("***Connection established" + "\n");
            new Thread(this).start();
        } catch (Exception e)   {
            responseArea.appendText("Exception" + "\n");
        }
    }
//--------------------------------------------------
    public void run() {
        String inputLine;
        try {
            while ((inputLine = is.readLine()) != null) {
                responseArea.appendText(inputLine + "\n");
            }
        } catch (IOException e) {
            responseArea.appendText("IO Exception" + "\n");
        }
    }   
//--------------------------------------------------
    public void send() {
            os.println(commandArea.getText());
    }   
//--------------------------------------------------
    public void close() {
        try {
            is.close();
            os.close();
            socket.close();
            responseArea.appendText("***Connection closed" + "\n");
        } catch (IOException e) {
            responseArea.appendText("IO Exception" + "\n");
        }
    }   
}

