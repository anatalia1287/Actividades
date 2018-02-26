/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad.modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection getConexionDB() throws ClassNotFoundException, SQLException{
        String servidor = "localhost";
        String nombreDB = "inventario1";
        String usuario = "natalia1";
        String clave = "1234";
        String puerto = "3306";
        
        Class.forName("com.mysql.jdbc.Driver"); 
        
        Connection cnn = DriverManager.getConnection("jdbc:mysql://"+servidor+":"+puerto+"/"+nombreDB, usuario, clave);
        cnn.setAutoCommit(false);
        return cnn;
        
    }
    public static void cerrarConexion(Connection cnn) throws SQLException{
        cnn.commit();
        cnn.close();
    }
    
    public static void cancelarTran(Connection cnn) throws SQLException{
        cnn.rollback();
        cnn.close();
    }
}

