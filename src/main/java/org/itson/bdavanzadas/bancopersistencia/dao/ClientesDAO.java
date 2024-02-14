/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.bancopersistencia.dao;

import java.util.List;
import java.util.logging.Logger;
import org.itson.bdavanzadas.bancodominio.Cliente;
import org.itson.bdavanzadas.bancodominio.Cuenta;
import org.itson.bdavanzadas.bancodominio.Transaccion;
import org.itson.bdavanzadas.bancopersistencia.dto.ClienteNuevoDTO;
import org.itson.bdavanzadas.persistencia.conexion.IConexion;

/**
 *
 * @author Oliver Valle
 */
public class ClientesDAO implements IClientesDAO {
    
    final IConexion conexion ;
    static final Logger logger = Logger.getLogger(ClientesDAO.class.getName()) ;
    
    public ClientesDAO(IConexion conexion) {
        this.conexion = conexion ;
    }
    
    @Override
    public Cliente agregarCliente(ClienteNuevoDTO clienteNuevo) throws PersistenciaException {
        String sentenciaSQL = """
                           INSERT INTO cliente(fecha_nacimiento, edad, contrasenia)
                           VALUES(?, ?, ?) ;
                          """;
        
        
        try (
                Connection conexion = this.conexion.obtenerConexion(); 
                PreparedStatement comando = conexion.prepareStatement(
                sentenciaSQL,
                Statement.RETURN_GENERATED_KEYS);) {
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = dateFormat.parse(clienteNuevo.getFechaNacimiento());
            java.sql.Date fechaSql = new java.sql.Date(fecha.getTime());
            int edad = Period.between(fechaSql.toLocalDate(), LocalDate.now()).getYears() ;
            
            
            comando.setDate(1, fechaSql);
            comando.setString(2, sentenciaSQL);
            comando.setInt(3, edad);

            int numRegistros = comando.executeUpdate();
            logger.log(Level.INFO, "Se agregaron {0} clientes", numRegistros);
            
            ResultSet idsGenerados = comando.getGeneratedKeys();
            idsGenerados.next();
            
            String sentenciaSQL2 = """
                               INSERT INTO domicilio(calle, codigo_postal, numero_exterior, id_cliente_dom)
                               VALUES (?, ?, ?, ?) ;
                               """ ;
            
            try(
                PreparedStatement comando2 = conexion.prepareStatement(
                sentenciaSQL2,
                Statement.RETURN_GENERATED_KEYS);
                    ) {
                comando2.setString(1, clienteNuevo.getCalle());
                comando2.setInt(2, clienteNuevo.getCp());
                comando2.setInt(3, clienteNuevo.getNumExt());
                comando2.setLong(4, idsGenerados.getLong(1));
            } catch(SQLException ex) {
                logger.log(Level.SEVERE, "Error con el Domicilio del Cliente", ex);
                throw new PersistenciaException("Error con el Domicilio del Cliente", ex);
            }
            
            String sentenciaSQL3 = """
                                   INSERT INTO nombre_completo(nombres, apellido_paterno, apellido_materno, id_cliente_nom)
                                   VALUES(?, ?, ?, ?) ;
                                   """ ;
            
            try(
                PreparedStatement comando3 = conexion.prepareStatement(
                sentenciaSQL3,
                Statement.RETURN_GENERATED_KEYS);
                    ) {
                comando3.setString(1, clienteNuevo.getNombres());
                comando3.setString(2, clienteNuevo.getApellidoP());
                comando3.setString(3, clienteNuevo.getApellidoM());
                comando3.setLong(4, idsGenerados.getLong(1));
            } catch(SQLException ex) {
                logger.log(Level.SEVERE, "Error con el Nombre del Cliente", ex);
                throw new PersistenciaException("Error con el Nombre del Cliente", ex);
            }
            
            
            Cliente cliente = new Cliente(idsGenerados.getLong(1),
                    String.valueOf(clienteNuevo.getCp()),
                    clienteNuevo.getNombres(),
                    clienteNuevo.getApellidoP(),
                    clienteNuevo.getApellidoM(),
                    clienteNuevo.getCalle(),
                    clienteNuevo.getNumExt(),
                    clienteNuevo.getContrasenia());

            return cliente;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo guardar el cliente", ex);
            throw new PersistenciaException("No se pudo guardar el cliente", ex);
        } catch(ParseException ex) {
            logger.log(Level.SEVERE, "No se pudo guardar el cliente", ex);
            throw new PersistenciaException("No se pudo guardar el cliente", ex);
        }
    }

    @Override
    public Transaccion agregarTransaccion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Cliente> obtenerListaClientes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Cuenta> obtenerListaCuentas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Transaccion> obtenerListaTransaccion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
