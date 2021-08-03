package Logica;

import Logica.Reserva;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-07-17T19:21:30")
@StaticMetamodel(Huesped.class)
public class Huesped_ extends Persona_ {

    public static volatile SingularAttribute<Huesped, Boolean> estado;
    public static volatile ListAttribute<Huesped, Reserva> reservas;
    public static volatile SingularAttribute<Huesped, String> profesion;

}