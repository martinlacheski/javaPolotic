package Logica;

import Persistencia.TipoHabitacionControladoraPersistencia;
import java.util.List;

public class TipoHabitacionControladora {
    TipoHabitacionControladoraPersistencia controladoraTipo = new TipoHabitacionControladoraPersistencia();
    
    //Creamos una variable de tipo list para obtener todos los Tipos de Habitaciones
    private List <Tipo> listaTipos;
    
    //Metodo Listar Tipos
    public List<Tipo> listarTipos() {
        listaTipos = controladoraTipo.listarTipos(); 
        return listaTipos;
    }
    
    //Metodo Obtener Tipo x ID
    public Tipo tipoId(int id) {
        Tipo tipo;
        tipo = controladoraTipo.tipoID(id); 
        return tipo;
    }

    //Metodo Crear Tipo de Habitacion
    public void crearTipo(String tipoHab, int capacidad) {
        
        //Se crea una instancia de Tipo
        Tipo tipo = new Tipo();
        
        //Asignamos los valores al Tipo, de la Vista
        tipo.setTipo(tipoHab);
        tipo.setCapacidad(capacidad);

        
        //Llamamos al metodo de la persistencia para realizar la insercion
        controladoraTipo.crearTipo(tipo);                
    }
    
    //Metodo Actualizar Tipo
    public void actualizarTipo(int id, String tipoHab, int capacidad) {
        
        //Se crea una instancia de Tipo
        Tipo tipo = new Tipo();
        
        //Asignamos los valores al Tipo, de la Vista
        tipo.setId(id);
        tipo.setTipo(tipoHab);
        tipo.setCapacidad(capacidad);
        
        //Llamamos al metodo de la persistencia para realizar la insercion
        controladoraTipo.actualizarTipo(tipo);                
    }
    
    //Metodo Eliminar Tipo (ELIMINACION LOGICA)
    public void eliminarTipo(int id, String tipoHab, int capacidad) {
        
        //Se crea una instancia de Tipo
        Tipo tipo = new Tipo();
        
        //Asignamos los valores al Tipo, de la Vista
        tipo.setId(id);
        tipo.setTipo(tipoHab);
        tipo.setCapacidad(capacidad);
        tipo.setEstado(false);
        
        //Llamamos al metodo de la persistencia para realizar la insercion
        controladoraTipo.actualizarTipo(tipo);              
    }
}
