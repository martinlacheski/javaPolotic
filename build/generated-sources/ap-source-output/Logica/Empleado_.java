package Logica;

import Logica.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-07-17T19:21:30")
@StaticMetamodel(Empleado.class)
public class Empleado_ extends Persona_ {

    public static volatile SingularAttribute<Empleado, Boolean> estado;
    public static volatile SingularAttribute<Empleado, Usuario> usuario;
    public static volatile SingularAttribute<Empleado, String> cargo;

}