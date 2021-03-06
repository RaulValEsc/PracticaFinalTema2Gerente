/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Nominas;

import Controlador.Ctrl_Nominas;
import Modelo.Nomina;
import Vista.VPrincipal;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class VModificarNomina extends javax.swing.JDialog {
    Ctrl_Nominas con = new Ctrl_Nominas(VPrincipal.controladorBD.getConexion());
    /**
     * Creates new form VModificarNomina
     */
    public VModificarNomina(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/Icon/modificar.png")).getImage());
        etANIO.setText(VNominas.anio);
        etMES.setText(VNominas.mes);
        etDNI.setText(VNominas.dni);
        etSUELDOH.setText(VNominas.sueldoh);
        etSUELDOHE.setText(VNominas.sueldohe);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etSUELDOH = new javax.swing.JFormattedTextField();
        etSUELDOHE = new javax.swing.JFormattedTextField();
        bModificar = new javax.swing.JButton();
        etANIO = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        etMES = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        etDNI = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificar N??minas");
        setResizable(false);

        etSUELDOH.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        etSUELDOH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                etSUELDOHKeyTyped(evt);
            }
        });

        etSUELDOHE.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        etSUELDOHE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                etSUELDOHEKeyTyped(evt);
            }
        });

        bModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/modificar.png"))); // NOI18N
        bModificar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarActionPerformed(evt);
            }
        });

        etANIO.setEditable(false);
        etANIO.setEnabled(false);

        jLabel1.setText("A??o");

        jLabel2.setText("Mes");

        jLabel3.setText("DNI");

        etMES.setEnabled(false);

        jLabel4.setText("Sueldo Horas");

        jLabel5.setText("Sueldo Horas Extras");

        etDNI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        etDNI.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etDNI)
                    .addComponent(etMES)
                    .addComponent(etSUELDOHE, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etSUELDOH)
                    .addComponent(etANIO))
                .addGap(91, 91, 91))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bModificar)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etANIO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(etMES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(etDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(etSUELDOH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(etSUELDOHE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bModificar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void etSUELDOHKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_etSUELDOHKeyTyped
        char num = evt.getKeyChar();
        if (!Character.isDigit(num) && evt.getKeyChar() != KeyEvent.VK_BACK_SPACE && evt.getKeyChar() != KeyEvent.VK_COMMA) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_etSUELDOHKeyTyped

    private void etSUELDOHEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_etSUELDOHEKeyTyped
        char num = evt.getKeyChar();
        if (!Character.isDigit(num) && evt.getKeyChar() != KeyEvent.VK_BACK_SPACE && evt.getKeyChar() != KeyEvent.VK_COMMA) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_etSUELDOHEKeyTyped

    private void bModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarActionPerformed
            if(etSUELDOH.getText().isEmpty()&&etSUELDOHE.getText().isEmpty()){
                if(!con.updateNomina(new Nomina(Integer.parseInt(etANIO.getText()),Integer.parseInt(etMES.getText()),etDNI.getText()))){
                    JOptionPane.showMessageDialog(this, "La nomina no ha podido ser modificada","Error",JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(this, "Update correcto");
                    dispose();
                }
            }else{
                if(!con.updateNomina(new Nomina(Integer.parseInt(etANIO.getText()),Integer.parseInt(etMES.getText()),etDNI.getText(), Double.parseDouble(etSUELDOH.getText().replace(",",".")), Double.parseDouble(etSUELDOHE.getText().replace(",","."))))){
                    JOptionPane.showMessageDialog(this, "La nomina no ha podido ser modificada","Error",JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(this, "Update correcto");
                    dispose();
                }
            }
    }//GEN-LAST:event_bModificarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VModificarNomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VModificarNomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VModificarNomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VModificarNomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VModificarNomina dialog = new VModificarNomina(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bModificar;
    private javax.swing.JTextField etANIO;
    private javax.swing.JFormattedTextField etDNI;
    private javax.swing.JTextField etMES;
    private javax.swing.JFormattedTextField etSUELDOH;
    private javax.swing.JFormattedTextField etSUELDOHE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
