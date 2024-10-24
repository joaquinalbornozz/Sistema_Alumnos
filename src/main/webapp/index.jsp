


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Alumnos</title>
	<link rel="stylesheet" href="css/vista.css">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<style>
	  .carousel-inner > .item > img,
	  .carousel-inner > .item > a > img {
		  width: 33%;
		  margin: auto;
		  display: inline-block;
	  }
          .cabeza {
            width: 60%;
            min-height: 100%;
            margin: 0 auto;

            }
           .menu {
                display: flex; /* Usamos flexbox para alinear en una sola fila */
                justify-content: center; /* Centra el menú horizontalmente */
                position: absolute ;
                top: 210px;
                padding: 0;
                margin: 0;
                list-style: none; /* Elimina los puntos de lista */
                width: auto;
            }

            .menu li {
                margin: auto; /* Espacio entre los elementos del menú */
            }

            .menu li a {
                font-size: 18px; /* Ajusta el tamaño de letra del menú */
                padding: 10px 20px; /* Espaciado entre los enlaces */
                color: #333; /* Color del texto del menú */
                text-transform: uppercase;
                text-decoration: none;
            }

            .dropdown-menu {
                text-align: left; /* Alinear las subopciones a la izquierda */
            }

	</style>
</head>	
<body style="" class="">
    <div class="cabeza">
	<div style="left: 400px; position: absolute; top: 30px; width: 85px; height: 90px;">
		<img alt="" style="display: block; width: 180px; height: 85px;" src="imagen/humo.png">
	</div>
	
	<div style="left: 372px; width: 241px; position: absolute; top: 115px;">
	<h1  class="font_0">
		<a href="" target="_self">
		<span style="letter-spacing:0.2em;">SISTEMA</span>
		<br>
		<span style="letter-spacing:0.38em;"><font color="#28b2a4">ALUMNOS</font>
		</span></a>
	</h1>
	</div>
	
	<div style="left: 674px; width: 60px; position: absolute; top: 268px; height: 20px;">

	<div style="position:absolute; width:100%; height:100%;">
	<div style="width:20px; height:20px; margin-bottom:0; margin-right:8px; display:inline-block;">
	<a href="">
		<div style="width:20px;height:20px;position:absolute;">
		<img alt="" style="display: block; width: 20px; height: 20px;" src="imagen/facenegro.png">
		</div>
	</a></div>
	<div style="width:20px;height:20px;margin-bottom:0;margin-right:8px;display:inline-block;">
	<a href="">
		<div style="width:20px;height:20px;position:absolute;">
			<img alt="" style="display: block; width: 20px; height: 20px;" src="imagen/twitnegro.png">
		</div>
	</a></div>
	</div>
	</div>
	
        <div class="container-fluid" style="margin-top: 20px;text-align: center">
            <ul class="nav nav-pills menu">
                <li><a href="#">Inicio</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Facultades <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <c:forEach var="facu" items="${facultades}">
                            <li><a href="Facultad?codigoFacu=${facu.getIdFacultad()}">${facu.getNombre()}</a></li>
                        </c:forEach>
                        <li><a href="SolicitarFacultad">Agregar Facultad</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Materias <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="ListarMaterias">Listar Materias</a></li>
                        <li><a href="SolicitarMateria">Agregar Materia</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Carreras <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="ListarCarreras">Listar Carreras</a></li>
                        <li><a href="SolicitarCarrera">Agregar Carrera</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Alumnos <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="ListarAluMat">Alumnos con Materias</a></li>
                        <li><a href="SolicitarDatos">Agregar</a></li>
                        <li><a href="Listar">Listar</a></li>
                        <li><a href="SolicitarMatAlumno">Materias de un Alumno</a></li>
                    </ul>
                </li>
                <li><a href="RindioDocente">Docentes</a></li>
            </ul>
        </div>
    </div>
	
	</div>
	
	<div style="width: 100%; position: absolute; left: 0px; height: 300px; bottom: auto; top: 310px;">
	<div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active" >
        <img src="imagen/imagen1.jpg" alt="Chania" width="460" height="345" style="opacity: 0.6;">
   
        <img src="imagen/imagen2.jpg" alt="Chania" width="460" height="345">
   
        <img src="imagen/imagen3.jpg" alt="Flower" width="460" height="345" style="opacity: 0.6;">
      </div>

      <div class="item">
	    <img src="imagen/imagen2.jpg" alt="Chania" width="460" height="345" style="opacity: 0.6;">
        <img src="imagen/imagen3.jpg" alt="Flower" width="460" height="345">
        <img src="imagen/imagen5.jpg" alt="Flower" width="460" height="345" style="opacity: 0.6;">
      </div>
	  
	  <div class="item">
	    <img src="imagen/imagen3.jpg" alt="Chania" width="460" height="345" style="opacity: 0.6;">
        <img src="imagen/imagen5.jpg" alt="Flower" width="460" height="345">
        <img src="imagen/imagen1.jpg" alt="Flower" width="460" height="345" style="opacity: 0.6;">
      </div>
	  <div class="item">
	    <img src="imagen/imagen5.jpg" alt="Chania" width="460" height="345" style="opacity: 0.6;">
        <img src="imagen/imagen1.jpg" alt="Flower" width="460" height="345">
        <img src="imagen/imagen2.jpg" alt="Flower" width="460" height="345" style="opacity: 0.6;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

	</div>

	<div style="position: absolute; left: 63px; width: 90%; top: 620px;" >
		<p style="text-align: right; line-height: 1.5em;">
		Â© 2020 - Catedra Tecnologias Web -&nbsp;

		<a href="http:www.unsj.edu.ar" target="_blank">
		<span class="color_12">unsj
		</span></a><span class="color_12">&nbsp;</span></p>
	</div>
</body>
</html>	