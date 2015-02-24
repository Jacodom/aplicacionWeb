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

        <div class="col-xs-6 col-md-6 col-lg-5 col-lg-offset-1" id="formUserDetalles">
          <c:choose>
            <c:when test="${accion=='C'}">
              <p><strong>Nombre:&nbsp</strong></p><p id="detalleNombreUser"> ${usuarioDetalles.nombreUsuario}</p>
              <p><strong>Username:&nbsp</strong></p><p id="detalleUserName"> ${usuarioDetalles.idUsuario}</p>
              <p><strong>Email:&nbsp</strong></p><p id="detalleEmailUser"> ${usuarioDetalles.emailUsuario}</p>
              <p><strong>Estado:&nbsp</strong></p><p id="detalleEstadoUser">
            </c:when>
            <c:when test="${accion=='M'}">
              <p><strong>Nombre:&nbsp</strong></p><input class="form-control" id="detalleNombreUser" value="${usuarioDetalles.nombreUsuario}">
              <p><strong>Username:&nbsp</strong></p><p class="form-control-static" id="detalleUserName">${usuarioDetalles.idUsuario}</p>
              <p><strong>Email:&nbsp</strong></p><p class="form-control-static" id="detalleEmailUser" >${usuarioDetalles.emailUsuario}</p>
              <p><strong>Estado:&nbsp</strong></p><p id="detalleEstadoUser"></p>
            </c:when>
          </c:choose>

          <c:choose>
            <c:when test="${accion=='C'}">
              <c:choose>
                <c:when test="${usuarioDetalles.estadoUsuario==true}">
                  <i class="fa fa-check-circle"></i>
                </c:when>
                <c:otherwise>
                  <i class="fa fa-times-circle"></i>
                </c:otherwise>
              </c:choose>
            </c:when>
            <c:when test="${accion=='M'}">
              <select>
                <option>Activo</option>
                <option>Inactivo</option>
              </select>
            </c:when>
          </c:choose>

            </div>

            <div class="col-xs-6 col-md-6 col-lg-6">
              <h4>Grupos del usuario</h4>
              <select multiple class="form-control">
                <c:forEach var="grupo" items="${listaGruposUser}">
                  <option>${grupo.descripcionGrupo}</option>
                </c:forEach>
              </select>
              <c:if test="${accion=='M'}">
                <div class="text-center">
                  <div class="btn-group" id="botonesGrupos">
                    <button class="btn btn-success center-block" type="button" id="btnAdd"><i id="iconoAdd" class="fa fa-arrow-up"></i></button>
                    <button class="btn btn-danger center-block" type="button" id="btnDel"><i id="iconoDel" class="fa fa-arrow-down"></i></button>
                  </div>
                </div>


                <h4>Todos los Grupos</h4>
                <select multiple class="form-control">
                  <c:forEach var="grupo" items="${gruposTodos}">
                    <option>${grupo.descripcionGrupo}</option>
                  </c:forEach>
                </select>
                <button class="btn btn-success center-block" type="button" id="btnGuardar"><span>Guardar&nbsp</span><i id="iconoGuardar" class="fa fa-floppy-o"></i></button>
              </c:if>
            </div>

        </div>



      </div>
    </div>

    <c:if test="${accion=='M'}">
      <div class="alert alert-success center-block">
        El usuario ha sido modificado correctamente, continúe modificando usuarios o
        <a href="${pageContext.request.contextPath}/Usuarios/usuario.do">vuelva al inicio.</a>
      </div>

      <div class="alert alert-danger center-block">
        El usuario no ha podido ser modificado. Intente nuevamente.
      </div>
    </c:if>
</body>
</html>
