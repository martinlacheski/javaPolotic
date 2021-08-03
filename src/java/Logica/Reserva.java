package Logica;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "reserva")
public class Reserva implements Serializable {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    @Column(nullable = false)
    private LocalDate checkIn;
    @Column(nullable = false)
    private LocalDate checkOut;
    @ManyToOne
    @JoinColumn(name = "idHuesped")
    private Huesped huesped;
    @ManyToOne
    @JoinColumn(name = "idHabitacion")
    private Habitacion habitacion;
    @Column(nullable = false)
    private int cantidadPersonas;
    @Column(nullable = false)
    private double importe;
    @Column(nullable = false)
    private boolean estado = true;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    //Constructores
    public Reserva() {
    }

    public Reserva(int id, LocalDate checkIn, LocalDate checkOut, Huesped huesped, 
            Habitacion habitacion, int cantidadPersonas, double importe, Usuario usuario) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.cantidadPersonas = cantidadPersonas;
        this.importe = importe;
        this.usuario = usuario;
    }

    //Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
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

    public String getCheckInLocalDate() {
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String text = this.checkIn.format(formatters);
        return text;
    }
    
    public String getCheckOutLocalDate() {
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String text = this.checkOut.format(formatters);
        return text;
    }
    
    public int getCantDiasReserva(){
        int dias = 0;
        Period period = Period.between(this.checkIn, this.checkOut);
        dias = period.getDays();
        return dias;
    }
}
