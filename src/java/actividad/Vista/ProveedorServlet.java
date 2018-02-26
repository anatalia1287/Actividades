/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad.Vista;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "ProveedorServlet", urlPatterns = {"/ProveedorServlet"})
public class ProveedorServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProveedorServlet</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css.Estilos.css\"> ");              
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet ProveedorServlet at " + request.getContextPath() + "</h1>");
            
            out.println("<h1> PROVEEDOR </h1>");
            out.println("<form form method=\"POST\">");
            out.println("<table id= tabla border = \"0\"> ");
            out.println("<div id= \"registroProveedor\">");
            
            out.println("<div>");
            out.println("<tr>");
            out.println("<td><label for=\"idProveedor\">Id Proveedor :</label></td>");
            out.println("<td><input type= \"text\" id=\"\" name=\"idProveedor\"></td>");
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
            out.println("<td><input type= \"text\" id=\"\" name=\"celular\"></td>");
            out.println("</tr>");
            out.println("</div>");
          
             out.println("<div>");
            out.println("<tr>");
            out.println("<td><label for= \"correo\">Correo :</label></td>");
            out.println("<td><input type= \"text\" id=\"\" name=\"correo\"></td>");
            out.println("</tr>");
            out.println("</div>");
             
            out.println("<div>");
            out.println("<tr>");
            out.println("<td><label for= \"direccion\">Direccion :</label></td>");
            out.println("<td><input type= \"text\" id=\"\" name=\"direccion\"></td>");
            out.println("</tr>");
            out.println("</div>");
            
             out.println("<div>");
            out.println("<tr>");
            out.println("<td><label for= \"empresa\">Empresa :</label></td>");
            out.println("<td><input type= \"text\" id=\"\" name=\"empresa\"></td>");
            out.println("</tr>");
            out.println("</div>");
            
             out.println("<div>");
            out.println("<tr>");
            out.println("<td><label for= \"fechaNacimiento\">Fecha de Nacimiento:</label></td>");
            out.println("<td><input type= \"date\" id=\"date\" name=\"date\"></td>");
            out.println("</tr>");
            out.println("</div>");
            
             out.println("<div>");
            out.println("<tr>");
            out.println("<td><input class=\"botones\" type= \"reset\" id= \"btnCancelar\" value=\"Cancelar\"></td>");
            out.println("<td><input class=\"botones\" type= \"submit\" id=\"btnGuardar\" value=\"Guardar\"></td>");
            out.println("</tr>");
            out.println("</div>");
            
            out.println("</table>");
            out.println("</form>");
            out.println("</div>");

            out.println("</body>");
            out.println("</html>");
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
