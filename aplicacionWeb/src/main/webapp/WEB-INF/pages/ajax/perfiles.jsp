<%--
  Created by IntelliJ IDEA.
  User: Jacobo
  Date: 03/03/2015
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="utf-8">
  <title>::. Perfiles</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap-theme.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/font-awesome/font-awesome.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/modificacion.css">
  <script src="${pageContext.request.contextPath}/js/detallesPerfil.js"></script>
</head>
<body>
<div class="table-responsive">
  <table class="table table-bordered table-hover" id="tableP">
    <thead>
    <tr>
      <th>ID</th>
      <th>Grupo</th>
      <th>Formulario</th>
      <th>URL</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="perfil" items="${listaPerfiles}">
      <tr>
        <td><c:out value="${perfil.idPerfil}"></c:out></td>
        <td><c:out value="${perfil.grupo.descripcionGrupo}"></c:out></td>
        <td><c:out value="${perfil.formulario.nombreFormulario}"></c:out></td>
        <td><c:out value="/${perfil.formulario.urlFormulario}"></c:out></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
<div id="detalles"></div>
</body>
</html>
