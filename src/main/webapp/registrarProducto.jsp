<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


<%@page import="java.util.*"%>
<%@page import="model.TblProductocl3.*"%>

<title>Registrar Producto</title>


</head>
<body bgcolor="#ce5dec9">

<h1 align="center">Registro de producto</h1>

<h2 align="center"> 
<a href="listaProductos.jsp" style="text-decoration:none ; color:blue;">Volver al Listado</a></h2>
	<form action="ControladorProducto" method="post">
		<table border="2" align="center">
			<tr>
				<td>Nombre</td>
				<td><input type="text" name="nom"></td>
			</tr>
			<tr>
				<td>Precio Venta</td>
				<td><input type="number" name="pv"></td>
			</tr>
			<tr>
				<td>Precio Compra</td>
				<td><input type="number" name="pc"></td>
			</tr>
			<tr>
				<td>Estado</td>
				<td><input type="text" name="estado"></td>
			</tr>
			<tr>
				<td>Descripcion</td>
				<td><input type="text" name="descrip"></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Registrar Producto"></td>
			</tr>
		</table>
	</form>
</body>
</html>