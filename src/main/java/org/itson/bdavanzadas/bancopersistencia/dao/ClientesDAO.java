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
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
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
        
        String sentenciaSQL4 = """
                               INSERT INTO cuenta(saldo, id_cliente)
                               VALUES(?, ?) ;
                               """ ;

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
                
                PreparedStatement comando4 = conexion.prepareStatement(
                        sentenciaSQL4,
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
                    clienteNuevo.getNombres(),
                    clienteNuevo.getApellidoP(),
                    clienteNuevo.getApellidoM(),
                    clienteNuevo.getFechaNacimiento(),
                    edad,
                    clienteNuevo.getCalle(),
                    clienteNuevo.getNumExt(),
                    clienteNuevo.getCp(),
                    clienteNuevo.getContrasenia());
            
            
            comando4.setFloat(1, 0) ;
            comando4.setLong(2, idsGenerados.getLong(1));
            
            int numRegistros4 = comando4.executeUpdate();
            ResultSet idsGenerados4 = comando4.getGeneratedKeys();
            idsGenerados4.next();
            
            logger.log(Level.INFO, "Se agrego una cuenta al cliente", numRegistros4);

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
    public Cliente actualizarCliente(Cliente cliente) throws PersistenciaException {
        String sentenciaSQL = """
                          UPDATE cliente c
                          JOIN domicilio d ON c.id_domicilio = d.id
                          SET 
                              d.calle = ? ,
                              d.codigo_postal = ? ,
                              d.numero_exterior = ? ,
                              c.contrasenia = ?
                          WHERE c.id = ?;
                          """;
        
        try(
            Connection conexion = this.conexion.obtenerConexion() ;
            PreparedStatement comando = conexion.prepareStatement(sentenciaSQL);
                ) {
            
            comando.setString(1, cliente.getCalle());
            comando.setInt(2, cliente.getCp()) ;
            comando.setInt(3, cliente.getNumExt());
            comando.setString(4, cliente.getContrasenia());
            comando.setInt(5, Integer.parseInt(String.valueOf(cliente.getId())));
            
            int numRegistros = comando.executeUpdate() ;
            logger.log(Level.INFO, "Se actualizaron los datos del cliente", numRegistros);
            
            return cliente ;
            
        } catch(SQLException ex) {
            logger.log(Level.SEVERE, "No se pudieron actualizar los datos del socio", ex) ;
            throw new PersistenciaException("No se pudieron actualizar los datos del socio", ex) ;
        }
    }

    @Override
    public Transaccion agregarRetiroSinCuenta(long numeroCuenta, float monto) throws PersistenciaException {
        String sentenciaSQL = """
                           INSERT INTO transaccion(monto, folio, fecha, num_cuenta_cliente, estado)
                           VALUES(?, ?, CURDATE(), ?, 'Pendiente') ;
                          """;
        
        String sentenciaSQL2 = """
                               INSERT INTO retiro_sin_cuenta(id_transaccion_ret, contrasenia)
                               VALUES(?, ?) ;
                               """ ;


        try (
                Connection conexion = this.conexion.obtenerConexion(); 
                
                PreparedStatement comando = conexion.prepareStatement(
                sentenciaSQL,
                Statement.RETURN_GENERATED_KEYS); 
                
                PreparedStatement comando2 = conexion.prepareStatement(
                        sentenciaSQL2,
                        Statement.RETURN_GENERATED_KEYS); 
                
                ) {

            int folio = generarContrasenia(6) ;
            int contrasenia = generarContrasenia(8) ;
            
            comando.setFloat(1, monto);
            comando.setInt(2, folio);
            comando.setLong(3, numeroCuenta);

            int numRegistros = comando.executeUpdate();
            ResultSet idsGenerados = comando.getGeneratedKeys();
            idsGenerados.next();
            
            comando2.setLong(1, idsGenerados.getLong(1));
            comando2.setInt(2, contrasenia);

            int numRegistros2 = comando2.executeUpdate();
            ResultSet idsGenerados2 = comando.getGeneratedKeys();
            idsGenerados2.next();


            Transaccion retiro = new Transaccion(idsGenerados.getLong(1),
                                    monto, 
                                    folio, 
                                    java.time.LocalDate.now().toString(),
                                    numeroCuenta,
                                    contrasenia,
                                    "Pendiente");
            
            
            
            logger.log(Level.INFO, "Se generaron las claves del retiro sin cuenta", numRegistros);

                return retiro;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo generar el registro sin cuenta", ex);
            throw new PersistenciaException("No se pudo generar el registro sin cuenta", ex);
        }
    }
    
    @Override
    public Transaccion agregarTransferencia(long numeroCuenta, long numeroCuentaDestino, float monto) throws PersistenciaException {
        String sentenciaSQL = """
                           INSERT INTO transaccion(monto, folio, fecha, num_cuenta_cliente, estado)
                           VALUES(?, ?, CURDATE(), ?, 'Pendiente') ;
                          """;
        
        String sentenciaSQL2 = """
                               INSERT INTO transferencia(id_transaccion_tra, num_cuenta_destino)
                               VALUES(?, ?) ;
                               """ ;


        try (
                Connection conexion = this.conexion.obtenerConexion(); 
                
                PreparedStatement comando = conexion.prepareStatement(
                sentenciaSQL,
                Statement.RETURN_GENERATED_KEYS); 
                
                PreparedStatement comando2 = conexion.prepareStatement(
                        sentenciaSQL2,
                        Statement.RETURN_GENERATED_KEYS); 
                
                ) {

            int folio = generarContrasenia(6) ;
            
            comando.setFloat(1, monto);
            comando.setInt(2, folio);
            comando.setLong(3, numeroCuenta);

            int numRegistros = comando.executeUpdate();
            ResultSet idsGenerados = comando.getGeneratedKeys();
            idsGenerados.next();
            
            comando2.setLong(1, idsGenerados.getLong(1));
            comando2.setLong(2, numeroCuentaDestino);

            int numRegistros2 = comando2.executeUpdate();
            ResultSet idsGenerados2 = comando.getGeneratedKeys();
            idsGenerados2.next();


            Transaccion retiro = new Transaccion(idsGenerados.getLong(1),
                                    monto, 
                                    folio, 
                                    java.time.LocalDate.now().toString(),
                                    numeroCuenta,
                                    numeroCuentaDestino,
                                    "Pendiente");
            
            logger.log(Level.INFO, "Se generaron las claves de la transferencia", numRegistros);

                return retiro;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo generar la transferencia", ex);
            throw new PersistenciaException("No se pudo generar la transferencia", ex);
        }
    }
    
    @Override
    public Transaccion aplicarRetiroSinCuenta(int folio, int contrasenia) throws PersistenciaException {
        List<Transaccion> listaTransacciones = obtenerListaTransaccion();
        boolean encontrado = false;
        Transaccion retiro = null ;

        for (int i = 0; i < listaTransacciones.size(); i++) {
            int folioBuscar = listaTransacciones.get(i).getFolio();
            int contraseniaBuscar = listaTransacciones.get(i).getContrasenia();
            
            if (folio == folioBuscar && contrasenia == contraseniaBuscar) {
                    retiro = listaTransacciones.get(i) ;
                    encontrado = true ;
                }
            }
                
                if(encontrado == true) {
                String sentenciaSQL = """
                          UPDATE transaccion SET estado = 'Cobrado' 
                                      WHERE folio = ? ;
                          """;

                try (
                        Connection conexion = this.conexion.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL);
                        ) {
                    
                    comando.setInt(1, folio);
                    
                    int numRegistros = comando.executeUpdate();
                    logger.log(Level.INFO, "Se actualizó el estado de la Transaccion", numRegistros);
                    
                    return retiro;
                } catch (SQLException ex) {
                    logger.log(Level.SEVERE, "No se pudieron actualizar los datos del socio", ex);
                    throw new PersistenciaException("No se pudieron actualizar los datos del socio", ex);
                }
                } else {
                    throw new PersistenciaException("Folio o Contrasenia incorrectos");
                }
        }
        
    @Override
    public Transaccion aplicarTransferencia(int folio) throws PersistenciaException {
        List<Transaccion> listaTransacciones = obtenerListaTransaccion();
        boolean encontrado = false;
        Transaccion retiro = null ;

        for (int i = 0; i < listaTransacciones.size(); i++) {
            int folioBuscar = listaTransacciones.get(i).getFolio();
            
            if (folio == folioBuscar) {
                    retiro = listaTransacciones.get(i) ;
                    encontrado = true ;
                }
            }
                
                if(encontrado == true) {
                String sentenciaSQL = """
                          UPDATE transaccion SET estado = 'Cobrado' 
                                      WHERE folio = ? ;
                          """;

                try (
                        Connection conexion = this.conexion.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL);
                        ) {
                    
                    comando.setInt(1, folio);
                    
                    int numRegistros = comando.executeUpdate();
                    logger.log(Level.INFO, "Se actualizó el estado de la Transaccion", numRegistros);
                    
                    return retiro;
                } catch (SQLException ex) {
                    logger.log(Level.SEVERE, "No se pudieron actualizar los datos del socio", ex);
                    throw new PersistenciaException("No se pudieron actualizar los datos del socio", ex);
                }
                } else {
                    throw new PersistenciaException("Folio incorrecto");
                }
    }
    
    @Override
    public List<Cliente> obtenerListaClientes() throws PersistenciaException {
        String sentenciaSQL = """
                            SELECT
                                cl.id AS id_cliente,
                                nc.nombres,
                                nc.apellido_paterno,
                                nc.apellido_materno,
                                d.calle,
                                d.codigo_postal,
                                d.numero_exterior,
                                cl.fecha_nacimiento,
                                cl.edad,
                                cl.contrasenia
                            FROM cliente cl
                            JOIN nombre_completo nc ON cl.id_nombre = nc.id
                            JOIN domicilio d ON cl.id_domicilio = d.id;
                            """;

        List<Cliente> listaClientes = new LinkedList<>();

        try (
                Connection conexion = this.conexion.obtenerConexion(); 
                PreparedStatement comando = conexion.prepareStatement(sentenciaSQL); 
                ResultSet resultados = comando.executeQuery()
                ) {

            while (resultados.next()) {
                Long id = resultados.getLong("id_cliente");
                String nombres = resultados.getString("nombres");
                String apellidoPaterno = resultados.getString("apellido_paterno");
                String apellidoMaterno = resultados.getString("apellido_materno");
                String calle = resultados.getString("calle");
                int cp = resultados.getInt("codigo_postal");
                int numExt = resultados.getInt("numero_exterior");
                String fechaNacimiento = resultados.getDate("fecha_nacimiento").toLocalDate().toString();
                int edad = resultados.getInt("edad");
                String contrasenia = resultados.getString("contrasenia");
                Cliente cliente = new Cliente(id, nombres, apellidoPaterno, apellidoMaterno, fechaNacimiento, edad, calle, numExt, cp, contrasenia) ;
                System.out.println(cliente.getNombres());
                listaClientes.add(cliente);
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener la lista de clientes", e);
        }

        
        return listaClientes;
    }

    @Override
    public List<Cuenta> obtenerListaCuentas() throws PersistenciaException {
        String sentenciaSQL = """
                            SELECT * FROM cuenta ;
                            """;

        List<Cuenta> listaCuentas = new LinkedList<>();

        try (
                Connection conexion = this.conexion.obtenerConexion(); 
                PreparedStatement comando = conexion.prepareStatement(sentenciaSQL); 
                ResultSet resultados = comando.executeQuery()
                ) {

            while (resultados.next()) {
                Long numeroCuenta = resultados.getLong("numero_cuenta") ;
                String fechaApertura = resultados.getString("fecha_apertura") ;
                Float saldo = resultados.getFloat("saldo") ;
                long idCliente = resultados.getInt("id_cliente") ;
                
                Cuenta cuenta = new Cuenta(numeroCuenta, fechaApertura, saldo, idCliente) ;
                listaCuentas.add(cuenta);
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener la lista de clientes", e);
        }

        
        return listaCuentas;
    }

    @Override
    public List<Transaccion> obtenerListaTransaccion() throws PersistenciaException{
        //Retiro sin cuenta
        String sentenciaSQL = """
                            SELECT 
                                t.id,
                                t.monto,
                                t.folio,
                                t.fecha,
                                t.num_cuenta_cliente,
                                rsc.contrasenia,
                                t.estado
                            FROM 
                                transaccion t
                            JOIN 
                                retiro_sin_cuenta rsc ON t.id = rsc.id_transaccion_ret;
                            """;

        //Transferencia
        String sentenciaSQL2 = """
                            SELECT 
                                t.id,
                                t.monto,
                                t.folio,
                                t.fecha,
                                t.num_cuenta_cliente,
                                tr.num_cuenta_destino,
                                t.estado
                            FROM 
                                transaccion t
                            JOIN 
                                transferencia tr ON t.id = tr.id_transaccion_tra;
                            """;

        List<Transaccion> listaTransacciones = new LinkedList<>();

        try (
                Connection conexion = this.conexion.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL); ResultSet resultados = comando.executeQuery();) {
            //Retiro sin cuenta
            while (resultados.next()) {
                Long id = resultados.getLong("id");
                float monto = resultados.getFloat("monto");
                int folio = resultados.getInt("folio");
                //Detalle con trigger o algo mencionado por oliver que registraba la fecha inicio transaccion automaticamente??
                String fecha = resultados.getString("fecha");
                Long numCuentaCliente = resultados.getLong("num_cuenta_cliente");
                int contrasenia = resultados.getInt("contrasenia");
                String estado = resultados.getString("estado") ;

                Transaccion transaccion = new Transaccion(id, monto, folio, fecha, numCuentaCliente, contrasenia, estado);
                listaTransacciones.add(transaccion);

            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener la lista de retiros sin cuenta", e);
        }

        try (
                Connection conexion = this.conexion.obtenerConexion(); PreparedStatement comando2 = conexion.prepareStatement(sentenciaSQL2); ResultSet resultados2 = comando2.executeQuery();) {
            //Transferencia
            while (resultados2.next()) {
                Long id = resultados2.getLong("id");
                float monto = resultados2.getFloat("monto");
                int folio = resultados2.getInt("folio");
                String fecha = resultados2.getString("fecha");
                Long numCuentaCliente = resultados2.getLong("num_cuenta_cliente");
                Long numCuentaDestino = resultados2.getLong("num_cuenta_destino");
                String estado = resultados2.getString("estado") ;

                Transaccion transaccion = new Transaccion(id, monto, folio, fecha, numCuentaCliente, numCuentaDestino, estado);
                listaTransacciones.add(transaccion);

            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener la lista de transferencias", e);
        }

        return listaTransacciones;
    }

    private int generarContrasenia(int longitud) {
        // Caracteres válidos para la contraseña
        String caracteres = "0123456789";
        
        // Creamos un objeto Random para generar números aleatorios
        Random random = new Random();
        
        // Creamos un StringBuilder para construir la contraseña
        StringBuilder contrasenia = new StringBuilder();
        
        // Generamos la contraseña caracter por caracter
        for (int i = 0; i < longitud; i++) {
            // Obtenemos un índice aleatorio dentro del rango de caracteres
            int indice = random.nextInt(caracteres.length());
            
            // Agregamos el caracter correspondiente al índice aleatorio a la contraseña
            contrasenia.append(caracteres.charAt(indice));
        }
        
        // Devolvemos la contraseña generada
        return Integer.parseInt(contrasenia.toString());
    }

    @Override
    public List<Transaccion> obtenerListaRetiroSinCuenta() throws PersistenciaException {
        String sentenciaSQL = """
                            SELECT 
                                t.id,
                                t.monto,
                                t.folio,
                                t.fecha,
                                t.num_cuenta_cliente,
                                rsc.contrasenia,
                                t.estado
                            FROM 
                                transaccion t
                            JOIN 
                                retiro_sin_cuenta rsc ON t.id = rsc.id_transaccion_ret;
                            """;
        
        List<Transaccion> listaRetiroSinCuenta = new LinkedList<>();

        try (
                Connection conexion = this.conexion.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL); ResultSet resultados = comando.executeQuery();) {
            //Retiro sin cuenta
            while (resultados.next()) {
                Long id = resultados.getLong("id");
                float monto = resultados.getFloat("monto");
                int folio = resultados.getInt("folio");
                //Detalle con trigger o algo mencionado por oliver que registraba la fecha inicio transaccion automaticamente??
                String fecha = resultados.getString("fecha");
                Long numCuentaCliente = resultados.getLong("num_cuenta_cliente");
                int contrasenia = resultados.getInt("contrasenia");
                String estado = resultados.getString("estado") ;
                
                Transaccion transaccion = new Transaccion(id, monto, folio, fecha, numCuentaCliente, contrasenia, estado);
                listaRetiroSinCuenta.add(transaccion);

            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener la lista de retiros sin cuenta", e);
        }
        
        return listaRetiroSinCuenta;
    }

    @Override
    public List<Transaccion> obtenerListaTransefencias() throws PersistenciaException {
        String sentenciaSQL = """
                            SELECT 
                                t.id,
                                t.monto,
                                t.folio,
                                t.fecha,
                                t.num_cuenta_cliente,
                                tr.num_cuenta_destino,
                                t.estado
                            FROM 
                                transaccion t
                            JOIN 
                                transferencia tr ON t.id = tr.id_transaccion_tra;
                            """;

        List<Transaccion> listaTransferencias = new LinkedList<>();
        
        try (
                Connection conexion = this.conexion.obtenerConexion(); PreparedStatement comando2 = conexion.prepareStatement(sentenciaSQL); ResultSet resultados = comando2.executeQuery();) {
            //Transferencia
            while (resultados.next()) {
                Long id = resultados.getLong("id");
                float monto = resultados.getFloat("monto");
                int folio = resultados.getInt("folio");
                String fecha = resultados.getString("fecha");
                Long numCuentaCliente = resultados.getLong("num_cuenta_cliente");
                Long numCuentaDestino = resultados.getLong("num_cuenta_destino");
                String estado = resultados.getString("estado") ;
                
                Transaccion transaccion = new Transaccion(id, monto, folio, fecha, numCuentaCliente, numCuentaDestino, estado);
                listaTransferencias.add(transaccion);

            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener la lista de transferencias", e);
        }

        return listaTransferencias;
    }

    @Override
    public List<Transaccion> obtenerHistorialOperaciones(long numeroCuenta, String fechaInicio, String fechaFin) {
        System.out.println("");
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
