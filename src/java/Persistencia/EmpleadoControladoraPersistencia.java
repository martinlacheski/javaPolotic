package Persistencia;

import Logica.Empleado;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoControladoraPersistencia {
    
    EmpleadoJpaController jpaEmpleado = new EmpleadoJpaController();

    //Metodo para listar los Empleados actuales en la BD por estado TRUE
    public List<Empleado> listarEmpleados() {
        List<Empleado> listaEmpleados;
        listaEmpleados = jpaEmpleado.findEmpleadoEntities();
        List<Empleado> listaFiltrada = new ArrayList<Empleado>();
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getEstado() == true) {
                listaFiltrada.add(empleado);
            }
        }
        return listaFiltrada;
    }

    //Metodo para obtener un Empleado x su ID
    public Empleado empleadoID(int id) {
        Empleado empleado;
        empleado = jpaEmpleado.findEmpleado(id);
        return empleado;
    }

    //Recibe el objeto Empleado creado desde la Logica y se encarga de persistir
    public void crearEmpleado(Empleado empleado) {
        //Utilizamos el TRY por si hay algun problema
        try {
            //Insertamos dentro de la BD
            jpaEmpleado.create(empleado);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(EmpleadoControladoraPersistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    //Recibe el objeto Empleado desde la Logica y se encarga de persistir la actualizacion
    public void actualizarEmpleado(Empleado empleado) {
        //Utilizamos el TRY por si hay algun problema
        try {
            //Insertamos dentro de la BD
            jpaEmpleado.edit(empleado);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(EmpleadoControladoraPersistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
}
