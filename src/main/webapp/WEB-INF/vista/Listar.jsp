<%-- 
    Document   : Listar
    Created on : 25/10/2010, 11:51:26
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Listado de Alumnos</title>
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
            <h1 class="text-center">Listado de Alumnos</h1>
            <hr>
            <!-- Tabla de alumnos -->
            <div class="table-responsive">
                <table class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th>Registro</th>
                            <th>Nombre</th>
                            <th>Carrera</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="a" items="${lista}">
                            <tr>
                                <td>${a.getRegistro()}</td>
                                <td>${a.getNombre()}</td>
                                <td>${a.getCarreraidCarrera().getNombre()}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
