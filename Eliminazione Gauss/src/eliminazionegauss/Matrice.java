/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eliminazionegauss;

/**
 *
 * @author raffaele
 */
public class Matrice {

    int indiceArray = -1;
    int riga = 0;
    int colonna = 0;
    Frazione[][] matrice;
    public int pivot[] = null;
    public Boolean righeNulle[];
    public Boolean colonneNulle[];
    int numscambi = 0;
    int primoZeta = 1; //1 per razionali o numero primo per le classi di congruenza modulo primoZeta

    public Matrice(int riga, int colonna, Frazione matrice[][]) {
        this.riga = riga;
        this.colonna = colonna;
        this.matrice = matrice;
        righeNulle = new Boolean[riga];
        colonneNulle = new Boolean[colonna];
        pivot = new int[calcolaMin() * 2];
        for (int i = 0; i < pivot.length; i++) {
            pivot[i] = -1;
        }
    }

    public void gauss() {
        int c = 0, r = 0, indice = 0, min = calcolaMin(), index = 0;
        while (index < min - 1) {
            ricercaPivot(c, r, indice);
            r = pivot[indice];
            c = pivot[indice + 1];
            if (r != -1 && c != -1) {
                if (r < riga - 1) {
                    for (int i = r; i < riga - 1; i++) {
                        Frazione mu = calcolaMu(i, c, indice);
                        moltiplicaSommaRiga(i, c, mu, indice);
                    }
                }
                r++;
                c++;
                index++;
                indice += 2;
            } else {
                break;
            }
        }
        if (r != -1 && c != -1) {
            ricercaPivot(c, r, indice);
            //visualizzaArrayPivot();
            if (pivot[pivot.length - 1] != -1 && pivot[pivot.length - 2] < riga) {
                for (int i = pivot[pivot.length - 2] + 1; i < riga; i++) {
                    matrice[i][pivot[pivot.length - 1]].numeratore = 0;
                    matrice[i][pivot[pivot.length - 1]].denominatore = 1;
                    matrice[i][pivot[pivot.length - 1]].segno = true;
                }
            }

        }
    }

    void ricercaPivot(int c, int r, int indice) {
        for (int j = c; j < colonna; j++) {
            for (int i = r; i < riga; i++) {
                if (matrice[i][j].numeratore != 0) {
                    if (i != r) {
                        scambiaRiga(i, r);
                    }
                    pivot[indice] = r;
                    pivot[indice + 1] = j;
                    break;
                }
            }
            if (pivot[indice + 1] != -1) {
                break;
            }
        }
    }

    void moltiplicaSommaRiga(int r, int c, Frazione mu, int indice) {
        if (primoZeta == 1) {
            for (int j = c; j < colonna; j++) {
                Frazione temp = new Frazione(1, 1);
                temp = mu.moltiplica(matrice[pivot[indice]][j]);
                Frazione risultato = matrice[r + 1][j].somma(temp);
                matrice[r + 1][j].numeratore = risultato.numeratore;
                matrice[r + 1][j].denominatore = risultato.denominatore;
                matrice[r + 1][j].segno = risultato.segno;
            }
        } else {
            for (int j = c; j < colonna; j++) {
                Frazione temp = new Frazione(1, 1);
                temp = mu.moltiplica(matrice[pivot[indice]][j]);
                temp.trasformaInZetaP(primoZeta);
                Frazione risultato = matrice[r + 1][j].somma(temp);
                risultato.trasformaInZetaP(primoZeta);
                System.out.println(mu.segnoFrazione());
                System.out.println(risultato.segnoFrazione());
                matrice[r + 1][j].segno = risultato.segno;
                matrice[r + 1][j].numeratore = risultato.numeratore;
                matrice[r + 1][j].denominatore = risultato.denominatore;


            }
        }
    }

    Frazione calcolaMu(int r, int c, int indice) {
        Frazione temp = new Frazione(1, 1);
        temp.denominatore = matrice[r + 1][c].denominatore;
        temp.numeratore = matrice[r + 1][c].numeratore;
        temp.segno = !matrice[r + 1][c].segno;
        if(primoZeta > 1){
            temp.trasformaInZetaP(primoZeta);
        }
        Frazione pivot1 = matrice[pivot[indice]][c];
        Frazione risultato = new Frazione(1, 1);
        if(primoZeta == 1)
            risultato = temp.dividi(pivot1);
        else{
            Frazione inversoPivot = new Frazione(1,1);
            inversoPivot.numeratore = pivot1.trovaInverso(primoZeta, pivot1.numeratore);
            risultato = temp.moltiplica(inversoPivot);
            risultato.trasformaInZetaP(primoZeta);
        }
        return risultato;
    }

