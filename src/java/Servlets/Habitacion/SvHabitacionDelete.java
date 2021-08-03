package Servlets.Habitacion;

import Logica.HabitacionControladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvHabitacionDelete", urlPatterns = {"/SvHabitacionDelete"})
public class SvHabitacionDelete extends HttpServlet {

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

        //Traigo los datos del habitacionEdit.jsp
        String nombre = request.getParameter("nombre");
        int tipo = 0;
        try {
            tipo = Integer.parseInt(request.getParameter("tipo"));
        } catch (Exception ex) {
            
        }
        int piso = Integer.parseInt(request.getParameter("piso"));
        double precio = Double.parseDouble(request.getParameter("precio"));
        
        //LLamamos a la controladora de la Logica
        HabitacionControladora controlHabitacion = new HabitacionControladora();
        controlHabitacion.eliminarHabitacion(id, nombre, tipo, piso, precio);
        
        //Armamos la redireccion
        response.sendRedirect("SvHabitacionList");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
