<%@ page import="com.example.bets_v1.Connect_PostgreSQL" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 19.05.2023
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменить лицевой счет</title>
</head>
<body>
<form action="welcome.jsp"
<%
    if (request.getParameter("message").equals("Пополнить")){

%>
<h2><%=request.getParameter("message")%></h2>
<h2>Пополнение</h2>
<%
        Connect_PostgreSQL.Change_Score(request.getParameter("player_login"), +Integer.parseInt(request.getParameter("score")));
        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
    if(request.getParameter("message").equals("Списать")){
%>
<h2>Списать</h2>
<%
        Connect_PostgreSQL.Change_Score(request.getParameter("player_login"), -Integer.parseInt(request.getParameter("score")));
        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
%>
</body>
</html>
