package Servlets.Reserva;

import Logica.ReservaControladora;
import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvReservaDelete", urlPatterns = {"/SvReservaDelete"})
public class SvReservaDelete extends HttpServlet {

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
        
        
        //Traigo los datos de reservaDelete.jsp
        int huespedGuardar = Integer.parseInt(request.getParameter("huesped"));
        LocalDate checkIN = LocalDate.parse(request.getParameter("checkin"));
        LocalDate checkOUT = LocalDate.parse(request.getParameter("checkout"));
        int cantPersonas = Integer.parseInt(request.getParameter("cantidad"));
        int habitacionGuardar = Integer.parseInt(request.getParameter("habitacion"));
        double importeGuardar = Double.parseDouble(request.getParameter("importe"));
        String usuario = request.getParameter("username");
        //LLamamos a la controladora de la Logica

        //LLamamos a las controladora de la Logica
        ReservaControladora controlReserva = new ReservaControladora();
        controlReserva.eliminarReserva(id, huespedGuardar, checkIN, checkOUT, cantPersonas, habitacionGuardar, importeGuardar, usuario);

        //Armamos la redireccion
        response.sendRedirect("SvReservaList");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
