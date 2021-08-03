package Logica;

import Persistencia.HabitacionControladoraPersistencia;
import java.util.List;

public class HabitacionControladora {
    
    HabitacionControladoraPersistencia controladoraHabitacion = new HabitacionControladoraPersistencia();
    
    //Creamos una variable de tipo list para obtener todos las Habitaciones
    private List <Habitacion> listaHabitaciones;
    
    //Metodo Listar Habitacion
    public List<Habitacion> listarHabitaciones() {
        listaHabitaciones = controladoraHabitacion.listarHabitaciones(); 
        return listaHabitaciones;
    }
    
    //Metodo Obtener Habitacion x ID
    public Habitacion habitacionId(int id) {
        Habitacion habitacion;
        habitacion = controladoraHabitacion.habitacionID(id); 
        return habitacion;
    }
    
    public void crearHabitacion(String nombre, int tipo, int piso, double precio) {
        
        //Creamos una instancia de controladora Tipo para traer el Tipo seleccionado
        TipoHabitacionControladora control = new TipoHabitacionControladora();
        Tipo tipoHab = control.tipoId(tipo);
        
        //Se crea una instancia de Habitacion
        Habitacion habitacion = new Habitacion();
        
        //Asignamos los valores a la habitacion, de la Vista
        habitacion.setNombre(nombre);
        habitacion.setTipo(tipoHab);
        habitacion.setPiso(piso);
        habitacion.setPrecio(precio);
        
        //Llamamos al metodo de la persistencia para realizar la insercion
        controladoraHabitacion.crearHabitacion(habitacion);
    }
    
    //Metodo Actualizar Habitacion
    public void actualizarHabitacion(int id, String nombre, int tipo, int piso, double precio) {
        
        //Creamos una instancia de controladora Tipo para traer el Tipo seleccionado
        TipoHabitacionControladora control = new TipoHabitacionControladora();
        Tipo tipoHab = control.tipoId(tipo);
        
        //Se crea una instancia de Habitacion
        Habitacion habitacion = new Habitacion();
        
        //Asignamos los valores a la habitacion, de la Vista
        habitacion.setId(id);
        habitacion.setNombre(nombre);
        habitacion.setTipo(tipoHab);
        habitacion.setPiso(piso);
        habitacion.setPrecio(precio);
        
        //Llamamos al metodo de la persistencia para realizar la insercion
        controladoraHabitacion.actualizarHabitacion(habitacion);
        }
        
    
    //Metodo Eliminar Habitacion (ELIMINACION LOGICA)
    public void eliminarHabitacion(int id, String nombre, int tipo, int piso, double precio) {
        
        //Buscamos el Tipo de habitacion
        Habitacion hab = habitacionId(id);
        
        //Se crea una instancia de Habitacion
        Habitacion habitacion = new Habitacion();
        
        //Asignamos los valores a la habitacion, de la Vista
        habitacion.setId(id);
        habitacion.setNombre(nombre);
        habitacion.setTipo(hab.getTipo());
        habitacion.setPiso(piso);
        habitacion.setPrecio(precio);
        habitacion.setEstado(false);
        
        //Llamamos al metodo de la persistencia para realizar la insercion
        controladoraHabitacion.actualizarHabitacion(habitacion);              
    }
    
}
