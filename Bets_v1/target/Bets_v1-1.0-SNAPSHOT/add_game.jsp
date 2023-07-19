<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 20.05.2023
  Time: 0:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить игру</title>
</head>
<body>
<h2>Добавить игру</h2>
<form action="check_game.jsp">
    <label>Введите название: </label>
    <input type="text" name="game_name"><br>
    <h2>   </h2>
    <label>Дата проведения: </label>
    <input type="datetime-local" name="date"><br>
    <h2>   </h2>
    <input type="submit" value="Добавить игру">
</form>
</body>
</html>
