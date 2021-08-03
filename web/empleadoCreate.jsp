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
        <!-- AdminLTE App -->
        <script src="lib/adminlte-3.0.4/js/adminlte.min.js"></script>    
        <!-- Select 2 -->
        <link href="lib/select2-4.0.13/css/select2.min.css" rel="stylesheet"/>
        <link href="lib/select2-4.0.13/css/select2-bootstrap4.min.css" rel="stylesheet"/>
        <script src="lib/select2-4.0.13/js/select2.min.js"></script>
        <script src="lib/select2-4.0.13/js/i18n/es.js"></script>
        <script>
            $(function () {
                $('.select2').select2({
                    theme: "bootstrap4",
                    language: 'es'
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
                                            Crear Empleado
                                        </h5>
                                        <div class="card-body">
                                            <!-- comment <form action="test.jsp" method="POST">-->

                                            <!-- Redireccionamos al Servlet correspondiente-->
                                            <form action="SvEmpleadoCreate" method="POST">
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
                                                        <div class="input-group-prepend datepicker">
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
                                                    <label for="cargo">
                                                        Cargo
                                                    </label>
                                                    <input type="text" class="form-control" id="cargo" name="cargo"
                                                           placeholder="Ingrese el cargo" minlength="4" autocomplete="off" required>
                                                </div>
                                                <div class="form-group">
                                                    <label for="usuario">
                                                        Usuario                                                    
                                                    </label>
                                                    <select class="form-control select2" id="usuario" name="usuario">
                                                        <!-- Utilizamos JSTL para cargar el combobox-->
                                                        <option value="0">---------</option>
                                                        <c:forEach items="${users}" var="user">
                                                            <option value="${user.getId()}">${user.getUsuario()}</option>
                                                        </c:forEach >
                                                    </select>
                                                </div>
                                                <button type="submit" class="btn btn-primary" value="Guardar Usuario">
                                                    <i class="fas fa-save"></i> Guardar Empleado
                                                </button>
                                                <a href="SvEmpleadoList" class="btn btn-danger">
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