    public void scambiaRiga(int p, int d) {
        Frazione temp = null;
        for (int i = 0; i < colonna; i++) {
            temp = matrice[d][i];
            matrice[d][i] = matrice[p][i];
            matrice[p][i] = temp;
        }
        numscambi++;
    }

    private Boolean controllaZeri(int k, Boolean r) {//se r è true controllo della colonna
        if (r) {
            for (int j = 0; j < colonna; j++) {
                if (matrice[k][j].numeratore != 0) {
                    return false;
                }
            }
            return true;
        } else {
            for (int i = 0; i < riga; i++) {
                if (matrice[i][k].numeratore != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public Boolean controllaMatrice() { //true se la matrice è nulla false altrimenti
        for (int i = 0; i < colonna; i++) {
            if (!controllaZeri(i, false)) {
                return false;
            }
        }
        return true;
    }

    void controllaRighe() {
        for (int i = 0; i < righeNulle.length; i++) {
            righeNulle[i] = false;
            if (controllaZeri(i, true)) {
                righeNulle[i] = true;
            }

        }
    }

    void controllaColonne() {
        for (int j = 0; j < colonneNulle.length; j++) {
            colonneNulle[j] = false;
            if (controllaZeri(j, false)) {
                colonneNulle[j] = true;
            }
        }
    }

    Matrice copiaMatrice() {
        Frazione[][] copia = new Frazione[riga][colonna];
        for (int i = 0; i < riga; i++) {
            for (int j = 0; j < colonna; j++) {
                Frazione temp = new Frazione(matrice[i][j].numeratore, matrice[i][j].denominatore);
                temp.segno = matrice[i][j].segno;
                copia[i][j] = temp;
            }
        }
        Matrice copy = new Matrice(riga, colonna, copia);
        copy.primoZeta = primoZeta;
        return copy;
    }

    void visualizzaArrayPivot() { //metodo di diagnostica
        for (int i = 0; i < pivot.length; i++) {
            System.out.print("[" + pivot[i] + "]");
        }
    }

    Boolean controllaArrayPivot() { //resistuisce true se l'array e pieno ergo sono stati trovati tutti i pivot
        for (int i = 0; i < pivot.length; i++) {
            if (pivot[i] == -1) {
                return false;
            }
        }
        return true;
    }

    int calcolaMin() {
        if (riga > colonna) {
            return colonna;
        }
        return riga;
    }

    int numPivot() {
        Matrice temp = this.copiaMatrice();
        temp.gauss();
        int cont = 0;
        for (int i = 0; i < temp.pivot.length; i += 2) {
            if (temp.pivot[i] != -1) {
                cont++;
            }
        }
        return cont;
    }

    String stampaPivot() {
        String stringaPivot = "";
        Matrice temp = this.copiaMatrice();
        temp.gauss();
        for (int i = 0; i < pivot.length; i += 2) {
            if (temp.pivot[i] != -1) {
                stringaPivot += "valore: " + temp.matrice[temp.pivot[i]][temp.pivot[i + 1]].stampaFrazione() + "\nposizione: riga " + (temp.pivot[i] + 1) + " colonna " + (temp.pivot[i + 1] + 1) + "\n";
            }
        }
        return stringaPivot;
    }

    Matrice sommaMatrici(Matrice b) {
        Frazione[][] somma = new Frazione[riga][colonna];
        for (int i = 0; i < riga; i++) {
            for (int j = 0; j < colonna; j++) {
                somma[i][j] = matrice[i][j].somma(b.matrice[i][j]);

            }
        }
        return new Matrice(riga, colonna, somma);
    }

    Matrice prodottoMatrici(Matrice b) {
        Frazione[][] prodotto = new Frazione[riga][b.colonna];
        for (int i = 0; i < riga; i++) {
            for (int j = 0; j < b.colonna; j++) {
                prodotto[i][j] = prodottoSingolo(matrice, b.matrice, i, j, colonna);
            }
        }
        return new Matrice(riga, b.colonna, prodotto);
    }

    /*calcola un singolo valore della matrice prodotto, num è il numero di colonne
    della prima matrice che è necessariamente anche il numero di righe della seconda
    matrice **/
    Frazione prodottoSingolo(Frazione[][] a, Frazione[][] b, int r, int c, int num) {
        Frazione temp = new Frazione(0, 1);
        for (int i = 0; i < num; i++) {
            temp = temp.somma(a[r][i].moltiplica(b[i][c]));
        }
        return temp;
    }

    Matrice creaIdentica() {
        Frazione[][] identica = new Frazione[riga][colonna];
        for (int i = 0; i < riga; i++) {
            for (int j = 0; j < colonna; j++) {
                if (i == j) {
                    identica[i][j] = new Frazione(1, 1);
                } else {
                    identica[i][j] = new Frazione(0, 1);
                }
            }
        }
        return new Matrice(riga, colonna, identica);
    }

    boolean stimaFrazioni(){
        for(int i = 0; i < riga; i++)
            for(int j = 0; j < colonna; j++){
                if(matrice[i][j].denominatore > 6)
                    return true;
            }
    return false;
    }


    Matrice estendiMatrice() {
        Frazione[][] estesa = new Frazione[riga][colonna * 2];
        Matrice identica = creaIdentica();
        for (int i = 0; i < riga; i++) {
            for (int j = 0; j < colonna * 2; j++) {
                if (j < colonna) {
                    Frazione temp = new Frazione(matrice[i][j].numeratore, matrice[i][j].denominatore);
                    temp.segno = matrice[i][j].segno;
                    estesa[i][j] = temp;
                } else {
                    Frazione temp = new Frazione(identica.matrice[i][j - colonna].numeratore, identica.matrice[i][j - colonna].denominatore);
                    temp.segno = true;
                    estesa[i][j] = temp;
                }

            }
        }
        Matrice extend = new Matrice(riga, colonna * 2, estesa);
        if(primoZeta > 1){
            extend.trasformaInZetaP(primoZeta);
            extend.primoZeta = primoZeta;

        }
        return extend;
    }

    void dividiPivot() {
        for (int i = 0; i < riga; i++) {
            Frazione piv = new Frazione(1, 1);
            piv.numeratore = matrice[i][i].numeratore;
            piv.denominatore = matrice[i][i].denominatore;
            piv.segno = matrice[i][i].segno;
            for (int j = 0; j < colonna; j++) {
                matrice[i][j] = matrice[i][j].dividi(piv);
                //if(primoZeta > 1)
                    //matrice[i][j].trasformaInZetaP(primoZeta);
            }

        }
    }

    Frazione calcolaLambda(int n, int i) {
        Frazione piv = new Frazione(1, 1);
        piv = matrice[n - i][n].dividi(matrice[n][n]);
        piv.segno = !piv.segno;
        //if(primoZeta > 1)
           // piv.trasformaInZetaP(primoZeta);
        return piv;
    }

    void moltiplicaRigaDalBasso(Frazione lambda, int n, int index) {
        for (int i = n; i < colonna; i++) {
            Frazione moltiplicata = new Frazione(1, 1);
            moltiplicata = lambda.moltiplica(matrice[n][i]);
            //if(primoZeta > 1)
                //moltiplicata.trasformaInZetaP(primoZeta);
            matrice[n - index][i] = matrice[n - index][i].somma(moltiplicata);
            //if(primoZeta > 1)
               // matrice[n- index][i].trasformaInZetaP(primoZeta);
        }

    }

    void GaussDallAlto() {
        int indice = riga - 1;
        while (indice > 0) {
            int rigatemp = 1;
            while (rigatemp <= indice) {
                Frazione lambda = new Frazione(1, 1);
                lambda = calcolaLambda(indice, rigatemp);
                moltiplicaRigaDalBasso(lambda, indice, rigatemp);
                rigatemp++;
            }
            indice--;
        }
    }

    Matrice estrapolaInversa() {

        Frazione[][] array = new Frazione[riga][riga];
        for (int i = 0; i < riga; i++) {
            for (int j = 0; j < riga; j++) {
                array[i][j] = new Frazione(1, 1);
                array[i][j].numeratore = matrice[i][j + riga].numeratore;
                array[i][j].denominatore = matrice[i][j + riga].denominatore;
                array[i][j].segno = matrice[i][j + riga].segno;
            }
        }
        Matrice inversa = new Matrice(riga, riga, array);
        if(primoZeta > 1){
            inversa.trasformaInZetaP(primoZeta);
            inversa.primoZeta = primoZeta;
        }
        return inversa;
    }

    String valoreDeterminante() {
        Matrice trasformata = this.copiaMatrice();
        trasformata.gauss();
        String det = "Valore del determinante: ";
        Frazione determinante1 = new Frazione(1, 1);
        for (int i = 0; i < trasformata.riga; i++) {
            determinante1 = determinante1.moltiplica(trasformata.matrice[i][i]);
        }
        if (trasformata.numscambi % 2 != 0) {
            determinante1.segno = !determinante1.segno;
        }
        if(primoZeta != 1)
            determinante1.trasformaInZetaP(primoZeta);
        if (determinante1.segno) {
            if (determinante1.denominatore == 1) {
                det += "" + determinante1.numeratore;
            } else {
                det += "" + determinante1.numeratore + "/" + determinante1.denominatore;
            }
        } else {
            if (determinante1.denominatore == 1) {
                if (determinante1.numeratore == 0) {
                    det += "" + determinante1.numeratore;
                } else {
                    det += "-" + determinante1.numeratore;
                }
            } else {
                det += "-" + determinante1.numeratore + "/" + determinante1.denominatore;
            }
        }
        det += "\n";
        return det;
    }

    String rango() {
        Matrice temp = this.copiaMatrice();
        temp.gauss();
        String rango = "Rango matrice rk(A): " + temp.numPivot() + "\n";
        return rango;

    }

    String imF() {
        Matrice temp = this.copiaMatrice();
        temp.gauss();
        String rango = "Dimensione (Im F): " + temp.numPivot() + "\n";
        return rango;
    }

    String kerF() {
        Matrice temp = this.copiaMatrice();
        temp.gauss();
        int ker = colonna - temp.numPivot();
        return "Dimensione (Ker F): " + ker + "\n";
    }

    Boolean iniettiva() {
        Matrice temp = this.copiaMatrice();
        temp.gauss();
        int rango = temp.numPivot();
        if (rango == colonna) {
            return true;
        }
        return false;
    }

    Boolean suriettiva() {
        Matrice temp = this.copiaMatrice();
        temp.gauss();
        int rango = temp.numPivot();
        if (rango == riga) {
            return true;
        }
        return false;
    }

    Boolean biiettiva() {
        if (iniettiva() && suriettiva()) {
            return true;
        }
        return false;
    }

    String riepilogo() {
        String riepilogo = "MATRICE " + riga + " X " + colonna + "\n";
        riepilogo += creaBarra(riepilogo)+"\n";
        if(primoZeta == 1)
           riepilogo += "\nDominio: Q\n";
        else
            riepilogo += "\nDominio: Z "+primoZeta+"\n";
        riepilogo += "\nPIVOT TROVATI: " + numPivot() + "\n\n";
        riepilogo += stampaPivot();
        if (riga == colonna) {
            riepilogo += "\n" + valoreDeterminante();
        }
        riepilogo += "\n" + rango();
        if(primoZeta == 1){
            String tmp = "\nAPPLICAZIONE LINEARE F TRA K(" + colonna + ") --> K(" + riga + ")\n";
            String barra = creaBarra(tmp);
            riepilogo += tmp + barra + "\n";

        }
        else{
            String tmp = "\nAPPLICAZIONE LINEARE F TRA Z "+primoZeta+" --> Z "+primoZeta+"\n";
            String barra = creaBarra(tmp);
            riepilogo += tmp + barra + "\n";

        }
        riepilogo += "\n" + imF();
        riepilogo += "\n" + kerF();
        riepilogo += "\nINIETTIVA: ";
        if (iniettiva()) {
            riepilogo += "SI\n";
        } else {
            riepilogo += "NO\n";
        }
        riepilogo += "\nSURIETTIVA: ";
        if (suriettiva()) {
            riepilogo += "SI\n";
        } else {
            riepilogo += "NO\n";
        }
        riepilogo += "\nBIIETTIVA: ";
        if (biiettiva()) {
            riepilogo += "SI\n";
        } else {
            riepilogo += "NO\n";
        }
        return riepilogo;
    }

    void trasformaInZetaP(int modulo) {
        if (primoZeta != modulo) {
            for (int i = 0; i < riga; i++) {
                for (int j = 0; j < colonna; j++) {
                    matrice[i][j].trasformaInZetaP(modulo);
                }
            }
            primoZeta = modulo;
        }
    }

String creaBarra(String value){
    if(value != null){
        String barra = "";
        int length = value.length();
        //if(value.contains("\n")){
        //length-
        //}
        for(int i = 0; i < length; i++){
            barra += "°";
        }
    return barra;
    }
    return null;

}

}
