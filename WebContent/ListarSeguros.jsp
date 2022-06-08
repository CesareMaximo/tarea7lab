<%@page import="Dominio.seguro"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dominio.tipoSeguro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SEGURO</title>
</head>
<body>

<body>

<a href="Inicio.jsp">Inicio</a>
<a href="servletSeguro?Param=1">Agregar seguro</a>
<a href="servletSeguro?listar=1">Listar seguros</a>

<br>
<br>
<br>

	<div>
		<form action="servletSeguro" method="post">
			Busqueda por tipo de Seguros
			<select name="tipo">
				<% ArrayList<tipoSeguro>lista = null;
					if(request.getAttribute("listaTS") != null){
						lista = (ArrayList<tipoSeguro>) request.getAttribute("listaTS");
					}
					if(lista != null){
						for(tipoSeguro tipo:lista){
							%>
							<option value="<%=tipo.getIdTipo()%>"> <%=tipo.getDescripcion() %></option>
							<%
						}
					}
				%>
			</select>
			<input type="submit" name="btnFiltrar" value="Filtrar"> <br>
		</form>
			<%
				ArrayList<seguro> listaSeg = null;
				if(request.getAttribute("listaSeg")!= null){
					listaSeg = (ArrayList<seguro>) request.getAttribute("listaSeg");
				}
			 %>
			<table border="1">
				<tr> <th>ID seguro</th> <th>Descripcion seguro</th> <th>Descripcion tipo seguro</th> <th>Costo contratacion</th> <th>Costo maximo asegurado</th> </tr>
				<% 
				if(listaSeg !=null)
				for(seguro seg : listaSeg){
				%>
				<tr> 
					<td><%=seg.getIdSeguro() %></td>
					<td><%=seg.getDescripcion() %></td>
					<td><%=seg.getIdTipo().getDescripcion() %></td>
					<td><%=seg.getCostoContratacion() %></td>
					<td><%=seg.getCostoAsegurado() %></td>
				<%} %>
				</tr>
			</table>
	</div>

</body>
</html>