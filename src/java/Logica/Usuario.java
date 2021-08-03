package Logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    @Column(nullable = false)
    private String usuario;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private boolean isJefe = false;
    @Column(nullable = false)
    private boolean estado = true;
    @OneToMany (mappedBy = "usuario")
    private List<Reserva> reservas = new ArrayList<>();
    
    //Constructores

    public Usuario() {
    }

    public Usuario(int id, String usuario, String password) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
    }
   
    //Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsJefe() {
        return isJefe;
    }

    public void setIsJefe(boolean isJefe) {
        this.isJefe = isJefe;
    }  

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    //Metodo toString
    @Override
    public String toString() {
        return usuario;
    }
    
    
}
