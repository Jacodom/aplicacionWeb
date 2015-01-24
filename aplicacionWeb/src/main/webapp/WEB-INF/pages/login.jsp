<%--
  Created by IntelliJ IDEA.
  User: Jacobo
  Date: 27/11/14
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>::. Login</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap-theme.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/font-awesome/font-awesome.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/modificacion.css">
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>

    </head>
    <body>
        <br>
        <br>
        <br>
        <br>
        <div class="container">
            <div class="row">
                <div class="col-lg-offset-3 col-md-6 col-xs-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <strong>Ingrese datos para inicio de sesión. </strong>
                        </div>

                        <div class="panel-body">
                            <form:form  role="form" id="formLogin" action="${pageContext.request.contextPath}/Usuarios/login.do" method="POST" modelAttribute="usuarioLogin">
                                <div>
                                    <div class="form-group" style="margin-bottom: 25px">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                            <form:input path="idUsuario" class="form-control" id="inputUsername"/>
                                        </div>
                                    </div>
                                </div>

                                <div>
                                    <div class="form-group" style="margin-bottom: 25px">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                            <form:input path="claveUsuario" class="form-control" id="pswUser"/>
                                        </div>
                                    </div>
                                </div>

                                <input type="submit" name="btnLogin" id="btnLogin" value="Login" class="btn btn-success center-block">

                            </form:form>
                        </div>

                        <h1>holaaaa!!</h1>

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
