<%@ page import="com.example.bets_v1.Connect_PostgreSQL" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 20.05.2023
  Time: 2:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Игра</title>
</head>
<body>
<%
    if ((request.getParameter("listbox_games") != "") && (request.getParameter("ratio") != "")) {
        Connect_PostgreSQL.Play(Integer.parseInt(request.getParameter("listbox_games")), Integer.parseInt(request.getParameter("ratio")));
        response.sendRedirect("admin_page.jsp");
    }
    else request.getRequestDispatcher("play_game.jsp").forward(request, response);
%>
</body>
</html>
