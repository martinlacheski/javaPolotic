package Logica;

import Logica.Habitacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-07-17T19:21:30")
@StaticMetamodel(Tipo.class)
public class Tipo_ { 

    public static volatile SingularAttribute<Tipo, String> tipo;
    public static volatile SingularAttribute<Tipo, Boolean> estado;
    public static volatile ListAttribute<Tipo, Habitacion> habitaciones;
    public static volatile SingularAttribute<Tipo, Integer> id;
    public static volatile SingularAttribute<Tipo, Integer> capacidad;

}