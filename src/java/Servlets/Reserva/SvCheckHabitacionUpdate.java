package Servlets.Reserva;

import Logica.ReservaControladora;
import com.google.gson.Gson;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvCheckHabitacionUpdate", urlPatterns = {"/SvCheckHabitacionUpdate"})
public class SvCheckHabitacionUpdate extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean isValid = false;

        //Traigo los datos del reservaEdit.jsp
        int idReserva = Integer.parseInt(request.getParameter("idReserva"));
        int habitacion = Integer.parseInt(request.getParameter("habitacion"));
        LocalDate checkIn = LocalDate.parse(request.getParameter("checkin"));
        LocalDate checkOut = LocalDate.parse(request.getParameter("checkout"));
        
        //LLamamos a la controladora de la Logica
        ReservaControladora control = new ReservaControladora();
        isValid = control.checkReservasHabitacionUpdate(idReserva, habitacion, checkIn, checkOut);

        //Generamos un Map para devolver el Json
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("isValid", isValid);
        write(response, map);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void write(HttpServletResponse response, Map<String, Object> map) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(map));
    }

}
