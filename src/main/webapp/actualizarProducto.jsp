<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@page import="model.TblProductocl3"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#ce5dec9">

	<h1 align="center">Actualizar Producto</h1>
	<form action="ControladorProducto" method="post">
		<%
		String id = request.getAttribute("id").toString();
		String nom = (request.getAttribute("nom") != null) ? request.getAttribute("nom").toString() : "";
		String pv = (request.getAttribute("pv") != null) ? request.getAttribute("pv").toString() : "0";
		String pc = (request.getAttribute("pc") != null) ? request.getAttribute("pc").toString() : "0";
		String estado = (request.getAttribute("estado") != null) ? request.getAttribute("estado").toString() : "";
		String descrip = (request.getAttribute("descrip") != null) ? request.getAttribute("descrip").toString() : "";

		if (id != null) {

		}
		%>
		<table border="2" align="center">
			<tr>
				<!-- Atributo para no ver xd type="hidden" -->
				<td>ID</td>
				<td><input type="text" name="id" value="<%=id%>" readonly></td>
			</tr>
			<tr>
				<td>Nombre</td>
				<td><input type="text" name="nom" value="<%=nom%>"></td>
			</tr>
			<tr>
				<td>Precio de venta</td>
				<td><input type="number" name="pv" value="<%=pv%>"></td>
			</tr>
			<tr>
				<td>Precio de compra</td>
				<td><input type="number" name="pc" value="<%=pc%>"></td>
			</tr>
			<tr>
				<td>Estado</td>
				<td><input type="text" name="estado" value="<%=estado%>"></td>
			</tr>
			<tr>
				<td>Descripción</td>
				<td><input type="text" name="descrip" value="<%=descrip%>"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Actualizar Producto"></td>
			</tr>
		</table>

	</form>


</body>
</html>