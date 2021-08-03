<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Sistema de Reservas</title>
        <!-- JQuery-Validation 
        <script src="lib/jquery-validation-1.19.3/jquery.validate.js"></script>-->
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
                                            Crear Tipo de Habitación
                                        </h5>
                                        <div class="card-body">
                                            <!-- comment <form action="test.jsp" method="POST">-->

                                            <!-- Redireccionamos al Servlet correspondiente-->
                                            <form action="SvTipoCreate" method="POST">
                                                <div class="form-group">
                                                    <label for="tipo">
                                                        Tipo de Habitación
                                                    </label>
                                                    <input type="text" class="form-control" id="tipo" name="tipo"
                                                           placeholder="Ingrese el nombre del tipo" minlength="4" autocomplete="off" required>
                                                </div>
                                                <div class="form-group">
                                                    <label for="capacidad">
                                                        Capacidad
                                                    </label>
                                                    <input type="number" min="1" class="form-control" id="capacidad" name="capacidad" onkeypress="return isNumberKey(event)"
                                                           placeholder="Ingrese la capacidad" autocomplete="off" required>
                                                </div>
                                                <button type="submit" class="btn btn-primary" value="Guardar Tipo">
                                                    <i class="fas fa-save"></i> Guardar Tipo
                                                </button>
                                                <a href="SvTipoList" class="btn btn-danger">
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
