/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.bancodominio;

/**
 *
 * @author Oliver Valle
 */
public class Transaccion {
    
    private long id ;
    private int folio ;
    private float monto ;
    private String fecha, estado ;
    private long numCuentaCliente ;
    private long numCuentaDestino ;
    private int contrasenia ;

    public Transaccion(long id, float monto, int folio, String fecha, long numCuentaCliente, long numCuentaDestino, String estado) {
        this.id = id;
        this.monto = monto;
        this.folio = folio;
        this.fecha = fecha;
        this.numCuentaCliente = numCuentaCliente;
        this.numCuentaDestino = numCuentaDestino ;
        this.estado = estado ;
    }
    
    public Transaccion(long id, float monto, int folio, String fecha, long numCuentaCliente, int contrasenia, String estado) {
        this.id = id;
        this.monto = monto;
        this.folio = folio;
        this.fecha = fecha;
        this.numCuentaCliente = numCuentaCliente;
        this.contrasenia = contrasenia ;
        this.estado = estado ;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public long getNumCuentaCliente() {
        return numCuentaCliente;
    }

    public void setNumCuentaCliente(long numCuentaCliente) {
        this.numCuentaCliente = numCuentaCliente;
    }

    public long getNumCuentaDestino() {
        return numCuentaDestino;
    }

    public void setNumCuentaDestino(long numCuentaDestino) {
        this.numCuentaDestino = numCuentaDestino;
    }

    public int getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(int contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    
    
}
