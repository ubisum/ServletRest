<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Aggiungi contatto</title>
</head>
<body>

<form method="post" action="AddContact">
  Nome:<br>
  <input type="text" name="name"><br>
  Cognome:<br>
  <input type="text" name="surname"><br>
  Telefono:<br>
  <input type="text" name="telephone"><br>
  Email:<br>
  <input type="text" name="email"><br><br>
  
  <input type="submit" value="Aggiungi">
</form>

</body>
</html>