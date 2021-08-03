package Logica;

import Logica.Reserva;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-07-17T19:21:30")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Boolean> isJefe;
    public static volatile SingularAttribute<Usuario, String> password;
    public static volatile SingularAttribute<Usuario, Boolean> estado;
    public static volatile ListAttribute<Usuario, Reserva> reservas;
    public static volatile SingularAttribute<Usuario, String> usuario;
    public static volatile SingularAttribute<Usuario, Integer> id;

}