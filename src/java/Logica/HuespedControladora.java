package Logica;

import Persistencia.HuespedControladoraPersistencia;
import java.time.LocalDate;
import java.util.List;

public class HuespedControladora {

    HuespedControladoraPersistencia controladoraHuesped = new HuespedControladoraPersistencia();
    
    //Creamos una variable de tipo list para obtener todos los Huespedes
    private List <Huesped> listaHuespedes;
    
    //Metodo Listar Huesped
    public List<Huesped> listarHuespedes() {
        listaHuespedes = controladoraHuesped.listarHuespedes(); 
        return listaHuespedes;
    }
    
    //Metodo Obtener Huesped x ID
    public Huesped huespedId(int id) {
        Huesped huesped;
        huesped = controladoraHuesped.huespedID(id); 
        return huesped;
    }

    public void crearHuesped(String dni, String nombres, String apellido, LocalDate fechaNacimiento, String direccion, String profesion) {
        
        //Se crea una instancia de Huesped
        Huesped huesped = new Huesped();
        
        //Asignamos los valores al Huesped, de la Vista
        huesped.setDni(dni);
        huesped.setNombre(nombres);
        huesped.setApellido(apellido);
        huesped.setFechaNacimiento(fechaNacimiento);
        huesped.setDireccion(direccion);
        huesped.setProfesion(profesion);
                
        //Llamamos al metodo de la persistencia para realizar la insercion
        controladoraHuesped.crearHuesped(huesped);
    }
   
    //Metodo Actualizar Huesped
    public void actualizarHuesped(int id, String dni, String nombres, String apellido, LocalDate fechaNacimiento, String direccion, String profesion) {
        
        //Se crea una instancia de Huesped
        Huesped huesped = new Huesped();
        
        //Asignamos los valores al huesped, de la Vista
        huesped.setId(id);
        huesped.setDni(dni);
        huesped.setNombre(nombres);
        huesped.setApellido(apellido);
        huesped.setFechaNacimiento(fechaNacimiento);
        huesped.setDireccion(direccion);
        huesped.setProfesion(profesion);
        
        //Llamamos al metodo de la persistencia para realizar la insercion
        controladoraHuesped.actualizarHuesped(huesped);
        }
          
    //Metodo Eliminar Huesped (ELIMINACION LOGICA)
    public void eliminarHuesped(int id, String dni, String nombres, String apellido, LocalDate fechaNacimiento, String direccion, String profesion) {
        
        //Se crea una instancia de Huesped
        Huesped huesped = new Huesped();
        
        //Asignamos los valores al Huesped, de la Vista
        huesped.setId(id);
        huesped.setDni(dni);
        huesped.setNombre(nombres);
        huesped.setApellido(apellido);
        huesped.setFechaNacimiento(fechaNacimiento);
        huesped.setDireccion(direccion);
        huesped.setProfesion(profesion);
        huesped.setEstado(false);
        
        //Llamamos al metodo de la persistencia para realizar la insercion
        controladoraHuesped.actualizarHuesped(huesped);              
    }
    
}
