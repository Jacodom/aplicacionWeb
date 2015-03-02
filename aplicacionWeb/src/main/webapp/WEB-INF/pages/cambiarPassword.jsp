<%--
  Created by IntelliJ IDEA.
  User: Aquiles
  Date: 27/02/2015
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>::.Cambiar contraseña</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap-theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/font-awesome/font-awesome.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/modificacion.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</head>
<body>
    <jsp:include page="panelUsuario.jsp"></jsp:include>
        <div>
          <form:form role="form" action="${pageContext.request.contextPath}/Usuarios/cambiarPassword.do" method="POST" modelAttribute="usuarioCambioPw">
            <div>

                <!--id de usuario -->
                <label>Username</label>
                <form:label path="username">${usuarioSession.idUsuario}</form:label>

              <!-- Contraseña anterior -->
                <label for="passwordAnterior">Contraseña anterior </label>
                <div >
                  <form:input type="password" path="passwordAnterior" />


                </div>


              <!-- Contraseña nueva -->
                <label for="passwordNueva">Contraseña nueva </label>
                <div >
                  <form:input path="passwordNueva" type="password"/>

                </div>


              <input type="submit" value="Cambiar" id="btnCambiar"/>


               <c:choose>
                   <c:when test="${alerta=='exito'}">
                       <div class="alert alert-success center-block">
                           La contraseña del usuario ha sido cambiada correctamente, vuelva a <a href="${pageContext.request.contextPath}/Usuarios/logout.do">Iniciar Sesión para confirmar el cambio.</a>
                       </div>
                   </c:when>
                   <c:when test="${alerta=='error'}">
                       <div class="alert alert-danger center-block">
                           No ha podido efectuarse el cambio de contraseña. Por favor intente nuevamente.
                       </div>
                   </c:when>
               </c:choose>







            </div>
          </form:form>
        </div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
