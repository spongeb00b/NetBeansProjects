import java.io.*;
import java.lang.*;

public class PingPong extends Thread {
    String word;
    int delay;
//--------------------------------------------------
    public PingPong (String whatToSay, int delayTime) {
        word = whatToSay;
        delay = delayTime;
    }
//--------------------------------------------------
    public void run () {
        try {
            while (true) {
                System.out.println(word);
                sleep(delay);
            }
        } catch (InterruptedException e) {
            return;
        }
    }
//--------------------------------------------------
    public static void main(String args[]) {
        new PingPong("ping", 250).start();  //1/4 sec.
        new PingPong("PONG", 100).start();  //1/10 sec.
    }
}
