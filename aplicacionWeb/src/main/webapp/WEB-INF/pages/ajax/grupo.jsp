<%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 09/03/2015
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap-theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/font-awesome/font-awesome.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/modificacion.css">
    <script src="${pageContext.request.contextPath}/js/modificarUsuario.js"></script>
</head>
<body>
      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="text-center panel-title">Datos de Grupo</h3>
        </div>

          <div class="panel-body">
          <form:form action="${pageContext.request.contextPath}/Grupos/modificarGrupo.do" method="POST" modelAttribute="grupoDetalle" id="formModificarGrupo">
            <div class="col-xs-6 col-md-6 col-lg-5 col-lg-offset-1">

            <c:choose>
              <c:when test="${accion=='C'||accion=='B'}">
                <p><strong>Código:&nbsp</strong></p><p id="detalleIdGrupo"> ${grupoDetalle.idGrupo}</p>
                <p><strong>Nombre:&nbsp</strong></p><p id="detalleDescripcionGrupo"> ${grupoDetalle.descripcionGrupo}</p>
                <p><strong>Estado:&nbsp</strong></p><p id="detalleEstadoGrupo">
              </c:when>
              <c:when test="${accion=='M'}">
                <p><strong>Código:&nbsp</strong></p>
                <form:input path="idGrupo" class="form-control"  id="detalleIdGrupo" value="${grupoDetalle.idGrupo}"/>
                <p><strong>Nombre:&nbsp</strong></p>
                <form:input path="descripcionGrupo" class="form-control disabled" disabled="false" id="detalleDescripcionGrupo" value="${grupoDetalle.descripcionGrupo}"/>
                <p><strong>Estado:&nbsp</strong></p>
              </c:when>
            </c:choose>
              <!-- Estado -->
            <c:choose>
              <c:when test="${accion=='C'||accion=='B'}">
                <c:choose>
                  <c:when test="${grupoDetalle.estadoGrupo==true}">
                    <i class="fa fa-check-circle"></i>
                  </c:when>
                  <c:otherwise>
                    <i class="fa fa-times-circle"></i>
                  </c:otherwise>
                </c:choose>
              </c:when>
              <c:when test="${accion=='M'}">
                <div class="col-xs-12 col-md-3 col-lg-6">
                  <form:select class="form-control" path="estadoGrupo">
                    <c:choose>
                      <c:when test="${  grupoDetalle.estadoGrupo==true}">
                        <form:option value="true" selected="true">Activo</form:option>
                        <form:option value="false">Inactivo</form:option>
                      </c:when>
                      <c:otherwise>
                        <form:option value="true">Activo</form:option>
                        <form:option value="false" selected="true">Inactivo</form:option>
                      </c:otherwise>
                    </c:choose>
                  </form:select>
                </div>
              </c:when>
            </c:choose>
            </div>

            <div class="col-xs-6 col-md-6 col-lg-6">
              <h4>Usuarios del grupo</h4>
              <form:select path="usuarios" items="${listaUsuariosGrupo}"
                           itemValue="idUsuario"
                           itemLabel="nombreUsuario" id="usuarioGrupo"
                           class="form-control" multiple="multiple">

              </form:select>

              <c:if test="${accion=='M'}">
                <div class="text-center">
                  <div class="btn-group" id="botonesGrupos">
                    <button class="btn btn-success center-block" type="button" id="btnAdd"><i id="iconoAdd" class="fa fa-arrow-up"></i></button>
                    <button class="btn btn-danger center-block" type="button" id="btnDel"><i id="iconoDel" class="fa fa-arrow-down"></i></button>
                  </div>
                </div>


                <h4>Todos los Usuarios</h4>

                <c:choose>
                  <c:when test="${empty usuariosTodos}">
                    <h3 class="text-center">El grupo tiene todos los usuarios posibles.</h3>
                  </c:when>
                  <c:otherwise>
                    <select id="usuariosTodos" multiple class="form-control">
                      <c:forEach var="usuario" items="${usuariosTodos}">
                        <option value="${usuario.idUsuario}">${usuario.nombreUsuario}</option>
                      </c:forEach>
                    </select>
                  </c:otherwise>
                </c:choose>


                <button class="btn btn-success center-block" type="submit" id="btnGuardar"><span>Guardar&nbsp</span><i id="iconoGuardar" class="fa fa-floppy-o"></i></button>
              </c:if>

            </div>


          </form:form>
         </div>
      </div>
</body>
</html>
