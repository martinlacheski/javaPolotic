package Logica;

import Persistencia.ReservaControladoraPersistencia;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservaControladora {

    ReservaControladoraPersistencia controladoraReserva = new ReservaControladoraPersistencia();

    //Creamos una variable de tipo list para obtener todos las Reservas
    private List<Reserva> listaReservas;

    //Metodo Listar Reserva
    public List<Reserva> listarReservas() {
        listaReservas = controladoraReserva.listarReservas();
        return listaReservas;
    }

    //Metodo Obtener Reserva x ID
    public Reserva reservaId(int id) {
        Reserva reserva;
        reserva = controladoraReserva.reservaID(id);
        return reserva;
    }

    //Metodo Chequear Reservas Habitacion
    public boolean checkReservasHabitacion(int hab, LocalDate in, LocalDate out) {
        //creamos variable check
        boolean check = false;
        List<Reserva> listaReservas = controladoraReserva.listarReservas();
        for (Reserva reserva : listaReservas) {
            if (reserva.getHabitacion().getId() == hab) {
                //if((str1 > start && str1 < end) || (str2 > start && str2 < end))
                if (in.isAfter(reserva.getCheckIn())
                        && (in.isBefore(reserva.getCheckOut()))) {
                    check = true;
                    //System.out.println("1");

                } else if (out.isAfter(reserva.getCheckIn())
                        && (out.isBefore(reserva.getCheckOut()))) {
                    check = true;
                    //System.out.println("2");

                } else if (in.equals(reserva.getCheckIn())
                        && (out.isAfter(reserva.getCheckOut()))) {
                    check = true;
                    //System.out.println("3");

                } else if (in.isBefore(reserva.getCheckIn())
                        && (out.isAfter(reserva.getCheckOut()))) {
                    check = true;
                    //System.out.println("4");

                } else if (in.isBefore(reserva.getCheckIn())
                        && (out.equals(reserva.getCheckOut()))) {
                    check = true;
                    //System.out.println("5");

                } else if (in.isBefore(reserva.getCheckIn())
                        && (out.equals(reserva.getCheckIn()))) {
                    check = true;
                    //System.out.println("6");

                } else if (in.equals(reserva.getCheckIn())
                        && (out.equals(reserva.getCheckOut()))) {
                    check = true;
                    //System.out.println("7");

                } else if (in.equals(reserva.getCheckOut())
                        && (out.isAfter(reserva.getCheckOut()))) {
                    check = true;
                    //System.out.println("8");

                } else {
                    check = false;
                    //System.out.println("OK");
                }
                if (check == true) {
                    break;
                }
            }
        }
        return check;
    }

    public boolean checkReservasHabitacionUpdate(int idReserva, int hab, LocalDate in, LocalDate out) {
        //creamos variable check
        boolean check = false;
        List<Reserva> listaReservas = controladoraReserva.listarReservas();
        for (Reserva reserva : listaReservas) {
            if (reserva.getHabitacion().getId() == hab && reserva.getId() != idReserva) {
                //if((str1 > start && str1 < end) || (str2 > start && str2 < end))
                if (in.isAfter(reserva.getCheckIn())
                        && (in.isBefore(reserva.getCheckOut()))) {
                    check = true;
                    //System.out.println("1");

                } else if (out.isAfter(reserva.getCheckIn())
                        && (out.isBefore(reserva.getCheckOut()))) {
                    check = true;
                    //System.out.println("2");

                } else if (in.equals(reserva.getCheckIn())
                        && (out.isAfter(reserva.getCheckOut()))) {
                    check = true;
                    //System.out.println("3");

                } else if (in.isBefore(reserva.getCheckIn())
                        && (out.isAfter(reserva.getCheckOut()))) {
                    check = true;
                    //System.out.println("4");

                } else if (in.isBefore(reserva.getCheckIn())
                        && (out.equals(reserva.getCheckOut()))) {
                    check = true;
                    //System.out.println("5");

                } else if (in.isBefore(reserva.getCheckIn())
                        && (out.equals(reserva.getCheckIn()))) {
                    check = true;
                    //System.out.println("6");

                } else if (in.equals(reserva.getCheckIn())
                        && (out.equals(reserva.getCheckOut()))) {
                    check = true;
                    //System.out.println("7");

                } else if (in.equals(reserva.getCheckOut())
                        && (out.isAfter(reserva.getCheckOut()))) {
                    check = true;
                    //System.out.println("8");

                } else {
                    check = false;
                    //System.out.println("OK");
                }
                if (check == true) {
                    break;
                }
            }
        }
        return check;
    }

    //Metodo Chequear Reservas x Dia
    public List<Reserva> checkReservasDia(LocalDate dia) {
        //creamos la lista       
        List<Reserva> listaReservas = controladoraReserva.listarReservas();
        List<Reserva> listaFiltrada = new ArrayList<Reserva>();
        //creamos variable check
        boolean check = false;
        for (Reserva reserva : listaReservas) {

            if ((dia.compareTo(reserva.getCheckIn()) >= 0)
                    && (dia.compareTo(reserva.getCheckOut())) <= 0) {
                check = true;
            }
            if (check == true) {
                listaFiltrada.add(reserva);
            }
            check = false;
        }
        return listaFiltrada;
    }

    //Metodo Chequear Reservas x Empleado
    public List<Reserva> checkReservasUsuario(int user) {
        //creamos la lista       
        List<Reserva> listaReservas = controladoraReserva.listarReservas();
        List<Reserva> listaFiltrada = new ArrayList<Reserva>();
        EmpleadoControladora controlEmpleado = new EmpleadoControladora();
        Empleado empleado = controlEmpleado.empleadoId(user);
        //creamos variable check
        boolean check = false;
        for (Reserva reserva : listaReservas) {
            if ((reserva.getUsuario().getId() == empleado.getUsuario().getId())) {
                check = true;
            }
            if (check == true) {
                listaFiltrada.add(reserva);
            }
            check = false;
        }
        return listaFiltrada;
    }

    //Metodo Chequear Reservas x Huesped y Fechas
    public List<Reserva> checkReservasHuesped(int huesp, LocalDate in, LocalDate out) {
        //creamos la lista       
        List<Reserva> listaReservas = controladoraReserva.listarReservas();
        List<Reserva> listaFiltrada = new ArrayList<Reserva>();
        HuespedControladora controlHuesped = new HuespedControladora();
        Huesped huesped = controlHuesped.huespedId(huesp);
        //creamos variable check
        boolean check = false;
        for (Reserva reserva : listaReservas) {
            if ((reserva.getHuesped().getId() == huesped.getId())) {
                //if((str1 > start && str1 < end) || (str2 > start && str2 < end))
                if (in.isAfter(reserva.getCheckIn())
                        && (in.isBefore(reserva.getCheckOut()))) {
                    check = true;
                    //System.out.println("1");

                } else if (out.isAfter(reserva.getCheckIn())
                        && (out.isBefore(reserva.getCheckOut()))) {
                    check = true;
                    //System.out.println("2");

                } else if (in.equals(reserva.getCheckIn())
                        && (out.isAfter(reserva.getCheckOut()))) {
                    check = true;
                    //System.out.println("3");

                } else if (in.isBefore(reserva.getCheckIn())
                        && (out.isAfter(reserva.getCheckOut()))) {
                    check = true;
                    //System.out.println("4");

                } else if (in.isBefore(reserva.getCheckIn())
                        && (out.equals(reserva.getCheckOut()))) {
                    check = true;
                    //System.out.println("5");

                } else if (in.isBefore(reserva.getCheckIn())
                        && (out.equals(reserva.getCheckIn()))) {
                    check = true;
                    //System.out.println("6");

                } else if (in.equals(reserva.getCheckIn())
                        && (out.equals(reserva.getCheckOut()))) {
                    check = true;
                    //System.out.println("7");
                }
                if (check == true) {
                    listaFiltrada.add(reserva);
                }
                check = false;
            }
        }

        return listaFiltrada;
    }

    //Metodo Chequear Reservas Recaudacion
    public List<Reserva> checkReservasRecaudacion(LocalDate in, LocalDate out) {
        //creamos variable check
        boolean check = false;
        List<Reserva> listaReservas = controladoraReserva.listarReservas();
        List<Reserva> listaFiltrada = new ArrayList<Reserva>();
        for (Reserva reserva : listaReservas) {
            //if((str1 > start && str1 < end) || (str2 > start && str2 < end))
            if (in.isAfter(reserva.getCheckIn())
                    && (in.isBefore(reserva.getCheckOut()))) {
                check = true;
                //System.out.println("1");

            } else if (out.isAfter(reserva.getCheckIn())
                    && (out.isBefore(reserva.getCheckOut()))) {
                check = true;
                //System.out.println("2");

            } else if (in.equals(reserva.getCheckIn())
                    && (out.isAfter(reserva.getCheckOut()))) {
                check = true;
                //System.out.println("3");

            } else if (in.isBefore(reserva.getCheckIn())
                    && (out.isAfter(reserva.getCheckOut()))) {
                check = true;
                //System.out.println("4");

            } else if (in.isBefore(reserva.getCheckIn())
                    && (out.equals(reserva.getCheckOut()))) {
                check = true;
                //System.out.println("5");

            } else if (in.isBefore(reserva.getCheckIn())
                    && (out.equals(reserva.getCheckIn()))) {
                check = true;
                //System.out.println("6");

            } else if (in.equals(reserva.getCheckIn())
                    && (out.equals(reserva.getCheckOut()))) {
                check = true;
                //System.out.println("7");            
            }
            if (check == true) {
                listaFiltrada.add(reserva);
            }
            check = false;
            
        }
        return listaFiltrada;
    }

    //Metodo Crear Reserva
    public void crearReserva(int huespedSeleccionado, LocalDate checkIn, LocalDate checkOut, int cantPersonas, int habitacionSeleccionada, Double importe, String usuario) {

        ///Creamos una instancia de controladora Usuario para traer el usuario activo
        UsuarioControladora controlUsuario = new UsuarioControladora();

        //Buscamos el usuario que coincide con el USERNAME y asignamos como parametro
        List<Usuario> usuarios = controlUsuario.listarUsuarios();
        Usuario userActivo = new Usuario();
        for (Usuario user : usuarios) {
            if (user.getUsuario().equals(usuario)) {
                userActivo = user;
            }
        }

        //Creamos una instancia de controladora Huesped para traer el huesped seleccionado
        HuespedControladora controlHuesped = new HuespedControladora();
        Huesped huesped = controlHuesped.huespedId(huespedSeleccionado);

        //Creamos una instancia de controladora Habitacion para traer la Habitacion seleccionada
        HabitacionControladora controlHabitacion = new HabitacionControladora();
        Habitacion habitacion = controlHabitacion.habitacionId(habitacionSeleccionada);

        //Se crea una instancia de Reserva
        Reserva reserva = new Reserva();

        //Asignamos los valores a la Reserva, de la Vista
        reserva.setHuesped(huesped);
        reserva.setCheckIn(checkIn);
        reserva.setCheckOut(checkOut);
        reserva.setCantidadPersonas(cantPersonas);
        reserva.setHabitacion(habitacion);
        reserva.setImporte(importe);
        reserva.setUsuario(userActivo);

        //Llamamos al metodo de la persistencia para realizar la insercion
        controladoraReserva.crearReserva(reserva);
    }

    //Metodo Actualizar Reserva
    public void actualizarReserva(int id, int huespedSeleccionado, LocalDate checkIn, LocalDate checkOut, int cantPersonas, int habitacionSeleccionada, Double importe, String usuario) {

        //Creamos una instancia de controladora Usuario para traer el usuario activo
        UsuarioControladora controlUsuario = new UsuarioControladora();
        //Buscamos el usuario que coincide con el USERNAME y asignamos como parametro
        List<Usuario> usuarios = controlUsuario.listarUsuarios();
        Usuario userActivo = new Usuario();
        for (Usuario user : usuarios) {
            if (user.getUsuario().equals(usuario)) {
                userActivo = user;
            }
        }

        //Creamos una instancia de controladora Huesped para traer el huesped seleccionado
        HuespedControladora controlHuesped = new HuespedControladora();
        Huesped huesped = controlHuesped.huespedId(huespedSeleccionado);

        //Creamos una instancia de controladora Habitacion para traer la Habitacion seleccionada
        HabitacionControladora controlHabitacion = new HabitacionControladora();
        Habitacion habitacion = controlHabitacion.habitacionId(habitacionSeleccionada);

        //Se crea una instancia de Reserva
        Reserva reserva = new Reserva();

        //Asignamos los valores de Reserva, de la Vista
        reserva.setId(id);
        reserva.setHuesped(huesped);
        reserva.setCheckIn(checkIn);
        reserva.setCheckOut(checkOut);
        reserva.setCantidadPersonas(cantPersonas);
        reserva.setHabitacion(habitacion);
        reserva.setImporte(importe);
        reserva.setUsuario(userActivo);

        //Llamamos al metodo de la persistencia para realizar la insercion
        controladoraReserva.actualizarReserva(reserva);
    }

    //Metodo Eliminar Reserva (ELIMINACION LOGICA)
    public void eliminarReserva(int id, int huespedSeleccionado, LocalDate checkIn, LocalDate checkOut, int cantPersonas, int habitacionSeleccionada, Double importe, String usuario) {

        //Creamos una instancia de controladora Usuario para traer el usuario activo
        UsuarioControladora controlUsuario = new UsuarioControladora();
        //Buscamos el usuario que coincide con el USERNAME y asignamos como parametro
        List<Usuario> usuarios = controlUsuario.listarUsuarios();
        Usuario userActivo = new Usuario();
        for (Usuario user : usuarios) {
            if (user.getUsuario().equals(usuario)) {
                userActivo = user;
            }
        }

        //Creamos una instancia de controladora Huesped para traer el huesped seleccionado
        HuespedControladora controlHuesped = new HuespedControladora();
        Huesped huesped = controlHuesped.huespedId(huespedSeleccionado);

        //Creamos una instancia de controladora Habitacion para traer la Habitacion seleccionada
        HabitacionControladora controlHabitacion = new HabitacionControladora();
        Habitacion habitacion = controlHabitacion.habitacionId(habitacionSeleccionada);

        //Se crea una instancia de Reserva
        Reserva reserva = new Reserva();

        //Asignamos los valores de Reserva, de la Vista
        reserva.setId(id);
        reserva.setHuesped(huesped);
        reserva.setCheckIn(checkIn);
        reserva.setCheckOut(checkOut);
        reserva.setCantidadPersonas(cantPersonas);
        reserva.setHabitacion(habitacion);
        reserva.setImporte(importe);
        reserva.setUsuario(userActivo);
        reserva.setEstado(false);

        //Llamamos al metodo de la persistencia para realizar la insercion
        controladoraReserva.actualizarReserva(reserva);
    }

}
