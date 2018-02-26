/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad.control;

import java.sql.Connection;
import java.sql.SQLException;
import actividad.modelo.dao.ProveedorDAO;
import actividad.modelo.vo.Proveedor;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author Natalia
 */
public class ControlProveedores {
    
    Connection cnn;
    ProveedorDAO dao;
    public ControlProveedores(Connection cnn){
        this.cnn = cnn;
        this.dao = new ProveedorDAO(cnn);
    }
    
    public boolean insertar(Proveedor vo){
        if(vo.getNombre()== null || vo.getNombre().isEmpty()
                || vo.getApellido() == null || vo.getApellido().isEmpty()
                || vo.getCelular() == null || vo.getCelular().isEmpty()
                || vo.getCorreo()== null || vo.getCorreo().isEmpty()
              //  || vo.getDireccion()== null || vo.getDireccion().isEmpty()
                || vo.getEmpresa()== null || vo.getEmpresa().isEmpty()
                || vo.getCelular() == null || vo.getCelular().isEmpty()
                || vo.getFechanacimiento()== null //|| vo.getFecharegistro()
                                                                                                                                              
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
