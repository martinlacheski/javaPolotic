package Persistencia;

import Logica.Habitacion;
import java.util.ArrayList;
import java.util.List;

public class HabitacionControladoraPersistencia {

    HabitacionJpaController jpaHabitacion = new HabitacionJpaController();

    //Metodo para listar las Habitaciones actuales en la BD por estado TRUE
    public List<Habitacion> listarHabitaciones() {
        List<Habitacion> listaHabitaciones;
        listaHabitaciones = jpaHabitacion.findHabitacionEntities();
        List<Habitacion> listaFiltrada = new ArrayList<Habitacion>();
        for (Habitacion habitacion : listaHabitaciones) {
            if (habitacion.getEstado() == true) {
                listaFiltrada.add(habitacion);
            }
        }
        return listaFiltrada;
    }

    //Metodo para obtener una Habitacion x su ID
    public Habitacion habitacionID(int id) {
        Habitacion habitacion;
        habitacion = jpaHabitacion.findHabitacion(id);
        return habitacion;
    }

    //Recibe el objeto Habitacion creado desde la Logica y se encarga de persistir
    public void crearHabitacion(Habitacion habitacion) {
        //Utilizamos el TRY por si hay algun problema
        try {
            //Insertamos dentro de la BD
            jpaHabitacion.create(habitacion);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(HabitacionControladoraPersistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    //Recibe el objeto Habitacion desde la Logica y se encarga de persistir la actualizacion
    public void actualizarHabitacion(Habitacion habitacion) {
        //Utilizamos el TRY por si hay algun problema
        try {
            //Insertamos dentro de la BD
            jpaHabitacion.edit(habitacion);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(HabitacionControladoraPersistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
}
