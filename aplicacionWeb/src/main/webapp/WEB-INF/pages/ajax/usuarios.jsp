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
  <title>::. Usuarios</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap-theme.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/font-awesome/font-awesome.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/modificacion.css">
</head>
<body>
    <div class="table-responsive">
      <table class="table table-bordered table-hover">
        <thead>
        <tr>
          <th>Nombre</th>
          <th>Username</th>
          <th>Email</th>
          <th class="text-center">Estado</th>
        </tr>
        </thead>
        <tbody>
          <c:forEach var="usuario" items="${listaUsuarios}">
            <tr>
              <td><c:out value="${usuario.nombreUsuario}"></c:out></td>
              <td><c:out value="${usuario.idUsuario}"></c:out></td>
              <td><c:out value="${usuario.emailUsuario}"></c:out></td>
              <td class="text-center">
                <c:choose>
                  <c:when test="${usuario.estadoUsuario==true}">
                    <i class="fa fa-check-circle"></i>
                  </c:when>
                  <c:otherwise>
                    <i class="fa fa-times-circle"></i>
                  </c:otherwise>
                </c:choose>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
</body>
</html>
