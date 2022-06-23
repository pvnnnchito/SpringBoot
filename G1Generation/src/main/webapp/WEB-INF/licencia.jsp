<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>Auto</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
            </head>

            <body>
                <div class="container">
                    <c:if test="${msgError!= null}">
                        <c:out value="${msgError}"></c:out>
                    </c:if>

                    <form:form action="/licencia/guardar" method="post" modelAttribute="licencia">
                        <form:label path="numero" class="form-label">Numero:</form:label>
                        <form:input path="numero" class="form-control" />
                        <br>
                        <form:label path="fechaVencimiento" class="form-label">Fecha Vencimiento:</form:label>
                        <form:input path="fechaVencimiento" type="date" class="form-control" />
                        <br>
                        <form:label path="clase" class="form-label">Clase:</form:label>
                        <form:input path="clase" class="form-control" />
                        <br>
                        <form:label path="estado" class="form-label">Estado:</form:label>
                        <form:input path="estado" class="form-control" />
                        <br>
                        <!--Usuario OneToOne-->
                        <form:select path="usuario" class="form-select">
                            <form:option value="0">Seleccione un usuario</form:option>
                            <c:forEach items="${listaUsuarios}" var="usuario">
                                <!--lo que explica el if, es que si el usuario no tiene una licencia asociada, la muestra-->
                                <c:if test="${usuario.licencia.id == null}">
                                    <!-- en el value pasamos la primary key (PK)-->
                                    <form:option value="${usuario.id}">${usuario.nombre} ${usuario.apellidos}</form:option>
                                </c:if>
                            </c:forEach>
                        </form:select>
                        <br>
                        <button type="submit" class="btn btn-outline-primary">Guardar Licencia</button>
                    </form:form>
                    <br>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Numero</th>
                                <th scope="col">Fecha de Vencimiento</th>
                                <th scope="col">Clase</th>
                                <th scope="col">Estado</th>
                                <th scope="col">Usuario</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="licencia" items="${listaLicencias}">
                                <tr>
                                    <th scope="row">${licencia.id}</th>
                                    <td>${licencia.numero}</td>
                                    <td>${licencia.fechaVencimiento}</td>
                                    <td>${licencia.clase}</td>
                                    <td>${licencia.estado}</td>
                                    <td>${licencia.usuario.nombre} ${licencia.usuario.apellidos}</td>
                                    <!-- ocupaños LAZY -->
                                    <td><a class="btn btn-warning" href="/auto/editar/${licencia.id}" role="button">Editar</a></td>
                                    <td><a class="btn btn-danger" href="/auto/eliminar/${licencia.id}" role="button">Eliminar</a></td>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                </div>
            </body>

            </html>