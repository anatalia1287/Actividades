/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import actividad.modelo.vo.Empleados;

/**
 *
 * @author Usuario
 */
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    Connection cnn;

    public EmpleadoDAO(Connection cnn) {
        this.cnn = cnn;
    }

    public boolean validarUsuario(Empleados vo) throws SQLException {
        PreparedStatement sentencia = cnn.prepareStatement("SELECT * FROM empleado WHERE usuario = ?");
        sentencia.setString(1, vo.getUsuario());
        ResultSet resultado = sentencia.executeQuery();
        if (resultado.next()) {
            Empleados voTemp = new Empleados();
            voTemp.setUsuario(resultado.getString("usuario"));
            voTemp.setContraseña(resultado.getString("contraseña"));
            return voTemp.getUsuario().equals(vo.getUsuario()) && voTemp.getContraseña().equals(vo.getContraseña());
        }
        return false;
    }

    public void insertar(Empleados vo) throws SQLException {
        PreparedStatement sentencia = cnn.prepareStatement("INSERT INTO empleado (nombre, apellido, celular, correo, direccion, cargo, fecharegistro, usuario, contraseña) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

        sentencia.setString(1, vo.getNombre());
        sentencia.setString(2, vo.getApellido());
        sentencia.setString(3, vo.getCelular());
        sentencia.setString(4, vo.getCorreo());
        sentencia.setString(5, vo.getDireccion());
        sentencia.setString(6, vo.getCargo());
        sentencia.setDate(7, new java.sql.Date(vo.getFecharegistro().getTime()));
        sentencia.setString(8, vo.getUsuario());
        sentencia.setString(9, vo.getContraseña());
        sentencia.executeUpdate();
    }

    public void modificar(Empleados vo) throws SQLException {
        PreparedStatement sentencia
                = cnn.prepareStatement(
                        "UPDATE empleado SET nombre= ?,apellido= ?,celular= ?,correo= ?,direccion= ?, cargo= ?,fecharegistro= ?,usuario= ?, contraseña= ? "
                        + "WHERE idempleado = ?");
        sentencia.setString(1, vo.getNombre());
        sentencia.setString(2, vo.getApellido());
        sentencia.setString(3, vo.getCelular());
        sentencia.setString(4, vo.getCorreo());
        sentencia.setString(5, vo.getDireccion());
        sentencia.setString(6, vo.getCargo());
        sentencia.setDate(7, new java.sql.Date(vo.getFecharegistro().getTime()));
        sentencia.setString(8, vo.getUsuario());
        sentencia.setString(9, vo.getContraseña());
        sentencia.setInt(10, vo.getIdempleado());
        sentencia.executeUpdate();

    }

    public void eliminar(Empleados vo) throws SQLException {
        PreparedStatement sentencia
                = cnn.prepareStatement("DELETE empleado" + "WHERE nombre = ?");
        sentencia.setString(1, vo.getNombre());
        sentencia.executeUpdate();
    }

    public List<Empleados> consultar() throws SQLException {
        List<Empleados> listaEmpleados = new ArrayList<>();

        PreparedStatement sentencia = cnn.prepareStatement("SELECT * FROM empleado");
        ResultSet resultado = sentencia.executeQuery();
        while (resultado.next()) {
            Empleados voTemp = new Empleados();
            voTemp.setIdempleado(resultado.getInt("idempleado"));
            voTemp.setNombre(resultado.getString("nombre"));
            voTemp.setApellido(resultado.getString("apellido"));
            voTemp.setCelular(resultado.getString("celular"));
            voTemp.setCorreo(resultado.getString("correo"));
            voTemp.setDireccion(resultado.getString("direccion"));
            voTemp.setCargo(resultado.getString("cargo"));
            voTemp.setFecharegistro(resultado.getDate("fecharegistro"));
            voTemp.setUsuario(resultado.getString("usuario"));
            voTemp.setContraseña(resultado.getString("contraseña"));
            listaEmpleados.add(voTemp);
        }
        if (listaEmpleados.size() > 0) {
            return listaEmpleados;
        } else {
            return null;
        }

    }

}
