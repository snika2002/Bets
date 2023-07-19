<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Добро пожаловать!</title>
</head>
<body>
<h1><%= "Добро пожаловать!" %></h1>
<br/>
<form action="login.jsp">
  <input type="submit" value="Войти в систему">
</form>
<h2>   </h2>
<form action="register.jsp" method="post">
  <input type="hidden" name="message" value=" ">
  <input type="submit" value="Зарегестрироваться">
</form>
</body>
</html>