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
	<h2>Pedido ${pedido.numero}</h2>
	<table>
		<tr>
			<th>Número</th>
			<td>${pedido.numero}</td>
		</tr>
		<tr>
			<th>Fecha</th>
			<td><fmt:formatDate pattern="dd/MM/yyyy" value="${pedido.fechaHora}"/></td>
		</tr>
		<tr>
			<th>Hora</th>
			<td><fmt:formatDate pattern="HH:mm" value="${pedido.fechaHora}"/></td>
		</tr>
		<tr>
			<th>DNI Técnico</th>
			<td>${pedido.tecnico.DNI}</td>
		</tr>
		<tr>
			<th>Nombre Completo</th>
			<td>${pedido.tecnico.nombre} ${pedido.tecnico.apellidos}</td>
		</tr>
		<tr>
			<th>Detalle del Pedido</th>
			<td>
				<table>
					<thead>
						<tr>
							<th>Código Producto</th>
							<th>Producto</th>
							<th>Cantidad</th>
							<th>Precio</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="linea" items="${pedido.lineas}">
							<tr>
								<td>${linea.producto.codigo}</td>
								<td>${linea.producto.nombre}</td>
								<td>${linea.cantidad}</td>
								<td>${linea.precio}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>