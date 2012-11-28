/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpingpong;

/**
 *
 * @author raffaele
 */
import java.io.*;
import java.lang.*;

public class RPingPong /*extends AnotherClass*/ implements Runnable {
    String word;
    int delay;
//--------------------------------------------------
    public RPingPong (String whatToSay, int delayTime) {
        word = whatToSay;
        delay = delayTime;
    }
//--------------------------------------------------
    public void run () {
        try {
            while (true) {
                System.out.println(word);
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            return;
        }
    }
//--------------------------------------------------
    public static void main(String args[]) {
        Runnable ping = new RPingPong("ping", 100); //1/10 sec.
        Runnable PONG = new RPingPong("PONG", 100); //1/10 sec.

        new Thread(ping).start();
        new Thread(PONG).start();
        new Thread(PONG).start();
        new Thread(ping).start();
        new Thread(PONG).start();
        new Thread(PONG).start();
        new Thread(PONG).start();
    }
}
