<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Jacobo
  Date: 20/02/2015
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <title>::. Recuperar Password</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap-theme.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/font-awesome/font-awesome.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/modificacion.css">
  <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
  <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
  <script src="${pageContext.request.contextPath}/js/recuperarPassword.js"></script>
</head>
<body>
  <div class="container">
    <div class="wrapForm">
      <div class="row">
        <div class="col-xs-12 col-md-12 col-lg-6 col-lg-offset-3">
          <div class="panel panel-default">
            <div class="panel-heading">
              <strong class="text-center">Ingrese datos para recuperar Password</strong>
            </div>
            <div class="panel-body">
              <form id="formRecuperar" action="${pageContext.request.contextPath}/Usuarios/recuperarPassword.do" method="POST">

                <div>
                  <div class="form-group" style="margin-bottom: 25px">
                    <div class="input-group">
                      <span class="input-group-addon"><i class="fa fa-user"></i></span>
                      <input path="idUsuario" class="form-control" id="inputUsername"/>
                    </div>
                    <div class="error-ingreso help-block" id="errorDisplayUserName"></div>
                  </div>
                </div>

                <div>
                  <div class="form-group" style="margin-bottom: 25px">
                    <div class="input-group">
                      <span class="input-group-addon"><i class="fa fa-at"></i></span>
                      <input path="emailUsuario" class="form-control" type="text" id="emailUsr"/>
                    </div>
                    <div class="error-ingreso help-block" id="errorDisplayEmail"></div>
                  </div>
                </div>


                <div class="error-ingreso help-block" id="errorDisplayRecuperar"></div>

                <div class="text-center">
                  <div class="btn-group">
                    <button class="btn btn-success" type="button" id="btnRecuperar"><span>Recuperar</span><i id="iconoSubmit" class="fa"></i></button>
                    <a class="btn btn-default" id="btnVolver" href="${pageContext.request.contextPath}/Usuarios/login.do"><span>Volver</span></a>
                  </div>
                </div>

                    <div class="alert alert-success center-block">
                      El password ha sido enviado correctamente a su e-mail. Revise su casilla y luego
                      <a href="${pageContext.request.contextPath}/Usuarios/login.do">inicie sesión.</a>
                    </div>
                    <div class="alert alert-danger center-block">
                      El usuario y e-mail ingresados no coinciden con la información de nuestra base de datos o no se ha podido actualizar la misma.
                    </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
