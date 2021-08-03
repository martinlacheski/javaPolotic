package Servlets.Tipo;

import Logica.TipoHabitacionControladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvTipoCreate", urlPatterns = {"/SvTipoCreate"})
public class SvTipoCreate extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        response.sendRedirect("tipoCreate.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Traigo los datos del tipoCreate.jsp
        String tipo = request.getParameter("tipo");
        int capacidad = Integer.parseInt(request.getParameter("capacidad"));
        
        //LLamamos a la controladora de la Logica
        TipoHabitacionControladora  controlTipo = new TipoHabitacionControladora();
        controlTipo.crearTipo(tipo, capacidad);
        
        //Armamos la redireccion
        response.sendRedirect("SvTipoList");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
