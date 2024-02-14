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
    public Cliente agregarCliente(ClienteNuevoDTO clienteNuevo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
