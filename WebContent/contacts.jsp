<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<p align="right">Benvenuto, <b><c:out value="${id.username}"/></b></p>
<table style="width:100%">
	<tr>
		<td>
		<b>Nome</b>
		</td>
		
		<td>
		<b>Cognome</b>
		</td>
		
		<td>
		<b>Telefono</b>
		</td>
		
		<td>
		<b>Email</b>
		</td>
		
		<td>
		<b>Azioni</b>
		</td>
	</tr>
	
	<c:forEach var="item" items="${contacts}">
	<tr>
		<td><c:out value="${item.name}" /></td>
		<td><c:out value="${item.surname}" /></td>
		<td><c:out value="${item.telephone}" /></td>
		<td><c:out value="${item.email}" /></td>
		<td>
			<a href="deleteContact?contact=<c:out value="${item.id}" />">Elimina</a>
			<a href="updateContact?contactId=<c:out value="${item.id}"/>">Modifica</a>
		</td>
	</tr>
	</c:forEach>

</table>
<br><br>
<a href="AddContact">Aggiungi contatto</a><br>
<a href="Logout">Logout</a>

</body>
</html>