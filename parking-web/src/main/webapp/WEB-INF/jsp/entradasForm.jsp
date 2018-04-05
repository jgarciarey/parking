<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>New/Edit Contact</title>
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
		<h2>Nueva Entrada</h2>

		<form:form action="saveEntrada" method="post"
			modelAttribute="entradaDto">
			<form:hidden path="id_entrada" />
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Matricula</label>
				<div class="col-sm-2">
					<form:input class="form-control" path="matricula" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Marca</label>
				<div class="col-sm-2">
					<form:input class="form-control" path="marca" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Color</label>
				<div class="col-sm-2">
					<form:input class="form-control" path="color" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Vehiculo</label>
				<div class="col-sm-2">
					<form:select path="vehiculo" class="selectpicker">
						<form:options items="${tiposVehiculo}" />
					</form:select>
					<%-- <form:input class="form-control" path="id_vehiculo" /> --%>
				</div>
			</div>
			<input type="submit" class="btn btn-primary" value="Save">

		</form:form>
	</div>




</body>
</html>