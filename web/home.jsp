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
    </head>
    <body>
    <body class="hold-transition layout-top-nav">
        
        <!-- Verificar si hay un usuario activo -->
        <% HttpSession misession = request.getSession();
        //Chequeo que exista un usuario
        String usuario = (String) request.getSession().getAttribute("username");
        
        if (usuario == null){
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
                        
                        <section class="content">
                            <div class="card">
                                <div class="card-body row">
                                    <div class="col-5 text-center d-flex align-items-center justify-content-center">
                                        <div class="">
                                            <h2>Sistema de Reservas</h2>
                                            <h2>Realizado en <strong>JAVA</strong></h2>
                                            <h3><strong>POLOTIC Misiones</strong></h3>
                                            <p class="lead mb-5"><strong>Dirección:</strong> Parque industrial - Posadas - Misiones<br>
                                                <strong>Teléfonos:</strong> +54 3764 484410
                                            </p>
                                        </div>
                                    </div>
                                    <div class="col-7">
                                        <div class="">
                                            <h2><strong>Institucional</strong></h2>
                                            <p class="text-justify">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod
                                                tempor incididunt ut labore et dolore magna aliqua. Nisi lacus sed viverra tellus in.
                                                At elementum eu facilisis sed odio morbi quis commodo odio. Ipsum a arcu cursus vitae congue.
                                                Facilisis magna etiam tempor orci eu. Aliquam vestibulum morbi blandit cursus risus at.
                                                Mauris pharetra et ultrices neque ornare aenean euismod. Lacus sed viverra tellus in hac.
                                                Eget mi proin sed libero enim sed faucibus turpis. Aliquam purus sit amet luctus venenatis
                                                lectus. Consequat semper viverra nam libero justo laoreet sit amet. Massa ultricies mi quis
                                                hendrerit. Ridiculus mus mauris vitae ultricies leo integer malesuada nunc vel.
                                                Amet consectetur adipiscing elit pellentesque habitant. Imperdiet sed euismod nisi porta
                                                lorem mollis. Faucibus scelerisque eleifend donec pretium vulputate.<br>
                                            </p>
                                        </div>

                                        </form>
                                    </div>
                                </div>
                            </div>
                        </section>
                        <!-- FIN Bloque CONTENIDO -->
                    </div>
                </div>
                
                <!-- Footer -->
                
                <%@ include file="footer.jsp" %>
                
            </div>
    </body>
</html>

