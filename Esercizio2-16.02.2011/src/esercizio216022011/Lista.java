/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio216022011;

import java.io.*;

/**
 *
 * @author raffaele
 */
public class Lista {

    Elemento testa = null;
    BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));

    Lista() {
    }

    void riempiLista() {
        boolean done = true;
        int count = 1;
        String letto;
        Elemento nuovo;
        while (done) {
            try {
                System.out.println("Inserisci la " + count + "a stringa della lista");
                letto = tastiera.readLine();
                nuovo = new Elemento(letto, testa);
                testa = nuovo;
                System.out.println("Inserire un altra stringa? (0 per uscire)");
                letto = tastiera.readLine();
                count++;
                if (letto.equals("0")) {
                    done = false;
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

    void stampaLista() {
        if (testa != null) {
            int conta = 1;
            for (Elemento corrente = testa; corrente != null; corrente = corrente.successivo) {
                System.out.println("Elemento" + conta + ": " + corrente.valore);
                conta++;
            }
        }
    }

    int conta(String stringa) {
        if (testa != null) {
            int conta = 0, conta2 = 0;
            for (Elemento corrente = testa; corrente != null; corrente = corrente.successivo) {
                if (stringa.charAt(conta) > corrente.valore.charAt(conta)) {
                    conta2++;
                } else if (stringa.charAt(conta) == corrente.valore.charAt(conta)) {
                    while (conta < stringa.length() - 1 && conta < corrente.valore.length() - 1) {
                        if (stringa.charAt(conta) > corrente.valore.charAt(conta)) {
                            conta2++;
                            break;
                        } else if (stringa.charAt(conta) < corrente.valore.charAt(conta)) {
                            break;
                        }
                        conta++;
                    }
                    conta = 0;
                }
            }
            return conta2;
        }
        return 0;
    }
}
