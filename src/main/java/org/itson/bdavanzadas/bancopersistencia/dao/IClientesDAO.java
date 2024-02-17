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
import org.itson.bdavanzadas.bancopersistencia.excepciones.PersistenciaException;

/**
 *
 * @author Oliver Valle
 */
public interface IClientesDAO {
    
    Cliente agregarCliente(ClienteNuevoDTO clienteNuevo) throws PersistenciaException ;
    
    Transaccion agregarRetiroSinCuenta(long numeroCuenta, float monto) throws PersistenciaException ;
    
    Transaccion agregarTransferencia(long numeroCuenta) throws PersistenciaException ;
    
    Transaccion aplicarRetiroSinCuenta(int folio, int contrasenia) throws PersistenciaException ;
    
    List<Cliente> obtenerListaClientes() throws PersistenciaException ;
    
    List<Cuenta> obtenerListaCuentas() throws PersistenciaException ;
    
    List<Transaccion> obtenerListaTransaccion() throws PersistenciaException ;
    
    List<Transaccion> obtenerListaRetiroSinCuenta() throws PersistenciaException ;
    
    List<Transaccion> obtenerListaTransefencias() throws PersistenciaException ;
    
    List<Transaccion> obtenerHistorialOperaciones(long numeroCuenta, String fechaInicio, String fechaFin) ;
    
}
