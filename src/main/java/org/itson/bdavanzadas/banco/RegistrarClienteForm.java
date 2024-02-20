/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.bdavanzadas.banco;

import javax.swing.JOptionPane;
import org.itson.bdavanzadas.bancodominio.Cliente;
import org.itson.bdavanzadas.bancopersistencia.dao.IClientesDAO;
import org.itson.bdavanzadas.bancopersistencia.dto.ClienteNuevoDTO;
import org.itson.bdavanzadas.bancopersistencia.excepciones.PersistenciaException;

/**
 *
 * @author Oliver Valle
 */
public class RegistrarClienteForm extends javax.swing.JFrame {

    IClientesDAO clientesDAO ;
    Cliente clienteRegistrado ;
    int contClicks = 0 ;
    
    /**
     * Creates new form RegistrarClienteForm
     */
    public RegistrarClienteForm(IClientesDAO clientesDAO) {
        initComponents();
        this.clientesDAO = clientesDAO ;
        hidePassword() ;
    }
    
    public void agregarCliente() {
        String nombres = txtNombres.getText() ;
        String apellidoP = txtApellidoP.getText() ;
        String apellidoM = txtApellidoM.getText() ;
        String fechaNacimiento = comboBoxAnio.getSelectedItem().toString() + "-" + comboBoxMes.getSelectedItem().toString() + "-" + comboBoxDia.getSelectedItem().toString() ;
        String calle = txtCalle.getText() ;
        int numExt = Integer.parseInt(txtNumExt.getText()) ;
        int cp = Integer.parseInt(txtCodigoPostal.getText()) ;
        String contrasenia = txtContrasenia.getText() ;
        
        ClienteNuevoDTO clienteNuevo = new ClienteNuevoDTO(nombres, apellidoP, apellidoM,
        fechaNacimiento, calle, numExt, cp, contrasenia) ;
        
        try {
            clienteRegistrado = clientesDAO.agregarCliente(clienteNuevo) ;
            
        } catch(PersistenciaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error al agregar cliente", JOptionPane.ERROR_MESSAGE) ;
        }
    }
    
