<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
 	<title>FlashWare</title>
</head>
<body>
	<jsp:include page="nav.jsp"/>
	<h2>Alta Establecimiento</h2>
	<form:form action="crear-establecimiento" method="POST" modelAttribute="establecimiento">
		<table>
			<tr>
				<th style="text-align: right;">Nombre</th>
				<td><form:input type="text" path="nombre"/></td>
			</tr>
			<tr>
				<th style="text-align: right;">Dirección</th>
				<td><form:input type="text" path="direccion.direccion"/></td>
			</tr>
			<tr>
				<th style="text-align: right;">Población</th>
				<td><form:input type="text" path="direccion.poblacion"/></td>
			</tr>
			<tr>
				<th style="text-align: right;">Código Postal</th>
				<td><form:input type="text" path="direccion.codigoPostal"/></td>
			</tr>
			<tr>
				<th style="text-align: right;">Provincia</th>
				<td><form:input type="text" path="direccion.provincia"/></td>
			</tr>
			<tr>
				<th style="text-align: right;">País</th>
				<td><form:input type="text" path="direccion.pais"/></td>
			</tr>
			 
			<tr>
				<th style="text-align: right;">Teléfono</th>
				<td><form:input type="text" path="datosContacto.telefonoFijo"/></td>
			</tr>
			<tr>
				<th style="text-align: right;">Móvil</th>
				<td><form:input type="text" path="datosContacto.telefonoMovil"/></td>
			</tr>
			<tr>
				<th style="text-align: right;">Email</th>
				<td><form:input type="text" path="datosContacto.email"/></td>
			</tr> 
			<tr>
				<th></th>
				<td><span style="text-align: right;"><input type="submit" value="Alta Establecimiento"/></span></td>
			</tr>
			
		</table>
	</form:form>
</body>
</html>
