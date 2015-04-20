<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Jacobo
  Date: 17/02/2015
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>::. Usuarios</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap-theme.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/font-awesome/font-awesome.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/modificacion.css">
  <script src="${pageContext.request.contextPath}/js/detallesUsuario.js"></script>
  <script src="${pageContext.request.contextPath}/js/eliminarUsuario.js"></script>
</head>
<body>
    <div class="table-responsive">
      <table class="table table-bordered table-hover" id="tableU">
        <thead>
        <tr class="text-center">
          <th>Nombre</th>
          <th>Username</th>
          <th>Email</th>
          <th class="text-center">Estado</th>
          <c:if test="${accion=='B'}">
            <th>Eliminar</th>
          </c:if>
        </tr>
        </thead>
        <tbody>
          <c:forEach var="usuario" items="${listaUsuarios}">
            <tr>
              <td class="infoP"><c:out value="${usuario.nombreUsuario}"></c:out></td>
              <td class="infoP"><c:out value="${usuario.idUsuario}"></c:out></td>
              <td class="infoP"><c:out value="${usuario.emailUsuario}"></c:out></td>
              <td class="infoP text-center">
                <c:choose>
                  <c:when test="${usuario.estadoUsuario==true}">
                    <i class="fa fa-check-circle"></i>
                  </c:when>
                  <c:otherwise>
                    <i class="fa fa-times-circle"></i>
                  </c:otherwise>
                </c:choose>
              </td>
              <c:if test="${accion=='B'}">
                <td>
                  <div class="text-center">
                    <a href="#confirmarModal" data-toggle="modal" data-target="#confirmarModal" class="btn btn-danger btn-sm text-center" data-usuario-id=${usuario.idUsuario}><i class="fa fa-times"></i></a>
                  </div>
                </td>
              </c:if>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>


    <!-- modal -->
    <form  id="formEliminar" action="${pageContext.request.contextPath}/Usuarios/eliminarUsuario.do" method="post">
      <div class="modal fade" id="confirmarModal">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Cerrar</span></button>
              <h4 class="modal-title text-center">Eliminar Usuario</h4>
            </div>
            <div class="modal-body">
              <div id="mensajeModal" class="text-center">
                <h3>¿Realmente desea eliminar el usuario seleccionado?&nbsp</h3>
                <i id="iconoAceptar"></i>
                <p name="usuarioID" id="usuarioID"><p>
              </div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-success" value="Eliminar" id="aceptarModal"></button>
              <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
            </div>
          </div>
        </div>
      </div>
    </form>


<div id="detalles">

</div>
</body>
</html>
