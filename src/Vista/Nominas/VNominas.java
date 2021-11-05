/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Nominas;

import Controlador.Ctrl_Nominas;
import Vista.VPrincipal;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class VNominas extends javax.swing.JDialog {
    Ctrl_Nominas con = new Ctrl_Nominas(VPrincipal.controladorBD.getConexion());
    
    /**
     * Creates new form VNominas
     */
    public VNominas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/Icon/nomina.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tNominas = new javax.swing.JTable();
        bCrear = new javax.swing.JButton();
        bBorrar = new javax.swing.JButton();
        bModificar = new javax.swing.JButton();
        bGenerar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tNominas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Año", "Mes", "Dni", "Sueldo ", "Sueldo Horas Extra"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tNominas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tNominas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tNominas);

        bCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/crear.png"))); // NOI18N
        bCrear.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCrearActionPerformed(evt);
            }
        });

        bBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/borrar.png"))); // NOI18N
        bBorrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBorrarActionPerformed(evt);
            }
        });

        bModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/modificar.png"))); // NOI18N
        bModificar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarActionPerformed(evt);
            }
        });

        bGenerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/fichaje.png"))); // NOI18N
        bGenerar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGenerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(bCrear)
                .addGap(25, 25, 25)
                .addComponent(bBorrar)
                .addGap(25, 25, 25)
                .addComponent(bModificar)
                .addGap(25, 25, 25)
                .addComponent(bGenerar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bCrear)
                        .addComponent(bBorrar)
                        .addComponent(bModificar))
                    .addComponent(bGenerar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCrearActionPerformed
        VCrearNominas v = new VCrearNominas(null,true);
        v.setVisible(true);
    }//GEN-LAST:event_bCrearActionPerformed

    private void bBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBorrarActionPerformed
        if (tNominas.getSelectedRow() != -1) {
            Object anio = tNominas.getValueAt(tNominas.getSelectedRow(), 0);
            Object mes = tNominas.getValueAt(tNominas.getSelectedRow(), 1);
            Object dni = tNominas.getValueAt(tNominas.getSelectedRow(), 2);
            if (con.deleteNomina(Integer.parseInt(anio.toString()),Integer.parseInt(mes.toString()),dni.toString())) {
                JOptionPane.showMessageDialog(this, "El empleado de dni " + dni + " ha sido eliminado correctamente");
                rellenarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "Error al borrar el empleado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un registro para borrarlo", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bBorrarActionPerformed

    private void bModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarActionPerformed
        /*if (tEmpleados.getSelectedRow() != -1) {
            dni = tEmpleados.getValueAt(tEmpleados.getSelectedRow(), 0).toString();
            nombre = tEmpleados.getValueAt(tEmpleados.getSelectedRow(), 1).toString();
            HorasMin = tEmpleados.getValueAt(tEmpleados.getSelectedRow(), 2).toString();
            precioHora = tEmpleados.getValueAt(tEmpleados.getSelectedRow(), 3).toString();
            precioHoraE = tEmpleados.getValueAt(tEmpleados.getSelectedRow(), 4).toString();
            VModificarEmpleado v = new VModificarEmpleado(null, true);
            v.setVisible(true);
            rellenarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un registro para modificarlo", "Error", JOptionPane.WARNING_MESSAGE);
        }*/

    }//GEN-LAST:event_bModificarActionPerformed

    private void bGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGenerarActionPerformed
        VGenerarNominas v = new VGenerarNominas(null, true);
        v.setVisible(true);
    }//GEN-LAST:event_bGenerarActionPerformed

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
            java.util.logging.Logger.getLogger(VNominas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VNominas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VNominas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VNominas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VNominas dialog = new VNominas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bBorrar;
    private javax.swing.JButton bCrear;
    private javax.swing.JButton bGenerar;
    private javax.swing.JButton bModificar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tNominas;
    // End of variables declaration//GEN-END:variables
}
