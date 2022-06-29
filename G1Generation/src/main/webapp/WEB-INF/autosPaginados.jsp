<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>Autos</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
            </head>

            <body>
                <div class="container">
                    <!--Formulario de busqueda-->
                    <form action="/auto/buscar" method="post">
                        <label for="marca">Marca:</label>
                        <input type="text" id="marca" name="marca">

                        <input type="submit" class="btn btn-primary">
                    </form>
                    <br>
                    <!-- Paginación-->
                    <c:forEach var="numeroPagina" begin="1" end="${totalPaginas}">
                        <a href="/auto/pagina/${numeroPagina}">${numeroPagina}</a>
                    </c:forEach>
                    <!--Tabla -->
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Marca</th>
                                <th scope="col">Motor</th>
                                <th scope="col">Color</th>
                                <th scope="col">Velocidad</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="auto" items="${autosCapturados.content}">
                                <tr>
                                    <th scope="row">${auto.id}</th>
                                    <td>${auto.marca}</td>
                                    <td>${auto.modelo}</td>
                                    <td>${auto.color}</td>
                                    <td>${auto.velocidad}</td>
                                    <td><a class="btn btn-warning" href="/auto/editar/${auto.id}" role="button">Editar</a></td>
                                    <td><a class="btn btn-danger" href="/auto/eliminar/${auto.id}" role="button">Eliminar</a></td>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <c:if test="${msgAuto != null}">
                        <c:out value="${msgAuto}"></c:out>
                    </c:if>
                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
            </body>

            </html>