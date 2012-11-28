import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class BaseAppE8 extends Frame implements WindowListener    {
    Label label0, label1, label2, label3, label4;
    TextField textField1, textField2;
    TextArea textArea1, textArea2;
    Button button1, button2, button3, button4, button5, button6;
    BaseTConn baseTConn;
//--------------------------------------------------
public BaseAppE8() {
        addWindowListener(this);
        this.setLayout(null);
               
        label1 = new Label("Host:");
        label1.reshape(120, 25, 40, 15);
        this.add(label1);
        textField1 = new TextField();
        textField1.reshape(150, 30, 200, 15);
        this.add(textField1);
        label2 = new Label("Port:");
        label2.reshape(370, 25, 40, 15);
        this.add(label2);
        textField2 = new TextField();
        textField2.reshape(410, 30, 30, 15);
        this.add(textField2);
        label3 = new Label("Command:");
        label3.reshape(20, 45 , 100, 15);
        this.add(label3);
        textArea1 = new TextArea();
        textArea1.reshape(20, 60, 560, 50);
        this.add(textArea1);
        label4 = new Label("Response:");
        label4.reshape(20, 115, 100, 15);
        this.add(label4);
        textArea2 = new TextArea();
        textArea2.reshape(20, 130, 560, 300);
        this.add(textArea2);
        button1 = new Button("Connect");
        button1.reshape(70, 450, 60, 20);
        this.add(button1);
        button2 = new Button("Send");
        button2.reshape(150, 450, 60, 20);
        this.add(button2);
 
        button4 = new Button("Close");
        button4.reshape(310, 450, 60, 20);
        this.add(button4);
        button5 = new Button("Button5");
        button5.reshape(390, 450, 60, 20);
        this.add(button5);
        button6 = new Button("Button6");
        button6.reshape(470, 450, 60, 20);
        this.add(button6);
        resize(600, 460);
        show();
    }
//--------------------------------------------------
    public static void main(String args[]) {
            new BaseAppE8();
    }
//--------------------------------------------------
    public boolean handleEvent(Event event) {
        if (event.id == Event.WINDOW_DESTROY) {
            hide();         // hide the Frame
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
    public void windowClosing(WindowEvent we) {
        dispose();
        System.exit(0);
    }

    public void windowOpened(WindowEvent e) {}

    public void windowClosed(WindowEvent e) {}
 
    public void windowIconified(WindowEvent e) {}
 
    public void windowDeiconified(WindowEvent e) {}

    public void windowActivated(WindowEvent e) {}

    public void windowDeactivated(WindowEvent e) {}
}
