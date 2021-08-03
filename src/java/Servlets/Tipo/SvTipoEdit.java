package Servlets.Tipo;

import Logica.TipoHabitacionControladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvTipoEdit", urlPatterns = {"/SvTipoEdit"})
public class SvTipoEdit extends HttpServlet {

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
        
        //Traigo los datos del tipoForm.jsp
        String tipo = request.getParameter("tipo");
        int capacidad = Integer.parseInt(request.getParameter("capacidad"));
        
        //LLamamos a la controladora de la Logica
        TipoHabitacionControladora control = new TipoHabitacionControladora();
        control.actualizarTipo(id, tipo, capacidad);
        
        //Armamos la redireccion
        response.sendRedirect("SvTipoList");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
