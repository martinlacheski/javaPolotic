package Servlets.Reportes;

import Logica.Empleado;
import Logica.EmpleadoControladora;
import Logica.Huesped;
import Logica.HuespedControladora;
import Logica.Reserva;
import Logica.ReservaControladora;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvReportes", urlPatterns = {"/SvReportes"})
public class SvReportes extends HttpServlet {

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

        String accion = request.getParameter("accion");
        ReservaControladora controlReserva = new ReservaControladora();
        //Creamos un List para recorrer las reservas
        List<Reserva> reservas;

        switch (accion) {

            case "reporteDia":
                //Seteamos la fecha del dia seleccionado
                LocalDate checkDia = LocalDate.parse(request.getParameter("checkDia"));
                //LLamamos a la controladora de la Logica
                reservas = controlReserva.checkReservasDia(checkDia);
                //seteamos a un atributo dicha lista
                request.setAttribute("reservas", reservas);
                request.setAttribute("dia", checkDia.toString());
                //Armamos la redireccion
                request.getRequestDispatcher("reporteDia.jsp").forward(request, response);

            case "reporteUsuario":
                //Seteamos el usuario
                int usuario = Integer.parseInt(request.getParameter("usuario"));
                //LLamamos a la controladora de la Logica para mantener el empleado
                EmpleadoControladora controlEmpleado = new EmpleadoControladora();
                Empleado user = controlEmpleado.empleadoId(usuario);
                //LLamamos a la controladora de la Logica
                //Creamos un List para recorrer las reservas
                reservas = controlReserva.checkReservasUsuario(usuario);
                //seteamos a un atributo dicha lista
                request.setAttribute("reservas", reservas);
                request.setAttribute("usuario", user);

                //Armamos la redireccion
                request.getRequestDispatcher("reporteUsuario.jsp").forward(request, response);

            case "reporteHuesped":
                //Seteamos el Huesped
                int huesped = Integer.parseInt(request.getParameter("huesped"));
                LocalDate checkIN = LocalDate.parse(request.getParameter("checkin"));
                LocalDate checkOUT = LocalDate.parse(request.getParameter("checkout"));
                //LLamamos a la controladora de la Logica para mantener el Huesped
                HuespedControladora controlHuesped = new HuespedControladora();
                Huesped huesp = controlHuesped.huespedId(huesped);
                //LLamamos a la controladora de la Logica
                //Creamos un List para recorrer las reservas
                reservas = controlReserva.checkReservasHuesped(huesped, checkIN, checkOUT);
                //seteamos a un atributo dicha lista
                request.setAttribute("checkin", checkIN);
                request.setAttribute("checkout", checkOUT);
                request.setAttribute("reservas", reservas);
                request.setAttribute("huesped", huesp);

                //Armamos la redireccion
                request.getRequestDispatcher("reporteHuesped.jsp").forward(request, response);

            case "reporteDiaGanancia":
                //Seteamos la fecha del dia seleccionado
                LocalDate checkDiaG = LocalDate.parse(request.getParameter("checkDia"));
                //LLamamos a la controladora de la Logica
                reservas = controlReserva.checkReservasDia(checkDiaG);
                double ganancia = 0;
                for (Reserva res : reservas) {
                    //Chequeamos que el el dia de Salida no compute como Recaudacion
                    if (!res.getCheckOut().isEqual(checkDiaG)) {
                        ganancia = ganancia + res.getHabitacion().getPrecio();
                    }
                }
                //seteamos a un atributo dicha lista
                request.setAttribute("reservas", reservas);
                request.setAttribute("ganancia", ganancia);
                request.setAttribute("dia", checkDiaG.toString());
                //Armamos la redireccion
                request.getRequestDispatcher("reporteDiaGanancia.jsp").forward(request, response);

            case "reporteMesGanancia":
                //Seteamos la fecha del dia seleccionado
                LocalDate checkInicio = LocalDate.parse(request.getParameter("checkin"));
                LocalDate checkFin = LocalDate.parse(request.getParameter("checkout"));
                reservas = controlReserva.checkReservasRecaudacion(checkInicio, checkFin);
                List<Reserva> reservasDia;
                long dias = ChronoUnit.DAYS.between(checkInicio, checkFin);
                //LLamamos a la controladora de la Logica
                //reservas = controlReserva.checkReservasRecaudacion(checkInicio, checkFin);
                double recaudacion = 0;
                LocalDate verReservasDia = checkInicio;
                //Hacemos un FOR por cada dia dentro de la seleccion y llamamos a la funcion por Dia
                for (int i = 1; i < dias; i++) {
                    reservasDia = controlReserva.checkReservasDia(verReservasDia);
                    for (Reserva res : reservasDia) {
                        //Chequeamos que el el dia de Salida no compute como Recaudacion
                        if (!res.getCheckOut().isEqual(verReservasDia)) {
                            recaudacion = recaudacion + res.getHabitacion().getPrecio();
                        }
                    }
                    verReservasDia = verReservasDia.plusDays(1);
                }
                //seteamos a un atributo dicha lista
                request.setAttribute("reservas", reservas);
                request.setAttribute("ganancia", recaudacion);
                request.setAttribute("checkin", checkInicio.toString());
                request.setAttribute("checkout", checkFin.toString());
                //Armamos la redireccion
                request.getRequestDispatcher("reporteMesGanancia.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
