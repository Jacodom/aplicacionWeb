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
    <script src="${pageContext.request.contextPath}/js/cambiarPassword.js"></script>
</head>
<body>
    <jsp:include page="panelUsuario.jsp"></jsp:include>

    <div class="container">
        <div class="wrapForm">
            <div class="row">
                <div class="col-xs-12 col-md-12 col-lg-6 col-lg-offset-3">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <strong>Cambio de contraseña</strong>
                        </div>
                        <div class="panel-body">
                            <form:form role="form" action="${pageContext.request.contextPath}/Usuarios/cambiarPassword.do" method="POST" modelAttribute="usuarioCambioPw" id="formCambioPW">

                                <!--Username-->
                                <div>
                                    <div class="form-group" style="margin-bottom: 25px">
                                        <h3><strong>Username:&nbsp</strong><span class="label label-info">${usuarioSession.idUsuario}</span></h3>
                                    </div>
                                </div>
                                <!--password anterior-->
                                <div>
                                    <div class="form-group" style="margin-bottom: 25px">
                                        <label class="control-label">Contraseña anterior </label>
                                            <form:input id="pwAnterior" cssClass="form-control" type="password" path="passwordAnterior" />
                                        <div class="error-ingreso help-block" id="errorDisplayPasswordAnterior">${errorPassword}</div>
                                    </div>
                                </div>
                                <!--password nueva-->
                                <div>
                                    <div class="form-group" style="margin-bottom: 25px">
                                        <label class="control-label">Contraseña nueva </label>
                                            <form:input id="pwNueva" cssClass="form-control" path="passwordNueva" type="password"/>
                                    </div>
                                </div>

                                <div class="text-center">
                                    <input class="btn btn-success" type="submit" value="Cambiar" id="btnCambiar"/>
                                </div>



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

                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
