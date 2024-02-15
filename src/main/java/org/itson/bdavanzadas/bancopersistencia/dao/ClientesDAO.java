/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.bancopersistencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.bancodominio.Cliente;
import org.itson.bdavanzadas.bancodominio.Cuenta;
import org.itson.bdavanzadas.bancodominio.Transaccion;
import org.itson.bdavanzadas.bancopersistencia.dto.ClienteNuevoDTO;
import org.itson.bdavanzadas.bancopersistencia.excepciones.PersistenciaException;
import org.itson.bdavanzadas.persistencia.conexion.IConexion;

/**
 *
 * @author Oliver Valle
 */
public class ClientesDAO implements IClientesDAO {
    
    final IConexion conexion ;
    static final Logger logger = Logger.getLogger(ClientesDAO.class.getName()) ;
    
    public ClientesDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public Cliente agregarCliente(ClienteNuevoDTO clienteNuevo) throws PersistenciaException {
        String sentenciaSQL = """
                           INSERT INTO cliente(fecha_nacimiento, edad, contrasenia, id_domicilio, id_nombre)
                           VALUES(?, ?, ?, ?, ?) ;
                          """;

        String sentenciaSQL2 = """
                               INSERT INTO domicilio(calle, codigo_postal, numero_exterior)
                               VALUES (?, ?, ?) ;
                               """;

        String sentenciaSQL3 = """
                                   INSERT INTO nombre_completo(nombres, apellido_paterno, apellido_materno)
                                   VALUES(?, ?, ?) ;
                                   """;

        try (
                Connection conexion = this.conexion.obtenerConexion(); 
                
                PreparedStatement comando = conexion.prepareStatement(
                sentenciaSQL,
                Statement.RETURN_GENERATED_KEYS); 
                
                PreparedStatement comando2 = conexion.prepareStatement(
                        sentenciaSQL2,
                        Statement.RETURN_GENERATED_KEYS); 
                
                PreparedStatement comando3 = conexion.prepareStatement(
                        sentenciaSQL3,
                        Statement.RETURN_GENERATED_KEYS);
                
                ) {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = dateFormat.parse(clienteNuevo.getFechaNacimiento());
            java.sql.Date fechaSql = new java.sql.Date(fecha.getTime());

            int edad = fechaSql.toLocalDate().until(LocalDate.now()).getYears();

            comando2.setString(1, clienteNuevo.getCalle());
            comando2.setInt(2, clienteNuevo.getCp());
            comando2.setInt(3, clienteNuevo.getNumExt());

            int numRegistros2 = comando2.executeUpdate();
            ResultSet idsGenerados2 = comando2.getGeneratedKeys();
            idsGenerados2.next();

            comando3.setString(1, clienteNuevo.getNombres());
            comando3.setString(2, clienteNuevo.getApellidoP());
            comando3.setString(3, clienteNuevo.getApellidoM());

            int numRegistros3 = comando3.executeUpdate();
            ResultSet idsGenerados3 = comando3.getGeneratedKeys();
            idsGenerados3.next();

            comando.setDate(1, fechaSql);
            comando.setInt(2, edad);
            comando.setString(3, clienteNuevo.getContrasenia());
            comando.setLong(4, idsGenerados2.getLong(1));
            comando.setLong(5, idsGenerados3.getLong(1));

            int numRegistros = comando.executeUpdate();
            logger.log(Level.INFO, "Se agregaron {0} clientes", numRegistros);

            ResultSet idsGenerados = comando.getGeneratedKeys();
            idsGenerados.next();

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
        } catch (ParseException ex) {
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
