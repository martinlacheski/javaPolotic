package Servlets.Huesped;

import Logica.HuespedControladora;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvHuespedEdit", urlPatterns = {"/SvHuespedEdit"})
public class SvHuespedEdit extends HttpServlet {

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
        
        //Traigo los datos del huespedEdit.jsp
        String dni = request.getParameter("dni");
        String nombres = request.getParameter("nombres");
        String apellido = request.getParameter("apellido");
        LocalDate fechaNacimiento = LocalDate.parse(request.getParameter("fechaNacimiento"));
        String direccion = request.getParameter("direccion");
        String profesion = request.getParameter("profesion");
        
        //LLamamos a la controladora de la Logica
        HuespedControladora controlHuesped = new HuespedControladora();
        controlHuesped.actualizarHuesped(id, dni, nombres, apellido, fechaNacimiento, direccion, profesion);
        
        //Armamos la redireccion
        response.sendRedirect("SvHuespedList");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
