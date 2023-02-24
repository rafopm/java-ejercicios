<%@ page import="com.example.javaweb.Mensaje" %>
<%@ page import="com.example.javaweb.MensajeDao" %><%--
  Created by IntelliJ IDEA.
  User: rafop
  Date: 23/02/2023
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Eliminar</title>
</head>
<body>
    <%
    String id = request.getParameter("id");
        Mensaje mensaje = new Mensaje(Integer.valueOf(id));
        MensajeDao mensajeDao = new MensajeDao();
        mensajeDao.eliminar(mensaje);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    %>
</body>
</html>
