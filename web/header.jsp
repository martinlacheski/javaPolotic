<!-- Navbar -->
<nav class="main-header navbar navbar-expand navbar-dark navbar-primary">
    <div class="container">
        
        <button class="navbar-toggler order-1" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <!-- MODULOS -->
        <div class="collapse navbar-collapse order-3" id="navbarCollapse">
            <ul class="navbar-nav">
                <!--Inicio-->
                <li class="nav-item">
                    <a href="home.jsp" class="nav-link"><i class="fas fa-home"></i>Inicio</a>
                </li>
                <!-- Reservas-->
                <li class="nav-item">
                    <a href="SvReservaList" class="nav-link"><i class="far fa-calendar-alt"></i>Reservas</a>
                </li>
                <!-- Huespedes-->
                <li class="nav-item">
                    <a href="SvHuespedList" class="nav-link"><i class="fas fa-user-check"></i>Huespedes</a>
                </li>
                <!--Habitaciones-->
                <li class="nav-item">
                    <a href="SvHabitacionList" class="nav-link"><i class="fas fa-home"></i>Habitaciones</a>
                </li>
                <!-- Tipos de Habitaciones-->
                <li class="nav-item">
                    <a href="SvTipoList" class="nav-link"><i class="fas fa-hotel"></i>Tipos</a>
                </li>
                <!-- Empleados-->
                <li class="nav-item">
                    <a href="SvEmpleadoList" class="nav-link"><i class="fas fa-users"></i>Empleados</a>
                </li>
                <!-- Usuarios-->
                <li class="nav-item">
                    <a href="SvUsuarioList" class="nav-link"><i class="fas fa-users-cog"></i>Usuarios</a>
                </li>
                <!-- Reportes-->
                <li class="nav-item dropdown">
                    <a id="dropdownSubMenu1" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"
                       class="nav-link dropdown-toggle"><i class="fas fa-file-alt"></i>Reportes</a>
                    <ul aria-labelledby="dropdownSubMenu1" class="dropdown-menu border-0 shadow">
                        <li><a href="reporteDia.jsp" class="dropdown-item"><i
                                class="fas fa-calendar-day"></i> Reservas por día</a></li>
                        <li><a href="reporteUsuario.jsp" class="dropdown-item"><i class="fas fa-address-card"></i>
                            Reservas por Empleado</a></li>
                        <li><a href="reporteHuesped.jsp" class="dropdown-item"><i
                                class="fas fa-address-card"></i> Reservas por Huésped</a></li>
                        <li><a href="reporteDiaGanancia.jsp" class="dropdown-item"><i class="fas fa-chart-bar"></i>
                            Recaudación por día</a></li>
                        <li><a href="reporteMesGanancia.jsp" class="dropdown-item"><i
                                class="fas fa-chart-bar"></i> Recaudación por rango de fechas</a></li>
                    </ul>
                </li>
                
            </ul>
        </div>

        <!-- Cerrar Sesion -->
        <ul class="order-1 order-md-3 navbar-nav navbar-no-expand ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="index.jsp" action="SvLogout" method="POST">
                    <i class="fas fa-power-off" aria-hidden="true"></i>Cerrar Sesión
                </a>
            </li>
        </ul>
    </div>
</nav>
