<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Materias de Alumno</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f0f0f0;
        }
        h2, h3 {
            color: #333;
        }
        .form-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top: 30px;
        }
        .table-container {
            margin-top: 20px;
        }
        th {
            background-color: #FC8B0B;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        .form-control {
            max-width: 300px;
            margin: 0 auto;
        }
        .btn-primary {
            margin-top: 10px;
        }
        p {
            color: #555;
        }
    </style>
</head>
<body>
    <div class="container">
        <!-- Formulario de búsqueda -->
        <div class="form-container">
            <h2 class="text-center">Consultar Materias de Alumno</h2>
            <form action="SolicitarMatAlumno" method="post" class="text-center">
                <input type="text" name="numeroRegistro" placeholder="Ingrese número de registro" 
                       class="form-control" required>
                <input type="submit" value="Buscar" class="btn btn-primary">
            </form>
        </div>

        <!-- Resultado de búsqueda: Materias -->
        <div class="table-container">
            <c:if test="${not empty materias}">
                <h3>Materias cursadas de ${alumno.getNombre()}:</h3>
                <p>Total materias encontradas: ${materias.size()}</p>
                <table class="table table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>Materia</th>
                            <th>Nota</th>
                            <th>Fecha</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="materia" items="${materias}">
                            <tr>
                                <td>${(materia.getMateria()).getNombre()}</td>
                                <td>${materia.getNota()}</td>
                                <td><fmt:formatDate value="${(materia.getMateriaHasAlumnoPK()).getFecha()}" pattern="dd/MM/yyyy" /></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>

            <!-- Mensaje si no se encuentran materias -->
            <c:if test="${empty materias}">
                <p class="text-center">No se encontraron materias para este alumno.</p>
            </c:if>
            <c:if test="${!error.trim().isEmpty()}">
                <p class="text-center" style="color:red">${error}</p>
            </c:if>
        </div>
    </div>

    <!-- Scripts de Bootstrap -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
