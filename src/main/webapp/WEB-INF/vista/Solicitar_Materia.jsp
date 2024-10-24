<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nueva Materia</title>
        <!-- Incluimos Bootstrap para mejorar el estilo -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container mt-5">
            <h1 class="text-center">Nueva Materia</h1>
            <form action="AgregarMateria" method="post" class="mt-4">
                <div class="form-group">
                    <label for="nombre">Nombre de la Materia:</label>
                    <input type="text" id="nombre" name="nombre" class="form-control" placeholder="Ingrese el nombre de la materia" required>
                </div>
                <div class="text-center">
                    <input type="submit" id="crear" value="Crear" class="btn btn-primary">
                </div>
            </form>
        
            <div class="mt-3 text-center">
                <a href="javascript:window.history.back();" class="btn btn-secondary">&laquo; Volver atrás</a>
                <a href="./index.jsp" class="btn btn-secondary">Volver a la página principal</a>
            </div>
        </div>
        
        <!-- Incluimos jQuery y Bootstrap para funcionalidad -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
