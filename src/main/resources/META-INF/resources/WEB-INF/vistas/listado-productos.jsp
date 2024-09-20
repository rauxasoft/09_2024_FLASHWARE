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
	<h2>Listado de Productos</h2>
	<table style="width: 100%;">
		<thead>
			<tr>
				<th style="text-align: left;">Código</th>
				<th style="text-align: left;">Fecha de Alta</th>
				<th style="text-align: left;">Nombre</th>
				<th style="text-align: center;">Categoría</th>
				<th style="text-align: right;">Precio</th>
				<th style="text-align: center;">Descatalogado</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="producto" items="${productos}">
			<tr>
				<td>${producto.codigo}</td>
				<td><fmt:formatDate pattern="dd/MM/yyyy" value="${producto.fechaAlta}"/></td>
				<td style="text-align: left;">${producto.nombre}</td>
				<td style="text-align: center;">${producto.categoria}</td>
				<td style="text-align: right;">${producto.precio}</td>
				<td style="text-align: center;">
					<c:if test="${producto.descatalogado}">
						<span style="color:red;">DESCATALOGADO</span>
					</c:if>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>