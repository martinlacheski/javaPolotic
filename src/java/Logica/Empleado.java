package Logica;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado extends Persona implements Serializable{
    
    //atributos
    @Basic
    @Column(nullable = false)
    private String cargo;
    @Column(nullable = false)
    private boolean estado = true;
    @OneToOne
    private Usuario usuario;
    
    //constructores

    public Empleado() {
    }

    public Empleado(String cargo, Usuario usuario, int id, String dni, String nombre, String apellido, LocalDate fechaNacimiento, String direccion) {
        super(id, dni, nombre, apellido, fechaNacimiento, direccion);
        this.cargo = cargo;
        this.usuario = usuario;
    }
    
    //Getters y Setters

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public int getId(){
        return super.getId();
    }
    
}
