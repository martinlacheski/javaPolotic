package Servlets.Empleado;

import Logica.Empleado;
import Logica.EmpleadoControladora;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvEmpleadoList", urlPatterns = {"/SvEmpleadoList"})
public class SvEmpleadoList extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        EmpleadoControladora controlEmpleado = new EmpleadoControladora();
        //Creamos un List para recorrer desde la vista
        List<Empleado> empleados = controlEmpleado.listarEmpleados();
        //seteamos a un atributo dicha lista
        request.setAttribute("empleados", empleados);
        //enviamos a la vista con el Dispatcher
        request.getRequestDispatcher("empleadoList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        int idEmpleado = Integer.parseInt(request.getParameter("id"));
        EmpleadoControladora controlEmpleado = new EmpleadoControladora();
        switch (accion) {

            case "Editar":
                //LLamamos a la controladora de la Logica
                Empleado empleado = controlEmpleado.empleadoId(idEmpleado);
                request.setAttribute("id", idEmpleado);
                request.setAttribute("dni", empleado.getDni());
                request.setAttribute("nombre", empleado.getNombre());
                request.setAttribute("apellido", empleado.getApellido());
                request.setAttribute("fechaNacimiento", empleado.getFechaNacimiento().toString());
                request.setAttribute("direccion", empleado.getDireccion());
                request.setAttribute("cargo", empleado.getCargo());
                request.setAttribute("usuario", empleado.getUsuario());
                //Armamos la redireccion
                request.getRequestDispatcher("empleadoEdit.jsp").forward(request, response);

            case "Eliminar":

                //LLamamos a la controladora de la Logica
                Empleado empleadoDel = controlEmpleado.empleadoId(idEmpleado);
                request.setAttribute("id", idEmpleado);
                request.setAttribute("dni", empleadoDel.getDni());
                request.setAttribute("nombre", empleadoDel.getNombre());
                request.setAttribute("apellido", empleadoDel.getApellido());
                request.setAttribute("fechaNacimiento", empleadoDel.getFechaNacimiento().toString());
                request.setAttribute("direccion", empleadoDel.getDireccion());
                request.setAttribute("cargo", empleadoDel.getCargo());
                request.setAttribute("user", empleadoDel.getUsuario());

                //Armamos la redireccion
                request.getRequestDispatcher("empleadoDelete.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
