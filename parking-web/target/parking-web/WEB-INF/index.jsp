<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<body>
	<h1>Entradas Parking</h1>
	<ul>

		<!-- Lista con todos los libros que hay en la base de datos, 
			los saca de la variable libros. -->

		<c:forEach var="entrada" items="${entradas}">
			<li>Matricula: ${entrada.matricula} - Marca: ${entrada.marca} - Fecha entrada: ${entrada.hora_entrada}</li>
		</c:forEach>
	</ul>

</body>