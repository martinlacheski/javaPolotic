package Servlets.Empleado;

import Logica.EmpleadoControladora;
import Logica.Usuario;
import Logica.UsuarioControladora;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvEmpleadoEdit", urlPatterns = {"/SvEmpleadoEdit"})
public class SvEmpleadoEdit extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        //LLamamos a la controladora de la Logica
        UsuarioControladora control = new UsuarioControladora();
        //Creamos un List para recorrer desde la vista
        List<Usuario> usuarios = control.listarUsuarios();
        //seteamos a un atributo dicha lista
        request.setAttribute("users", usuarios);
        //enviamos a la vista con el Dispatcher
        request.getRequestDispatcher("empleadoEdit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));      

        //Traigo los datos del empleadoEdit.jsp
        String dni = request.getParameter("dni");
        String nombres = request.getParameter("nombres");
        String apellido = request.getParameter("apellido");
        LocalDate fechaNacimiento = LocalDate.parse(request.getParameter("fechaNacimiento"));
        
        String direccion = request.getParameter("direccion");
        String cargo = request.getParameter("cargo");
        int usuario = 0;
        try {
            usuario = Integer.parseInt(request.getParameter("usuario"));
        } catch (Exception ex) {
            
        }
       
        //LLamamos a la controladora de la Logica
        EmpleadoControladora controlEmpleado = new EmpleadoControladora();
        if (usuario != 0) {
            controlEmpleado.actualizarEmpleado(id, dni, nombres, apellido, fechaNacimiento, direccion, cargo, usuario);
        } else {
            controlEmpleado.actualizarEmpleadoSinUser(id, dni, nombres, apellido, fechaNacimiento, direccion, cargo);
        }

        //Armamos la redireccion
        response.sendRedirect("SvEmpleadoList");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
