/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author raffaele
 */
public class Motocicletta {
    String marca;
    String colore;
    boolean accesa = false;

    void accendi()
    {if(accesa)
        System.out.println("E' già accesa ");
     else
        {
         accesa = true;
         System.out.println("Ora è accesa ");
        }
    }
    void mostra()
    {System.out.println("Questa moto è una "+marca+" "+colore);
     if(accesa)
         System.out.println("E' accesa ");
     else
         System.out.println("E' spenta ");
   }
   void spengi()
   {if(!accesa)
        System.out.println("E' già spenta ");
    else
        {
        accesa = false;
        System.out.println("Ora è spenta ");
        }

  }
}


class ProgrammaMotocicletta {
public static void main (String args[]){
    Motocicletta m;
    Motocicletta m2;
    m = new Motocicletta();
    m.marca = "Suzuki";
    m.colore = "rossa";
    System.out.println("Descrizione: ");
    m.mostra();
    System.out.println("Accensione: ");
    m.accendi();
    m.spengi();
    m2 = new Motocicletta();
    m2.marca = "Yamaha";
    m2.colore = "nera";
    System.out.println("Descrizione");
    m2.mostra();
    m2.spengi();
    m2.accendi();

}
}
