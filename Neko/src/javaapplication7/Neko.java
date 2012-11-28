/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication7;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.net.MalformedURLException;
import java.net.URL;


/**
 *
 * @author raffaele
 */
public class Neko extends java.applet.Applet implements Runnable {


    Image nekopics[] = new Image[9];
    Image currentimg;
    Thread runner;
    int imagenumber;
    int xpos;
    int ypos = 0;
    Font f = new Font("HELVETICA", Font.BOLD, 12);
    /**
     * Initialization method that will be called after the applet is loaded
     * into the browser.
     */
    public void init() {
        // TODO start asynchronous download of heavy resources
    String nekosrc[] = {"right1.gif","right2.gif","stop.gif","yawn.gif","scratch1.gif",
    "scratch2.gif","sleep1.gif","sleep2.gif","awake.gif"};
    for(int i = 0; i < nekopics.length; i++)
        try {
            nekopics[i] = getImage(new URL("http://www.csse.uwa.edu.au/~peterj/javalin/showneko/images/"+nekosrc[i]));
        } catch (MalformedURLException ex) {}
    }

    public void start(){
        if(runner == null) {
            runner = new Thread(this);
            runner.start();
        }
    }
    public void stop(){
       if(runner != null){
           runner.interrupt();
           runner = null;
       }
    }
    public void run(){
        
        while(true){
            setBackground(Color.white);

            imagenumber = 1;
            nekorun(0, getSize().width /2);
            

            currentimg = nekopics[2];
            imagenumber = 2; 
            repaint();
            pause(1000);

       
            imagenumber = 3;
            nekoscratch(4);
            

            currentimg = nekopics[3];
            imagenumber = 4;
            repaint();
            pause(1000);

            imagenumber = 5;
            nekosleep(5);
            

            currentimg = nekopics[8];
            imagenumber = 6;
            repaint();
            pause(1500);

            imagenumber = 1;
            nekorun(xpos, getSize().width + 10);
            
            
            
        }
    }
     void nekorun(int start, int end){
         for(int i = start; i < end; i +=10){
             xpos = i;
             if(currentimg == nekopics[0])
                 currentimg = nekopics[1];
             else    
                 currentimg = nekopics[0];
             repaint();
             pause(150);
         }
     }
                

     void nekoscratch(int numtimes){
         for(int i = numtimes; i > 0; i--){
             currentimg = nekopics[4];
             repaint();
             pause(150);
             currentimg = nekopics[5];
             repaint();
             pause(250);
         }
    }

     void nekosleep(int numtimes){
         for(int i = numtimes; i > 0; i--){
             currentimg = nekopics[6];
             repaint();
             pause(250);
             currentimg = nekopics[7];
             repaint();
             pause(250);

         }
     }
         


     void pause(int time){
         try{
             Thread.sleep(time);
         }
         catch(InterruptedException e){}
         }
    public void paint(Graphics g){
        if(currentimg != null);

    
        g.drawImage(currentimg, xpos, ypos, this);
        g.drawImage(currentimg, xpos, ypos + 30, this);
        g.drawImage(currentimg, xpos, ypos + 60, this);
        g.drawImage(currentimg, xpos, ypos + 90, this);
        g.drawImage(currentimg, xpos, ypos + 120, this);
        g.drawImage(currentimg, xpos, ypos + 150, this);
        g.setFont(f);
        g.setColor(Color.blue);
        switch(imagenumber){
            case 1: g.drawString("Run",xpos-3,getHeight()-5); break;
            case 2: g.drawString("Stop",xpos-2,getHeight()-5); break;
            case 3: g.drawString("Scratch",xpos-15,getHeight()-5); break;
            case 4: g.drawString("Yawn",xpos-7,getHeight()-5); break;
            case 5: g.drawString("Sleep",xpos-4,getHeight()-5); break;
            case 6: g.drawString("Wake up",xpos-17,getHeight()-5); break;
        }
        
    }
}

    // TODO overwrite start(), stop() and destroy() methods

