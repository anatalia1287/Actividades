/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import actividad.modelo.vo.Proveedor;

/**
 *
 * @author Natalia
 */
public class ProveedorDAO {
    Connection cnn;

    public ProveedorDAO(Connection cnn) {
        this.cnn = cnn;
    }

    public void insertar(Proveedor vo) throws SQLException {
        PreparedStatement sentencia = cnn.prepareStatement("INSERT INTO proveedor(nombre, apellido, celular, correo, direccion, empresa, fechanacimiento)  "
                + "VALUES(?,?,?,?,?,?,?)");
        sentencia.setString(1, vo.getNombre());
        sentencia.setString(2, vo.getApellido());
        sentencia.setString(3, vo.getCelular());
        sentencia.setString(4, vo.getCorreo());
        sentencia.setString(5, vo.getDireccion());
        sentencia.setString(6, vo.getEmpresa());
        sentencia.setDate(7, new java.sql.Date(vo.getFechanacimiento().getTime()));
        sentencia.executeUpdate();
    }
    
}
