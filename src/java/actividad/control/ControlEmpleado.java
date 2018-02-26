
package actividad.control;

import actividad.modelo.dao.EmpleadoDAO;
import actividad.modelo.vo.Empleados;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author Usuario
 */
public class ControlEmpleado {

  Connection cnn;
    EmpleadoDAO dao;    
    public ControlEmpleado(Connection cnn){
        this.cnn = cnn;
        this.dao = new EmpleadoDAO(cnn);
    }
    
    public boolean insertar(Empleados vo){
        if(vo.getNombre()== null || vo.getNombre().isEmpty()
                || vo.getApellido() == null || vo.getApellido().isEmpty()
                || vo.getCelular() == null || vo.getCelular().isEmpty()
                || vo.getCorreo()== null || vo.getCorreo().isEmpty()
                || vo.getCargo()== null || vo.getCargo().isEmpty()
                || vo.getFecharegistro()== null 
                || vo.getUsuario()== null || vo.getUsuario().isEmpty()
                || vo.getContraseña()== null || vo.getContraseña().isEmpty() 
                )
            return false;
        
        else{
            try {
                dao.insertar(vo);
                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        }
        
    }
    
    public boolean modificar(Empleados vo){
        if(vo.getNombre()== null || vo.getNombre().isEmpty()
                || vo.getApellido() == null || vo.getApellido().isEmpty()
                || vo.getCelular() == null || vo.getCelular().isEmpty()
                || vo.getCorreo()== null || vo.getCorreo().isEmpty()
                || vo.getCargo()== null || vo.getCargo().isEmpty()
                || vo.getFecharegistro()== null 
                || vo.getUsuario()== null || vo.getUsuario().isEmpty()
                || vo.getContraseña()== null || vo.getContraseña().isEmpty()            
                || vo.getIdempleado()== 0){
            return false;
        }else{
           try {
                dao.modificar(vo);
                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        }        
    }
    
    public boolean borrar(Empleados vo){
        //if(vo.getNombre() != 0)
        if(vo.getNombre()== null || vo.getNombre().isEmpty()){
            return false;
        }else{
            try {
                dao.eliminar(vo);
                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        }
    }
    
    public List<Empleados> consultar(){
        try {
            return dao.consultar(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}

//public void LlenarTabla (JTable tblDatosEmpleado){
//    DefaultTableModel modeloTabla = new DefaultTableModel();
//    tblDatosEmpleado.setModel(modeloTabla);
//    
//    modeloTabla.addColumn("idEmpelado");
//    modeloTabla.addColumn("nombre");
//    modeloTabla.addColumn("apellido");
//    modeloTabla.addColumn("celular");
//    modeloTabla.addColumn("correo");
//    modeloTabla.addColumn("direccion");
//    modeloTabla.addColumn("cargo");
//    modeloTabla.addColumn("fechaRegistro");
//    modeloTabla.addColumn("idEmpelado");
//    modeloTabla.addColumn("usuario");
//    modeloTabla.addColumn("contraseña");
//    
//    Object[] columna = new Object[11];
//    
//    int numRegistro = dao.listaEmpleados().Size();


