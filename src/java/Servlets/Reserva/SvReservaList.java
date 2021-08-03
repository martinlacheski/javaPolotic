package Servlets.Reserva;

import Logica.Habitacion;
import Logica.HabitacionControladora;
import Logica.Huesped;
import Logica.HuespedControladora;
import Logica.Reserva;
import Logica.ReservaControladora;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvReservaList", urlPatterns = {"/SvReservaList"})
public class SvReservaList extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ReservaControladora controlReserva = new ReservaControladora();
        //Creamos un List para recorrer desde la vista
        List<Reserva> reservas = controlReserva.listarReservas();
        //seteamos a un atributo dicha lista
        request.setAttribute("reservas", reservas);
        //enviamos a la vista con el Dispatcher
        request.getRequestDispatcher("reservaList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        int idReserva = Integer.parseInt(request.getParameter("id"));

        ReservaControladora controlReserva = new ReservaControladora();

        //LLamamos a la controladora de la Logica
        Reserva reserva = controlReserva.reservaId(idReserva);
        request.setAttribute("id", idReserva);
        request.setAttribute("huesped", reserva.getHuesped());
        //Seteamos la fecha CheckIN y CheckOUT
        request.setAttribute("checkin", reserva.getCheckIn().toString());
        request.setAttribute("checkout", reserva.getCheckOut().toString());
        //seteamos los demas atributos
        request.setAttribute("cantDias", reserva.getCantDiasReserva());
        request.setAttribute("cantPersonas", reserva.getCantidadPersonas());
        request.setAttribute("habitacion", reserva.getHabitacion());
        request.setAttribute("precio", reserva.getHabitacion().getPrecio());
        request.setAttribute("importe", reserva.getImporte());
        //request.setAttribute("usuario", reserva.getUsuario());

        switch (accion) {

            case "Editar":
                //LLamamos a las controladoras de la Logica
                HuespedControladora controlHuesped = new HuespedControladora();
                HabitacionControladora controlHabitacion = new HabitacionControladora();
                //Creamos un List para recorrer los huespedes
                List<Huesped> huespedes = controlHuesped.listarHuespedes();
                //seteamos a un atributo dicha lista
                request.setAttribute("huespedes", huespedes);
                // Creamos un List para recorrer las habitaciones
                List<Habitacion> habitaciones = controlHabitacion.listarHabitaciones();
                //seteamos a un atributo dicha lista
                request.setAttribute("habitaciones", habitaciones);
                //Armamos la redireccion
                request.getRequestDispatcher("reservaEdit.jsp").forward(request, response);

            case "Eliminar":
                //Armamos la redireccion
                request.getRequestDispatcher("reservaDelete.jsp").forward(request, response);

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
