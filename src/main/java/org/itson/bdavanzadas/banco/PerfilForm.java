/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.bdavanzadas.banco;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.itson.bdavanzadas.bancodominio.Cliente;
import org.itson.bdavanzadas.bancodominio.Cuenta;
import org.itson.bdavanzadas.bancopersistencia.dao.IClientesDAO;
import org.itson.bdavanzadas.bancopersistencia.excepciones.PersistenciaException;

/**
 *
 * @author Oliver Valle
 */
public class PerfilForm extends javax.swing.JFrame {
    
    IClientesDAO clientesDAO ;
    Cliente cliente ;
    List<Cuenta> cuentasCliente ;
    /**
     * Creates new form PerfilForm
     */
    public PerfilForm(IClientesDAO clientesDAO, Cliente cliente, List<Cuenta> listaCuentas) {
        initComponents();
        this.clientesDAO = clientesDAO ;
        this.cliente = cliente ;
        this.cuentasCliente = listaCuentas ;
        asignarCampos() ;
        setComboBoxModel() ;
        btnActualizar.setEnabled(false);
        btnActualizar.setVisible(false);
    }
    
    public void enableCampos() {
        txtContrasenia.setEnabled(true);
        txtContrasenia.setEditable(true);
        txtCalle.setEnabled(true);
        txtCalle.setEditable(true);
        txtCodigoPostal.setEnabled(true);
        txtCodigoPostal.setEditable(true);
        txtNumExterior.setEnabled(true);
        txtNumExterior.setEditable(true);
        btnActualizar.setEnabled(true);
        btnActualizar.setVisible(true);
    }
    
    public void disableCampos() {
        txtContrasenia.setEnabled(false);
        txtContrasenia.setEditable(false);
        txtCalle.setEnabled(false);
        txtCalle.setEditable(false);
        txtCodigoPostal.setEnabled(false);
        txtCodigoPostal.setEditable(false);
        txtNumExterior.setEnabled(false);
        txtNumExterior.setEditable(false);
        btnActualizar.setEnabled(false);
        btnActualizar.setVisible(false);

    }
    
    public void asignarCampos() {
        lblNombre.setText(cliente.getNombres() + " " + cliente.getApellidoP() + " " + cliente.getApellidoM());
        txtEdad.setText(String.valueOf(convertirFechaAEdad()));
        txtFechaNacimiento.setText(cliente.getFechaNacimiento());
        txtCalle.setText(cliente.getCalle());
        txtCodigoPostal.setText(String.valueOf(cliente.getCp()));
        txtNumExterior.setText(String.valueOf(cliente.getNumExt())) ;
        txtId.setText(String.valueOf(cliente.getId())) ;
        txtContrasenia.setText(cliente.getContrasenia());
    }
    
    public int convertirFechaAEdad() {
        
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaNacimiento = LocalDate.parse(cliente.getFechaNacimiento(), dateFormat);

            int edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        
            return edad ;
    }    
    
    public void actualizarCliente() {
        cliente.setCalle(txtCalle.getText());
        cliente.setContrasenia(txtContrasenia.getText());
        cliente.setCp(Integer.parseInt(txtCodigoPostal.getText()));
        cliente.setNumExt(Integer.parseInt(txtNumExterior.getText()));
    }
    
