/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.bancodominio;

/**
 *
 * @author Oliver Valle
 */
public class Cuenta {
    
    private long numCuenta, idCliente ;
    private String fechaApertura ;
    private float saldo ;
    
    public Cuenta(long numCuenta, String fechaApertura, float saldo, long idCliente) {
        this.numCuenta = numCuenta ;
        this.fechaApertura = fechaApertura ;
        this.saldo = saldo ;
        this.idCliente = idCliente ;
    }

    public long getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(long numCuenta) {
        this.numCuenta = numCuenta;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
    
    
}
