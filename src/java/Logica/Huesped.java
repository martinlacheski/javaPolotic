package Logica;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "huesped")
public class Huesped extends Persona implements Serializable {
    
    //Atributos
    @Basic
    @Column(nullable = false)
    private String profesion;
    @Column(nullable = false)
    private boolean estado = true;
    @OneToMany (mappedBy = "huesped")
    private List<Reserva> reservas = new ArrayList<>();
    
    //Constructores

    public Huesped() {
    }

    public Huesped(String profesion, int id, String dni, String nombre, String apellido, LocalDate fechaNacimiento, String direccion) {
        super(id, dni, nombre, apellido, fechaNacimiento, direccion);
        this.profesion = profesion;
    }  
    
    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
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
