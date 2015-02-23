<%--
  Created by IntelliJ IDEA.
  User: Jacobo
  Date: 18/02/2015
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="utf-8">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap-theme.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/font-awesome/font-awesome.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/modificacion.css">
</head>
<body>
    <div class="panel panel-default">
      <div class="panel-heading">
        <h3 class="text-center panel-title">Datos de Usuario</h3>
      </div>
      <div class="panel-body">

        <div class="col-xs-6 col-md-6 col-lg-6">
          <form class="form-horizontal">
            <div class="form-group">
              <p><strong>Nombre: </strong></p><p id="detalleNombreUser">${usuarioDetalles.nombreUsuario}</p>
            </div>
            <div class="form-group">
              <p><strong>Username: </strong></p><p id="detalleUserName">${usuarioDetalles.idUsuario}</p>
            </div>
            <div class="form-group">
              <p><strong>Email: </strong></p><p id="detalleEmailUser">${usuarioDetalles.emailUsuario}</p>
            </div>
            <div class="form-group">
              <p><strong>Estado: </strong></p><p id="detalleEstadoUser">
              <c:choose>
                <c:when test="${usuarioDetalles.estadoUsuario==true}">
                  <i class="fa fa-check-circle"></i>
                </c:when>
                <c:otherwise>
                  <i class="fa fa-times-circle"></i>
                </c:otherwise>
              </c:choose></p>
            </div>

          </form>
        </div>

        <div class="col-xs-6 col-md-6 col-lg-6">
          <h4>Grupos</h4>
          <select multiple class="form-control">
            <c:forEach var="grupo" items="${listaGruposUser}">
              <option>${grupo.descripcionGrupo}</option>
            </c:forEach>
          </select>
        </div>

      </div>
    </div>
</body>
</html>
