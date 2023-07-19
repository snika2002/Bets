<%@ page import="com.example.bets_v1.Connect_PostgreSQL" %>
<%@ page import="java.time.LocalDateTime" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 20.05.2023
  Time: 0:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Проверка игры</title>
</head>
<body>
<%
    if((request.getParameter("game_name") != "") && (request.getParameter("date") != "")){
        Connect_PostgreSQL.Insert_Game(request.getParameter("game_name"), LocalDateTime.parse(request.getParameter("date")));
        response.sendRedirect("admin_page.jsp");
        //request.getRequestDispatcher("admin_page.jsp?game_name=&date=").forward(request, response);
    }
    else request.getRequestDispatcher("add_game.jsp").forward(request, response);
%>
</body>
</html>
