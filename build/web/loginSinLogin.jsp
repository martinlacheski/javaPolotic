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
        <!-- Bootstrap 4 -->
        <script src="lib/adminlte-3.0.4/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- JQuery-Validation -->
        <script src="lib/jquery-validation-1.19.3/jquery.validate.js"></script>
        <!-- jQuery -->
        <script src="lib/adminlte-3.0.4/plugins/jquery/jquery.min.js"></script>

        <!-- Validación en el LOGIN -->
        <script>
            $(function () {
                $("#username").validate();
                $("#password").validate();
            });
        </script>
    </head>

    <body class="hold-transition login-page">
        <div class="login-box">
            <div class="login-logo">
                <a href="#"/>
                Sistema de<b> Reservas</b></a>
            </div>
            <div class="card">
                <div class="card-body login-card-body">
                    <form action="index.jsp" method="post">
                        <div class="col-12 text-center d-flex align-items-center justify-content-center">
                            <div class="">
                                <h2>Error</h2>
                                <p class="lead mb-5"><br>
                                    Debe iniciar Sesión para utilizar el sistema
                                </p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-12">
                                <button class="btn btn-danger btn-block">
                                    <i class="fas fa-sign-in-alt"></i> Volver al Login
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
