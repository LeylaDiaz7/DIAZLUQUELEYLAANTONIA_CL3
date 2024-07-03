<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@page import="java.util.List"%>
<%@page import="model.TblProductocl3"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de Productos</title>

<style>
    .tabla-header {
        background-color: #6699CC;
        color: black;
        font-weight: bold;
    }
    
    .tabla-productos {
        margin: 20px auto;
        border: 2px solid #000;
        border-collapse: collapse;
        width: 80%;
        text-align: center;
    }
    
</style>

</head>

<body bgcolor="#ce5dec9">

<h1 align="center">Listado de productos</h1>

<h2 align="center"> 
<a href="registrarProducto.jsp" style="text-decoration:none ; color:blue;">Registrar Producto</a></h2>
<h2 align="center"> <a href="index.jsp" style="text-decoration:none ; color:blue;">Volver al Index</a>
</h2>

<table class="tabla-productos" border="2" align="center">

		<tr class="tabla-header">
			<td>ID</td>
			<td>NOMBRE</td>
			<td>PRECIO VENTA</td>
			<td>PRECIO COMPRA</td>
			<td>ESTADO</td>
			<td>DESCRIPCIÓN</td>
			<td colspan="2" align="center">ACCIONES</td>
		</tr>

		<%
		List<TblProductocl3> listadoProductos=(List<TblProductocl3>)request.getAttribute("listadoProductos");
		//aplicamos una condicion..

		if (listadoProductos != null) {

			//aplicamos un bucle for..

			for (TblProductocl3 lis : listadoProductos) {
			%>
			<tr>
				<td><%=lis.getIdproductoscl3()%></td>
				<td><%=lis.getNombrecl3()%></td>
				<td><%=lis.getPrecioventacl3()%></td>
				<td><%=lis.getPreciocompcl3()%></td>
				<td><%=lis.getEstadocl3()%></td>
				<td><%=lis.getDescripcl3()%></td>
				<td><a href="ControladorProducto?accion=Eliminar&id=<%=lis.getIdproductoscl3()%>">
				<img src="Eliminar.png" style="width: 25px; height: 25px;">Eliminar</a></td>
				<td><a href="ControladorProducto?accion=Modificar&id=<%=lis.getIdproductoscl3()%>">
				<img src="Actualizar.png" style="width: 25px; height: 25px;">Actualizar</a></td>
			</tr>
			<%
			} //fin del bucle for...
			%>
			<%
		} //fin de la condicion ...
		%>
	</table>
	
</body>
</html>
