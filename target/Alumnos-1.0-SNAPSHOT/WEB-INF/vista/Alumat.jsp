<%-- 
    Document   : Alumat
    Created on : 25/10/2010, 11:51:26
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Alumnos con materias</title>
        <style>
            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }

            th, td {
                padding: 10px;
                text-align: left;
            }

            th {
                background-color: #FC8B0B; 
                color: white;
            }

            tr:nth-child(even) {
                background-color: #f2f2f2;
            }

            #lista {
                border: 1px solid #ddd;
                box-shadow: 2px 2px 12px rgba(0,0,0,0.1);
            }
        </style>
    </head>
    <body>
        <header>
            <h1 class="font_0 text-center">Listado de Alumnos con materias aprobadas</h1>
            <hr>
        </header>

        <main>
            <table id="lista">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Materia</th>
                        <th>Nota</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="a" begin="0" items="${lista}">
                        <tr>
                            <td>${a.getAlumno().getNombre()}&nbsp;&nbsp;</td>
                            <td>${(a.getMateria()).getNombre()}&nbsp;&nbsp;</td>
                            <td>${a.getNota()}&nbsp;&nbsp;</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </main>

        <footer>
            <p class="opcion">© 2024 Sistema Alumnos</p>
        </footer>
    </body>
</html>
