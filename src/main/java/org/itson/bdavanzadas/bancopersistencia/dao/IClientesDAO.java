/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.bdavanzadas.bancopersistencia.dao;

import java.util.List;
import org.itson.bdavanzadas.bancodominio.Cliente;
import org.itson.bdavanzadas.bancodominio.Cuenta;
import org.itson.bdavanzadas.bancodominio.Transaccion;
import org.itson.bdavanzadas.bancopersistencia.dto.ClienteNuevoDTO;

/**
 *
 * @author Oliver Valle
 */
public interface IClientesDAO {
    
    Cliente agregarCliente(ClienteNuevoDTO clienteNuevo) ;
    
    Transaccion agregarTransaccion() ;
    
    List<Cliente> obtenerListaClientes() ;
    
    List<Cuenta> obtenerListaCuentas() ;
    
    List<Transaccion> obtenerListaTransaccion() ;
    
}
