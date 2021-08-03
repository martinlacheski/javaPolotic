package Servlets.Huesped;

import Logica.Huesped;
import Logica.HuespedControladora;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvHuespedList", urlPatterns = {"/SvHuespedList"})
public class SvHuespedList extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HuespedControladora controlHuesped = new HuespedControladora();
        //Creamos un List para recorrer desde la vista
        List<Huesped> huespedes = controlHuesped.listarHuespedes();
        //seteamos a un atributo dicha lista
        request.setAttribute("huespedes", huespedes);
        //enviamos a la vista con el Dispatcher
        request.getRequestDispatcher("huespedList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        int idHuesped = Integer.parseInt(request.getParameter("id"));
        HuespedControladora controlHuesped = new HuespedControladora();
        switch (accion) {

            case "Editar":
                //LLamamos a la controladora de la Logica
                Huesped huesped = controlHuesped.huespedId(idHuesped);
                request.setAttribute("id", idHuesped);
                request.setAttribute("dni", huesped.getDni());
                request.setAttribute("nombre", huesped.getNombre());
                request.setAttribute("apellido", huesped.getApellido());
                //Seteamos la fecha
                request.setAttribute("fechaNacimiento", huesped.getFechaNacimiento().toString());
                request.setAttribute("direccion", huesped.getDireccion());
                request.setAttribute("profesion", huesped.getProfesion());
                //Armamos la redireccion
                request.getRequestDispatcher("huespedEdit.jsp").forward(request, response);

            case "Eliminar":

                //LLamamos a la controladora de la Logica
                Huesped huespedDel = controlHuesped.huespedId(idHuesped);
                request.setAttribute("id", idHuesped);
                request.setAttribute("dni", huespedDel.getDni());
                request.setAttribute("nombre", huespedDel.getNombre());
                request.setAttribute("apellido", huespedDel.getApellido());
                //Seteamos la fecha
                request.setAttribute("fechaNacimiento", huespedDel.getFechaNacimiento().toString());
                request.setAttribute("direccion", huespedDel.getDireccion());
                request.setAttribute("profesion", huespedDel.getProfesion());

                //Armamos la redireccion
                request.getRequestDispatcher("huespedDelete.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
