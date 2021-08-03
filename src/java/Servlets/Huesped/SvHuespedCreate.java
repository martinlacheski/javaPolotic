package Servlets.Huesped;

import Logica.HuespedControladora;
import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvHuespedCreate", urlPatterns = {"/SvHuespedCreate"})
public class SvHuespedCreate extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.sendRedirect("huespedCreate.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Traigo los datos del empleadoCreate.jsp
        String dni = request.getParameter("dni");
        String nombres = request.getParameter("nombres");
        String apellido = request.getParameter("apellido");
        //String fechaNacimiento = request.getParameter("fechaNacimiento");
        LocalDate fechaNacimiento = LocalDate.parse(request.getParameter("fechaNacimiento"));
        
        String direccion = request.getParameter("direccion");
        String profesion = request.getParameter("profesion");

        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //LocalDate date = LocalDate.parse(fechaNacimiento, formatter);

        //LLamamos a la controladora de la Logica
        HuespedControladora controlHuesped = new HuespedControladora();

        controlHuesped.crearHuesped(dni, nombres, apellido, fechaNacimiento, direccion, profesion);

        //Armamos la redireccion
        response.sendRedirect("SvHuespedList");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
