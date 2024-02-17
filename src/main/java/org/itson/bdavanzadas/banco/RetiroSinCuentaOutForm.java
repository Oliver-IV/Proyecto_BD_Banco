/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.bdavanzadas.banco;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import org.itson.bdavanzadas.bancodominio.Transaccion;
import org.itson.bdavanzadas.bancopersistencia.dao.IClientesDAO;
import org.itson.bdavanzadas.bancopersistencia.excepciones.PersistenciaException;

/**
 *
 * @author Oliver Valle
 */
public class RetiroSinCuentaOutForm extends javax.swing.JFrame {

    IClientesDAO clientesDAO;
    Transaccion transaccion;

    public RetiroSinCuentaOutForm(IClientesDAO clientesDAO) {
        initComponents();
        this.clientesDAO = clientesDAO;
    }

    public void obtener() {
        try {
            List<Transaccion> listaTransacciones = clientesDAO.obtenerListaTransaccion();
            int folio = Integer.parseInt(txtFolio.getText());
            int contrasenia = Integer.parseInt(txtContraseniaRetiro.getText());

            for (int i = 0; i < listaTransacciones.size(); i++) {
                if (folio == listaTransacciones.get(i).getFolio() && contrasenia == listaTransacciones.get(i).getContrasenia()) {
                    float monto = listaTransacciones.get(i).getMonto();
                    String fecha = listaTransacciones.get(i).getFecha();
                    clientesDAO.aplicarRetiroSinCuenta(folio, contrasenia) ;
                    PantallaRetiroOutForm pantallaRetiroOutForm = new PantallaRetiroOutForm(monto, fecha);
                    dispose();
                    pantallaRetiroOutForm.setVisible(true);
                }
            }
        } catch (PersistenciaException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error al generar el retiro", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblInicio = new javax.swing.JLabel();
        lblFolio = new javax.swing.JLabel();
        lblContrasenia = new javax.swing.JLabel();
        txtFolio = new javax.swing.JTextField();
        txtContraseniaRetiro = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblInicio.setText("Retiro sin Cuenta");

        lblFolio.setText("Folio:");

        lblContrasenia.setText("Contraseña:");

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblFolio)
                            .addComponent(lblContrasenia))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtContraseniaRetiro, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(txtFolio)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(btnConfirmar)))
                .addContainerGap(93, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblInicio)
                        .addGap(154, 154, 154))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnVolver)
                        .addGap(15, 15, 15))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnVolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInicio)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFolio)
                    .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContrasenia)
                    .addComponent(txtContraseniaRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(btnConfirmar)
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        if (txtFolio.getText().isBlank() || txtContraseniaRetiro.getText().isBlank() || txtFolio.getText().isEmpty() || txtContraseniaRetiro.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Rellena los espacios en Blanco",
                        "Espacios en Blanco", JOptionPane.ERROR_MESSAGE);
        }else{
            obtener() ;
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        dispose() ;
        LoginForm login = new LoginForm(clientesDAO) ;
        login.setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(RetiroSinCuentaOutForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(RetiroSinCuentaOutForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(RetiroSinCuentaOutForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(RetiroSinCuentaOutForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new RetiroSinCuentaOutForm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel lblContrasenia;
    private javax.swing.JLabel lblFolio;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JTextField txtContraseniaRetiro;
    private javax.swing.JTextField txtFolio;
    // End of variables declaration//GEN-END:variables
}