    public boolean validarEnteros() {
        try {
            int entero = Integer.parseInt(txtCodigoPostal.getText());
            int entero2 = Integer.parseInt(txtNumExt.getText()) ;
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public void hidePersonalData() {
        lblDatosPersonales.setVisible(false);
        lblDatosPersonales.setEnabled(false);
        lblDomicilio.setVisible(false);
        lblDomicilio.setEnabled(false);
        lblNombres.setVisible(false);
        lblNombres.setEnabled(false);
        txtNombres.setVisible(false);
        txtNombres.setEnabled(false);
        lblApellidoP.setVisible(false);
        lblApellidoP.setEnabled(false);
        txtApellidoP.setVisible(false);
        txtApellidoP.setEnabled(false);
        lblApellidoM.setVisible(false);
        lblApellidoM.setEnabled(false);
        txtApellidoM.setVisible(false);
        txtApellidoM.setEnabled(false);
        lblFechaNacimiento.setVisible(false);
        lblFechaNacimiento.setEnabled(false);
        comboBoxAnio.setEnabled(false);
        comboBoxAnio.setVisible(false);
        comboBoxMes.setEnabled(false);
        comboBoxMes.setVisible(false);
        comboBoxDia.setEnabled(false);
        comboBoxDia.setVisible(false);
        lblCalle.setVisible(false);
        lblCalle.setEnabled(false);
        txtCalle.setVisible(false);
        txtCalle.setEnabled(false);
        lblNumExt.setVisible(false);
        lblNumExt.setEnabled(false);
        txtNumExt.setVisible(false);
        txtNumExt.setEnabled(false);
        lblCodigoPostal.setVisible(false);
        lblCodigoPostal.setEnabled(false);
        txtCodigoPostal.setVisible(false);
        txtCodigoPostal.setEnabled(false);
    }

    public void showPersonalData() {
        lblDatosPersonales.setVisible(true);
        lblDatosPersonales.setEnabled(true);
        lblDomicilio.setVisible(true);
        lblDomicilio.setEnabled(true);
        lblNombres.setVisible(true);
        lblNombres.setEnabled(true);
        txtNombres.setVisible(true);
        txtNombres.setEnabled(true);
        lblApellidoP.setVisible(true);
        lblApellidoP.setEnabled(true);
        txtApellidoP.setVisible(true);
        txtApellidoP.setEnabled(true);
        lblApellidoM.setVisible(true);
        lblApellidoM.setEnabled(true);
        txtApellidoM.setVisible(true);
        txtApellidoM.setEnabled(true);
        lblFechaNacimiento.setVisible(true);
        lblFechaNacimiento.setEnabled(true);
        comboBoxAnio.setEnabled(true);
        comboBoxAnio.setVisible(true);
        comboBoxMes.setEnabled(true);
        comboBoxMes.setVisible(true);
        comboBoxDia.setEnabled(true);
        comboBoxDia.setVisible(true);
        lblCalle.setVisible(true);
        lblCalle.setEnabled(true);
        txtCalle.setVisible(true);
        txtCalle.setEnabled(true);
        lblNumExt.setVisible(true);
        lblNumExt.setEnabled(true);
        txtNumExt.setVisible(true);
        txtNumExt.setEnabled(true);
        lblCodigoPostal.setVisible(true);
        lblCodigoPostal.setEnabled(true);
        txtCodigoPostal.setVisible(true);
        txtCodigoPostal.setEnabled(true);

    }
    
    public void showPassword() {
        lblContrasenia.setVisible(true);
        lblContrasenia.setEnabled(true);
        txtContrasenia.setVisible(true);
        txtContrasenia.setEnabled(true);
        lblCrearContrasenia.setVisible(true);
        lblCrearContrasenia.setEnabled(true);
        btnVolver.setVisible(true);
        btnVolver.setEnabled(true);
    }
    
    public void hidePassword() {
        lblContrasenia.setVisible(false);
        lblContrasenia.setEnabled(false);
        txtContrasenia.setVisible(false);
        txtContrasenia.setEnabled(false);
        lblCrearContrasenia.setVisible(false);
        lblCrearContrasenia.setEnabled(false);
        btnVolver.setVisible(false);
        btnVolver.setEnabled(false);
    }
    
    public boolean booleansFirst() {
        return txtNombres.getText().isBlank() || txtNombres.getText().isEmpty() || txtApellidoP.getText().isBlank() || txtApellidoP.getText().isEmpty()
            || txtApellidoM.getText().isBlank() || txtApellidoM.getText().isEmpty() || txtCodigoPostal.getText().isBlank() || txtCodigoPostal.getText().isEmpty() 
                || txtCalle.getText().isBlank() || txtCalle.getText().isEmpty();
        
    }
    
    public boolean booleansSecond() {
        return txtContrasenia.getText().isBlank() || txtContrasenia.getText().isEmpty() ;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblDatosPersonales = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        lblNombres = new javax.swing.JLabel();
        lblApellidoP = new javax.swing.JLabel();
        lblApellidoM = new javax.swing.JLabel();
        lblFechaNacimiento = new javax.swing.JLabel();
        lblDomicilio = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtApellidoP = new javax.swing.JTextField();
        txtApellidoM = new javax.swing.JTextField();
        lblCalle = new javax.swing.JLabel();
        lblCodigoPostal = new javax.swing.JLabel();
        lblNumExt = new javax.swing.JLabel();
        txtCalle = new javax.swing.JTextField();
        txtCodigoPostal = new javax.swing.JTextField();
        txtNumExt = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        lblContrasenia = new javax.swing.JLabel();
        txtContrasenia = new javax.swing.JTextField();
        lblCrearContrasenia = new javax.swing.JLabel();
        comboBoxAnio = new javax.swing.JComboBox<>();
        comboBoxMes = new javax.swing.JComboBox<>();
        comboBoxDia = new javax.swing.JComboBox<>();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("¡Registrate como Cliente!");
        setPreferredSize(new java.awt.Dimension(450, 350));
        setResizable(false);
        getContentPane().setLayout(null);

        lblTitulo.setText("¡Crea una cuenta con nosotros!");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(40, 40, 210, 16);

        lblDatosPersonales.setText("Datos Personales");
        getContentPane().add(lblDatosPersonales);
        lblDatosPersonales.setBounds(80, 110, 130, 16);

        lblDescripcion.setText("*Es obligatorio llenar todos los campos*");
        getContentPane().add(lblDescripcion);
        lblDescripcion.setBounds(80, 60, 260, 16);

        lblNombres.setText("Nombres:");
        getContentPane().add(lblNombres);
        lblNombres.setBounds(60, 150, 52, 16);

        lblApellidoP.setText("Apellido Paterno:");
        getContentPane().add(lblApellidoP);
        lblApellidoP.setBounds(20, 180, 110, 16);

        lblApellidoM.setText("Apellido Materno:");
        getContentPane().add(lblApellidoM);
        lblApellidoM.setBounds(20, 210, 110, 16);

        lblFechaNacimiento.setText("Fecha de Nacimiento:");
        getContentPane().add(lblFechaNacimiento);
        lblFechaNacimiento.setBounds(80, 250, 170, 16);

        lblDomicilio.setText("Domicilio");
        getContentPane().add(lblDomicilio);
        lblDomicilio.setBounds(260, 110, 90, 16);
        getContentPane().add(txtNombres);
        txtNombres.setBounds(130, 150, 71, 22);
        getContentPane().add(txtApellidoP);
        txtApellidoP.setBounds(130, 180, 71, 22);
        getContentPane().add(txtApellidoM);
        txtApellidoM.setBounds(130, 210, 71, 22);

        lblCalle.setText("Calle:");
        getContentPane().add(lblCalle);
        lblCalle.setBounds(300, 150, 70, 16);

        lblCodigoPostal.setText("Codigo Postal:");
        getContentPane().add(lblCodigoPostal);
        lblCodigoPostal.setBounds(250, 180, 100, 16);

        lblNumExt.setText("Num. Exterior:");
        getContentPane().add(lblNumExt);
        lblNumExt.setBounds(250, 210, 100, 16);
        getContentPane().add(txtCalle);
        txtCalle.setBounds(340, 150, 83, 22);
        getContentPane().add(txtCodigoPostal);
        txtCodigoPostal.setBounds(340, 180, 70, 22);
        getContentPane().add(txtNumExt);
        txtNumExt.setBounds(340, 210, 35, 22);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar);
        btnAceptar.setBounds(300, 260, 90, 23);

        lblContrasenia.setText("Contraseña:");
        getContentPane().add(lblContrasenia);
        lblContrasenia.setBounds(120, 170, 70, 16);
        getContentPane().add(txtContrasenia);
        txtContrasenia.setBounds(190, 170, 90, 22);

        lblCrearContrasenia.setText("¡Crea tu contraseña!");
        getContentPane().add(lblCrearContrasenia);
        lblCrearContrasenia.setBounds(150, 90, 140, 16);

        comboBoxAnio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930" }));
        getContentPane().add(comboBoxAnio);
        comboBoxAnio.setBounds(40, 270, 70, 22);

        comboBoxMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));
        comboBoxMes.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                comboBoxMesComponentHidden(evt);
            }
        });
        getContentPane().add(comboBoxMes);
        comboBoxMes.setBounds(110, 270, 72, 22);

        comboBoxDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", " " }));
        getContentPane().add(comboBoxDia);
        comboBoxDia.setBounds(180, 270, 72, 22);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver);
        btnVolver.setBounds(340, 40, 72, 23);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
  
        if (contClicks == 1) {
            if (!booleansSecond()) {
                agregarCliente();
                dispose();
                PantallaFinRegistroForm finRegistro = new PantallaFinRegistroForm(clientesDAO, clienteRegistrado);
                finRegistro.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Rellena los espacios en Blanco",
                        "Espacios en Blanco", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if (!booleansFirst()) {
            if (!validarEnteros()) {
                JOptionPane.showMessageDialog(this, "Codigo Postal o Numero exterior no son enteros, verificalo",
                        "Formato invalido", JOptionPane.ERROR_MESSAGE);
            } else {
                contClicks++;
                hidePersonalData();
                showPassword();
            }
        } else if (booleansSecond()) {
            JOptionPane.showMessageDialog(this, "Rellena los espacios en Blanco",
                    "Espacios en Blanco", JOptionPane.ERROR_MESSAGE);
        } else if (validarEnteros()) {
            JOptionPane.showMessageDialog(this, "Codigo Postal o Numero exterior no son enteros, verificalo",
                    "Formato invalido", JOptionPane.ERROR_MESSAGE);
        }

        
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void comboBoxMesComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_comboBoxMesComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxMesComponentHidden

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        showPersonalData() ;
        hidePassword() ;
        contClicks = 0 ;
    }//GEN-LAST:event_btnVolverActionPerformed

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
//            java.util.logging.Logger.getLogger(RegistrarClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(RegistrarClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(RegistrarClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(RegistrarClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new RegistrarClienteForm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> comboBoxAnio;
    private javax.swing.JComboBox<String> comboBoxDia;
    private javax.swing.JComboBox<String> comboBoxMes;
    private javax.swing.JLabel lblApellidoM;
    private javax.swing.JLabel lblApellidoP;
    private javax.swing.JLabel lblCalle;
    private javax.swing.JLabel lblCodigoPostal;
    private javax.swing.JLabel lblContrasenia;
    private javax.swing.JLabel lblCrearContrasenia;
    private javax.swing.JLabel lblDatosPersonales;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblDomicilio;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblNumExt;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtApellidoM;
    private javax.swing.JTextField txtApellidoP;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtCodigoPostal;
    private javax.swing.JTextField txtContrasenia;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNumExt;
    // End of variables declaration//GEN-END:variables
}
