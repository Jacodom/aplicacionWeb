<%@ page import="com.model.Grupo" %>
<%--
  Created by IntelliJ IDEA.
  User: Jacobo
  Date: 03/02/2015
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>::. Panel de Usuario</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap-theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/font-awesome/font-awesome.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/modificacion.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>

</head>
<body>
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" data-target="#navBarCollapse" data-toggle="collapse" class="navbar-toggle">
            <span class="sr-only">Toggle Navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a href="#" class="navbar-brand">Inicio</a>
        </div>
        <div id="navBarCollapse" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Usuarios</a></li>
            <li><a href="#">Grupos</a></li>
          </ul>

          <ul>
              <c:forEach items="${usuarioLogin.coleccionGrupos}" var="grupo">
                <li><c:out value="${grupo.descripcionGrupo}"></c:out></li>
              </c:forEach>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li>
              <a href="#">${usuarioLogin.nombreUsuario}</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
</body>
</html>
