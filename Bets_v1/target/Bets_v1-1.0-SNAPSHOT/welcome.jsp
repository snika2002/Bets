<%@ page import="com.example.bets_v1.Player" %>
<%@ page import="com.example.bets_v1.Connect_PostgreSQL" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.bets_v1.Game" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 19.05.2023
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Личный Кабинет</title>
</head>
<body>
<%
    Player player = Connect_PostgreSQL.getPlayer(request.getParameter("player_login"));
%>
<h1>Привет, <%=player.getPlayer_name()%>.</h1>
<h1>Не хочешь сделать ставку?</h1>
<h3>Лицевой счет: <%=player.getScore()%></h3>
<h1>   </h1>
<form action="check_bet.jsp">
    <h2>Сделать ставку: </h2>
    <label>Выберите игру: </label>
    <select name="listbox_games">
        <%
            ArrayList<Game> games = Connect_PostgreSQL.getGames();
            if(games == null){


        %>
        <option value="<%="0"%>"><%="Нет доступных игр для ставок"%></option>
        <%
            }
            else for (int i = 0; i < games.size(); i++){
        %>
        <option value="<%=games.get(i).getGame_id()%>"><%=games.get(i).getGame_name()%></option>
        <%
                }
        %>
    </select><br>
    <h2>   </h2>
    <label>Сумма:      </label>
    <input type=number name="amount"><br>
    <h2>   </h2>
    <input type="hidden" name="player_login" value=<%=player.getPlayer_login()%>>
    <input type="submit" value="Сделать ставку">
</form>
<h1>  </h1>
<form action="changescore.jsp">
    <input type="hidden" name="player_login" value=<%=player.getPlayer_login()%>>
    <input type="hidden" name="message" value="Пополнить">
    <input type="submit" value="Пополнить лицевой счет">
</form>
<h2>   </h2>
<form action="changescore.jsp">
    <input type="hidden" name="player_login" value=<%=player.getPlayer_login()%>>
    <input type="hidden" name="message" value="Списать">
    <input type="submit" value="Списать с лицевого счета">
</form>
</body>
</html>
