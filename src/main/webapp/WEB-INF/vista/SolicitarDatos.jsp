<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Nuevo Alumno</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <style>
            body {
                background-color: #f8f9fa;
            }
            .container {
                margin-top: 50px;
                background-color: white;
                padding: 30px;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            h1 {
                color: #333;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Nuevo Alumno</h1>
            <form action="AgregarAlumno" method="post">
                <div class="form-group">
                    <label for="registro">Registro:</label>
                    <input type="text" id="registro" name="registro" class="form-control" required />
                </div>
                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <input type="text" id="nombre" name="nombre" class="form-control" required />
                </div>
                <div class="form-group">
                    <label for="carrera">Carrera:</label>
                    <select id="carrera" name="carrera" class="form-control" required>
                        <option value="">Seleccione carrera</option>
                        <c:forEach var="c" items="${carreras}">
                            <option value="${c.getIdCarrera()}">${c.getNombre()}</option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Crear</button>
            </form>

            <div class="mt-4">
                <a href="javascript:window.history.back();" class="btn btn-secondary">&laquo; Volver atrás</a>
                <a href="./index.jsp" class="btn btn-link">Volver a la página principal</a>
            </div>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
