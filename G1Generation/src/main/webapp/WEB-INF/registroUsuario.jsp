<%--
  Created by IntelliJ IDEA.
  User: pvnnn
  Date: 13-06-2022
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registro</title>
</head>
<body>
    <div>
        <!-- pasar informacion desde la vista a una url (action) -->
        <!-- el method "GET" es por default, los parametros se ven en la ruta -->
        <!-- el method "POST" los parametros no se ven, van ocultos -->
        <form action="/registro/usuario" method="post">
            <label for="nombre"> Nombre: </label>
            <input type="text" id="nombre" name="gato"> <!-- nos sirve para capturar la informacion -->
            <br> <!-- Salto de linea -->
            <label for="apellido"> Apellido: </label>
            <input type="text" id="apellido" name="apellido">
            <br>
            <label for="edad"> Edad: </label>
            <input type="number" id="edad" name="edad">
            <br>
            <input type="submit" value="Registrar"> <!-- vamos agregar un boton, enviar informacion -->
            <input type="button" value="Enviar">  <!-- vamos agregar un boton, este es un boton clickeable-->

        </form>
    </div>
</body>
</html>
