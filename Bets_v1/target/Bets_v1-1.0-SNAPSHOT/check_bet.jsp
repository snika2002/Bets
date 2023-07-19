<%@ page import="java.sql.Connection" %>
<%@ page import="com.example.bets_v1.Connect_PostgreSQL" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 20.05.2023
  Time: 1:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Проверка ставки</title>
</head>
<body>
<form action="welcome.jsp">
<%
    if(Connect_PostgreSQL.Insert_Bet(request.getParameter("player_login"), Integer.parseInt(request.getParameter("listbox_games")), Integer.parseInt(request.getParameter("amount"))) && request.getParameter("amount") != ""){
        Connect_PostgreSQL.Change_Score(request.getParameter("player_login"), -Integer.parseInt(request.getParameter("amount")));
        response.sendRedirect("welcome.jsp?player_login=" + request.getParameter("player_login"));
        //request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
    else request.getRequestDispatcher("welcome.jsp").forward(request, response);
%>
</form>
</body>
</html>
