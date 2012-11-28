/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prova;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class BaseAppE3 extends Frame implements WindowListener {

    Label label1, label2, label3, label4;
    TextField textField1, textField2;
    TextArea textArea1, textArea2;
    Button button1, button2, button3, button4, button5, button6;
    BaseRead baseRead;
    BaseWrite baseWrite;
    BaseConn baseConn;
    BaseTConn baseTConn;
//--------------------------------------------------

    public BaseAppE3() {
        addWindowListener(this);
        this.setLayout(null);
        label1 = new Label("Host:");
        label1.reshape(110, 35, 40, 15);
        this.add(label1);
        textField1 = new TextField();

        textField1.reshape(150, 35, 200, 20);
        this.add(textField1);
        textField1.setText("127.0.0.1");
        label2 = new Label("Port:");
        label2.reshape(370, 35, 40, 15);
        this.add(label2);
        textField2 = new TextField();
        textField2.reshape(410, 35, 40, 20);
        this.add(textField2);
        textField2.setText("8888");
        label3 = new Label("Command:");
        label3.reshape(20, 55, 100, 15);
        this.add(label3);
        textArea1 = new TextArea();
        textArea1.reshape(20, 70, 560, 50);
        this.add(textArea1);
        textArea1.setText("Insert your username");
        label4 = new Label("Response:");
        label4.reshape(20, 125, 100, 15);
        this.add(label4);
        textArea2 = new TextArea();
        textArea2.reshape(20, 140, 560, 300);
        this.add(textArea2);
        button1 = new Button("Connect");
        button1.reshape(70, 460, 60, 20);
        this.add(button1);
        button2 = new Button("Send");
        button2.reshape(150, 460, 60, 20);
        this.add(button2);
        button3 = new Button("Recive");
        button3.reshape(230, 460, 60, 20);
        this.add(button3);
        button4 = new Button("Close");
        button4.reshape(310, 460, 60, 20);
        this.add(button4);
        button5 = new Button("Button5");
        button5.reshape(390, 460, 60, 20);
        this.add(button5);
        button6 = new Button("Button6");
        button6.reshape(470, 460, 60, 20);
        this.add(button6);
        resize(600, 510);
        show();
        this.setBounds(370, 100, 600, 510);
        this.setTitle("SAED Java Client");

    }
//--------------------------------------------------

    public static void main(String args[]) {
        new BaseAppE3();

    }
//--------------------------------------------------

    public boolean handleEvent(Event event) {

        if (event.target == textField1 && event.id == Event.GOT_FOCUS) {
            textField1.selectAll();
        }
        if (event.target == textField2 && event.id == Event.GOT_FOCUS) {
            textField2.selectAll();
        }
        if (event.target == textArea1 && event.id == Event.GOT_FOCUS) {
            textArea1.selectAll();
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
        baseTConn = new BaseTConn(textField1.getText(),
                textField2.getText(),
                textArea1, textArea2);
    }
//--------------------------------------------------

    void button2_Clicked(Event event) {
        baseTConn.send();

    }
//--------------------------------------------------

    void button3_Clicked(Event event) {
        /*baseTConn.receive();*/

    }
//--------------------------------------------------

    void button4_Clicked(Event event) {
        baseTConn.close();

    }
//--------------------------------------------------

    void button5_Clicked(Event event) {
        textArea2.setText(textArea2.getText() + "Hai premuto bottone 5\n");
    }
//--------------------------------------------------

    void button6_Clicked(Event event) {
        textArea2.setText(textArea2.getText() + "Hai premuto bottone 6\n");
    }

    @Override
    public void windowClosing(WindowEvent we) {
        dispose();
        System.exit(0);
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
