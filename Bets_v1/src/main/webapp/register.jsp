<%@ page import="com.example.bets_v1.Connect_PostgreSQL" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 19.05.2023
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<form action="check_register.jsp">
  <label><%=request.getParameter("message")%></label><br>
  <label>Имя:</label>
  <input type="search" name="player_name"><br>
  <h2>   </h2>
  <label>Логин:</label>
  <input type="search" name="player_login"><br>
  <h2>   </h2>
  <label>Пароль:</label>
  <input type="password" name="player_password"><br>
  <h2>   </h2>
  <label>Лицевой счет:</label>
  <input type="number" name="score"><br>
  <h2>   </h2>
  <input type="submit" value="Зарегистрироваться">
</form>
</body>
</html>
