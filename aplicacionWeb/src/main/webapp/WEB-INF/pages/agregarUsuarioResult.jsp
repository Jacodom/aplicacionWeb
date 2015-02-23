<%--
  Created by IntelliJ IDEA.
  User: Jacobo
  Date: 20/11/14
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap-theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/font-awesome/font-awesome.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/modificacion.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/js/notify.min.js"></script>
    <%@ page isELIgnored="false" %>
</head>

<body>
    <jsp:include page="panelUsuario.jsp"></jsp:include>
    <div id="container" class="jumbotron container-agregarUsuarioResult">
        <script type="text/javascript">
            $.notify("${alerta}", "success"
            );
        </script>
        <div class="banner">
        <h1>Qué desea hacer?</h1>
            <button class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/Usuarios/agregarUsuario.do'" >Continuar cargando usuarios</button>
            <button class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/Usuarios/login.do'" >Volver a inicio</button>

        </div>
    </div>
    <div id="footer">
        <jsp:include page="footer.jsp"></jsp:include>
    </div>
</body>
</html>
