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
        <!-- Jquery Confirm -->
        <link rel="stylesheet" href="lib/jquery-confirm-v3.3.4/jquery-confirm.min.css">
        <script src="lib/jquery-confirm-v3.3.4/jquery-confirm.min.js"></script>
        <!-- Datatables -->
        <link rel="stylesheet" href="lib/datatables-1.10.20/css/dataTables.bootstrap4.min.css"/>
        <link rel="stylesheet"
              href="lib/datatables-1.10.20/plugins/responsive-2.2.3/css/responsive.bootstrap4.min.css"/>
        <script src="lib/datatables-1.10.20/js/jquery.dataTables.js"></script>
        <script src="lib/datatables-1.10.20/js/dataTables.bootstrap4.min.js"></script>
        <script src="lib/datatables-1.10.20/plugins/responsive-2.2.3/js/dataTables.responsive.min.js"></script>
        <script src="lib/datatables-1.10.20/plugins/responsive-2.2.3/js/responsive.bootstrap4.min.js"></script>
        <script src="lib/datatables-1.10.20/plugins/responsive-2.2.3/js/responsive.bootstrap4.min.js"></script>
        <script src="lib/datatables-1.10.20/js/dataTables.dateTime.min.js"></script>
        <script src="lib/datatables-1.10.20/js/dataTables.editor.min.js"></script>

        <!-- Funcion para el datatables -->
        <script type="application/javascript">
            $(function () {
            $('#data').DataTable({
            responsive: true,
            autoWidth: false,
            lengthMenu: [ 25, 50, 75, 100 ],
            order : [ 0, 'asc' ]

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

                        <div class="card card-default">
                            <div class="card-header">
                                <h3 class="card-title">
                                    <i class="fas fa-search"></i>
                                    Reportes de Reservas por día
                                </h3>
                            </div>
                            <div class="card-body">
                                <form action="SvReportes" method="POST">
                                    <div class="row">
                                        <div class="col-5">
                                            <label for="checkDia">
                                                Seleccione el día
                                            </label>
                                            <div class="input-group">
                                                <div class="input-group-prepend datepicker">
                                                    <span class="input-group-text"><i class="far fa-calendar-alt"></i></span>
                                                </div>
                                                <input type="date" class="form-control" checkDia id="checkDia" name="checkDia"
                                                       value="${dia}" required>
                                                <div class="input-group-append">
                                                    <button type="submit" name="accion" value="reporteDia" class="btn btn-success btn-flat btnAddHuesped">
                                                        <i class="fas fa-search"> Buscar reservas</i>
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                                <div class="card-body">

                                    <table class="table" id="data" name="tabla">
                                        <thead>
                                            <tr>
                                                <th scope="col" style="width: 10%;">ID</th>
                                                <th scope="col" style="width: 20%;">Check-IN</th>
                                                <th scope="col" style="width: 20%;">Check-OUT</th>
                                                <th scope="col" style="width: 30%;">Huesped</th>
                                                <th scope="col" style="width: 15%;">Habitación</th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <!-- Utilizamos JSTL para recorrer la lista -->
                                            <c:forEach items="${reservas}" var="res">
                                                <tr>
                                                    <td>${res.getId()}</td>
                                                    <td>${res.getCheckInLocalDate()}</td>
                                                    <td>${res.getCheckOutLocalDate()}</td>
                                                    <td>${res.huesped.getApellido()}, ${res.huesped.getNombre()}</td>
                                                    <td>${res.getHabitacion().getNombre()}</td>
                                                </tr>
                                            </c:forEach >
                                        </tbody>
                                    </table>
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
