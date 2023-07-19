<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 19.05.2023
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменить лицевой счет</title>
</head>
<body>
<%
    if (request.getParameter("message").equals("Пополнить")){
%>
<form action="change_score.jsp">
    <h2>Пополнить лицевой счет</h2>
    <input type="hidden" name="message" value="Пополнить">
    <input type="hidden" name="player_login" value=<%=request.getParameter("player_login")%>>
    <input type="number" name="score"><br>
    <h2>   </h2>
    <input type="submit" value="Пополнить">
</form>
    <%
    }
    else if (request.getParameter("message").equals("Списать")){
    %>
<form action="change_score.jsp?">
    <h2>Списать с лицевого счета</h2>
    <input type="hidden" name="message" value="Списать">
    <input type="hidden" name="player_login" value=<%=request.getParameter("player_login")%>>
    <input type="number" name="score"><br>
    <h2>   </h2>
    <input type="submit" value="Списать">
    <%
        }
    %>
</form>
</body>
</html>
