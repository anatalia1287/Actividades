package actividad.Vista;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import actividad.modelo.dao.EmpleadoDAO;
import actividad.modelo.conexion.Conexion;
import actividad.modelo.vo.Empleados;
import java.sql.SQLException;
/**
 *
 * @author Usuario
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");   
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/Estilos.css\"> ");  
            out.println("</head>");
            
            out.println("<body>");
            out.println("<h1> INICIAR SESIÓN </h1>");
            out.println("<table id= tabla border = \"0\"> ");
            out.println("<form method=\"POST\">");
            
            out.println("<div>");
            out.println("<tr>");
            out.println("<td><label for=\"usuario\">Usuario :</label></td>");
            out.println("<td><input type=\"text\" id=\"usuario\" name=\"usuario\"></td>");
            out.println("</tr>");
            out.println("</div>");
            
            out.println("<div>");
            out.println("<tr>");
            out.println("<td><label for=\"clave\">Clave :</label></td>");
            out.println("<td><input type=\"password\" id=\"clave\" name=\"clave\"></td>");
            out.println("</tr>");
            out.println("</div>");
            
            out.println("<div>");
            out.println("<tr>");
            out.println("<td><input class=\"botones\" type=\"reset\" id=\"btCancelar\" value=\"Cancelar\"></td>");
            out.println("<td><input class=\"botones\" type=\"submit\" id=\"btAceptar\" value=\"Aceptar\"></td>");
            out.println("</tr>");
            out.println("</div>");
            
            out.println("</table>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
            try {
                cnn = Conexion.getConexionDB();
                if (request.getParameter("usuario") != null && request.getParameter("clave") != null) {
                Empleados vo = new Empleados();
                vo.setUsuario(request.getParameter("usuario"));
                vo.setContraseña(request.getParameter("clave"));
                try {
                    boolean validado = validarlogin(cnn, vo);
                    if (validado == true){
                       response.sendRedirect("ActividadServlet");                       
                    }else{
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('Usuario o Contraseña Incorrecta');");
                        out.println("</script>");                        
                    }
                } catch (SQLException ex) {
                }
            }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
       public boolean validarlogin(Connection cnn, Empleados vo) throws SQLException {
        EmpleadoDAO dao = new EmpleadoDAO(cnn);
        boolean validado = dao.validarUsuario(vo);
        return validado;
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
