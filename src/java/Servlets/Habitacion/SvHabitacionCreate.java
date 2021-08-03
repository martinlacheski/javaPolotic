package Servlets.Habitacion;

import Logica.HabitacionControladora;
import Logica.Tipo;
import Logica.TipoHabitacionControladora;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvHabitacionCreate", urlPatterns = {"/SvHabitacionCreate"})
public class SvHabitacionCreate extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //LLamamos a la controladora de la Logica
        TipoHabitacionControladora control = new TipoHabitacionControladora();
        //Creamos un List para recorrer desde la vista
        List<Tipo> tipos = control.listarTipos();
        //seteamos a un atributo dicha lista
        request.setAttribute("tipos", tipos);
        //enviamos a la vista con el Dispatcher
        request.getRequestDispatcher("habitacionCreate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Traigo los datos del habitacionCreate.jsp
        String nombre = request.getParameter("nombre");
        int tipo = Integer.parseInt(request.getParameter("tipo"));
        int piso = Integer.parseInt(request.getParameter("piso"));
        double precio = Double.parseDouble(request.getParameter("precio"));
        
        //LLamamos a la controladora de la Logica
        HabitacionControladora  controlHabitacion = new HabitacionControladora();
        controlHabitacion.crearHabitacion(nombre, tipo, piso, precio);
        
        //Armamos la redireccion
        response.sendRedirect("SvHabitacionList");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
