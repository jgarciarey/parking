<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Parking</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="entradas">Entradas</a></li>
			<li><a href="#">Salidas</a></li>
			<li><a href="vehiculos">Tarifas</a></li>
		</ul>

		<spring:url value="addEntrada"
			var="addEntrada" />
		<button class="btn btn-success navbar-btn"
			onclick="location.href='${addEntrada}'">Add Entrada</button>
	</div>
</nav>