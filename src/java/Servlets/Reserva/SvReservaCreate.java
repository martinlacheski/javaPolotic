package Servlets.Reserva;

import Logica.Habitacion;
import Logica.HabitacionControladora;
import Logica.Huesped;
import Logica.HuespedControladora;
import Logica.Reserva;
import Logica.ReservaControladora;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvReservaCreate", urlPatterns = {"/SvReservaCreate"})
public class SvReservaCreate extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //LLamamos a las controladoras de la Logica
        HuespedControladora controlHuesped = new HuespedControladora();
        HabitacionControladora controlHabitacion = new HabitacionControladora();
        ReservaControladora controlReserva = new ReservaControladora();

        //Creamos un List para recorrer los huespedes
        List<Huesped> huespedes = controlHuesped.listarHuespedes();
        //seteamos a un atributo dicha lista
        request.setAttribute("huespedes", huespedes);

        //Creamos un List para recorrer las habitaciones
        List<Habitacion> habitaciones = controlHabitacion.listarHabitaciones();
        //seteamos a un atributo dicha lista
        request.setAttribute("habitaciones", habitaciones);

        //Creamos un List para recorrer las reservas
        List<Reserva> reservas = controlReserva.listarReservas();
        //seteamos a un atributo dicha lista
        request.setAttribute("reservas", reservas);
        request.setAttribute("verificado", false);
        //enviamos a la vista con el Dispatcher
        request.getRequestDispatcher("reservaCreate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //LLamamos a las controladora de la Logica
        ReservaControladora controlReserva = new ReservaControladora();
        //Traigo los datos de reservaCreate.jsp
        int huespedGuardar = Integer.parseInt(request.getParameter("huesped"));
        LocalDate checkIN = LocalDate.parse(request.getParameter("checkin"));
        LocalDate checkOUT = LocalDate.parse(request.getParameter("checkout"));
        int cantPersonas = Integer.parseInt(request.getParameter("cantidad"));
        int habitacionGuardar = Integer.parseInt(request.getParameter("habitacion"));
        double importeGuardar = Double.parseDouble(request.getParameter("importe"));
        String usuario = request.getParameter("username");
        //LLamamos a la controladora de la Logica

        controlReserva.crearReserva(huespedGuardar, checkIN, checkOUT, cantPersonas, habitacionGuardar, importeGuardar, usuario);

        //Armamos la redireccion
        response.sendRedirect("SvReservaList");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
