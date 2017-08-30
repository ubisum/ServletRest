<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Aggiorna dati</title>
</head>

<body>
<h3><c:out value="${contact.name}"/></h3>
<form action="updateContact" method="post">
  First name:<br>
  <input type="text" name="name" value="<c:out value="${contact.name}"/>"><br>
  Last name:<br>
  <input type="text" name="surname" value="<c:out value="${contact.surname}"/>"><br>
  Telephone:<br>
  <input type="text" name="telephone" value="<c:out value="${contact.telephone}"/>"><br>
  Email:<br>
  <input type="text" name="email" value="<c:out value="${contact.email}"/>"><br>
  <br>
    <input type="hidden" name="contactId" value="<c:out value="${contact.id}"/>">
  <input type="submit" value="Aggiorna">
</form>

</body>
</html>