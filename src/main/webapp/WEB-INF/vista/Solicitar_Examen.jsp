<%-- 
    Document   : Solicitar_Examen
    Created on : 24 oct 2024, 14:30:04
    Author     : users
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Solicitar Examen</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f0f0f0;
        }
        .form-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top: 30px;
        }
        h2 {
            color: #333;
        }
        .form-control {
            margin-bottom: 15px;
        }
        .btn-primary {
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="form-container">
            <h2 class="text-center">Registrar Examen</h2>
            <form action="AgregarExamen" method="post">
                <div class="form-group">
                    <label for="alu">Seleccione Alumno:</label>
                    <select name="alu" id="alu" class="form-control" required>
                        <c:forEach var="alumno" items="${alumnos}">
                            <option value="${alumno.getIdAlumno()}">${alumno.getNombre()}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="mat">Seleccione Materia:</label>
                    <select name="mat" id="mat" class="form-control" required>
                        <c:forEach var="materia" items="${materias}">
                            <option value="${materia.getIdMateria()}">${materia.getNombre()}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="nota">Nota del Examen:</label>
                    <input type="number" step="0.1" name="nota" id="nota" class="form-control" required>
                </div>

                <div class="form-group">
                    <label for="fecha">Fecha del Examen:</label>
                    <input type="date" name="fecha" id="fecha" class="form-control" required>
                </div>

                <button type="submit" class="btn btn-primary btn-block">Registrar Examen</button>
            </form>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
