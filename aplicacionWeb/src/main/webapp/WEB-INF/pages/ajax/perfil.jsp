<%--
  Created by IntelliJ IDEA.
  User: Jacobo
  Date: 03/03/2015
  Time: 23:31
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
</head>
<body>
  <div class="panel panel-default">
    <div class="panel-heading">
      <h3 class="text-center panel-title">Detalles de Perfil</h3>
    </div>

    <div class="panel-body">
      <div class="col-xs-6 col-md-6 col-lg-5 col-lg-offset-1">
        <p><strong>Grupo:&nbsp</strong></p><p id="detalleGrupoPerfil"> ${perfilDetalles.grupo.descripcionGrupo}</p>
        <select multiple="multiple" class="form-control" id="usuariosGrupo">
          <c:forEach var="usuario" items="${perfilDetalles.grupo.usuarios}">
            <option value="${usuario.idUsuario}">${usuario.nombreUsuario}</option>
          </c:forEach>
        </select>
      </div>
      <div class="col-xs-12 col-md-3 col-lg-6">
        <p><strong>Formulario habilitado:&nbsp</strong></p><p id="formulario"> ${perfilDetalles.formulario.nombreFormulario}</p>
        <p><strong>Descripción:&nbsp</strong></p>
        <textarea class="form-control" rows="5" id="descripcionFormulario"> ${perfilDetalles.formulario.descripcionFormulario}</textarea>
      </div>
    </div>
  </div>
</body>
</html>
