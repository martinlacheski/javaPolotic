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

@WebServlet(name = "SvHabitacionEdit", urlPatterns = {"/SvHabitacionEdit"})
public class SvHabitacionEdit extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //response.setContentType("text/html;charset=UTF-8");
        //LLamamos a la controladora de la Logica
        TipoHabitacionControladora control = new TipoHabitacionControladora();
        //Creamos un List para recorrer desde la vista
        List<Tipo> tipos = control.listarTipos();
        //seteamos a un atributo dicha lista
        request.setAttribute("tipos", tipos);
        //enviamos a la vista con el Dispatcher
        request.getRequestDispatcher("habitacionEdit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));      

        //Traigo los datos del habitacionEdit.jsp
        String nombre = request.getParameter("nombre");
        int tipo = Integer.parseInt(request.getParameter("tipo"));

        System.out.println(tipo);
        
        int piso = Integer.parseInt(request.getParameter("piso"));
        double precio = Double.parseDouble(request.getParameter("precio"));
        
        
        //LLamamos a la controladora de la Logica
        HabitacionControladora controlHabitacion = new HabitacionControladora();
        controlHabitacion.actualizarHabitacion(id, nombre, tipo, piso, precio);
        
        //Armamos la redireccion
        response.sendRedirect("SvHabitacionList");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
