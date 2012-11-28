

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author raffaele
 */
public class Main {

    public static void main(String[] args) {
        if (args.length == 1) {
            Totalizzatore t = new Totalizzatore();

            System.out.println("\nSto per generare " + args[0] + " Threads!");
            System.out.println("Ognuno dei quali genera 10 numeri casuali in scala ");
            System.out.println("e incrementerà un totalizzatore che ora vale: " + t.getTotale() + "\n");
            int numThread = Integer.parseInt("" + args[0]);
            //numThread = 10;//Integer.valueOf(args[0]);
            ThreadGroup gruppo = new ThreadGroup("Gruppo1");

            for (int i = 0; i < numThread; i++) {
                new ThreadGenera(i * 10, (i + 1) * 10, gruppo, i, t).start();
            }
            ThreadGenera[] arrayThread = new ThreadGenera[numThread];
            gruppo.enumerate(arrayThread);
            System.out.println("Thread aperti: " + gruppo.activeCount());
            //for (int i = 0; i < numThread; i++) {
            //        arrayThread[i].interrupt();
            System.out.println("Lettura totale dal Main = " + t.getTotale());


        }



    }
}

