<%@ page import="com.example.bets_v1.Bet_List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.bets_v1.Connect_PostgreSQL" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 20.05.2023
  Time: 0:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Управление ставками</title>
</head>
<body>
<h2>Управление ставками</h2>
<form action="add_game.jsp">
    <input type="submit" value="Добавить игру">
</form>
<h2>  </h2>
<form action="play_game.jsp">
    <input type="submit" value="Сыграть игру">
</form>
<label>Лист ставок: </label> <br>
<%
    ArrayList<Bet_List> bet_lists = new ArrayList<>();
    bet_lists = Connect_PostgreSQL.getBet_List();
    if(bet_lists != null){
%>
<table>
    <tr>
        <td>bet_id</td>
        <td>Игра</td>
        <td>Игрок</td>
        <td>Ставка</td>
    </tr>
    <%
        for(int i = 0; i < bet_lists.size(); i++){

    %>
    <tr>
        <td><%=bet_lists.get(i).getBet_id()%></td>
        <td><%=bet_lists.get(i).getGame_name()%></td>
        <td><%=bet_lists.get(i).getPlayer_name()%></td>
        <td><%=bet_lists.get(i).getPlayer_amount()%></td>
    </tr>
    <%
        }
    %>
</table>
<%
    }
    else {
%>
<table>Ставок нет</table>
<%
    }

%>
</body>
</html>
