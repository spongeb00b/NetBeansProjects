/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eliminazionegauss;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author raffaele
 */
public class MatriceInserimento extends FrameMatrice implements ActionListener, FocusListener {

    JFrame finestraMatrice;
    TextField[][] text = null;
    private JButton carica;
    private JButton annulla;
    public Matrice matrix;
    FrameMatrice frame = null;

    MatriceInserimento(int righe, int colonne, FrameMatrice f) {
        this.righe = righe;
        this.colonne = colonne;
        frame = f;
    }

    void DisegnaFrame() {
        finestraMatrice = new JFrame();
        finestraMatrice.setTitle("Matrice Inserimento");
        finestraMatrice.setLayout(new BorderLayout());
        JPanel pannelloTitolo = new JPanel(new FlowLayout());
        JLabel titolo = new JLabel("INSERISCI I COEFFICENTI:");
        titolo.setForeground(Color.blue);
        pannelloTitolo.add(titolo, CENTER_ALIGNMENT);
        finestraMatrice.add("North", pannelloTitolo);
        pannelloTitolo.setSize(400, 900);
        JPanel areaTesto = new JPanel();
        areaTesto.setLayout(new GridLayout(righe, colonne));
        areaTesto.setVisible(true);
        finestraMatrice.add("Center", areaTesto);
        text = new TextField[righe][colonne];
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                text[i][j] = new TextField("0");
                text[i][j].setVisible(true);
                text[i][j].addFocusListener(this);
                text[i][j].addActionListener(this);
                areaTesto.add(text[i][j]);
            }
        }
        JPanel pannelloMenu = new JPanel();
        pannelloMenu.setLayout(new GridLayout(3, 0));
        pannelloMenu.setVisible(true);
        carica = new JButton("Disegna");
        annulla = new JButton("Annulla");
        annulla.addActionListener(this);
        carica.addActionListener(this);
        pannelloMenu.add(carica);
        pannelloMenu.add(annulla);
        finestraMatrice.add("South", pannelloMenu);
        finestraMatrice.setBounds(480, 250, +150 + 60 * colonne, 120 + 40 * righe);
        finestraMatrice.setResizable(true);
        finestraMatrice.setVisible(true);
        Image icona = Toolkit.getDefaultToolkit().getImage("/home/raffaele/NetBeansProjects/Eliminazione Gauss/matrixIcon.jpg");
        finestraMatrice.setIconImage(icona);
        finestraMatrice.setAlwaysOnTop(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == carica || e.getSource().getClass().getName().contains("TextField")) {
            if (caricaValori()) {
                MatrixCanvas canvas = new MatrixCanvas(righe, colonne, matrix, frame);
                canvas.disegnaMatrice();
                if (FrameMatrice.canvas[0] != null) {
                    int x = FrameMatrice.canvas[0].finestraMatrice.getX(), y = FrameMatrice.canvas[0].finestraMatrice.getY();
                    canvas.finestraMatrice.setBounds(x, y, FrameMatrice.canvas[0].finestraMatrice.getWidth(), FrameMatrice.canvas[0].finestraMatrice.getHeight());
                    FrameMatrice.canvas[0].finestraMatrice.dispose();
                    FrameMatrice.canvas[0] = null;
                    FrameMatrice.arrayMatriceCalcolo[0] = null;
                }
                ThreadBottoni check = new ThreadBottoni(frame);
                check.start();
                finestraMatrice.dispose();
            }
        }
        if (e.getSource() == annulla) {
            finestraMatrice.dispose();
        }
    }

    private boolean caricaValori() {
        matrix = new Matrice(righe, colonne, new Frazione[righe][colonne]);
        if (frame.radioZetaP.isSelected()) {
            matrix.primoZeta = FrameMatrice.zetaP;
        }
        int r = 0, c = 0, index = 0;
        String temp = null;
        try {
            for (int i = 0; i < righe; i++) {
                for (int j = 0; j < colonne; j++) {
                    r = i;
                    c = j;
                    temp = text[i][j].getText();
                    if (temp.contains("/")) {
                        index = temp.indexOf('/');
                        matrix.matrice[i][j] = new Frazione(Long.valueOf(temp.substring(0, index)), Integer.valueOf(temp.substring(index + 1, temp.length())));
                        controllaDenominatore(matrix.matrice[i][j]);
                        matrix.matrice[i][j].normalizzaFrazione();
                        if (matrix.primoZeta > 1) {
                            matrix.matrice[i][j].trasformaInZetaP(matrix.primoZeta);
                            controllaDenominatore(matrix.matrice[i][j]);
                        }
                        continue;

                    }
                    matrix.matrice[i][j] = new Frazione(Long.valueOf(temp), 1);
                    if (matrix.primoZeta > 1) {
                        matrix.matrice[i][j].trasformaInZetaP(matrix.primoZeta);
                    }
                }
            }
            frame.ErroreMsg.setVisible(true);
            frame.ErroreMsg.setForeground(Color.BLUE);
            frame.ErroreMsg.setText("Matrice caricata!");
            return true;
        } catch (NumberFormatException ev) {
            frame.ErroreMsg.setForeground(Color.red);
            frame.ErroreMsg.setText("Formato numerico errato nella riga " + (r + 1) + " colonna " + (c + 1));
            return false;
        } catch (DivisionePerZeroException e) {
            if (matrix.primoZeta == 1) {
                frame.ErroreMsg.setForeground(Color.red);
                frame.ErroreMsg.setText("Errore divisione per zero nella riga " + (r + 1) + " colonna " + (c + 1));
                return false;
            } else {
                frame.ErroreMsg.setForeground(Color.red);
                frame.ErroreMsg.setText("Errore divisione per classe di [0] nella riga " + (r + 1) + " colonna " + (c + 1));
                return false;
            }
        }
    }

    public void controllaDenominatore(Frazione f) throws DivisionePerZeroException {
        if (f.denominatore == 0) {
            throw new DivisionePerZeroException();
        }
    }

    public void focusGained(FocusEvent e) {
        Object testo = e.getSource();
        ((TextField) testo).selectAll();
    }

    public void focusLost(FocusEvent e) {
    }

    void modificaFrame() {
        finestraMatrice = new JFrame();
        finestraMatrice.setTitle("Modifica Matrice");
        finestraMatrice.setLayout(new BorderLayout());
        JPanel pannelloTitolo = new JPanel(new FlowLayout());
        JLabel titolo = new JLabel("MODIFICA I COEFFICENTI:");
        titolo.setForeground(Color.blue);
        pannelloTitolo.add(titolo, CENTER_ALIGNMENT);
        finestraMatrice.add("North", pannelloTitolo);
        pannelloTitolo.setSize(400, 900);
        JPanel areaTesto = new JPanel();
        areaTesto.setLayout(new GridLayout(righe, colonne));
        areaTesto.setVisible(true);
        finestraMatrice.add("Center", areaTesto);
        text = new TextField[righe][colonne];
        String temp = "";
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                temp = "" + FrameMatrice.arrayMatriceCalcolo[0].matrice[i][j].segnoFrazione();
                text[i][j] = new TextField(temp);
                text[i][j].setVisible(true);
                text[i][j].addFocusListener(this);
                text[i][j].addActionListener(this);
                areaTesto.add(text[i][j]);
            }
        }
        JPanel pannelloMenu = new JPanel();
        pannelloMenu.setLayout(new GridLayout(3, 0));
        pannelloMenu.setVisible(true);
        carica = new JButton("Modifica");
        annulla = new JButton("Annulla");
        annulla.addActionListener(this);
        carica.addActionListener(this);
        pannelloMenu.add(carica);
        pannelloMenu.add(annulla);
        finestraMatrice.add("South", pannelloMenu);
        finestraMatrice.setBounds(480, 250, +150 + 60 * colonne, 120 + 40 * righe);
        finestraMatrice.setResizable(true);
        finestraMatrice.setVisible(true);
        Image icona = Toolkit.getDefaultToolkit().getImage("/home/raffaele/NetBeansProjects/Eliminazione Gauss/matrixIcon.jpg");
        finestraMatrice.setIconImage(icona);
        finestraMatrice.setAlwaysOnTop(true);
    }
}
