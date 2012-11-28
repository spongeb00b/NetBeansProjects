/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author raffaele
 */
package BaseAppE1;

import java.awt.*;

public class BaseAppE1 extends Frame    {
    Label label1, label2, label3, label4;
    TextField textField1, textField2;
    TextArea textArea1, textArea2;
    Button button1, button2, button3, button4, button5, button6;
//--------------------------------------------------
public BaseAppE1() {
        this.setLayout(null);
        label1 = new Label("Label1:");
        label1.reshape(110, 5, 40, 15);
        this.add(label1);
        textField1 = new TextField();
        textField1.reshape(150, 10, 200, 15);
        this.add(textField1);
        label2 = new Label("Label2:");
        label2.reshape(370, 5, 40, 15);
        this.add(label2);
        textField2 = new TextField();
        textField2.reshape(410, 10, 30, 15);
        this.add(textField2);
        label3 = new Label("Label3:");
        label3.reshape(20, 25, 100, 15);
        this.add(label3);
        textArea1 = new TextArea();
        textArea1.reshape(20, 40, 560, 50);
        this.add(textArea1);
        label4 = new Label("Label4:");
        label4.reshape(20, 95, 100, 15);
        this.add(label4);
        textArea2 = new TextArea();
        textArea2.reshape(20, 110, 560, 300);
        this.add(textArea2);
        button1 = new Button("Button1");
        button1.reshape(70, 430, 60, 20);
        this.add(button1);
        button2 = new Button("Button2");
        button2.reshape(150, 430, 60, 20);
        this.add(button2);
        button3 = new Button("Button3");
        button3.reshape(230, 430, 60, 20);
        this.add(button3);
        button4 = new Button("Button4");
        button4.reshape(310, 430, 60, 20);
        this.add(button4);
        button5 = new Button("Button5");
        button5.reshape(390, 430, 60, 20);
        this.add(button5);
        button6 = new Button("Button6");
        button6.reshape(470, 430, 60, 20);
        this.add(button6);
        resize(600, 550);
        show();
    }
//--------------------------------------------------
    public static void main(String args[]) {
            new BaseAppE1();
            
    }
//--------------------------------------------------
    public boolean handleEvent(Event event) {
        
        if (event.id == Event.WINDOW_DESTROY) {
            
 //this.setVisible(false);
            //hide();         // hide the Frame
            setVisible(false);
            dispose();      // tell windowing system to free resources
            System.exit(0); // exit
            return true;
        }
        if (event.target == button1 && event.id == Event.ACTION_EVENT) {
            button1_Clicked(event);
        }
        if (event.target == button2 && event.id == Event.ACTION_EVENT) {
            button2_Clicked(event);
        }
        if (event.target == button3 && event.id == Event.ACTION_EVENT) {
            button3_Clicked(event);
        }
        if (event.target == button4 && event.id == Event.ACTION_EVENT) {
            button4_Clicked(event);
        }
        if (event.target == button5 && event.id == Event.ACTION_EVENT) {
            button5_Clicked(event);
        }
        if (event.target == button6 && event.id == Event.ACTION_EVENT) {
            button6_Clicked(event);
        }
        return super.handleEvent(event);
    }
//--------------------------------------------------
    void button1_Clicked(Event event) {
            textArea2.setText(textArea2.getText() + "Hai premuto bottone 1\n");
    }
//--------------------------------------------------
    void button2_Clicked(Event event) {
            textArea2.setText(textArea2.getText() + "Hai premuto bottone 2\n");
    }
//--------------------------------------------------
    void button3_Clicked(Event event) {
        textArea2.setText(textArea2.getText() + "Hai premuto bottone 3\n");
    }
//--------------------------------------------------
    void button4_Clicked(Event event) {
        textArea2.setText(textArea2.getText() + "Hai premuto bottone 4\n");
    }
//--------------------------------------------------
    void button5_Clicked(Event event) {
        textArea2.setText(textArea2.getText() + "Hai premuto bottone 5\n");
    }
//--------------------------------------------------
    void button6_Clicked(Event event) {
        textArea2.setText(textArea2.getText() + "Hai premuto bottone 6\n");
    }
}
