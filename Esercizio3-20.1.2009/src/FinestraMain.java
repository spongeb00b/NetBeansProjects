/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FinestraMain.java
 *
 * Created on 14-giu-2011, 11.31.26
 */

/**
 *
 * @author raffaele
 */
public class FinestraMain extends javax.swing.JFrame {

    /** Creates new form FinestraMain */
    public FinestraMain() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Bottone = new javax.swing.JButton();
        etichetta = new javax.swing.JLabel();
        campoTesto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        Bottone.setText("Incrementa");
        Bottone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BottoneActionPerformed(evt);
            }
        });

        etichetta.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Bottone, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(etichetta, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(campoTesto, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Bottone)
                    .addComponent(campoTesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etichetta))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BottoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BottoneActionPerformed
        String value = campoTesto.getText(), label = etichetta.getText();;
        int num1, num2;
        try{
             num1 = Integer.parseInt(value);
             num2 = Integer.parseInt(label);
             etichetta.setText(""+(num1+num2));
        }
        catch(NumberFormatException e){etichetta.setText("0");}

    }//GEN-LAST:event_BottoneActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FinestraMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bottone;
    private javax.swing.JTextField campoTesto;
    private javax.swing.JLabel etichetta;
    // End of variables declaration//GEN-END:variables

}