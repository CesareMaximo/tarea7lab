<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import ="Dominio.seguro" %>
<%@ page import ="Dominio.tipoSeguro" %>
<%@ page import ="Dominio.tipoSeguroDAO" %>

<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="Inicio.jsp">Inicio</a>
<a href="servletSeguro?Param=1">Agregar seguro</a>
<a href="servletSeguro?listar=1">Listar seguros</a>

<br>
<br>
<br>

<h1>Agregar seguros</h1>

<%  int id=0;
	if(request.getAttribute("proxID")!=null)
	{
		 id = (int)request.getAttribute("proxID");
		
	}%>

<form method="post" action="servletSeguro">


<table border=0 >
<tr> <td> Id Seguro </td> <td><%=id%> </td> </tr>
<tr> <td> Descripcion </td> <td> <input type="text" name="txtDescripcion" required/> </td> </tr>
<tr> <td>Tipo de seguro</td>  <td>  <select name="tipoSeguro">

<% ArrayList<tipoSeguro> listaTipos = null;
	if(request.getAttribute("listaTS")!=null)
	{
		listaTipos = (ArrayList<tipoSeguro>) request.getAttribute("listaTS");
	}
	
	  if(listaTipos!=null)
		for(tipoSeguro tipo : listaTipos) 
		{ %>
			<option value="<%=tipo.getIdTipo()%>"><%=tipo.getDescripcion()%></option>
		<% 
		}
	%>

	</select> </td> </tr> 
<tr> <td>Costo contratacíon </td> <td> <input type="number" name="txtCContratacion" required/> </td></tr>
<tr><td>Costo máximo asegurado</td><td> <input type="number" name="txtMaximoAseg" required/> </td></tr>
<tr><td></td><td><input type="submit" name="btnAceptar" value="Aceptar"></td></tr>
</table>
</form>


<%
	boolean insert = false;
	if(request.getAttribute("insert")!=null)
		insert = (boolean)request.getAttribute("insert");	
%>

<%
if(insert == true) 
	{
%>
		Seguro agregado con éxito.
<%} %>

</body>
</html>