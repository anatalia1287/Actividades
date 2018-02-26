/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad.Vista;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import actividad.modelo.conexion.Conexion;
import actividad.modelo.dao.EmpleadoDAO;
import  actividad.modelo.vo.Empleados;
import actividad.control.ControlEmpleado;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "EmpleadosServlet", urlPatterns = {"/EmpleadosServlet"})
public class EmpleadosServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         Connection cnn =  null;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EmpleadosServlet</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/Estilos.css\"> ");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> EMPLEADOS </h1>");
            out.println("<form form method=\"POST\">"); // 
            out.println("<table id= tabla border = \"0\"> ");
            out.println("<div id= \"registroEmpleados\">");
            out.println("<div>");
            out.println("<tr>");
            out.println("<td><label for=\"idEmpleados\">Id Empleados :</label></td>");
            out.println("<td><input type= \"text\" id=\"\" name=\"idEmpleados\"></td>");
            out.println("</tr>");
            out.println("</div>");
            out.println("<div>");
            out.println("<tr>");
            out.println("<td><label for= \"nombre\">Nombre :</label></td>");
            out.println("<td><input type= \"text\" id=\"\" name=\"nombre\"></td>");
            out.println("</tr>");
            out.println("</div>");
            out.println("<div>");
            out.println("<tr>");
            out.println("<td><label for= \"apellido\">Apellido :</label></td>");
            out.println("<td><input type= \"text\" id=\"\" name=\"apellido\"></td>");
            out.println("</tr>");
            out.println("</div>");
            out.println("<div>");
            out.println("<tr>");
            out.println("<td><label for= \"celular\">Celular :</label></td>");
            out.println(" <td><input type= \"text\" id=\"\" name=\"celular\"></td>");
            out.println("</tr>");
            out.println("</div>");
            out.println("<div>");
            out.println("<tr>");
            out.println("<td><label for= \"correo\">Correo :</label></td>");
            out.println(" <td><input type= \"text\" id=\"\" name=\"correo\"></td>");
            out.println("</tr>");
            out.println("</div>");
            out.println("<div>");
            out.println("<div>");
            out.println("<tr>");
            out.println("<td><label for= \"direccion\">Direccion :</label></td>");
            out.println("<td><input type= \"text\" id=\"\" name=\"direccion\"></td>");
            out.println("</tr>");
            out.println("</div>");
            out.println("<div>");
            out.println("<tr>");
            out.println("<td><label for= \"cargo\">Cargo :</label></td>");
            out.println("<td><input type= \"text\" id=\"\" name=\"cargo\"></td>");
            out.println("</tr>");
            out.println("</div>");
            out.println("<div>");
            out.println("<tr>");
            out.println("<td><label for= \"fechaRegistro\">Fecha de Registro :</label></td>");
            out.println("<td><input type= \"Date\" id=\"fechaRegistro\" name=\"fechaRegistro\"></td>");
            out.println("</tr>");
            out.println("</div>");
            out.println("<div>");
            out.println("<tr>");
            out.println("<td><label for= \"usuario\">Usuario :</label></td>");
            out.println("<td><input type= \"text\" id=\"\" name=\"usuario\"></td>");
            out.println("</tr>");
            out.println("</div>");
            out.println("<div>");
            out.println("<tr>");
            out.println(" <td><label for= \"clave\">Clave :</label></td>");
            out.println("<td><input type= \"password\" id=\"\" name=\"clave\"></td>");
            out.println("</tr>");
            out.println("</div>");
            out.println("<div>");
            out.println("<tr>");
            out.println("<td><input class=\"botones\" type= \"reset\" id= \"btnCancelar\" value=\"Cancelar\"></td>");
            out.println("<td><input class=\"botones\" type= \"submit\" id=\"btnGuardar\" value=\"Guardar\"></td>");
            out.println("<td><input class=\"botones\" type= \"submit\" id=\"btnCancelar\" value=\"Cancelar\"></td>");
            out.println("</tr>");
            out.println("</div>");
            // out.println("<h1>Servlet EmpleadosServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");

        try {
            cnn = Conexion.getConexionDB();
            Empleados vo = new Empleados();
            vo.setNombre(request.getParameter("nombre"));
            vo.setApellido(request.getParameter("apellido"));
            vo.setCelular(request.getParameter("celular"));
            vo.setCorreo(request.getParameter("correo"));
            vo.setDireccion(request.getParameter("direccion"));
            vo.setCargo(request.getParameter("cargo"));
            SimpleDateFormat formato  = new SimpleDateFormat("yyyy-MM-dd");
            vo.setFecharegistro(formato.parse(request.getParameter("fechaRegistro")));
            vo.setUsuario(request.getParameter("usuario"));
            vo.setContraseña(request.getParameter("clave"));
            
            ControlEmpleado control = new ControlEmpleado(cnn);
            boolean resultado = control.insertar(vo);
               if (resultado = true){
                   out.println("<script type=\"text/javascript\">");
                   out.println("alert('Los datos han sido insertado correctamente');");
                   out.println("</script>");   
               }else {
                   out.println("<script type=\"text/javascript\">");
                   out.println("alert('No se puedieron insertar los datos');");
                   out.println("</script>"); 
               }
            

        } catch (Exception e) {
        }
    }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
