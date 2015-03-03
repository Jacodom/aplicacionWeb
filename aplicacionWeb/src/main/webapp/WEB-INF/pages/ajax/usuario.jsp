<%--
  Created by IntelliJ IDEA.
  User: Jacobo
  Date: 18/02/2015
  Time: 17:06
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
        <h3 class="text-center panel-title">Datos de Usuario</h3>
      </div>

      <div class="panel-body">
        <form:form action="${pageContext.request.contextPath}/Usuarios/modificarUsuario.do" method="POST" modelAttribute="usuarioDetalles" id="formModificarUsuario">
          <div class="col-xs-6 col-md-6 col-lg-5 col-lg-offset-1">

              <c:choose>
                <c:when test="${accion=='C'}">
                  <p><strong>Nombre:&nbsp</strong></p><p id="detalleNombreUser"> ${usuarioDetalles.nombreUsuario}</p>
                  <p><strong>Username:&nbsp</strong></p><p id="detalleUserName"> ${usuarioDetalles.idUsuario}</p>
                  <p><strong>Email:&nbsp</strong></p><p id="detalleEmailUser"> ${usuarioDetalles.emailUsuario}</p>
                  <p><strong>Estado:&nbsp</strong></p><p id="detalleEstadoUser">
                </c:when>
                <c:when test="${accion=='M'}">
                  <p><strong>Nombre:&nbsp</strong></p>
                    <form:input path="nombreUsuario" class="form-control"  id="detalleNombreUser" value="${usuarioDetalles.nombreUsuario}"/>
                  <p><strong>Username:&nbsp</strong></p>
                    <form:input path="idUsuario" class="form-control disabled" disabled="false" id="detalleUserName" value="${usuarioDetalles.idUsuario}"/>
                  <p><strong>Email:&nbsp</strong></p>
                    <form:input path="emailUsuario" class="form-control" id="detalleEmailUser" value="${usuarioDetalles.emailUsuario}"/>
                  <p><strong>Estado:&nbsp</strong></p>
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
                  <div class="col-xs-12 col-md-3 col-lg-6">
                    <form:select class="form-control" path="estadoUsuario">
                      <c:choose>
                        <c:when test="${usuarioDetalles.estadoUsuario==true}">
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
                  <h4>Grupos del usuario</h4>
                  <form:select path="grupos" items="${listaGruposUser}"
                               itemValue="idGrupo"
                               itemLabel="descripcionGrupo" id="gruposUsuario"
                               class="form-control" multiple="multiple">

                  </form:select>

                  <c:if test="${accion=='M'}">
                    <div class="text-center">
                      <div class="btn-group" id="botonesGrupos">
                        <button class="btn btn-success center-block" type="button" id="btnAdd"><i id="iconoAdd" class="fa fa-arrow-up"></i></button>
                        <button class="btn btn-danger center-block" type="button" id="btnDel"><i id="iconoDel" class="fa fa-arrow-down"></i></button>
                      </div>
                    </div>


                    <h4>Todos los Grupos</h4>

                      <c:choose>
                        <c:when test="${empty gruposTodos}">
                          <h3 class="text-center">El usuario tiene todos los grupos posibles.</h3>
                        </c:when>
                        <c:otherwise>
                          <select id="gruposTodos" multiple class="form-control">
                            <c:forEach var="grupo" items="${gruposTodos}">
                              <option value="${grupo.idGrupo}">${grupo.descripcionGrupo}</option>
                            </c:forEach>
                          </select>
                        </c:otherwise>
                      </c:choose>


                    <button class="btn btn-success center-block" type="submit" id="btnGuardar"><span>Guardar&nbsp</span><i id="iconoGuardar" class="fa fa-floppy-o"></i></button>
                  </c:if>

          </div>


        </form:form>
      </div>


</body>
</html>
