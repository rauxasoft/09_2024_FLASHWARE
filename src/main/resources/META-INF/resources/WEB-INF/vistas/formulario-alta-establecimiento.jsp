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
	<h2>Alta Establecimiento</h2>
	<form action="" method="POST">
		<table>
			<tr>
				<th style="text-align: right;">Nombre</th>
				<td><input type="text" name="nombre"/></td>
			</tr>
			<tr>
				<th style="text-align: right;">Dirección</th>
				<td><input type="text" name="direccion"/></td>
			</tr>
			<tr>
				<th style="text-align: right;">Población</th>
				<td><input type="text" name="poblacion"/></td>
			</tr>
			<tr>
				<th style="text-align: right;">Código Postal</th>
				<td><input type="text" name="codigoPostal"/></td>
			</tr>
			<tr>
				<th style="text-align: right;">Provincia</th>
				<td><input type="text" name="provincia"/></td>
			</tr>
			<tr>
				<th style="text-align: right;">País</th>
				<td><input type="text" name="pais"/></td>
			</tr>
			<tr>
				<th style="text-align: right;">Teléfono</th>
				<td><input type="text" name="telefono"/></td>
			</tr>
			<tr>
				<th style="text-align: right;">Móvil</th>
				<td><input type="text" name="movil"/></td>
			</tr>
			<tr>
				<th style="text-align: right;">Email</th>
				<td><input type="text" name="email"/></td>
			</tr>
			<tr>
				<th></th>
				<td><span style="text-align: right;"><input type="submit" value="Alta Establecimiento"/></span></td>
			</tr>
		</table>
	</form>
</body>
</html>