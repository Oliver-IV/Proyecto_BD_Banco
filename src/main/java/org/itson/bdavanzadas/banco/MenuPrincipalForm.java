/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.bdavanzadas.banco;

import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.itson.bdavanzadas.bancodominio.Cliente;
import org.itson.bdavanzadas.bancodominio.Cuenta;
import org.itson.bdavanzadas.bancopersistencia.dao.ClientesDAO;
import org.itson.bdavanzadas.bancopersistencia.dao.IClientesDAO;
import org.itson.bdavanzadas.bancopersistencia.excepciones.PersistenciaException;

/**
 *
 * @author Oliver Valle
 */
public class MenuPrincipalForm extends javax.swing.JFrame {

    IClientesDAO clientesDAO;
    List<Cuenta> cuentasCliente;
    Cliente cliente;

    /**
     * Creates new form MenuPrincipalForm
     */
    public MenuPrincipalForm(IClientesDAO clientesDAO, Cliente cliente) {
        initComponents();
        this.clientesDAO = clientesDAO;
        this.cliente = cliente;
        cuentasCliente = new LinkedList();
        obtenerCuentas();
        setComboBoxModel();
        asignarSaldo();
        lblInicio.setText(lblInicio.getText() + " " + cliente.getNombres() + "!");
    }

    public void obtenerCuentas() {
        long idCliente = cliente.getId();
        try {
            List<Cuenta> listaCuentas = clientesDAO.obtenerListaCuentas();
            for (int i = 0; i < listaCuentas.size(); i++) {
                long idBuscar = listaCuentas.get(i).getIdCliente();

                if (idCliente == idBuscar) {
                    cuentasCliente.add(listaCuentas.get(i));
                }

            }
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error al obtener cuentas", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void asignarSaldo() {
        txtSaldo.setText(String.valueOf(obtenerCuentaSelec().getSaldo()));
        txtSaldo.setEditable(false);
    }

    public void setComboBoxModel() {
        String[] arregloCuentas = new String[cuentasCliente.size()];
        try {
            for (int i = 0; i < cuentasCliente.size(); i++) {
                arregloCuentas[i] = "Numero de Cuenta: " + String.valueOf(cuentasCliente.get(i).getNumCuenta());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        DefaultComboBoxModel<String> modeloComboBox = new DefaultComboBoxModel<>(arregloCuentas);
        comboBoxCuentas.setModel(modeloComboBox);
    }

    public Cuenta obtenerCuentaSelec() {
        Cuenta cuentaSelec = null;
        for (int i = 0; i < cuentasCliente.size(); i++) {
            if (cuentasCliente.get(i).getNumCuenta() == obtenerNumCuentaSelec()) {
                cuentaSelec = cuentasCliente.get(i);
            }
        }

        return cuentaSelec;
    }

    public long obtenerNumCuentaSelec() {
        String textoSaldo = comboBoxCuentas.getSelectedItem().toString();
        String[] numeros = textoSaldo.split("\\D+"); // Divide la cadena en partes que no son números
        for (String numero : numeros) {
            if (!numero.isEmpty()) { // Para evitar cadenas vacías
                int num = Integer.parseInt(numero);
                return num;
            }
        }
        return -1;

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
        lblSaldo = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        btnTransferir = new javax.swing.JButton();
        btnRetiroSinCuenta = new javax.swing.JButton();
        btnHistorialOp = new javax.swing.JButton();
        btnPerfil = new javax.swing.JButton();
        comboBoxCuentas = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblInicio.setText("Hola");

        lblSaldo.setText("Saldo en Pesos:");

        btnTransferir.setText("Transferir");
        btnTransferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferirActionPerformed(evt);
            }
        });

        btnRetiroSinCuenta.setText("Retiro Sin Cuenta");
        btnRetiroSinCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetiroSinCuentaActionPerformed(evt);
            }
        });

        btnHistorialOp.setText("Historial de Operaciones");
        btnHistorialOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialOpActionPerformed(evt);
            }
        });

        btnPerfil.setText("Perfil");
        btnPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerfilActionPerformed(evt);
            }
        });

        comboBoxCuentas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnTransferir)
                    .addComponent(btnPerfil))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnHistorialOp)
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRetiroSinCuenta)
                        .addGap(66, 66, 66))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lblInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSaldo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(lblInicio)
                .addGap(5, 5, 5)
                .addComponent(comboBoxCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSaldo)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHistorialOp)
                    .addComponent(btnPerfil))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTransferir)
                    .addComponent(btnRetiroSinCuenta))
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerfilActionPerformed
        dispose();
        PerfilForm perfil = new PerfilForm(clientesDAO, cliente);
        perfil.setVisible(true);
    }//GEN-LAST:event_btnPerfilActionPerformed

    private void btnHistorialOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialOpActionPerformed
        HistorialOperacionesForm historialOperaciones = new HistorialOperacionesForm(clientesDAO, obtenerNumCuentaSelec());
        historialOperaciones.setVisible(true);
//        JOptionPane.showMessageDialog(this, "Esta función está en desarrollo actualmente", 
//                            "Opcion en Desarrollo", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnHistorialOpActionPerformed

    private void btnTransferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferirActionPerformed
      dispose();
      TransferenciaForm transferenciaForm = new TransferenciaForm(clientesDAO, cliente, obtenerNumCuentaSelec());
      transferenciaForm.setVisible(true);
    }//GEN-LAST:event_btnTransferirActionPerformed

    private void btnRetiroSinCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetiroSinCuentaActionPerformed
        dispose();
        RetiroSinCuentaInForm retiroSinCuenta = new RetiroSinCuentaInForm(clientesDAO, Float.parseFloat(txtSaldo.getText()), cuentasCliente.get(0));
        retiroSinCuenta.setVisible(true);
    }//GEN-LAST:event_btnRetiroSinCuentaActionPerformed

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
//            java.util.logging.Logger.getLogger(MenuPrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MenuPrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MenuPrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MenuPrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MenuPrincipalForm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHistorialOp;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JButton btnRetiroSinCuenta;
    private javax.swing.JButton btnTransferir;
    private javax.swing.JComboBox<String> comboBoxCuentas;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JTextField txtSaldo;
    // End of variables declaration//GEN-END:variables
}
