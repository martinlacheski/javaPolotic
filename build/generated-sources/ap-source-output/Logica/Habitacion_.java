package Logica;

import Logica.Reserva;
import Logica.Tipo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-07-17T19:21:30")
@StaticMetamodel(Habitacion.class)
public class Habitacion_ { 

    public static volatile SingularAttribute<Habitacion, Integer> piso;
    public static volatile SingularAttribute<Habitacion, Double> precio;
    public static volatile SingularAttribute<Habitacion, Boolean> estado;
    public static volatile SingularAttribute<Habitacion, Tipo> tipo;
    public static volatile ListAttribute<Habitacion, Reserva> reservas;
    public static volatile SingularAttribute<Habitacion, Integer> id;
    public static volatile SingularAttribute<Habitacion, String> nombre;

}