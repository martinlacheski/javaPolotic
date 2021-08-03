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
@Table(name = "tipo")
public class Tipo implements Serializable {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    @Column(nullable = false)
    private String tipo;
    @Column(nullable = false)
    private int capacidad;
    @Column(nullable = false)
    private boolean estado = true;
    @OneToMany (mappedBy = "tipo")
    private List<Habitacion> habitaciones = new ArrayList<>();

    
    //Constructores

    public Tipo() {
    }

    public Tipo(int id, String tipo, int capacidad) {
        this.id = id;
        this.tipo = tipo;
        this.capacidad = capacidad;
    }
    
    //Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }
    
    //Metodo toString
    @Override
    public String toString() {
        return tipo;
    }
    
}
