/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eliminazionegauss;

/**
 *
 * @author raffaele
 */
public class ThreadBottoni extends Thread {

FrameMatrice theFrame;



    ThreadBottoni(FrameMatrice theFrame){
        this.theFrame = theFrame;
}



public void run(){
        Matrice mat = FrameMatrice.arrayMatriceCalcolo[0];
        if(mat != null){
            if(mat.riga == mat.colonna){
                theFrame.determinante.setEnabled(true);
                theFrame.inversa.setEnabled(true);
                theFrame.itemDeterminante.setEnabled(true);
                theFrame.itemInversa.setEnabled(true);

            }
            theFrame.gauss.setEnabled(true);
            theFrame.trasposta.setEnabled(true);
            theFrame.moltiplica.setEnabled(true);
            theFrame.ToggleProprietà.setEnabled(true);
            theFrame.toggleSomma.setEnabled(true);
            theFrame.modifica.setEnabled(true);
            theFrame.ToggleProprietà.setEnabled(true);
            theFrame.itemGauss.setEnabled(true);
            theFrame.itemTrasposta.setEnabled(true);
            theFrame.itemProdotto.setEnabled(true);
            theFrame.itemProprietà.setEnabled(true);
            theFrame.itemSomma.setEnabled(true);
            theFrame.itemModifica.setEnabled(true);
            theFrame.itemProprietà.setEnabled(true);
            theFrame.itemSalva.setEnabled(true);
            theFrame.salvaProprietà.setEnabled(true);
            
        }
        if(mat == null){
            theFrame.determinante.setEnabled(false);
            theFrame.inversa.setEnabled(false);
            theFrame.gauss.setEnabled(false);
            theFrame.trasposta.setEnabled(false);
            theFrame.moltiplica.setEnabled(false);
            theFrame.toggleSomma.setEnabled(false);
            theFrame.modifica.setEnabled(false);
            theFrame.ToggleProprietà.setEnabled(false);
            theFrame.itemGauss.setEnabled(false);
            theFrame.itemTrasposta.setEnabled(false);
            theFrame.itemProdotto.setEnabled(false);
            theFrame.itemProprietà.setEnabled(false);
            theFrame.itemSomma.setEnabled(false);
            theFrame.itemModifica.setEnabled(false);
            theFrame.itemProprietà.setEnabled(false);
            theFrame.itemDeterminante.setEnabled(false);
            theFrame.itemInversa.setEnabled(false);
            theFrame.itemSalva.setEnabled(false);
            theFrame.salvaProprietà.setEnabled(false);
        }
        if(theFrame.radioZetaP.isSelected())
            theFrame.jSlider1.setEnabled(false);
        else
            theFrame.jSlider1.setEnabled(true);
}




}





