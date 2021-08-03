package Servlets.Habitacion;

import Logica.Habitacion;
import Logica.HabitacionControladora;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvHabitacionList", urlPatterns = {"/SvHabitacionList"})
public class SvHabitacionList extends HttpServlet {
    
    HabitacionControladora control = new HabitacionControladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        //Creamos un List para recorrer desde la vista
        List<Habitacion> habitaciones = control.listarHabitaciones();
        //seteamos a un atributo dicha lista
        request.setAttribute("habitaciones", habitaciones);
        //enviamos a la vista con el Dispatcher
        request.getRequestDispatcher("habitacionList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        int idHab = Integer.parseInt(request.getParameter("id"));
        
        switch (accion) {

            case "Editar":
                //LLamamos a la controladora de la Logica
                Habitacion habitacion = control.habitacionId(idHab);
                request.setAttribute("id", idHab);
                request.setAttribute("nombre", habitacion.getNombre());
                request.setAttribute("tipo", habitacion.getTipo());
                request.setAttribute("piso", habitacion.getPiso());
                request.setAttribute("precio", habitacion.getPrecio());
                
                //Armamos la redireccion
                request.getRequestDispatcher("habitacionEdit.jsp").forward(request, response);

            case "Eliminar":

                //LLamamos a la controladora de la Logica
                Habitacion habitacionDel = control.habitacionId(idHab);
                request.setAttribute("id", idHab);
                request.setAttribute("nombre", habitacionDel.getNombre());
                request.setAttribute("tipo", habitacionDel.getTipo());
                request.setAttribute("piso", habitacionDel.getPiso());
                request.setAttribute("precio", habitacionDel.getPrecio());
                
                //Armamos la redireccion
                request.getRequestDispatcher("habitacionDelete.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
