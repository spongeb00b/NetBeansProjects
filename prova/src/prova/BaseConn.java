/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prova;

import java.awt.*;
import java.lang.*;
import java.io.*;
import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseConn {

    TextArea commandArea, responseArea;
    Socket socket = null;
    PrintStream os = null;
    DataInputStream is = null;
    DateFormat dateFormat = null;
    //--------------------------------------------------

    public BaseConn(String host, String port, TextArea commandArea, TextArea responseArea) {
        this.commandArea = commandArea;
        this.responseArea = responseArea;
        this.dateFormat  = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try {
            socket = new Socket(host, Integer.parseInt(port));
            os = new PrintStream(socket.getOutputStream());
            is = new DataInputStream(socket.getInputStream());
            responseArea.appendText("[" + dateFormat.format(new Date()) + "]" +" ***Connection established with " + host +"\n");
        } catch (Exception e) {
            responseArea.appendText("[" + dateFormat.format(new Date()) + "]" +" Exception: "+e.toString()+"\n");
            
        }

    }
//--------------------------------------------------

    public void send() {
        String text = commandArea.getText();
        try{
            os.println(text);
            responseArea.append("[" + dateFormat.format(new Date()) + "]" +" I've just sent to the server: " + text +"\n");
        }
        catch(Exception e){
            responseArea.appendText("Exception: " +e.toString()+"\n");
       }    
    
 }
//--------------------------------------------------

    public void receive() {
        String inputLine;
        try {

            inputLine = is.readLine();
            responseArea.appendText("[" + dateFormat.format(new Date()) + "] " +inputLine + "\n");

        } catch (Exception e) {
            responseArea.appendText("[" + dateFormat.format(new Date()) + "]" +"Exception: " +e.toString()+"\n"); 

        }
    }
//--------------------------------------------------

    public void close() {
        try {
            is.close();
            os.close();
            socket.close();
            responseArea.appendText("[" + dateFormat.format(new Date()) + "]" + " ***Connection closed" + "\n");
        } catch (Exception e) {
            responseArea.appendText("[" + dateFormat.format(new Date()) + "]" +" Exception" +e.toString()+ "\n");
        }
    }
}
