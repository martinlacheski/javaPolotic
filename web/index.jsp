<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <p class="login-box-msg">Ingresá tus datos de acceso</p>
                    <form action="SvLogin" method="post">

                        <div class="form-group">
                            <label for="username">
                                Nombre de Usuario
                            </label>
                            <input type="text" class="form-control" id="username" name="username"
                                   autocomplete="off" placeholder="Ingrese el nombre de usuario">
                        </div>
                        <div class="form-group">
                            <label for="password">
                                Contraseña
                            </label>
                            <input type="password" class="form-control" id="password" name="password"
                                   autocomplete="off" placeholder="Ingrese la contraseña">
                        </div>
                        <div class="row">
                            <div class="col-lg-12">
                                <button type="submit" class="btn btn-primary btn-block">
                                    <i class="fas fa-sign-in-alt"></i> Iniciar sesión
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
