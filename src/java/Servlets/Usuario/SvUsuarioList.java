package Servlets.Usuario;

import Logica.Usuario;
import Logica.UsuarioControladora;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvUsuarioList", urlPatterns = {"/SvUsuarioList"})
public class SvUsuarioList extends HttpServlet {
    
    UsuarioControladora control = new UsuarioControladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //LLamamos a la controladora de la Logica
        UsuarioControladora control = new UsuarioControladora();
        //Creamos un List para recorrer desde la vista
        List<Usuario> usuarios = control.listarUsuarios();
        //seteamos a un atributo dicha lista
        request.setAttribute("users", usuarios);
        //enviamos a la vista con el Dispatcher
        request.getRequestDispatcher("usuarioList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        int id = Integer.parseInt(request.getParameter("id"));

        switch (accion) {
            
            case "Editar":
                
                //LLamamos a la controladora de la Logica
                Usuario usuario = control.usuarioId(id);
                request.setAttribute("idUser", id);
                request.setAttribute("user", usuario);
                request.setAttribute("username", usuario.getUsuario());
                request.setAttribute("pass", usuario.getPassword());
                request.setAttribute("jefe", usuario.getIsJefe());
                //Armamos la redireccion
                request.getRequestDispatcher("usuarioEdit.jsp").forward(request, response);
            
            case "Eliminar":
                
                //LLamamos a la controladora de la Logica
                Usuario usuarioDel = control.usuarioId(id);
                request.setAttribute("idUser", id);
                request.setAttribute("user", usuarioDel);
                request.setAttribute("username", usuarioDel.getUsuario());
                request.setAttribute("pass", usuarioDel.getPassword());
                request.setAttribute("jefe", usuarioDel.getIsJefe());
                request.getRequestDispatcher("usuarioDelete.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
