/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prova;


import java.awt.*;
import java.io.*;

public class BaseWrite {
    TextArea commandArea, responseArea;
    PrintStream os = null;
//--------------------------------------------------
    public BaseWrite(TextArea commandArea, TextArea responseArea) {
    
        this.commandArea = commandArea;
        this.responseArea = responseArea;
        
        try {
            os = new PrintStream(new FileOutputStream(commandArea.getText()));
        } catch (Exception e)   {
            responseArea.appendText("Exception" + "\n");
        }
    }
//--------------------------------------------------
    public void writeFile() {
        os.print(responseArea.getText());
        os.close();
    }   
}

    
