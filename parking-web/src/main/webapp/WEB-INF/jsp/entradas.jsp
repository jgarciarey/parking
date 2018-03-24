<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>Parking</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	<%@ include file="menu.jsp"%>

	<%-- 	<div>
		<h3>Plazas Totales: ${plazasTotales}</h3>
		<h3>Plazas Disponibles: ${plazasDisponibles}</h3>
		<h3>Plazas Ocupadas: ${plazasOcupadas}</h3>
	</div> --%>
	<div class="container">

		<h1>All Entradas</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>#</th>
					<th>Matricula</th>
					<th>Marca</th>
					<th>Color</th>
					<th>Hora Entrada</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="entrada" items="${listaEntradas}">
					<tr>
						<td>${entrada.id_entrada}</td>
						<td>${entrada.matricula}</td>
						<td>${entrada.marca}</td>
						<td>${entrada.color}</td>
						<td>${entrada.hora_entrada}</td>
						<td><spring:url value="deleteEntrada/${entrada.matricula}"
								var="deleteEntrada" /> <spring:url
								value="editEntrada/${entrada.matricula}" var="editEntrada" />

							<button class="btn btn-danger"
								onclick="location.href='${deleteEntrada}'">
								<span class="glyphicon glyphicon-trash"></span>
							</button>

							<button class="btn btn-primary"
								onclick="location.href='${editEntrada}'">
								<span class="glyphicon glyphicon-pencil"></span>
							</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>



	</div>

</body>
</html>