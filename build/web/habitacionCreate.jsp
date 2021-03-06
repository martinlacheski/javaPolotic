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
        <!-- JQuery-Validation -->
        <script src="lib/jquery-validation-1.19.3/jquery.validate.js"></script>
        <!-- Sweetalert2 -->
        <script src="lib/sweetalert2-10.0.2/sweetalert2.all.min.js"></script>
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
            //agregar al campo numerico lo siguiente
            //onkeypress="return isNumberKey(event)"
            function isNumberKey(evt)
            {
                var charCode = (evt.which) ? evt.which : evt.keyCode;
                if (charCode < 48 || charCode > 57)
                    return false;
                return true;
            }
            //agregar al campo numerico lo siguiente
            //onkeypress="return isDoubleKey(event)"
            function isDoubleKey(evt) {
                var charCode = (evt.which) ? evt.which : event.keyCode
                if (charCode > 31 && (charCode < 48 || charCode > 57) && charCode != 46)
                    return false;
                else {
                    var len = document.getElementById("precio").value.length;
                    var index = document.getElementById("precio").value.indexOf('.');

                    if (index > 0 && charCode == 46) {
                        return false;
                    }
                    if (index > 0) {
                        var CharAfterdot = (len + 1) - index;
                        if (CharAfterdot > 3) {
                            return false;
                        }
                    }
                }
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
                                            Crear Habitaci??n
                                        </h5>
                                        <div class="card-body">
                                            <!-- comment <form action="test.jsp" method="POST">-->

                                            <!-- Redireccionamos al Servlet correspondiente-->
                                            <form action="SvHabitacionCreate" method="POST">
                                                <div class="form-group">
                                                    <label for="nombre">
                                                        Nombre
                                                    </label>
                                                    <input type="text" class="form-control" id="nombre" name="nombre"
                                                           placeholder="Ingrese el nombre" minlength="2" autocomplete="off" required>
                                                </div>
                                                <div class="form-group">
                                                    <label for="tipo">
                                                        Tipo                                               
                                                    </label>
                                                    <select class="form-control select2" id="tipo" name="tipo">
                                                        <!-- Utilizamos JSTL para cargar el combobox-->
                                                        <option value="0">---------</option>
                                                        <c:forEach items="${tipos}" var="tipo">
                                                            <option value="${tipo.getId()}">${tipo.getTipo()}</option>
                                                        </c:forEach >
                                                    </select>
                                                </div>
                                                <div class="form-group">
                                                    <label for="piso">
                                                        Piso
                                                    </label>
                                                    <input type="number" min="0" class="form-control" id="piso" name="piso" placeholder="Ingrese el piso"
                                                           onkeypress="return isNumberKey(event)" minlength="1" autocomplete="off" required>
                                                </div>
                                                <div class="form-group">
                                                    <label for="precio">
                                                        Precio por noche
                                                    </label>
                                                    <input type="text" class="form-control" id="precio" name="precio" onkeypress="return isDoubleKey(event)"
                                                           placeholder="Ingrese el precio por noche" minlength="1" autocomplete="off" required>
                                                </div>
                                                <button type="submit" class="btn btn-primary" value="Guardar Usuario">
                                                    <i class="fas fa-save"></i> Guardar Habitaci??n
                                                </button>
                                                <a href="SvHabitacionList" class="btn btn-danger">
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
