/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.bdavanzadas.persistencia.conexion;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Oliver Valle
 */
public interface IConexion {
    
    Connection obtenerConexion() throws SQLException ;
    
}
