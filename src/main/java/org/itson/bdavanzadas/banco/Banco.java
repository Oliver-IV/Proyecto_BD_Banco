/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.itson.bdavanzadas.banco;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.bancodominio.Cliente;
import org.itson.bdavanzadas.bancodominio.Transaccion;
import org.itson.bdavanzadas.bancopersistencia.dao.ClientesDAO;
import org.itson.bdavanzadas.bancopersistencia.dao.IClientesDAO;
import org.itson.bdavanzadas.bancopersistencia.dto.ClienteNuevoDTO;
import org.itson.bdavanzadas.bancopersistencia.excepciones.PersistenciaException;
import org.itson.bdavanzadas.persistencia.conexion.Conexion;
import org.itson.bdavanzadas.persistencia.conexion.IConexion;

/**
 *
 * @author Oliver Valle
 */
public class Banco {

    static final Logger logger = Logger.getLogger(Banco.class.getName()) ;
    
    public static void main(String[] args) {
        String cadenaConexion = "jdbc:mysql://localhost/bd_banco" ;
        String user = "root" ;
        String password = "inzunzam1977" ;
        
        IConexion conexion = new Conexion(cadenaConexion, user, password) ;
        IClientesDAO clientesDAO = new ClientesDAO(conexion) ;
        
        LoginForm login = new LoginForm(clientesDAO) ;        
        login.setVisible(true);
//        TablaSocios tablaSocios = new TablaSocios(sociosDAO) ;
//        tablaSocios.setVisible(true);
        
//        SociosForm sociosForm = new SociosForm(sociosDAO) ;
//        sociosForm.setVisible(true) ;
        
        
//        ClienteNuevoDTO clienteNuevo = new ClienteNuevoDTO() ;
//        clienteNuevo.setCp(85150);
//        clienteNuevo.setNombres("Oliver");
//        clienteNuevo.setApellidoP("Inzunza");
//        clienteNuevo.setApellidoM("Valle");
//        clienteNuevo.setFechaNacimiento("2004-07-06");
//        clienteNuevo.setCalle("Moises Vazquez");
//        clienteNuevo.setNumExt(507);
//        clienteNuevo.setContrasenia("Pera123");

    
//        
//        try{
//            //Transaccion retiro = clientesDAO.agregarRetiroSinCuenta(2, 500) ;
//            
//            for (int i = 0; i < 3; i++) {
//                System.out.println(clientesDAO.obtenerListaCuentas().get(i).getNumCuenta());
//            }
//            
//            //logger.log(Level.INFO, retiro.toString());
//            //List<Cliente> listaSocios = clientesDAO.obtenerListaClientes();
//            //listaSocios.forEach(socio -> System.out.println(socio));
//        } catch (PersistenciaException ex) {
//            logger.log(Level.SEVERE, null, ex) ;
//        }
    }
}
