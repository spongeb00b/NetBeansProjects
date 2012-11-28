/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eliminazionegauss;

import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;

/**
 *
 * @author raffaele
 */
public class MatrixCanvas extends JFrame implements MouseListener, WindowListener {

    int righe;
    int colonne;
    Matrice matrice;
    DrawingArea[][] matrix;
    Frazione corrente;
    JFrame finestraMatrice;
    FrameMatrice frame;

    MatrixCanvas(int righe, int colonne, Matrice matrice, FrameMatrice frame) {

        this.righe = righe;
        this.colonne = colonne;
        this.matrice = matrice;
        this.frame = frame;
    }

    void disegnaMatrice() {

        finestraMatrice = new JFrame();
        finestraMatrice.setTitle("Matrice " + righe + " x " + colonne);
        finestraMatrice.setLayout(new BorderLayout());
        finestraMatrice.setBackground(Color.white);
        finestraMatrice.setVisible(true);
        finestraMatrice.setResizable(false);
        JPanel masterCentrale = new JPanel();
        masterCentrale.setLayout(new BorderLayout());
        JPanel canvasCentrale = new JPanel();
        masterCentrale.add(canvasCentrale, BorderLayout.CENTER);
        canvasCentrale.setLayout(new GridLayout(righe, colonne));
        canvasCentrale.setVisible(true);
        finestraMatrice.add("Center", masterCentrale);
        int max = calcolaCifreDecimali(calcolaMaxMatrice(matrice.matrice));
        matrix = new DrawingArea[righe][colonne];
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                corrente = matrice.matrice[i][j];
                matrix[i][j] = new DrawingArea(corrente, max);
                matrix[i][j].setVisible(true);
                matrix[i][j].addMouseListener(this);
                canvasCentrale.add(matrix[i][j]);

        }
        }
        JLabel dominio = new JLabel("Pronto");
        finestraMatrice.add("South", dominio);
        if (matrice.primoZeta == 1) {
            dominio.setText("Dominio: Q");
        } else {
            dominio.setText("Dominio: Z " + matrice.primoZeta);
        }
        if (FrameMatrice.canvas[0] == null) {
            if (righe == 1) {
                finestraMatrice.setBounds(10, 310, (matrix[0][0].getWidth() * colonne) + 20, (matrix[0][0].getHeight() * righe) + 40);
            } else if (colonne == 1) {
                finestraMatrice.setBounds(10, 310, (matrix[0][0].getWidth() * colonne), (matrix[0][0].getHeight() * righe) + 50);
            } else {
                finestraMatrice.setBounds(10, 310, (matrix[0][0].getWidth() * colonne), (matrix[0][0].getHeight() * righe) + 40);
            }
        } else {

            int x = FrameMatrice.canvas[0].finestraMatrice.getX() + FrameMatrice.canvas[0].finestraMatrice.getWidth() + 1;
            int y = FrameMatrice.canvas[0].finestraMatrice.getY();
            if (righe == 1) {
                finestraMatrice.setBounds(x, y, (matrix[0][0].getWidth() * colonne) + 20, (matrix[0][0].getHeight() * righe) + 40);
            } else if (colonne == 1) {
                finestraMatrice.setBounds(x, y, (matrix[0][0].getWidth() * colonne), (matrix[0][0].getHeight() * righe) + 50);
            } else {
                finestraMatrice.setBounds(x, y, (matrix[0][0].getWidth() * colonne), (matrix[0][0].getHeight() * righe) + 40);
            }
        }
        finestraMatrice.addWindowListener(this);
        Image icona = Toolkit.getDefaultToolkit().getImage("/home/raffaele/NetBeansProjects/Eliminazione Gauss/matrixIcon.jpg");
        finestraMatrice.setIconImage(icona);
        finestraMatrice.setAlwaysOnTop(true);








    }

    int calcolaCifreDecimali(long a) {
        int cifre = 0;
        while (a > 0) {
            a /= 10;
            cifre++;
        }
        return cifre;
    }

    long calcolaMaxMatrice(Frazione a[][]) {
        long max = a[0][0].numeratore;
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                if (a[i][j].numeratore > max) {
                    max = a[i][j].numeratore;
                }
                if (a[i][j].denominatore > max) {
                    max = a[i][j].denominatore;
                }
            }
        }
        return max;
    }

    public void mouseClicked(MouseEvent e) {

        if (matrice.indiceArray == -1) {
            if (FrameMatrice.arrayMatriceCalcolo[0] != null && frame.moltiplica.isSelected()) {
                FrameMatrice.arrayMatriceCalcolo[1] = matrice;
                if (FrameMatrice.arrayMatriceCalcolo[0].colonna != FrameMatrice.arrayMatriceCalcolo[1].riga) {
                    frame.dialog.setVisible(true);
                    frame.dialog.setTitle("Prodotto");
                    frame.dialog.setBounds(450, 350, 420, 125);
                    frame.labelDialog.setForeground(Color.BLUE);
                    frame.labelDialog.setVisible(true);
                    frame.labelDialog.setText("Prodotto impossibile matrici incompatibili");
                    FrameMatrice.arrayMatriceCalcolo[1] = null;
                    frame.moltiplica.doClick();
                } else if (FrameMatrice.arrayMatriceCalcolo[0].primoZeta != FrameMatrice.arrayMatriceCalcolo[1].primoZeta) {
                    frame.dialog.setVisible(true);
                    frame.dialog.setTitle("Prodotto");
                    frame.dialog.setBounds(450, 350, 420, 125);
                    frame.labelDialog.setForeground(Color.BLUE);
                    frame.labelDialog.setVisible(true);
                    frame.labelDialog.setText("Prodotto impossibile domini differenti");
                    FrameMatrice.arrayMatriceCalcolo[1] = null;
                    frame.moltiplica.doClick();

                } else {
                    Matrice prodotto = FrameMatrice.arrayMatriceCalcolo[0].prodottoMatrici(FrameMatrice.arrayMatriceCalcolo[1]);
                    if (FrameMatrice.arrayMatriceCalcolo[0].primoZeta > 1) {
                        prodotto.trasformaInZetaP(FrameMatrice.arrayMatriceCalcolo[0].primoZeta);
                        prodotto.primoZeta = FrameMatrice.arrayMatriceCalcolo[0].primoZeta;
                    }
                    MatrixCanvas prodottoMatrice = new MatrixCanvas(prodotto.riga, prodotto.colonna, prodotto, frame);
                    frame.ErroreMsg.setForeground(Color.blue);
                    frame.ErroreMsg.setText("Prodotto matrici eseguito");
                    prodottoMatrice.disegnaMatrice();
                    frame.moltiplica.setSelected(false);
                    for (int i = 0; i < righe; i++) {
                        for (int j = 0; j < colonne; j++) {
                            if (!(matrix[i][j].getBackground() == Color.red)) {
                                matrix[i][j].setBackground(Color.WHITE);
                            }
                        }
                    }
                    FrameMatrice.arrayMatriceCalcolo[1] = null;
                }
            }
            if (FrameMatrice.arrayMatriceCalcolo[0] != null && frame.toggleSomma.isSelected()) {
                FrameMatrice.arrayMatriceCalcolo[1] = matrice;
                if (FrameMatrice.arrayMatriceCalcolo[0].colonna != FrameMatrice.arrayMatriceCalcolo[1].colonna || FrameMatrice.arrayMatriceCalcolo[0].riga != FrameMatrice.arrayMatriceCalcolo[1].riga) {
                    frame.dialog.setVisible(true);
                    frame.dialog.setTitle("Somma");
                    frame.dialog.setBounds(450, 350, 420, 125);
                    frame.labelDialog.setForeground(Color.BLUE);
                    frame.labelDialog.setVisible(true);
                    frame.labelDialog.setText("Somma impossibile matrici incompatibili");
                    FrameMatrice.arrayMatriceCalcolo[1] = null;
                    frame.toggleSomma.doClick();
                } else if (FrameMatrice.arrayMatriceCalcolo[0].primoZeta != FrameMatrice.arrayMatriceCalcolo[1].primoZeta) {
                    frame.dialog.setVisible(true);
                    frame.dialog.setTitle("Somma");
                    frame.dialog.setBounds(450, 350, 420, 125);
                    frame.labelDialog.setForeground(Color.BLUE);
                    frame.labelDialog.setVisible(true);
                    frame.labelDialog.setText("Somma impossibile domini differenti");
                    FrameMatrice.arrayMatriceCalcolo[1] = null;
                    frame.toggleSomma.doClick();
                } else {
                    Matrice somma = FrameMatrice.arrayMatriceCalcolo[0].sommaMatrici(FrameMatrice.arrayMatriceCalcolo[1]);
                    if (FrameMatrice.arrayMatriceCalcolo[0].primoZeta > 1) {
                        somma.trasformaInZetaP(FrameMatrice.arrayMatriceCalcolo[0].primoZeta);
                        somma.primoZeta = FrameMatrice.arrayMatriceCalcolo[0].primoZeta;
                    }
                    MatrixCanvas sommaMatrice = new MatrixCanvas(somma.riga, somma.colonna, somma, frame);
                    frame.ErroreMsg.setForeground(Color.blue);
                    frame.ErroreMsg.setText("Somma matrici eseguita");
                    sommaMatrice.disegnaMatrice();
                    frame.toggleSomma.setSelected(false);
                    for (int i = 0; i < righe; i++) {
                        for (int j = 0; j < colonne; j++) {
                            if (!(matrix[i][j].getBackground() == Color.red)) {
                                matrix[i][j].setBackground(Color.WHITE);
                            }
                        }
                    }
                    FrameMatrice.arrayMatriceCalcolo[1] = null;
                }
            }
            if (FrameMatrice.arrayMatriceCalcolo[0] == null) {
                FrameMatrice.canvas[0] = this;
                FrameMatrice.arrayMatriceCalcolo[0] = matrice;
                matrice.indiceArray = 0;
                for (int i = 0; i < righe; i++) {
                    for (int j = 0; j < colonne; j++) {
                        if (!(matrix[i][j].getBackground() == Color.red)) {
                            matrix[i][j].setBackground(Color.YELLOW);
                        }
                    }
                }
                frame.ErroreMsg.setForeground(Color.blue);
                frame.editorRiepilogo.setText(matrice.riepilogo());
                frame.editorRiepilogo.setCaretPosition(0);
                if (matrice.primoZeta == 1) {
                    frame.radioRazionali.doClick();
                } else {
                    frame.radioZetaP.doClick();
                    frame.areaTestoPrimo.setText("" + matrice.primoZeta);
                    frame.areaTestoPrimo.setEditable(false);
                    FrameMatrice.zetaP = matrice.primoZeta;
                }
                frame.ErroreMsg.setText("Matrice selezionata");
            } else { //se ce n'è una gia selezionata
                for (int i = 0; i < FrameMatrice.arrayMatriceCalcolo[0].riga; i++) {
                    for (int j = 0; j < FrameMatrice.arrayMatriceCalcolo[0].colonna; j++) {
                        if (!(FrameMatrice.canvas[0].matrix[i][j].getBackground() == Color.red)) {
                            FrameMatrice.canvas[0].matrix[i][j].setBackground(Color.WHITE);
                        }
                    }
                }
                FrameMatrice.arrayMatriceCalcolo[0].indiceArray = -1;
                FrameMatrice.arrayMatriceCalcolo[0] = matrice;
                FrameMatrice.canvas[0] = this;
                matrice.indiceArray = 0;
                for (int i = 0; i < righe; i++) {
                    for (int j = 0; j < colonne; j++) {
                        if (!(matrix[i][j].getBackground() == Color.red)) {
                            matrix[i][j].setBackground(Color.YELLOW);
                        }
                    }
                }
                frame.ErroreMsg.setForeground(Color.blue);
                frame.editorRiepilogo.setText(matrice.riepilogo());
                frame.editorRiepilogo.setCaretPosition(0);
                if (matrice.primoZeta == 1) {
                    frame.radioRazionali.doClick();
                } else {
                    frame.radioZetaP.doClick();
                    frame.areaTestoPrimo.setText("" + matrice.primoZeta);
                    frame.areaTestoPrimo.setEditable(false);
                    FrameMatrice.zetaP = matrice.primoZeta;
                }
                frame.ErroreMsg.setText("Matrice selezionata");

            }
        } else if (FrameMatrice.arrayMatriceCalcolo[0] != null) {
            FrameMatrice.arrayMatriceCalcolo[0] = null;
            FrameMatrice.canvas[0] = null;
            for (int i = 0; i < righe; i++) {
                for (int j = 0; j < colonne; j++) {
                    if (!(matrix[i][j].getBackground() == Color.red)) {
                        matrix[i][j].setBackground(Color.WHITE);
                    }
                }
            }
            frame.ErroreMsg.setForeground(Color.blue);
            frame.ErroreMsg.setText("Matrice deselezionata");
            matrice.indiceArray = -1;
            frame.editorRiepilogo.setText("Seleziona una matrice per le proprietà");
        }
        ThreadBottoni check = new ThreadBottoni(frame);
        check.start();

    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void windowOpened(WindowEvent e) {
    }

    public void windowClosing(WindowEvent e) {
        ThreadBottoni checkOnClose = new ThreadBottoni(frame);
        checkOnClose.start();
        if (matrice.indiceArray != -1) {
            FrameMatrice.arrayMatriceCalcolo[0] = null;
            frame.ErroreMsg.setForeground(Color.blue);
            frame.ErroreMsg.setText("Matrice finestra chiusa");
            frame.ToggleProprietà.setSelected(false);
            frame.editorRiepilogo.setText("Seleziona una matrice per le proprietà");
            frame.dialogRiepilogo.setVisible(false);
            matrice.indiceArray = -1;
            FrameMatrice.canvas[0] = null;

        }

    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }

    public void evidenziaPivot() {
        int index = 0;
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                while (index < matrice.pivot.length - 1) {
                    if (i == matrice.pivot[index] && j == matrice.pivot[index + 1]) {
                        for (int k = j; k < colonne; k++) {
                            matrix[i][k].setBackground(Color.red);
                        }
                        break;
                    }

                    index += 2;
                }
                index = 0;
            }
        }
    }
}
