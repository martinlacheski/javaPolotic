package Logica;

import java.time.LocalDate;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

//Agregamos el mapeo para poder generar las entidades Empleado y Huesped

@MappedSuperclass
public abstract class Persona {
    
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    @Column(nullable = false)
    private String dni;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @Column(nullable = false)
    private LocalDate fechaNacimiento;
    @Column(nullable = false)
    private String direccion;
    
    //constructores
    public Persona() {
    }

    public Persona(int id, String dni, String nombre, String apellido, LocalDate fechaNacimiento, String direccion) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }
    
    //Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
