/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.69
 * Generated at: 2021-07-26 13:50:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class usuarioEdit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/footer.jsp", Long.valueOf(1627301722520L));
    _jspx_dependants.put("/header.jsp", Long.valueOf(1627301722520L));
    _jspx_dependants.put("/cabecera.jsp", Long.valueOf(1627301722516L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"es\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta http-equiv=\"x-ua-compatible\" content=\"ie=edge\">\n");
      out.write("        <title>Sistema de Reservas</title>\n");
      out.write("        <!-- Font Awesome Icons -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"lib/adminlte-3.0.4/plugins/font-awesome-5.11.1/css/all.min.css\">\n");
      out.write("        <!-- Theme style -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"lib/adminlte-3.0.4/css/adminlte.min.css\">\n");
      out.write("        <!-- Google Font: Source Sans Pro -->\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700\" rel=\"stylesheet\">\n");
      out.write("        <!-- jQuery -->\n");
      out.write("        <script src=\"lib/adminlte-3.0.4/plugins/jquery/jquery.min.js\"></script>\n");
      out.write("        <!-- Bootstrap 4 -->\n");
      out.write("        <script src=\"lib/adminlte-3.0.4/plugins/bootstrap/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("        <!-- AdminLTE App -->\n");
      out.write("        <script src=\"lib/adminlte-3.0.4/js/adminlte.min.js\"></script>\n");
      out.write("        <!-- JQuery-Validation -->\n");
      out.write("        <script src=\"lib/jquery-validation-1.19.3/jquery.validate.js\"></script>\n");
      out.write("        <!-- Sweetalert2 -->\n");
      out.write("        <script src=\"lib/sweetalert2-10.0.2/sweetalert2.all.min.js\"></script>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            $(function () {\n");
      out.write("                $(\"#username\").validate();\n");
      out.write("                $(\"#password\").validate();\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <body class=\"hold-transition layout-top-nav\">\n");
      out.write("\n");
      out.write("        <!-- Verificar si hay un usuario activo -->\n");
      out.write("        ");
 HttpSession misession = request.getSession();
            //Chequeo que exista un usuario
            String usuario = (String) request.getSession().getAttribute("username");
            if (usuario == null) {
                //Si no existe un usuario se redirecciona al LOGIN
                response.sendRedirect("loginSinLogin.jsp");
            } else {
                //Existe un usuario 
            }
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"wrapper\">\n");
      out.write("\n");
      out.write("            <!-- BARRA DE NAVEGACION -->\n");
      out.write("\n");
      out.write("            ");
      out.write("<!-- Navbar -->\n");
      out.write("<nav class=\"main-header navbar navbar-expand navbar-dark navbar-primary\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("        \n");
      out.write("        <button class=\"navbar-toggler order-1\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarCollapse\"\n");
      out.write("                aria-controls=\"navbarCollapse\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("            <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("        </button>\n");
      out.write("        <!-- MODULOS -->\n");
      out.write("        <div class=\"collapse navbar-collapse order-3\" id=\"navbarCollapse\">\n");
      out.write("            <ul class=\"navbar-nav\">\n");
      out.write("                <!--Inicio-->\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a href=\"home.jsp\" class=\"nav-link\"><i class=\"fas fa-home\"></i>Inicio</a>\n");
      out.write("                </li>\n");
      out.write("                <!-- Reservas-->\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a href=\"SvReservaList\" class=\"nav-link\"><i class=\"far fa-calendar-alt\"></i>Reservas</a>\n");
      out.write("                </li>\n");
      out.write("                <!-- Huespedes-->\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a href=\"SvHuespedList\" class=\"nav-link\"><i class=\"fas fa-user-check\"></i>Huespedes</a>\n");
      out.write("                </li>\n");
      out.write("                <!--Habitaciones-->\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a href=\"SvHabitacionList\" class=\"nav-link\"><i class=\"fas fa-home\"></i>Habitaciones</a>\n");
      out.write("                </li>\n");
      out.write("                <!-- Tipos de Habitaciones-->\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a href=\"SvTipoList\" class=\"nav-link\"><i class=\"fas fa-hotel\"></i>Tipos</a>\n");
      out.write("                </li>\n");
      out.write("                <!-- Empleados-->\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a href=\"SvEmpleadoList\" class=\"nav-link\"><i class=\"fas fa-users\"></i>Empleados</a>\n");
      out.write("                </li>\n");
      out.write("                <!-- Usuarios-->\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a href=\"SvUsuarioList\" class=\"nav-link\"><i class=\"fas fa-users-cog\"></i>Usuarios</a>\n");
      out.write("                </li>\n");
      out.write("                <!-- Reportes-->\n");
      out.write("                <li class=\"nav-item dropdown\">\n");
      out.write("                    <a id=\"dropdownSubMenu1\" href=\"#\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\"\n");
      out.write("                       class=\"nav-link dropdown-toggle\"><i class=\"fas fa-file-alt\"></i>Reportes</a>\n");
      out.write("                    <ul aria-labelledby=\"dropdownSubMenu1\" class=\"dropdown-menu border-0 shadow\">\n");
      out.write("                        <li><a href=\"reporteDia.jsp\" class=\"dropdown-item\"><i\n");
      out.write("                                class=\"fas fa-calendar-day\"></i> Reservas por día</a></li>\n");
      out.write("                        <li><a href=\"reporteUsuario.jsp\" class=\"dropdown-item\"><i class=\"fas fa-address-card\"></i>\n");
      out.write("                            Reservas por Empleado</a></li>\n");
      out.write("                        <li><a href=\"reporteHuesped.jsp\" class=\"dropdown-item\"><i\n");
      out.write("                                class=\"fas fa-address-card\"></i> Reservas por Huésped</a></li>\n");
      out.write("                        <li><a href=\"reporteDiaGanancia.jsp\" class=\"dropdown-item\"><i class=\"fas fa-chart-bar\"></i>\n");
      out.write("                            Recaudación por día</a></li>\n");
      out.write("                        <li><a href=\"reporteMesGanancia.jsp\" class=\"dropdown-item\"><i\n");
      out.write("                                class=\"fas fa-chart-bar\"></i> Recaudación por rango de fechas</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("                \n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Cerrar Sesion -->\n");
      out.write("        <ul class=\"order-1 order-md-3 navbar-nav navbar-no-expand ml-auto\">\n");
      out.write("            <li class=\"nav-item\">\n");
      out.write("                <a class=\"nav-link\" href=\"index.jsp\" action=\"SvLogout\" method=\"POST\">\n");
      out.write("                    <i class=\"fas fa-power-off\" aria-hidden=\"true\"></i>Cerrar Sesión\n");
      out.write("                </a>\n");
      out.write("            </li>\n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"content-wrapper\">\n");
      out.write("\n");
      out.write("                <!-- CABECERA -->\n");
      out.write("\n");
      out.write("                ");
      out.write("<div class=\"content-header\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"row mb-2\">\n");
      out.write("            <div class=\"col-sm-6\">\n");
      out.write("                <h1 class=\"m-0 text-dark\"><strong>Sistema de Reservas</strong></h1>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-sm-6\">\n");
      out.write("                <ol class=\"breadcrumb float-sm-right\">\n");
      out.write("                    <h1 class=\"m-0 text-dark\"><small>Bienvenido  <strong>");
      out.print( request.getSession().getAttribute("username"));
      out.write("</strong></small></h1>\n");
      out.write("                </ol>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"content\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("\n");
      out.write("                        <!-- Bloque CONTENIDO -->\n");
      out.write("\n");
      out.write("                        <div class=\"container-fluid\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-md-12\">\n");
      out.write("                                    <div class=\"card bg-default\">\n");
      out.write("                                        <h5 class=\"card-header\">\n");
      out.write("                                            Editar Usuario\n");
      out.write("                                        </h5>\n");
      out.write("                                        <div class=\"card-body\">\n");
      out.write("\n");
      out.write("                                            <!-- Redireccionamos al Servlet correspondiente-->\n");
      out.write("                                            <form action=\"SvUsuarioEdit\" method=\"POST\">\n");
      out.write("                                                <input type=\"hidden\" name=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${idUser}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <label for=\"username\">\n");
      out.write("                                                        Nombre de Usuario\n");
      out.write("                                                    </label>\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" id=\"username\" name=\"username\"\n");
      out.write("                                                           value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" minlength=\"4\" autocomplete=\"off\" required>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <label for=\"password\">\n");
      out.write("                                                        Contraseña\n");
      out.write("                                                    </label>\n");
      out.write("                                                    <input type=\"password\" class=\"form-control\" id=\"password\" name=\"password\"\n");
      out.write("                                                           value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pass}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" minlength=\"4\" autocomplete=\"off\" required>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"checkbox\">\n");
      out.write("                                                    <label>\n");
      out.write("                                                        <input type=\"checkbox\" id=\"isJefe\" name=\"isJefe\" value=\"true\"> ¿El usuario es Administrador?\n");
      out.write("                                                    </label>\n");
      out.write("                                                </div> \n");
      out.write("                                                <button type=\"submit\" class=\"btn btn-primary\" value=\"Update\">\n");
      out.write("                                                    <i class=\"fas fa-save\"></i> Actualizar Usuario\n");
      out.write("                                                </button>\n");
      out.write("                                                <a href=\"SvUsuarioList\" class=\"btn btn-danger\">\n");
      out.write("                                                    <i class=\"fas fa-times\"></i> Cancelar\n");
      out.write("                                                </a>\n");
      out.write("                                            </form>\n");
      out.write("                                            </p>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- FIN Bloque CONTENIDO -->\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <!-- Footer -->\n");
      out.write("\n");
      out.write("                ");
      out.write("<div class=\"card-footer\">\n");
      out.write("    <footer class=\"main-footer text-center\">\n");
      out.write("        <strong>Copyright &copy; 2021 <a href=\"home.jsp\">Sistema de Reservas</a>.</strong>\n");
      out.write("        <p>Desarrollado por: Lacheski, Martín Aníbal - Todos los derechos reservados.</p>\n");
      out.write("    </footer>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