    public void setComboBoxModel() {
        String[] arregloCuentas = new String[cuentasCliente.size()];
        try{
        for (int i = 0; i < cuentasCliente.size(); i++) {
            arregloCuentas[i] = "Numero de Cuenta: " + String.valueOf(cuentasCliente.get(i).getNumCuenta()) ;
        }
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
        
        DefaultComboBoxModel<String> modeloComboBox = new DefaultComboBoxModel<>(arregloCuentas) ;
        comboBoxCuentas.setModel(modeloComboBox);
    }
    
    public long obtenerNumCuentaSelec() {
        String textoSaldo = comboBoxCuentas.getSelectedItem().toString() ;
        String[] numeros = textoSaldo.split("\\D+"); // Divide la cadena en partes que no son números
        for (String numero : numeros) {
            if (!numero.isEmpty()) { // Para evitar cadenas vacías
                int num = Integer.parseInt(numero);
                return num ;
            }
        }
         return -1 ;
        
    }
    
    public void obtenerCuentas() {
        long idCliente = cliente.getId() ;
        try {
            List<Cuenta> listaCuentas = clientesDAO.obtenerListaCuentas();
            for (int i = 0; i < listaCuentas.size(); i++) {
                long idBuscar = listaCuentas.get(i).getIdCliente() ;
                
                if (idCliente == idBuscar) {
                    cuentasCliente.add(listaCuentas.get(i)) ;
                }
                
            }
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error al obtener cuentas", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean validarEnteros() {
        try {
            int entero = Integer.parseInt(txtCodigoPostal.getText());
            int entero2 = Integer.parseInt(txtNumExterior.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
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

        lblNombre = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        lblFechaNacimiento = new javax.swing.JLabel();
        lblDomicilio = new javax.swing.JLabel();
        lblCalle = new javax.swing.JLabel();
        lblCodigoPostal = new javax.swing.JLabel();
        lblNumExt = new javax.swing.JLabel();
        txtCalle = new javax.swing.JTextField();
        txtCodigoPostal = new javax.swing.JTextField();
        txtNumExterior = new javax.swing.JTextField();
        txtFechaNacimiento = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        btnVolver = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();
        lblContrasenia = new javax.swing.JLabel();
        txtContrasenia = new javax.swing.JPasswordField();
        txtId = new javax.swing.JTextField();
        toggleContrasenia = new javax.swing.JToggleButton();
        toggleModificar = new javax.swing.JToggleButton();
        btnActualizar = new javax.swing.JButton();
        comboBoxCuentas = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Perfil de Usuario");
        setResizable(false);

        lblNombre.setText("Nombre");

        lblEdad.setText("Edad:");

        lblFechaNacimiento.setText("Fecha de Nacimiento:");

        lblDomicilio.setText("Domicilio");

        lblCalle.setText("Calle:");

        lblCodigoPostal.setText("Codigo Postal:");

        lblNumExt.setText("Numero Exterior:");

        txtCalle.setEditable(false);

        txtCodigoPostal.setEditable(false);

        txtNumExterior.setEditable(false);

        txtFechaNacimiento.setEditable(false);

        txtEdad.setEditable(false);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        lblId.setText("ID:");

        lblContrasenia.setText("Contraseña:");

        txtContrasenia.setEditable(false);

        txtId.setEditable(false);

        toggleContrasenia.setText("Ver Contraseña");
        toggleContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleContraseniaActionPerformed(evt);
            }
        });

        toggleModificar.setText("Modificar");
        toggleModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleModificarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jLabel1.setText("Cuentas:");

        btnCancelar.setText("Cancelar Cuenta");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(48, 48, 48)
                                    .addComponent(lblId)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(26, 26, 26)
                                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFechaNacimiento)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblEdad)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblContrasenia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtContrasenia)
                                    .addComponent(toggleContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnActualizar)
                        .addGap(46, 46, 46)
                        .addComponent(toggleModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVolver, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(lblNumExt)
                                                .addComponent(lblCalle)
                                                .addComponent(lblCodigoPostal))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtCalle)
                                                .addComponent(txtCodigoPostal)
                                                .addComponent(txtNumExterior, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(117, 117, 117)
                                            .addComponent(lblDomicilio)))
                                    .addGap(34, 34, 34))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(comboBoxCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(32, 32, 32)
                                    .addComponent(btnCancelar))))))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(btnVolver))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnCancelar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblContrasenia)
                            .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(toggleContrasenia)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblEdad)
                                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(lblFechaNacimiento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCalle)
                            .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodigoPostal)
                            .addComponent(txtCodigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNumExt)
                            .addComponent(txtNumExterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblDomicilio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toggleModificar)
                    .addComponent(btnActualizar))
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        dispose() ;
        MenuPrincipalForm menu = new MenuPrincipalForm(clientesDAO, cliente) ;
        menu.setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void toggleContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleContraseniaActionPerformed
        if (toggleContrasenia.isSelected()) {
            txtContrasenia.setEchoChar((char)0);
        } else {
            txtContrasenia.setEchoChar('*');
        }
    }//GEN-LAST:event_toggleContraseniaActionPerformed

    private void toggleModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleModificarActionPerformed
        if (toggleModificar.isSelected()) {
            enableCampos() ;
        } else {
            disableCampos() ;
        }
    }//GEN-LAST:event_toggleModificarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
         try {
            if (txtCodigoPostal.getText().isBlank() || txtCodigoPostal.getText().isBlank()
                    || txtNumExterior.getText().isBlank() || txtNumExterior.getText().isEmpty()
                    || txtCalle.getText().isBlank() || txtCalle.getText().isEmpty()
                    || txtContrasenia.getText().isBlank() || txtContrasenia.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Rellena los espacios en Blanco",
                        "Espacios en Blanco", JOptionPane.ERROR_MESSAGE);
                return ;
            }

            if (!validarEnteros()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa valores válidos para los campos numéricos.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int resp = JOptionPane.showConfirmDialog(this, "¿Estás seguro de realizar estos cambios?", "Modificar datos",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (resp == 0) {
                actualizarCliente();
                clientesDAO.actualizarCliente(cliente);
                JOptionPane.showMessageDialog(this, "¡Se han actualizado tus datos!", "Modificación exitosa", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error en Modificación", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int resp = JOptionPane.showConfirmDialog(this, "¿Estas seguro de querer cancelar tu cuenta?, TODO el SALDO será removido y ya no tendrás acceso a ella.", "Modificar datos", 
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) ;
            if (resp == 0) {
                clientesDAO.cancelarCuenta(obtenerNumCuentaSelec()) ;
                obtenerCuentas() ;
                JOptionPane.showMessageDialog(this, "¡Se han cancelado tu cuenta!", "Cancelación exitosa", JOptionPane.INFORMATION_MESSAGE);
                setComboBoxModel() ;
            } 
    }//GEN-LAST:event_btnCancelarActionPerformed

//    /**
//     * @param args the command line arguments
//     */
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
//            java.util.logging.Logger.getLogger(PerfilForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(PerfilForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(PerfilForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(PerfilForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new PerfilForm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> comboBoxCuentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCalle;
    private javax.swing.JLabel lblCodigoPostal;
    private javax.swing.JLabel lblContrasenia;
    private javax.swing.JLabel lblDomicilio;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumExt;
    private javax.swing.JToggleButton toggleContrasenia;
    private javax.swing.JToggleButton toggleModificar;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtCodigoPostal;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNumExterior;
    // End of variables declaration//GEN-END:variables
}
