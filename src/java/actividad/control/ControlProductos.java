/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad.control;

import java.sql.Connection;
import java.sql.SQLException;
import actividad.modelo.dao.ProductoDAO;
import actividad.modelo.vo.Productos;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Natalia
 */
public class ControlProductos {
    Connection cnn;
    ProductoDAO dao;
    
        public ControlProductos(Connection cnn){
        this.cnn = cnn;
        this.dao = new ProductoDAO(cnn);
    }
        public boolean insertar(Productos vo){
        if(vo.getNombre()== null || vo.getNombre().isEmpty()
                || vo.getMarca()== null || vo.getMarca().isEmpty()
                || vo.getPrecio()== 0
                || vo.getUnidades()== 0
                || vo.getFecharegistro()== null 
                || vo.getDescripcion()== null || vo.getDescripcion().isEmpty()                                                                                                                              
                )
        
        {
            return false;
        }else{
            try {
                dao.insertar(vo);
                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        }
        
    }
}
