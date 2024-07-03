<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ingresar al sistema</title>

</head>
<body bgcolor="#ce5dec9">

	<h1 align="center">Ingresar al sistema</h1>

	<form  method="post" action="ControladorUsuario">
		<table border="2" align="center">
			<tr>
				<td>Usuario</td>
				<td><input type="text" name="user"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Ingresar"></td>
			</tr>
		</table>
		<div align="center" style="color: red;">
			<c:if test="${not empty errorMessage}">
            ${errorMessage}
        </c:if>
		</div>
	</form>

</body>
</html>
