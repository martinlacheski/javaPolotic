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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "habitacion")
public class Habitacion implements Serializable {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    @Column(nullable = false)
    private int piso;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private double precio;
    @Column(nullable = false)
    private boolean estado = true;
    @ManyToOne
    @JoinColumn(name = "idTipo")
    private Tipo tipo;
    @OneToMany (mappedBy = "habitacion")
    private List<Reserva> reservas = new ArrayList<>();

    public Habitacion() {
    }

    public Habitacion(int id, int piso, String nombre, double precio, Tipo tipo) {
        this.id = id;
        this.piso = piso;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
    }
    
    //Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public int getCapacidad() {
        return this.tipo.getCapacidad();
    }
}
