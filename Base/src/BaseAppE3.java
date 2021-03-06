import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class BaseAppE3 extends Frame implements WindowListener    {
    Label label1, label2, label3, label4;
    TextField textField1, textField2;
    TextArea textArea1, textArea2;
    Button button1, button2, button3, button4, button5, button6;
    BaseRead baseRead;
    BaseWrite baseWrite; 	
//--------------------------------------------------
public BaseAppE3() {
        addWindowListener(this);
        this.setLayout(null);
        label1 = new Label("Label1:");
        label1.reshape(110, 35, 40, 15);
        this.add(label1);
        textField1 = new TextField();
        textField1.reshape(150, 40, 200, 15);
        this.add(textField1);
        label2 = new Label("Label2:");
        label2.reshape(370, 35, 40, 15);
        this.add(label2);
        textField2 = new TextField();
        textField2.reshape(410, 40, 30, 15);
        this.add(textField2);
        label3 = new Label("Nome file:");
        label3.reshape(20, 55, 100, 15);
        this.add(label3);
        textArea1 = new TextArea();
        textArea1.reshape(20, 70, 560, 50);
        this.add(textArea1);
        label4 = new Label("Contenuto file:");
        label4.reshape(20, 125, 100, 15);
        this.add(label4);
        textArea2 = new TextArea();
        textArea2.reshape(20, 140, 560, 300);
        this.add(textArea2);
        button1 = new Button("Apri");
        button1.reshape(70, 460, 60, 20);
        this.add(button1);
        button2 = new Button("Salva");
        button2.reshape(150, 460, 60, 20);
        this.add(button2);
        button3 = new Button("Button3");
        button3.reshape(230, 460, 60, 20);
        this.add(button3);
        button4 = new Button("Button4");
        button4.reshape(310, 460, 60, 20);
        this.add(button4);
        button5 = new Button("Button5");
        button5.reshape(390, 460, 60, 20);
        this.add(button5);
        button6 = new Button("Button6");
        button6.reshape(470, 460, 60, 20);
        this.add(button6);
        resize(600, 460);
        show();
    }
//--------------------------------------------------
    public static void main(String args[]) {
        BaseAppE3 baseAppE3 = new BaseAppE3();
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
            baseRead = new BaseRead(textArea1, textArea2);
        baseRead.readFile();
    }
//--------------------------------------------------
    void button2_Clicked(Event event) {
            baseWrite = new BaseWrite(textArea1, textArea2);
        baseWrite.writeFile();

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





