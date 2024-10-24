<%-- 
    Document   : ListarCarreras
    Created on : 16 oct 2024, 16:18:16
    Author     : users
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Listar Carreras - ${facultad.getNombre()}</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <style>
            h1 {
                margin-bottom: 20px;
                color: #333;
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
            <h1 class="text-center">Listado de Carreras - ${facultad.getNombre()}</h1>
            <hr>
            <!-- Tabla de carreras -->
            <div class="table-responsive">
                <table class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th>Nombre de la Carrera</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="car" items="${facultad.getCarreraCollection()}">
                            <tr>
                                <td>${car.getNombre()}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
