


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author raffaele
 */
public class ThreadGenera extends Thread {

    int inizio;
    int fine;
    Totalizzatore t;

    ThreadGenera(int inizio, int fine, ThreadGroup gruppo, int id, Totalizzatore t) {
        super(gruppo, "Thread " + id);
        this.inizio = inizio;
        this.fine = fine;
        this.t = t;

    }

    public void run() {
        int contatore = 0, temp = 0, intervallo = fine - inizio;

        for (int i = inizio; i < fine; i++) {
            temp = (int) (Math.random() * intervallo) + inizio;
            System.out.println(this.getName() + ": Ha generato " + temp);
            contatore += temp;
        }
        synchronized (t) {
            t.incrementa(contatore);
        System.out.println("Lettura totalizzatore dal "+this.getName()+": "+t.getTotale());
        }
        /*try {
            this.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadGenera.class.getName()).log(Level.SEVERE, null, ex);
        }*/




    }
}
