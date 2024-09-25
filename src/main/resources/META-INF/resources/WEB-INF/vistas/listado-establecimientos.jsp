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
	<table style="width: 100%;">
		<thead>
			<tr>
				<th style="text-align: left;">Id</th>
				<th style="text-align: left;">Nombre</th>
				<th style="text-align: left;">Poblacion</th>
				<th style="text-align: left;">Provincia</th>
				<th style="text-align: left;">Teléfono</th>
				<th style="text-align: left;">Móvil</th>
				<th style="text-align: left;">Email</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="establecimiento" items="${establecimientos}">
			<tr>
				<td>${establecimiento.id}</td>
				<td>${establecimiento.nombre}</td>
				<td>${establecimiento.direccion.poblacion}</td>
				<td>${establecimiento.direccion.provincia}</td>
				<td>${establecimiento.datosContacto.telefonoFijo}</td>
				<td>${establecimiento.datosContacto.telefonoMovil}</td>
				<td>${establecimiento.datosContacto.email}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>