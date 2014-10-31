<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>::. Agregar Usuario</title>
        <link rel="stylesheet" href="CSS/Bootstrap/bootstrap.css">
        <link rel="stylesheet" href="CSS/Bootstrap/bootstrap-theme.css">
        <link rel="stylesheet" href="CSS/Bootstrap/modificacion.css">
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>

    </head>
    <body>
        <div class="nvar navbar-inverse navbar-fixed-top"> 
            <div class="container">
                <div class="navbar-header">                    
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                        <span class="sr-only">Responsive</span>
                        <span class="icon-bar"></span>
                        <span class ="icon-bar"></span>
                        <span class ="icon-bar"></span>
                    </button> 
                    
                    <a class="navbar-brand" href="#">Login</a>                    
                </div>
                <div class="navbar-collapse collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a href="#Usuarios">Usuario</a>
                        </li>
                        <li>
                            <a href="#Grupos">Grupos</a>
                        </li>
                        <li>
                            <a href="#Help">Help</a>
                        </li> 
                    </ul>
                        <form class="navbar-form navbar-right">
                            <div class="form-group">
                                <input type="text" placeholder="Email" class="form-control-own">
                            </div>
                            <div class="form-group">
                                <input type="text" placeholder="Password" class="form-control">
                            </div>
                            <button type="submit" class="btn btn-success">Login</button>
                        </form>
                    </div>
                </div>
            </div>
        <hr>
        <br>
        <br>
        <br>
    <div class="container">
        <div class="row">
            <form:form role="form" id="addUsuarioForm" action="${pageContext.request.contextPath}/Usuarios/addUsuario" method="POST" commandName="userForm">
                <div class="col-lg-6">
                    <div class="well well-sm">
                        <strong><span class="glyphicon glyphicon-asterisk"></span> Campos Requeridos</strong>
                    </div>

                    <div class="form-group">
                        <label for="nombreInput">Nombre</label>
                        <div class="input-group">
                            <input type="text" class="form-control" name="nombreInput" id="nombreInput" placeholder="Username" required>
                            <span class="input-group-addon"><span id="iconoNombre" class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
                        <div class="error-ingreso" id="errorDisplayNombre"></div>
                    </div>

                    <div class="form-group">
                        <label for="primerEmail">Email</label>
                        <div class="input-group">
                            <input type="email" class="form-control" id="primerEmail" name="primerEmail" placeholder="Email" required>
                            <span class="input-group-addon"><span id="iconoEmail" class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
                        <div class="error-ingreso" id="errorDisplayPrimerEmail"></div>
                    </div>

                    <div class="form-group">
                        <label for="segundoEmail">Confirm Email</label>
                        <div class="input-group">
                            <input type="email" class="form-control" id="segundoEmail" name="segundoEmail" placeholder="Confirmar Email" required>
                            <span class="input-group-addon"><span id="iconoSegundoEmail" class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
                        <div class="error-ingreso" id="errorDisplaySegundoEmail"></div>
                    </div>

                    <input type="submit" name="submit" id="submit" value="Registrar" class="btn btn-info pull-left">

                </div>
            </form:form>


            <div class="col-lg-5 col-md-push-1">
                <div class="col-md-12">
                    <div class="alert alert-success">
                        <strong><span class="glyphicon glyphicon-ok"></span> Success! Message sent.</strong>
                    </div>
                    <div class="alert alert-danger">
                        <span class="glyphicon glyphicon-remove"></span><strong> Error! Please check all page inputs.</strong>
                    </div>
                </div>
            </div>
        </div>
    </div>


        <script src="${pageContext.request.contextPath}/js/agregarUsuario.js"></script>


    </body>
</html>