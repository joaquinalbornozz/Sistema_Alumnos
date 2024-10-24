<%-- 
    Document   : Docente
    Created on : 23 oct 2024, 15:58:02
    Author     : users
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

        h2 {
            color: #333;
            margin-bottom: 20px;
        }

        select, input[type="submit"] {
            max-width: 300px;
            margin-bottom: 10px;
        }

        .alert {
            margin-top: 20px;
        }

        /* Estilos de tabla */
        table {
            margin-top: 20px;
        }

        th {
            background-color: #FC8B0B;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center font_0">Consultar Materias de Alumno</h2>
        
        <!-- Formulario para seleccionar un docente -->
        <form action="RindioDocente" method="post" class="text-center">
            <select name="docente" class="form-control d-inline-block">
                <option value="">Seleccione un docente</option>
                <c:forEach var="d" items="${docentes}">
                    <option value="${d.getIdDocente()}">${d.getNombre()}</option>
                </c:forEach>    
            </select>
            <input type="submit" value="Buscar" class="btn btn-primary">
        </form>

        <!-- Verificar si hay materias para mostrar -->
        <c:if test="${not empty mha}">
            <h3 class="mt-4 text-center">Materias y Alumnos</h3>
            
            <!-- Tabla para mostrar las materias y los alumnos -->
            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>Materia</th>
                        <th>Alumno</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="mha" items="${mha}">
                        <tr>
                            <td>${mha.getMateria().getNombre()}</td>
                            <td>${mha.getAlumno().getNombre()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>

        <!-- Mensaje en caso de que no haya materias -->
        <c:if test="${empty mha}">
            <div class="alert alert-info text-center">
                No se encontraron materias ni alumnos para el docente seleccionado.
            </div>
        </c:if>
    </div>

    <footer class="text-center mt-4">
        <p class="opcion">© 2024 Tu Aplicación</p>
    </footer>
</body>
</html>
