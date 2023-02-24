<%@ page import="java.util.*" %>
<%@ page import="com.example.javaweb.Mensaje" %>
<%@ page import="com.example.javaweb.MensajeDao" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <title>Mensajes</title>
</head>
<body>
<div class="container" style="width: 30rem;">

    <div class="modal-dialog">
        <div class="modal-content">
            <form action="index.jsp" method="POST">
                <div class="modal-header">
                    <h5 class="modal-title">Crear mensaje</h5>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Ingrese el mensaje</label>
                        <textarea class="form-control" name="mensaje" rows="3"></textarea>
                    </div>
                    <div class="form-group">
                        <label>Autor</label>
                        <input type="text" class="form-control" name="autor">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" name="enviar">Enviar</button>
                </div>
            </form>
        </div>
    </div>
    <%
        MensajeDao mensajeDao = new MensajeDao();

        if (request.getParameter("enviar") != null) {
            Mensaje mensaje = new Mensaje(request.getParameter("mensaje"), request.getParameter("autor"));

            mensajeDao.inserta(mensaje);
        }


    %>

    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Crear mensaje</h5>
            </div>
            <%
                //MensajeDao mensajeDao = new MensajeDao();
                List<Mensaje> mensajes = mensajeDao.seleccionar();
                Collections.reverse(mensajes);

                for (Mensaje mensaje : mensajes) {


            %>
            <div class="modal-body">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title"><%=mensaje.getAutor()%>
                        </h5>

                        <p class="card-text"><%=mensaje.getMensaje()%>
                        </p>
                        <p class="blockquote-footer"><cite><%=mensaje.getFecha()%>
                        </cite></p>
                        <a href="editar.jsp?id=<%=mensaje.getId()%>
                        &&mensaje=<%=mensaje.getMensaje()%>
                        &&autor=<%=mensaje.getAutor()%>"
                           class="card-link" style="text-decoration: none">Editar</a>
                        <a href="eliminar.jsp?id=<%=mensaje.getId()%>" class="card-link" style="text-decoration: none">Eliminar</a>
                    </div>
                </div>
            </div>
            <%}%>
        </div>
    </div>

</div>

</body>
</html>