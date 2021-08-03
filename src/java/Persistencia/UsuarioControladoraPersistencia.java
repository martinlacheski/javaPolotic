package Persistencia;

import Logica.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioControladoraPersistencia {
    
    UsuarioJpaController jpaUsuario = new UsuarioJpaController();
    
    //Metodo para listar los Usuarios actuales en la BD por estado TRUE
    public List<Usuario> listarUsuarios() {
        List<Usuario> listaUsuarios;
        listaUsuarios = jpaUsuario.findUsuarioEntities();
        List<Usuario> listaFiltrada = new ArrayList<Usuario>();
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getEstado() == true) {
                listaFiltrada.add(usuario);
            }
        }
        return listaFiltrada;
    }
    
    //Metodo para obtener un Usuario x su ID
    public Usuario usuarioID(int id) {
        Usuario usuario;
        usuario = jpaUsuario.findUsuario(id);
        return usuario;
    }

    //Recibe el objeto Usuario creado desde la Logica y se encarga de persistir
    public void crearUsuario(Usuario usuario) {
        //Utilizamos el TRY por si hay algun problema
        try {
            //Insertamos dentro de la BD
            jpaUsuario.create(usuario);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(UsuarioControladoraPersistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    //Recibe el objeto Usuario desde la Logica y se encarga de persistir la actualizacion
    public void actualizarUsuario(Usuario usuario) {
        //Utilizamos el TRY por si hay algun problema
        try {
            //Insertamos dentro de la BD el UPDATE
            jpaUsuario.edit(usuario);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(UsuarioControladoraPersistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
