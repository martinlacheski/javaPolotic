package Servlets.Empleado;

import Logica.EmpleadoControladora;
import java.io.IOException;

import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvEmpleadoDelete", urlPatterns = {"/SvEmpleadoDelete"})
public class SvEmpleadoDelete extends HttpServlet {

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
        int id = Integer.parseInt(request.getParameter("id"));

        //Traigo los datos del empleadoDelete.jsp
        String dni = request.getParameter("dni");
        String nombres = request.getParameter("nombres");
        String apellido = request.getParameter("apellido");
        LocalDate fechaNacimiento = LocalDate.parse(request.getParameter("fechaNacimiento"));
        String direccion = request.getParameter("direccion");
        String cargo = request.getParameter("cargo");

        //LLamamos a la controladora de la Logica
        EmpleadoControladora controlEmpleado = new EmpleadoControladora();

        controlEmpleado.eliminarEmpleado(id, dni, nombres, apellido, fechaNacimiento, direccion, cargo);

        //Armamos la redireccion
        response.sendRedirect("SvEmpleadoList");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
