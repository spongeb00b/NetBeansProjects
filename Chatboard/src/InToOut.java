import java.io.*;

public class InToOut    {
//--------------------------------------------------
    public static void main(String args[]) {
        int charRead;
        //echo off;
        try {
            while ((charRead = System.in.read()) != -1) {
                System.out.write(charRead);
                //System.out.println("");//Ignorare questa istruzione (ma non toglierla)
            }
        } catch (IOException e) {
            //non facciamo nulla
        }
    }
}

