package Persistencia;

import Logica.Reserva;
import java.util.ArrayList;
import java.util.List;

public class ReservaControladoraPersistencia {

    ReservaJpaController jpaReserva = new ReservaJpaController();

    //Metodo para listar las Reservas actuales en la BD por estado TRUE
    public List<Reserva> listarReservas() {
        List<Reserva> listaReservas;
        listaReservas = jpaReserva.findReservaEntities();
        List<Reserva> listaFiltrada = new ArrayList<Reserva>();
        for (Reserva reserva : listaReservas) {
            if (reserva.getEstado() == true) {
                listaFiltrada.add(reserva);
                
            }
        }
        return listaFiltrada;
    }

    //Metodo para obtener una Reserva x su ID
    public Reserva reservaID(int id) {
        Reserva reserva;
        reserva = jpaReserva.findReserva(id);
        return reserva;
    }

    //Recibe el objeto Reserva creado desde la Logica y se encarga de persistir
    public void crearReserva(Reserva reserva) {
        //Utilizamos el TRY por si hay algun problema
        try {
            //Insertamos dentro de la BD
            jpaReserva.create(reserva);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ReservaControladoraPersistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    //Recibe el objeto Reserva desde la Logica y se encarga de persistir la actualizacion
    public void actualizarReserva(Reserva reserva) {
        //Utilizamos el TRY por si hay algun problema
        try {
            //Insertamos dentro de la BD
            jpaReserva.edit(reserva);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ReservaControladoraPersistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

}
