package Persistencia;

import Logica.Huesped;
import java.util.ArrayList;
import java.util.List;

public class HuespedControladoraPersistencia {

    HuespedJpaController jpaHuesped = new HuespedJpaController();

    //Metodo para listar los Huespedes actuales en la BD por estado TRUE
    public List<Huesped> listarHuespedes() {
        List<Huesped> listaHuespedes;
        listaHuespedes = jpaHuesped.findHuespedEntities();
        List<Huesped> listaFiltrada = new ArrayList<Huesped>();
        for (Huesped huesped : listaHuespedes) {
            if (huesped.getEstado() == true) {
                listaFiltrada.add(huesped);
            }
        }
        return listaFiltrada;
    }

    //Metodo para obtener un Huesped x su ID
    public Huesped huespedID(int id) {
        Huesped huesped;
        huesped = jpaHuesped.findHuesped(id);
        return huesped;
    }

    //Recibe el objeto Huesped creado desde la Logica y se encarga de persistir
    public void crearHuesped(Huesped huesped) {
        //Utilizamos el TRY por si hay algun problema
        try {
            //Insertamos dentro de la BD
            jpaHuesped.create(huesped);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(HuespedControladoraPersistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    //Recibe el objeto Huesped desde la Logica y se encarga de persistir la actualizacion
    public void actualizarHuesped(Huesped huesped) {
        //Utilizamos el TRY por si hay algun problema
        try {
            //Insertamos dentro de la BD
            jpaHuesped.edit(huesped);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(HuespedControladoraPersistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
}
