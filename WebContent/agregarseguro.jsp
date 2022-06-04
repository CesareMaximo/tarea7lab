<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import ="Dominio.seguro" %>
<%@ page import ="Dominio.tipoSeguro" %>
<%@ page import ="Dominio.tipoSeguroDAO" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="index.jsp" > Inicio</a>
<a href="agregarseguro.jsp" > Agregar Seguro</a>
<a href="" > Listar Seguros</a>

<br>
<br>
<br>

<b>Agregar Seguros</b>

<form action="">
Id Seguro:  <br>
Descripcion: <input type="text" name="txtDescripcion"> <br>
Tipo de seguro :<select name"tiposeguro">


<option> Ejemplo </option>

</select>
<br>

Costo contratación: <input type="text"" name="txtContratacion"> <br>
Costo máximo asegurado : <input type="text" name="txtAsegurado"> <br>

<input type="submit" name="btnAceptar"  value="Aceptar" > 

</form>


</body>
</html>