<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
 	<title>FlashWare</title>
</head>
<body>
	<jsp:include page="nav.jsp"/>
	<h2>Listado de Establecimientos</h2>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Poblacion</th>
				<th>Provincia</th>
				<th>Teléfono</th>
				<th>Email</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="establecimiento" items="${establecimientos}">
			<tr>
				<td>${establecimiento.id}</td>
				<td>${establecimiento.nombre}</td>
				<td>${establecimiento.direccion.poblacion}</td>
				<td>${establecimiento.direccion.provincia}</td>
				<td>${establecimiento.datosContacto.telefonoMovil}</td>
				<td>${establecimiento.datosContacto.email}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>