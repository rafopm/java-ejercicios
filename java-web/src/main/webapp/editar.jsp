<%@ page import="com.example.javaweb.MensajeDao" %>
<%@ page import="com.example.javaweb.Mensaje" %><%--
  Created by IntelliJ IDEA.
  User: rafop
  Date: 23/02/2023
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <title>Editar mensaje</title>
</head>
<body>

<div class="modal-dialog" style="width: 25rem;">
    <div class="modal-content">
        <form action="editar.jsp" method="POST">
            <div class="modal-header">
                <h5 class="modal-title">Editar mensaje</h5>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <input type="hidden" name="id" value="<%=request.getParameter("id")%>" >
                    <label>Ingrese el mensaje</label>
                    <textarea class="form-control" name="mensaje" rows="3"><%=request.getParameter("mensaje")%></textarea>
                </div>
                <div class="form-group">
                    <label>Autor</label>
                    <input type="text" class="form-control" name="autor" value="<%=request.getParameter("autor")%>">
                </div>
            </div>
            <div class="modal-footer">
                <a href="index.jsp" type="button" class="btn btn-danger">Regresar</a>
                <button type="submit" class="btn btn-primary" name="enviar">Guardar cambios</button>
            </div>
        </form>
    </div>
</div>
<%
    MensajeDao mensajeDao = new MensajeDao();

    String id = request.getParameter("id");

    if (request.getParameter("enviar") != null) {
        Mensaje mensaje = new Mensaje(
                Integer.parseInt(id.trim()),
                request.getParameter("mensaje"), request.getParameter("autor"));

        mensajeDao.editar(mensaje);
    }


%>
</body>
</html>
