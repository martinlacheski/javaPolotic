package Logica;

import Persistencia.UsuarioControladoraPersistencia;
import java.util.List;

public class UsuarioControladora {
    
    UsuarioControladoraPersistencia controladoraUsuario = new UsuarioControladoraPersistencia();
    
    //Creamos una variable de tipo list para obtener todos los Usuarios
    private List <Usuario> listaUsuarios;
    
    //Metodo Listar Usuarios
    public List<Usuario> listarUsuarios() {
        listaUsuarios = controladoraUsuario.listarUsuarios(); 
        return listaUsuarios;
    }
    
    //Metodo Obtener Usuario x ID
    public Usuario usuarioId(int id) {
        Usuario usuario;
        usuario = controladoraUsuario.usuarioID(id); 
        return usuario;
    }

    //Metodo Crear Usuario
    public void crearUsuario(String username, String password, boolean isJefe) {
        
        //Se crea una instancia de Usuario
        Usuario usuario = new Usuario();
        
        //Asignamos los valores al Usuario, de la Vista
        usuario.setUsuario(username);
        usuario.setPassword(password);
        usuario.setIsJefe(isJefe);
        
        //Llamamos al metodo de la persistencia para realizar la insercion
        controladoraUsuario.crearUsuario(usuario);                
    }
    
    //Metodo Actualizar Usuario
    public void actualizarUsuario(int id, String username, String password, boolean isJefe) {
        
        //Se crea una instancia de Usuario
        Usuario usuario = new Usuario();
        
        //Asignamos los valores al Usuario, de la Vista
        usuario.setId(id);
        usuario.setUsuario(username);
        usuario.setPassword(password);
        usuario.setIsJefe(isJefe);
        
        //Llamamos al metodo de la persistencia para realizar la insercion
        controladoraUsuario.actualizarUsuario(usuario);                
    }
    
    //Metodo Eliminar Usuario (ELIMINACION LOGICA)
    public void eliminarUsuario(int id, String username, String password, boolean isJefe) {
        
        //Se crea una instancia de Usuario
        Usuario usuario = new Usuario();
        
        //Asignamos los valores al Usuario, de la Vista
        usuario.setId(id);
        usuario.setUsuario(username);
        usuario.setPassword(password);
        usuario.setIsJefe(isJefe);
        usuario.setEstado(false);
        
        //Llamamos al metodo de la persistencia para realizar la insercion
        controladoraUsuario.actualizarUsuario(usuario);              
    }

    //Metodo Buscar Usuario Registrado
    public boolean comprobarIngreso(String username, String password) {
        //para retornar si el usuario y password coinciden con algun usuario en la BD
        boolean usuarioValido = false;
        
        //Obtenemos el listado de usuarios
        listaUsuarios = controladoraUsuario.listarUsuarios();
        //Chequeamos si el username y password coinciden
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getUsuario().equals(username) && usuario.getPassword().equals(password)) {
                usuarioValido = true;
                return usuarioValido;
            }
        }     
        return usuarioValido;
    }
    
}
