<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Sistema de Reservas</title>
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
        <!-- AdminLTE App -->
        <script src="lib/adminlte-3.0.4/js/adminlte.min.js"></script>
        <!-- JQuery-Validation -->
        <script src="lib/jquery-validation-1.19.3/jquery.validate.js"></script>
        <!-- Sweetalert2 -->
        <script src="lib/sweetalert2-10.0.2/sweetalert2.all.min.js"></script>

        <script>
            $(function () {
                $("#username").validate();
                $("#password").validate();
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
                                            Editar Huesped
                                        </h5>
                                        <div class="card-body">

                                            <!-- Redireccionamos al Servlet correspondiente-->
                                            <form action="SvHuespedEdit" method="POST">
                                                <input type="hidden" name="id" value="${id}">
                                                <div class="form-group">
                                                    <label for="dni">
                                                        DNI
                                                    </label>
                                                    <input type="text" class="form-control" id="dni" name="dni"
                                                           value="${dni}" minlength="7" autocomplete="off" required>
                                                </div>
                                                <div class="form-group">
                                                    <label for="nombres">
                                                        Nombres
                                                    </label>
                                                    <input type="text" class="form-control" id="nombres" name="nombres"
                                                           value="${nombre}" minlength="4" autocomplete="off" required>
                                                </div>
                                                <div class="form-group">
                                                    <label for="apellido">
                                                        Apellido
                                                    </label>
                                                    <input type="text" class="form-control" id="apellido" name="apellido"
                                                           value="${apellido}" minlength="3" autocomplete="off" required>
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
                                                               value="${fechaNacimiento}" required>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="direccion">
                                                        Dirección
                                                    </label>
                                                    <input type="text" class="form-control" id="direccion" name="direccion"
                                                           value="${direccion}" minlength="4" autocomplete="off" required>
                                                </div>
                                                <div class="form-group">
                                                    <label for="profesion">
                                                        Profesion
                                                    </label>
                                                    <input type="text" class="form-control" id="profesion" name="profesion"
                                                           value="${profesion}" minlength="4" autocomplete="off" required>
                                                </div>
                                                <button type="submit" class="btn btn-primary" value="Update">
                                                    <i class="fas fa-save"></i> Actualizar Huesped
                                                </button>
                                                <a href="SvHuespedList" class="btn btn-danger">
                                                    <i class="fas fa-times"></i> Cancelar
                                                </a>
                                            </form>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- FIN Bloque CONTENIDO -->
                    </div>
                </div>

                <!-- Footer -->

                <%@ include file="footer.jsp" %>

            </div>
    </body>
</html>
