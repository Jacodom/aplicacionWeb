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
          <a href="/Usuarios/usuario.do" class="navbar-brand">Inicio</a>
        </div>
        <div id="navBarCollapse" class="collapse navbar-collapse">


          <ul class="nav navbar-nav">
              <c:forEach var="modulo" items="${modulosUsuario}">
                  <li class="dropdown">
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">${modulo.descripcionModulo}<span class="caret"></span></a>
                      <ul class="dropdown-menu" role="menu">
                          <c:forEach var="perfil" items="${perfilesUsuario}">
                              <c:if test="${perfil.formulario.modulo.idModulo==modulo.idModulo}">
                                <li><a href="/${modulo.descripcionModulo}/${perfil.formulario.nombreFormulario}.do">${perfil.formulario.descripcionFormulario}</a></li>
                              </c:if>
                          </c:forEach>
                      </ul>
                  </li>
              </c:forEach>
          </ul>

            <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">${usuarioSession.nombreUsuario}<span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                    <li>
                        <a href="/Usuarios/logout.do">Salir</a>
                    </li>
                </ul>
            </li>
          </ul>


        </div>
      </div>
    </div>




</body>
</html>
