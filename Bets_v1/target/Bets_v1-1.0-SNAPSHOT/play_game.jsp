<%@ page import="com.example.bets_v1.Game" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.bets_v1.Connect_PostgreSQL" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 20.05.2023
  Time: 0:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Сыграть игру</title>
</head>
<body>
<form action="play.jsp">
    <label>Выберите игру: </label><br>
    <select name="listbox_games">
        <%
            ArrayList<Game> games = Connect_PostgreSQL.getGames();
            if(games == null){


        %>
        <option value="<%="0"%>"><%="Нет доступных игр"%></option>
        <%
        }
        else for (int i = 0; i < games.size(); i++){
        %>
        <option value="<%=games.get(i).getGame_id()%>"><%=games.get(i).getGame_name()%></option>
        <%
                }
        %>
    </select><br>
    <label>Коэффициент: </label>
    <input type="number" name="ratio">
    <input type="submit" value="Играть">
</form>
</body>
</html>
