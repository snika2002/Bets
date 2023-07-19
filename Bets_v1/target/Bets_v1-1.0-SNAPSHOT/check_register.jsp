<%@ page import="com.example.bets_v1.Connect_PostgreSQL" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 19.05.2023
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Проверка решистрации</title>
</head>
<body>
<%
  if(Connect_PostgreSQL.Check_Login(request.getParameter("player_login")))
  {
    Connect_PostgreSQL.Insert_Player(request.getParameter("player_name"), request.getParameter("player_login"), request.getParameter("player_password"), Integer.parseInt(request.getParameter("score")));
    request.getRequestDispatcher("login.jsp").forward(request, response);
  }
  else request.getRequestDispatcher("register.jsp?message=Логин занят").forward(request, response);
%>
</body>
</html>