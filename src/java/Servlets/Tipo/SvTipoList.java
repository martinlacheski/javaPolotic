package Servlets.Tipo;

import Logica.Tipo;
import Logica.TipoHabitacionControladora;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvTipoList", urlPatterns = {"/SvTipoList"})
public class SvTipoList extends HttpServlet {
    //LLamamos a la controladora de la Logica
    TipoHabitacionControladora control = new TipoHabitacionControladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Creamos un List para recorrer desde la vista
        List<Tipo> tipos = control.listarTipos();
        //seteamos a un atributo dicha lista
        request.setAttribute("tipos", tipos);
        //enviamos a la vista con el Dispatcher
        request.getRequestDispatcher("tipoList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        int id = Integer.parseInt(request.getParameter("id"));

        switch (accion) {
            
            case "Editar":
                
                //LLamamos a la controladora de la Logica
                Tipo tipo = control.tipoId(id);
                request.setAttribute("tipoObj", tipo);
                request.setAttribute("idTipo", id);
                request.setAttribute("tipo", tipo.getTipo());
                request.setAttribute("capacidad", tipo.getCapacidad());
                //Armamos la redireccion
                request.getRequestDispatcher("tipoEdit.jsp").forward(request, response);
            
            case "Eliminar":
                
                //LLamamos a la controladora de la Logica
                Tipo tipoDel = control.tipoId(id);
                request.setAttribute("idTipo", id);
                request.setAttribute("tipoObj", tipoDel);
                request.setAttribute("tipo", tipoDel.getTipo());
                request.setAttribute("capacidad", tipoDel.getCapacidad());
                //Armamos la redireccion
                request.getRequestDispatcher("tipoDelete.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
