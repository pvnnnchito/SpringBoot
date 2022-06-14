<%--
  Created by IntelliJ IDEA.
  User: pvnnn
  Date: 13-06-2022
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- capturar el objeto completo y traspasar el objeto completo -->

<html>
<head>
    <title>Registro</title>
</head>
<body>
<div>
    <c:if test="${msgError != null }">
        <c:out value="${msgError}"></c:out>
    </c:if>

    <%--@elvariable id="usuario" type="com.g1generation.models.Usuario"--%>
    <form:form action="/registro/usuario" method="post" modelAttribute="usuario">
        <form:label path="nombre"> Nombre:</form:label>
        <form:input  path="nombre"/>
        <br>
        <form:label path="apellidos">Apellido:</form:label>
        <form:input path="apellidos"/>
        <br>
        <form:label path="edad">Edad:</form:label>
        <form:input type="number" path="edad"/>
        <br>
        <input type="submit" value="Registrar">



    </form:form>


</div>
</body>
</html>
