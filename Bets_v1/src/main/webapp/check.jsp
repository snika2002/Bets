<%@ page import="com.example.bets_v1.Connect_PostgreSQL" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 19.05.2023
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Проверка пользователя</title>
</head>
<body>
<label>Проверка пользователя</label>
<label><%=request.getParameter("player_login")%></label>
<%
    String player_login = request.getParameter("player_login");
    String player_password = request.getParameter("player_password");
    if ((player_login.equals("admin")) && (player_password.equals("admin"))){
        request.getRequestDispatcher("admin_page.jsp").forward(request, response);
    }
    else if(Connect_PostgreSQL.Check_Player(player_login, player_password)){
        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
    else{
        request.setAttribute("message", "Пользователь не найден");
        request.getRequestDispatcher("register.jsp?message=Пользователь не найден").forward(request, response);
    }
%>
</body>
</html>
