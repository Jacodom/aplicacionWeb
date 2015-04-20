<%--
  Created by IntelliJ IDEA.
  User: Jacobo
  Date: 16/02/2015
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Error 500</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap-theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/font-awesome/font-awesome.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/modificacion.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</head>
<body>
    <div class="container">
      <div class="row">
        <div class="col-xs-12 col-md-12 col-lg-12">
          <img src="${pageContext.request.contextPath}/img/error500Page.png" alt="Obi: may the force be with you...always" class="img-responsive center-block">
          <h3 class="text-center"><strong>Ups! </strong>algo no funcionó en el servidor. Actualiza la página en unos minutos. <small> Para volver al inicio haz click <a href="${pageContext.request.contextPath}/Usuarios/usuario.do">aquí.</a></small> </h3>
        </div>
      </div>
    </div>
</body>
</html>
