<%--
  Created by IntelliJ IDEA.
  User: pvnnn
  Date: 13-06-2022
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Francisco Javier Pérez Morales</title>
</head>
<body>
<h1>Hola <c:out value="${Nombres}"></c:out>
    <c:out value="${Apellidos}"></c:out>
</h1>

<p><c:out value="${Edad}"></c:out>
</p>


<p><c:out value="${usuario.nombre} ${usuario.apellidos}" ></c:out>
</p>



</body>
</html>
