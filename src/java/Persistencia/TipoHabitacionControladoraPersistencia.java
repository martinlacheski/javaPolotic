package Persistencia;
import Logica.Tipo;
import java.util.ArrayList;
import java.util.List;

public class TipoHabitacionControladoraPersistencia {

    TipoHabitacionJpaController jpaTipo = new TipoHabitacionJpaController();
    
    //Metodo para listar los Tipos actuales en la BD por estado TRUE
    public List<Tipo> listarTipos() {
        List<Tipo> listaTipos;
        listaTipos = jpaTipo.findTipoHabitacionEntities();
        List<Tipo> listaFiltrada = new ArrayList<Tipo>();
        for (Tipo tipo : listaTipos) {
            if (tipo.getEstado() == true) {
                listaFiltrada.add(tipo);
            }
        }
        return listaFiltrada;
    }

    //Metodo para obtener un Tipo x su ID
    public Tipo tipoID(int id) {
        Tipo tipo;
        tipo = jpaTipo.findTipoHabitacion(id);
        return tipo;
    }

    //Recibe el objeto Tipo creado desde la Logica y se encarga de persistir
    public void crearTipo(Tipo tipo) {
        //Utilizamos el TRY por si hay algun problema
        try {
            //Insertamos dentro de la BD
            jpaTipo.create(tipo);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(TipoHabitacionControladoraPersistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    //Recibe el objeto Tipo desde la Logica y se encarga de persistir la actualizacion
    public void actualizarTipo(Tipo tipo) {
        //Utilizamos el TRY por si hay algun problema
        try {
            //Insertamos dentro de la BD el UPDATE
            jpaTipo.edit(tipo);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(TipoHabitacionControladoraPersistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
}
