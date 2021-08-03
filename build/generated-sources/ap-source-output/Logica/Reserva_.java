package Logica;

import Logica.Habitacion;
import Logica.Huesped;
import Logica.Usuario;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-07-17T19:21:30")
@StaticMetamodel(Reserva.class)
public class Reserva_ { 

    public static volatile SingularAttribute<Reserva, Huesped> huesped;
    public static volatile SingularAttribute<Reserva, Boolean> estado;
    public static volatile SingularAttribute<Reserva, LocalDate> checkIn;
    public static volatile SingularAttribute<Reserva, Usuario> usuario;
    public static volatile SingularAttribute<Reserva, Integer> id;
    public static volatile SingularAttribute<Reserva, LocalDate> checkOut;
    public static volatile SingularAttribute<Reserva, Double> importe;
    public static volatile SingularAttribute<Reserva, Habitacion> habitacion;

}