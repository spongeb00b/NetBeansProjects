/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prova;

import java.awt.*;
import java.io.*;

public class BaseRead {
    TextArea commandArea, responseArea;
    DataInputStream is = null;
//--------------------------------------------------
    public BaseRead(TextArea commandArea, TextArea responseArea) {
        this.commandArea = commandArea;
        this.responseArea = responseArea;
        try {
            is=new DataInputStream(new FileInputStream(commandArea.getText()));
        } catch (Exception e)   {
            responseArea.appendText("Exception" + "\n");
        }
    }
//--------------------------------------------------
    public void readFile() {
        String inputLine;
        try {
            while ((inputLine = is.readLine()) != null) {
                responseArea.appendText(inputLine + "\n");
            }
        } catch (IOException e) {
            responseArea.appendText("IO Exception" + "\n");
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                responseArea.appendText("IO Exception" + "\n");
            }
        }
    }   
}