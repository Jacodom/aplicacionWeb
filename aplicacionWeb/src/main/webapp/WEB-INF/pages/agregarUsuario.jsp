<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>::. Agregar Usuario</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap-theme.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/font-awesome/font-awesome.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/modificacion.css">
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
        <script src="${pageContext.request.contextPath}/js/agregarUsuario.js"></script>
    </head>
    <body>

        <!--prueba insercion jsp-->
        <jsp:include page="panelUsuario.jsp"></jsp:include>

        <%--<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" data-target="#navBarCollapse" data-toggle="collapse" class="navbar-toggle">
                        <span class="sr-only">Toggle Navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a href="#" class="navbar-brand">Modulo Seguridad</a>
                </div>
                <div id="navBarCollapse" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Usuarios</a></li>
                        <li><a href="#">Grupos</a></li>
                    </ul>
                </div>
            </div>
        </div>--%>
        <hr>
        <br>
        <br>
        <br>
    <div class="container">
        <div class="row">
            <div class="col-lg-offset-2 col-md-8 col-xs-8">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <strong>Datos de Nuevo Usuario</strong>
                    </div>

                    <div class="panel-body">
                        <form role="form" id="addUsuarioForm" action="${pageContext.request.contextPath}/Usuarios/addUsuario.do" method="post">
                            <div>
                                <!-- Nombre -->
                                <div class="form-group">
                                    <label class="control-label" for="nameInput">Nombre </label>
                                    <div class="input-group">
                                        <input path="idUsuario" class="form-control" id="nameInput"/>
                                        <span class="input-group-addon"><span id="iconoNombre" class="glyphicon glyphicon-asterisk"></span></span>

                                    </div>

                                    <div class="error-ingreso help-block" id="errorDisplayNombre"></div>
                                </div>


                                <!-- Username -->
                                <div class="form-group">
                                    <label class="control-label" for="userNameInput">Username </label>
                                    <div class="input-group">
                                        <input path="nombreUsuario" class="form-control" id="userNameInput"/>
                                        <span class="input-group-addon"><span id="iconoUserName" class="glyphicon glyphicon-asterisk"></span></span>
                                    </div>
                                    <div class="error-ingreso help-block" id="errorDisplayUserName"></div>
                                </div>

                                <!-- mail -->
                                <div class="form-group">
                                    <label for="emailUser">Email</label>
                                    <div class="input-group">
                                        <input path="emailUsuario" type="text" class="form-control" id="emailUser" name="emailUser" placeholder="ejemplo@ejemplo.com"/>
                                        <span class="input-group-addon"><span id="iconoEmail" class="glyphicon glyphicon-asterisk"></span></span>
                                    </div>
                                    <div class="error-ingreso help-block" id="errorDisplayEmail"></div>
                                </div>

                                <!-- estado -->
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="" id="chkEstado">
                                        Activo
                                    </label>
                                </div>

                                <div class="error-ingreso help-block" id="errorDisplayAgregar"></div>
                                <button class="btn btn-success center-block" type="button" id="btnRegistrar"><span>Registrar</span><i id="iconoSubmit" class="fa"></i></button>
                                <!--<input type="submit" name="btnRegistrar" id="btnRegistrar" value="Registrar" class="btn btn-info center-block">-->


                                        <div class="alert alert-success center-block">
                                            El usuario ha sido agregado correctamente, continúe agregando usuarios o
                                            <a href="${pageContext.request.contextPath}/Usuarios/usuario.do">vuelva al inicio.</a>
                                        </div>

                                        <div class="alert alert-danger center-block">
                                            El usuario no ha podido ser agregado. Intente nuevamente.
                                        </div>



                            </div>
                        </form>
                    </div>
                    <div class="panel-footer">
                        <strong><span class="glyphicon glyphicon-asterisk"></span> Campos Requeridos</strong>
                    </div>
                </div>
            </div>
        </div>
    </div>

        <jsp:include page="footer.jsp"></jsp:include>




    </body>
</html>