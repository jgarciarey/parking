<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

	<div class="container">
		<h1>Tarifas</h1>
		<table class="table">
			<thead>
				<tr>
					<th>#</th>
					<th>Tipo de vehiculo</th>
					<th>Tarifa (euros/hora)</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row"><c:forEach var="vehiculo"
							items="${listaVehiculos}">
							<p>
								<c:out value="${vehiculo.id_vehiculo}" />
							<p>
						</c:forEach></th>
					<td><c:forEach var="vehiculo" items="${listaVehiculos}">
							<p>
								<c:out value="${vehiculo.tipo}" />
							<p>
						</c:forEach></td>
					<td><c:forEach var="vehiculo" items="${listaVehiculos}">
							<p>
								<c:out value="${vehiculo.tarifa}" />
							<p>
						</c:forEach></td>
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>