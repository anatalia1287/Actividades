package actividad.Vista;

import java.io.IOException; 
import java.io.PrintWriter;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest; //peticion 
import javax.servlet.http.HttpServletResponse; //respuesta
@WebServlet(name = "ActividadServlet", urlPatterns = {"/ActividadServlet" }) // registra el servlet  

public class ActividadServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8"); // se decuelve html, o culquier otro archivo
        try (PrintWriter out = response.getWriter()) {  //
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ActividadServlet</title>");    
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/Estilos.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<form form method=\"POST\">"); 
            out.println("<h1> MENU </h1>");
	    out.println("<table id= tabla border = \"0\">");
            out.println("<div id=\"contenidoLogin\">");
            out.println("<div>"); 
            out.println("<tr>");
            out.println("<td><input class=\"botones\" type=\"submit\" id=\"btnRegistrarEmpleado\" value=\"Empleado\"></td>");
            response.sendRedirect("EmpleadosServlet"); // o con slach  
	    out.println("<td><input class=\"botones\" type=\"submit\" id=\"btnRegistrarProveedor\" value=\"Proveedor\"></td>");
	    response.sendRedirect("ProveedorServlet"); // o con slach  
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td><input class=\"botones\" type=\"submit\" id=\"btnRegistrarProducto\" value=\"producto\"></td>");
            response.sendRedirect("ProductoServlet");
            out.println("<td><input class=\"botones\" type=\"submit\" id=\"btnRegistrarVenta\" value=\"Venta\"></td>");
            out.println("</tr>");
            out.println("</div>");
            out.println("</div>");
            out.println("</table>");
           // out.println("<h1> EMPLEADOS </h1>");
           // out.println("<h1>Servlet ActividadServlet at " + request.getContextPath() + "</h1>");
         
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) //Entran todas la peticiones  
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) //Entran todas la peticiones  
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
