<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
 	<title>FlashWare</title>
</head>
<body>
	<jsp:include page="nav.jsp"/>
	<h2>Listado de Pedidos</h2>
	<table style="width: 100%;">
		<thead>
			<tr>
				<th style="text-align: left;">Número</th>
				<th style="text-align: left;">Fecha</th>
				<th style="text-align: left;">Hora</th>
				<th style="text-align: left;">Establecimiento</th>
				<th style="text-align: left;">Técnico Responsable</th>
				<th style="text-align: center;">Estado</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="pedido" items="${pedidos}">
			<tr>
				<td><a href="/app/pedido?numero=${pedido.numero}">${pedido.numero}</a></td>
				<td><fmt:formatDate pattern="dd/MM/yyyy" value="${pedido.fechaHora}"/></td>
				<td><fmt:formatDate pattern="HH:mm" value="${pedido.fechaHora}"/></td>
				<td>${pedido.establecimiento.nombre} (${pedido.establecimiento.direccion.poblacion})</td>
				<td style="text-align: left;">${pedido.tecnico.nombre} ${pedido.tecnico.apellidos}</td>
				<td style="text-align: center;">${pedido.estado}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>