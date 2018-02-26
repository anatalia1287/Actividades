/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad.modelo.dao;
import actividad.modelo.vo.Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    
    
       Connection cnn;

    public ProductoDAO(Connection cnn) {
        this.cnn = cnn;
    }
    
    
    public void insertar(Productos vo) throws SQLException {
        PreparedStatement sentencia = cnn.prepareStatement("INSERT INTO productos(nombre, marca, precio, unidades, fecharegistro, descripcion) "
                + "VALUES(?,?,?,?,?,?)");
        sentencia.setString(1, vo.getNombre());
         sentencia.setString(2, vo.getMarca());
        sentencia.setDouble(3, vo.getPrecio());
        sentencia.setInt(4, vo.getUnidades());
        sentencia.setDate(5, new java.sql.Date(vo.getFecharegistro().getTime()));
        sentencia.setString(6, vo.getDescripcion());
        sentencia.executeUpdate();
    }
    
}
