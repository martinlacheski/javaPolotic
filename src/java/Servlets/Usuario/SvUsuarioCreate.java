 package Servlets.Usuario;

import Logica.UsuarioControladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvUsuarioCreate", urlPatterns = {"/SvUsuarioCreate"})
public class SvUsuarioCreate extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Traigo los datos del usuarioCreate.jsp
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //Convertimos a tipo Boolean el value del CHECKBOX
        boolean isJefe = Boolean.parseBoolean(request.getParameter("isJefe"));
        
        //LLamamos a la controladora de la Logica
        UsuarioControladora  control = new UsuarioControladora();
        control.crearUsuario(username, password, isJefe);
        
        //Armamos la redireccion
        response.sendRedirect("SvUsuarioList");
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
