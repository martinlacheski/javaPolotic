<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Agregamos la siguiente libreria paa poder utilizar JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Sistema de Reservas</title>
        <!-- jQuery -->
        <script src="lib/jquery/jquery.min.js"></script>
        <!-- Font Awesome Icons -->
        <link rel="stylesheet" href="lib/adminlte-3.0.4/plugins/font-awesome-5.11.1/css/all.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="lib/adminlte-3.0.4/css/adminlte.min.css">
        <!-- Google Font: Source Sans Pro -->
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
        <!-- jQuery -->
        <script src="lib/adminlte-3.0.4/plugins/jquery/jquery.min.js"></script>
        <!-- Bootstrap 4 -->
        <script src="lib/adminlte-3.0.4/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- Select 2 -->
        <link href="lib/select2-4.0.13/css/select2.min.css" rel="stylesheet"/>
        <link href="lib/select2-4.0.13/css/select2-bootstrap4.min.css" rel="stylesheet"/>
        <script src="lib/select2-4.0.13/js/select2.min.js"></script>
        <script src="lib/select2-4.0.13/js/i18n/es.js"></script>
        <!-- Jquery Confirm -->
        <link rel="stylesheet" href="lib/jquery-confirm-v3.3.4/jquery-confirm.min.css">
        <script src="lib/jquery-confirm-v3.3.4/jquery-confirm.min.js"></script>
        <!-- Bloque JAVASCRIPT -->
        <script>
            //agregar al campo numerico lo siguiente
            //onkeypress="return isNumberKey(event)"
            function isNumberKey(evt)
            {
                var charCode = (evt.which) ? evt.which : evt.keyCode;
                if (charCode < 48 || charCode > 57)
                    return false;
                return true;
            }
            $(function () {
                $('.select2').select2({
                    theme: "bootstrap4",
                    language: 'es'
                });
                //Mostrar MODAL de Crear Huesped
                $('.btnAddHuesped').on('click', function () {
                    $('#myModalHuesped').modal('show');
                });
                //Ocultar y resetear modal al Crear Huesped
                $('#myModalHuesped').on('hidden.bs.modal', function (e) {
                    $('#frmHuesped').trigger('reset');
                });
                //Deshabilitamos el boton de Generar Reserva en cambio de fecha CheckIN
                $('#checkin').on('change', function (e) {
                    var btn = document.getElementById('btnGuardar');
                    btn.disabled = true;
                });
                //Chequeamos que la fecha de checkOUT sea mayor que checkIN
                $("#checkout").on('change', function (e) {
                    var btn = document.getElementById('btnGuardar');
                    btn.disabled = true;
                    var dateIN = $('input[name="checkin"]').val();
                    var dateOUT = $('input[name="checkout"]').val();
                    if (dateIN >= dateOUT) {
                        $('input[name="checkout"]').val(dateIN);
                        $.alert({
                            title: 'Error!',
                            content: 'La fecha debe ser mayor que la de CHECK-IN',
                        });
                    } else {
                        //Calculamos la cantidad de dias para poder sacar el importe
                        date1 = new Date(dateIN);
                        date2 = new Date(dateOUT);
                        var cantDias = (date2 - date1) / (1000 * 60 * 60 * 24);
                        $('input[name="dias"]').val(cantDias);
                        var precio = parseFloat(${precio});
                        var importe = cantDias * precio;
                        $('input[name="importe"]').val(importe);
                    }
                });

                //Chequeamos que la fecha de checkIN  no sea mayor que checkOUT
                $("#checkin").on('change', function (e) {
                    var btn = document.getElementById('btnGuardar');
                    btn.disabled = true;
                    var dateIN = $('input[name="checkin"]').val();
                    var dateOUT = $('input[name="checkout"]').val();
                    if (dateIN >= dateOUT) {
                        $('input[name="checkin"]').val(dateOUT);
                        $.alert({
                            title: 'Error!',
                            content: 'La fecha no debe ser mayor que la de CHECK-OUT',
                        });
                    } else {
                        //Calculamos la cantidad de dias para poder sacar el importe
                        date1 = new Date(dateIN);
                        date2 = new Date(dateOUT);
                        var cantDias = (date2 - date1) / (1000 * 60 * 60 * 24);
                        $('input[name="dias"]').val(cantDias);
                        var precio = parseFloat(${precio});
                        var importe = cantDias * precio;
                        $('input[name="importe"]').val(importe);
                    }
                });
                
                //Funcion obtener capacidad habitacion
                //Cargamos en un input la capacidad de personas por habitacion seleccionada
                $("#habitacion").on('change', function () {
                    //Inicializamos unas variables para la funcion
                    var btn = document.getElementById('btnGuardar');
                    btn.disabled = true;    //Desactivamos Boton por cada seleccion de Hab.
                    var ide = $(this).val();    //ID habitacion
                    //Variables de fechas de inicio y fin
                    var dateIN = $('input[name="checkin"]').val();
                    var dateOUT = $('input[name="checkout"]').val();
                    ///recorremos las habitaciones para sacar la capacidad
            <c:forEach items="${habitaciones}" var="hab">
                    var h = parseInt(${hab.getId()});
                    //verificamos que coincida la habitacion del listado
                    if (h == ide) {
                        //asignamos al input oculto la capacidad
                        $('input[name="capHab"]').val(${hab.getCapacidad()});
                        //Calculamos el importe sacando precio * cantidad de dias
                        var precio = parseFloat(${hab.getPrecio()});
                        var dias = parseInt($('input[name="dias"]').val());
                        var importe = dias * precio;
                        $('input[name="importe"]').val(importe);
                    }
            </c:forEach >
                });

                //Funcion para validar que este disponible la habitacion seleccionada
                $('#btnCheck').click(function () {
                    var btn = document.getElementById('btnGuardar');
                    var idReserva = parseInt(${id});
                    var hab = $('#habitacion').val();
                    var checkIN = $('#checkin').val();
                    var checkOUT = $('#checkout').val();
                    var huesped = $('#huesped').val();
                    if (huesped == "0") {
                        $.alert({
                            title: 'Error!',
                            content: 'Debe seleccionar un Huésped',
                        });
                    } else {
                        $.ajax({
                            url: 'SvCheckHabitacionUpdate',
                            type: "POST",
                            data: {
                                'idReserva': idReserva,
                                'habitacion': hab,
                                'checkin': checkIN,
                                'checkout': checkOUT,
                            },
                            dataType: 'json',
                            success: function (data) {
                                if (data.isValid) {
                                    $.alert({
                                        title: 'Error!',
                                        content: 'Habitación ocupada, por favor seleccione otra',
                                    });
                                    btn.disabled = true;
                                } else {
                                    $.alert({
                                        title: 'Confirmación!',
                                        content: 'Habitación disponible para la reserva',
                                    });
                                    btn.disabled = false;
                                }

                            },
                            error: function (error) {
                                //console.log('Error ${error}');
                            }
                        });
                    }


                });

                //Chequeamos que la cantidad de personas no supere el limite de la Habitacion
                $("#cantidad").on('change', function (e) {
                    var cantPersonas = $('input[name="cantidad"]').val();
                    var cantHab = $('input[name="capHab"]').val();
                    if (cantPersonas > cantHab) {
                        $.alert({
                            title: 'Error!',
                            content: 'La cantidad de personas supera el limite de la habitacion',
                        });
                        $('input[name="cantidad"]').val(cantHab);
                    }
                });
            });
        </script>
    </head>
    <body>
    <body class="hold-transition layout-top-nav">

        <!-- Verificar si hay un usuario activo -->
        <% HttpSession misession = request.getSession();
            //Chequeo que exista un usuario
            String usuario = (String) request.getSession().getAttribute("username");
            if (usuario == null) {
                //Si no existe un usuario se redirecciona al LOGIN
                response.sendRedirect("loginSinLogin.jsp");
            } else {
                //Existe un usuario 
            }%>

        <div class="wrapper">

            <!-- BARRA DE NAVEGACION -->

            <%@ include file="header.jsp" %>

            <div class="content-wrapper">

                <!-- CABECERA -->

                <%@ include file="cabecera.jsp" %>

                <div class="content">
                    <div class="container">

                        <!-- Bloque CONTENIDO -->

                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="card bg-default">
                                        <h5 class="card-header">
                                            Editar Reserva
                                        </h5>
                                        <div class="card-body">
                                            <!-- comment <form action="test.jsp" method="POST">-->
                                            <!-- Redireccionamos al Servlet correspondiente-->
                                            <form action="SvReservaEdit" method="POST">
                                                <input type="hidden" name="id" value="${id}">
                                                <div class="card-body">
                                                    <label for="huesped">
                                                        Seleccione el huesped
                                                    </label>
                                                    <div class="input-group">

                                                        <select class="form-control select2" id="huesped" name="huesped" required>
                                                            <!-- Utilizamos JSTL para cargar el combobox-->
                                                            <option value="${huesped.getId()}">${huesped.getApellido()}, ${huesped.getNombre()}</option>
                                                            <c:forEach items="${huespedes}" var="huesp">
                                                                <option value="${huesp.getId()}">${huesp.getApellido()}, ${huesp.getNombre()}</option>
                                                            </c:forEach >
                                                        </select>

                                                        <div class="input-group-append">
                                                            <button class="btn btn-success btn-flat btnAddHuesped" type="button">
                                                                <i class="fas fa-user-plus"></i>
                                                            </button>
                                                        </div>
                                                    </div>
                                                    <br>
                                                    <br>
                                                    <div class="row">
                                                        <div class="col-4">
                                                            <label for="checkin">
                                                                Check-IN
                                                            </label>
                                                            <div class="input-group">
                                                                <div class="input-group-prepend datepicker">
                                                                    <span class="input-group-text"><i class="far fa-calendar-alt"></i></span>
                                                                </div>
                                                                <input type="date" class="form-control" checkin id="checkin" name="checkin"
                                                                       value="${checkin}" required>
                                                            </div>
                                                        </div>
                                                        <div class="col-4">
                                                            <label for="checkout">
                                                                Check-OUT
                                                            </label>
                                                            <div class="input-group">
                                                                <div class="input-group-prepend datepicker">
                                                                    <span class="input-group-text"><i class="far fa-calendar-alt"></i></span>
                                                                </div>
                                                                <input type="date" class="form-control" checkout id="checkout" name="checkout"
                                                                       value="${checkout}" required>

                                                            </div>
                                                        </div>
                                                        <div class="col-4">
                                                            <label for="dias">
                                                                Cantidad de dias

                                                            </label>
                                                            <input type="text" class="form-control" id="dias" name="dias"
                                                                   value="${cantDias}" autocomplete="off" readonly required>
                                                        </div>
                                                    </div>
                                                    <br>
                                                    <br>
                                                    <div class="row">
                                                        <div class="col-3">
                                                            <label for="habitacion">
                                                                Habitación                                                    
                                                            </label>
                                                            <select class="form-control select2" id="habitacion" name="habitacion">
                                                                <!-- Utilizamos JSTL para cargar el combobox-->
                                                                <option value="${habitacion.getId()}">${habitacion.getNombre()}</option>
                                                                <c:forEach items="${habitaciones}" var="hab">
                                                                    <option value="${hab.getId()}">${hab.getNombre()}</option>
                                                                </c:forEach >
                                                            </select>
                                                            <input type="hidden" name="capHab" value="0">
                                                        </div>
                                                        <div class="col-3">
                                                            <label for="cantidad">
                                                                Cantidad de Personas
                                                            </label>
                                                            <input type="number" min="1" class="form-control" id="cantidad" name="cantidad" 
                                                                   value="1" onkeypress="return isNumberKey(event)" autocomplete="off" 
                                                                   value="${cantPersonas}" required>
                                                        </div>
                                                        <div class="col-3">
                                                            <label for="importe">
                                                                Importe
                                                            </label>
                                                            <input type="text" class="form-control" id="importe" name="importe"
                                                                   value="${importe}" autocomplete="off" readonly required>
                                                        </div> 

                                                    </div>
                                                    <br>
                                                    <input type="hidden" name="username" value="<%= request.getSession().getAttribute("username")%>">
                                                    <br>
                                                    <!-- Boton para interactuar con ajax para validar la disponibilidad de la habitacion -->
                                                    <button type="button" method="POST" id="btnCheck" name="accion" value="chequear" class="btn btn-success">
                                                        <i class="far fa-calendar-check"></i> Chequear habitacion
                                                    </button>
                                                    <button type="submit" name="accion" value="guardar" id="btnGuardar" disabled btnGuardar 
                                                            class="btn btn-primary" value="Actualizar reserva">
                                                        <i class="fas fa-save"></i> Actualizar Reserva
                                                    </button>
                                                    <a href="SvReservaList" class="btn btn-danger">
                                                        <i class="fas fa-times"></i> Cancelar
                                                    </a>

                                            </form>

                                        </div>


                                        <!-- Modal -->


                                        <div class="modal fade" id="myModalHuesped" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                                             aria-hidden="true">
                                            <form id="frmHuesped" action="SvHuespedCreateReserva" method="POST">
                                                <div class="modal-dialog" role="document">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title" id="exampleModalLabel">
                                                                <b><i class="fas fa-user-plus"></i> Crear Huesped</b>
                                                            </h5>
                                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                <span aria-hidden="true">&times;</span>
                                                            </button>
                                                        </div>
                                                        <div class="modal-body">
                                                            <div class="form-group">
                                                                <label for="dni">
                                                                    DNI
                                                                </label>
                                                                <input type="text" class="form-control" id="dni" name="dni"
                                                                       placeholder="Ingrese el DNI" minlength="7" autocomplete="off" required>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="nombres">
                                                                    Nombres
                                                                </label>
                                                                <input type="text" class="form-control" id="nombres" name="nombres"
                                                                       placeholder="Ingrese los nombres" minlength="4" autocomplete="off" required>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="apellido">
                                                                    Apellido
                                                                </label>
                                                                <input type="text" class="form-control" id="apellido" name="apellido"
                                                                       placeholder="Ingrese el apellido" minlength="3" autocomplete="off" required>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="fechaNacimiento">
                                                                    Fecha de Nacimiento
                                                                </label>
                                                                <div class="input-group">
                                                                    <div class="input-group-prepend">
                                                                        <span class="input-group-text"><i class="far fa-calendar-alt"></i></span>
                                                                    </div>
                                                                    <input type="date" class="form-control" id="fechaNacimiento" name="fechaNacimiento"
                                                                           placeholder="Ingrese la fecha de nacimiento" required>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="direccion">
                                                                    Dirección
                                                                </label>
                                                                <input type="text" class="form-control" id="direccion" name="direccion"
                                                                       placeholder="Ingrese la dirección" minlength="4" autocomplete="off" required>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="profesion">
                                                                    Profesión
                                                                </label>
                                                                <input type="text" class="form-control" id="profesion" name="profesion"
                                                                       placeholder="Ingrese la profesión" autocomplete="off" required>
                                                            </div>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="submit" class="btn btn-primary btn-block btn-flat">
                                                                <i class="fas fa-save"></i> Crear Huesped
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                        <!-- END Modal -->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- FIN Bloque CONTENIDO -->
                </div>
                <!-- Footer -->
                <%@ include file="footer.jsp" %>
            </div>

        </div>
    </body>
</html>
