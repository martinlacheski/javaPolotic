package Servlets.login;

import Logica.UsuarioControladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {

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

        boolean usuarioValido = false;

        //LLamamos a la controladora de la Logica
        UsuarioControladora control = new UsuarioControladora();

        //Comprobamos que el usuario sea un usuario registrado
        usuarioValido = control.comprobarIngreso(request.getParameter("username"), request.getParameter("password"));
        System.out.println("Usuario valido: " + usuarioValido);
        if (usuarioValido == true) {
                   
            String usuario = request.getParameter("username");
            //String password = request.getParameter("password");
            HttpSession miSession = request.getSession(true);
            
            miSession.setAttribute("username", usuario);
            miSession.setAttribute("control", control);

            response.sendRedirect("home.jsp");

        } else {
            HttpSession miSession = request.getSession(false);
            response.sendRedirect("loginError.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
