<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Respuesta de Alta de Usuario</title>
    </head>
    <body>
        <h1>Ingresó los siguientes datos:</h1>
        <p>Nombre de Usuario: <%= session.getAttribute("username")%></p>
        <p>Password: <%= session.getAttribute("password")%></p>
        <p>Es Administrador: <%= session.getAttribute("isJefe")%></p>
    </body>
</html>
