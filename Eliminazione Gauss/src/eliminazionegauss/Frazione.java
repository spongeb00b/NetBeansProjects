/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eliminazionegauss;

/**
 *
 * @author raffaele
 */
public class Frazione {

    long numeratore;
    long denominatore;
    boolean segno;

    Frazione(long num, long den) {
        //Aggiusta il segno della frazione

        boolean numsign, densign;
        if (num >= 0) {
            numsign = true;
        } else {
            numsign = false;
        }
        if (den >= 0) {
            densign = true;
        } else {
            densign = false;
        }
        segno = !(numsign ^ densign);
        denominatore = Math.abs(den);
        numeratore = Math.abs(num);
    }

    private long minimoComuneMultiplo(long a, long b) {
        return a * b / massimoComunDivisore(a, b);
    }

    private long massimoComunDivisore(long a, long b) {
        //Euclide algorithm rules
        if (a == 0 || b == 0) {
            return 0;
        } else {
            while (a != b) {
                if (a > b) {
                    a -= b;
                } else {
                    b -= a;
                }
            }
        }
        return a;
    }

    boolean calcolaSegno(Frazione a, Frazione b) {

        return !(a.segno ^ b.segno);
    }

    void normalizzaFrazione() {
        //Semplifica la frazione restituendo numeratore e denominatore primi fra loro
        long mcd = massimoComunDivisore(numeratore, denominatore);
        if (mcd == 0) {
            denominatore = 1;
            return;
        }
        denominatore /= mcd;
        numeratore /= mcd;

    }

    String stampaFrazione() {
        String valore = "";
        if (numeratore == denominatore) {
            if (segno) {
                valore = "" + 1;
            } else {
                valore = "-" + 1;
            }
        } else if (denominatore == 1) {
            if (segno) {
                valore = "" + numeratore;
            } else {
                valore = "-" + numeratore;
            }
        } else if (segno) {
            valore = "" + numeratore + "/" + denominatore;
        } else {
            valore = "-" + numeratore + "/" + denominatore;
        }
        return valore;
    }

    Frazione somma(Frazione b) {
        this.normalizzaFrazione();
        b.normalizzaFrazione();
        if (numeratore == 0) {
            return b;
        }
        if (b.numeratore == 0) {
            return this;
        }
        long mcm = minimoComuneMultiplo(denominatore, b.denominatore);
        long thisnum = numeratore, bnum = b.numeratore;
        if (segno == false) {
            thisnum *= (-1);
        }
        if (b.segno == false) {
            bnum *= (-1);
        }
        long tempnum = (thisnum * (mcm / denominatore)) + (bnum * (mcm / b.denominatore));
        Frazione risultato = new Frazione(tempnum, mcm);
        risultato.normalizzaFrazione();
        return risultato;

    }

    Frazione moltiplica(Frazione b) {
        if (numeratore == 0 || b.numeratore == 0) {
            return new Frazione(0, 1);
        }
        long tempnum = numeratore * b.numeratore;
        long tempden = denominatore * b.denominatore;
        Frazione risultato = new Frazione(tempnum, tempden);
        risultato.segno = calcolaSegno(this, b);
        risultato.normalizzaFrazione();
        return risultato;
    }

    Frazione dividi(Frazione b) {
        if (numeratore == 0) {
            return new Frazione(0, 1);
        }
        long tempnum = numeratore * b.denominatore;
        long tempden = denominatore * b.numeratore;
        Frazione risultato = new Frazione(tempnum, tempden);
        risultato.segno = calcolaSegno(this, b);
        risultato.normalizzaFrazione();
        return risultato;


    }
    /*Restituisce una stringa contentente il valore della frazione numeratore e denominatore
     * separati dal simbolo /
     **/

    String segnoFrazione() {
        String valore = "";
        if (this.denominatore == 1) {
            if (!this.segno) {
                long num = this.numeratore * (-1);
                valore = "" + num;
            } else {
                valore = "" + this.numeratore;
            }
        } else {
            if (!this.segno) {
                long num = this.numeratore * (-1);
                valore = "" + num + "/" + this.denominatore;
            } else {
                valore = "" + this.numeratore + "/" + this.denominatore;
            }
        }
        return valore;
    }

    int[] caricaInversiMoltiplicativi(int modulo) {
        int moltiplica[] = new int[modulo * 2];
        for (int i = 0; i < modulo * 2; i += 2) {
            if (i == 0) {
                moltiplica[i] = 0;
                moltiplica[i + 1] = modulo;
            } else {
                moltiplica[i] = i / 2;
                for (int j = 1; j <= modulo; j++) {
                    if ((moltiplica[i] * j) % modulo == 1) {
                        moltiplica[i + 1] = j;
                        break;
                    }
                }
            }
        }
        return moltiplica;
    }

    long trovaInverso(int modulo, long valore){
        int valoreZeta = (int) (valore % modulo);
        int []array = caricaInversiMoltiplicativi(modulo);
        for(int i = 0; i < modulo*2; i += 2){
            if(array[i] == valoreZeta)
                return array[i+1];
        }
    return 0;
    }

    long convertiNegativoZetaP(int modulo, long valore){
        if(valore < 0){
            while(valore <= 0)
                valore += modulo;
        }
        return valore;

    }

    void trasformaInZetaP(int modulo) {
        if(denominatore % modulo == 0)
            denominatore = 0;
        else{ 
            if(!segno)
        {
            numeratore *= -1;
            segno = true;
        }
        long num = convertiNegativoZetaP(modulo, numeratore);
        numeratore = ((num % modulo)*trovaInverso(modulo,denominatore)) % modulo;
        denominatore = 1;
        }
    }

void stampaInversi(int modulo){ //metodo di diagnostica
    int []array = caricaInversiMoltiplicativi(modulo);
    for(int i = 0; i < array.length; i++){
            System.out.print("["+array[i]+"]");
        if(i % 2 == 1)
            System.out.println("");
        
    }
    System.out.println("\n\n");

    
}   




}

