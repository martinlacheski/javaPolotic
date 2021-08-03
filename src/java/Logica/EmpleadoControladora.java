package Logica;

import Persistencia.EmpleadoControladoraPersistencia;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoControladora {

    EmpleadoControladoraPersistencia controladoraEmpleado = new EmpleadoControladoraPersistencia();
    
    //Creamos una variable de tipo list para obtener todos los Empleados
    private List <Empleado> listaEmpleados;
    
    //Metodo Listar Empleado
    public List<Empleado> listarEmpleados() {
        listaEmpleados = controladoraEmpleado.listarEmpleados(); 
        return listaEmpleados;
    }
    
    //Metodo Listar Empleados con Usuarios
    public List<Empleado> listarUsuariosEmpleados() {
        listaEmpleados = controladoraEmpleado.listarEmpleados(); 
        List<Empleado> listaFiltrada = new ArrayList<Empleado>();
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getUsuario() != null) {
                listaFiltrada.add(empleado);
            }
        }
        return listaFiltrada;
    }
    
    //Metodo Obtener Empleado x ID
    public Empleado empleadoId(int id) {
        Empleado empleado;
        empleado = controladoraEmpleado.empleadoID(id); 
        return empleado;
    }

    public void crearEmpleado(String dni, String nombres, String apellido, LocalDate fechaNacimiento, String direccion, String cargo, int usuario) {
        
        //Creamos una instancia de controladora Usuario para traer el usuario seleccionado
        UsuarioControladora control = new UsuarioControladora();
        Usuario user = control.usuarioId(usuario);
        
        //Se crea una instancia de Empleado
        Empleado empleado = new Empleado();
        
        //Asignamos los valores al Empleado, de la Vista
        empleado.setDni(dni);
        empleado.setNombre(nombres);
        empleado.setApellido(apellido);
        empleado.setFechaNacimiento(fechaNacimiento);
        empleado.setDireccion(direccion);
        empleado.setCargo(cargo);
        empleado.setUsuario(user);
        
        //Llamamos al metodo de la persistencia para realizar la insercion
        controladoraEmpleado.crearEmpleado(empleado);
    }

    public void crearEmpleadoSinUser(String dni, String nombres, String apellido, LocalDate fechaNacimiento, String direccion, String cargo) {
        
        //Se crea una instancia de Empleado
        Empleado empleado = new Empleado();
        
        //Asignamos los valores al Empleado, de la Vista
        empleado.setDni(dni);
        empleado.setNombre(nombres);
        empleado.setApellido(apellido);
        empleado.setFechaNacimiento(fechaNacimiento);
        empleado.setDireccion(direccion);
        empleado.setCargo(cargo);
        
        ///Llamamos al metodo de la persistencia para realizar la insercion
        controladoraEmpleado.crearEmpleado(empleado);
    }
    
    //Metodo Actualizar Empleado
    public void actualizarEmpleado(int id, String dni, String nombres, String apellido, LocalDate fechaNacimiento, String direccion, String cargo, int usuario) {
        
        //Creamos una instancia de controladora Usuario para traer el usuario seleccionado
        UsuarioControladora control = new UsuarioControladora();
        Usuario user = control.usuarioId(usuario);
        
        //Se crea una instancia de Empleado
        Empleado empleado = new Empleado();
        
        //Asignamos los valores al Empleado, de la Vista
        empleado.setId(id);
        empleado.setDni(dni);
        empleado.setNombre(nombres);
        empleado.setApellido(apellido);
        empleado.setFechaNacimiento(fechaNacimiento);
        empleado.setDireccion(direccion);
        empleado.setCargo(cargo);
        empleado.setUsuario(user);
        
        //Llamamos al metodo de la persistencia para realizar la insercion
        controladoraEmpleado.actualizarEmpleado(empleado);
        }
        
    //Metodo Actualizar Empleado
    public void actualizarEmpleadoSinUser(int id, String dni, String nombres, String apellido, LocalDate fechaNacimiento, String direccion, String cargo) {
               
        //Se crea una instancia de Empleado
        Empleado empleado = new Empleado();
        
        //Asignamos los valores al Empleado, de la Vista
        empleado.setId(id);
        empleado.setDni(dni);
        empleado.setNombre(nombres);
        empleado.setApellido(apellido);
        empleado.setFechaNacimiento(fechaNacimiento);
        empleado.setDireccion(direccion);
        empleado.setCargo(cargo);
        
        //Llamamos al metodo de la persistencia para realizar la insercion
        controladoraEmpleado.actualizarEmpleado(empleado);
        }

    
    //Metodo Eliminar Empleado (ELIMINACION LOGICA)
    public void eliminarEmpleado(int id, String dni, String nombres, String apellido, LocalDate fechaNacimiento, String direccion, String cargo) {
        
        //Buscamos el usuario del Empleado
        Empleado user = empleadoId(id);
        
        //Se crea una instancia de Empleado
        Empleado empleado = new Empleado();
        
        //Asignamos los valores al Empleado, de la Vista
        empleado.setId(id);
        empleado.setDni(dni);
        empleado.setNombre(nombres);
        empleado.setApellido(apellido);
        empleado.setFechaNacimiento(fechaNacimiento);
        empleado.setDireccion(direccion);
        empleado.setCargo(cargo);
        empleado.setUsuario(user.getUsuario());
        empleado.setEstado(false);
        
        //Llamamos al metodo de la persistencia para realizar la insercion
        controladoraEmpleado.actualizarEmpleado(empleado);              
    }
    
}
