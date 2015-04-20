<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Jacobo
  Date: 10/03/2015
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>::. Agregar Perfil</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap-theme.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/font-awesome/font-awesome.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/modificacion.css">
  <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
  <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</head>
<body>
  <jsp:include page="panelUsuario.jsp"></jsp:include>

<div class="container">
  <div class="wrapForm">
    <div class="row">
      <form:form action="${pageContext.request.contextPath}/Perfiles/agregarPerfil.do" method="POST" modelAttribute="perfil" id="formAgregarPerfil">
        <div class="col-xs-12 col-md-12 col-lg-8 col-lg-offset-2">
          <div class="panel panel-default">
            <div class="panel-heading">
              <h4 class="text-center">Crear Perfil</h4>
            </div>
            <div class="panel-body">
              <div class="col-lg-6 col-md-4 col-xs-12">
                <div class="form-group-lg">
                  <label>Seleccione un grupo</label>
                  <form:select path="grupo" items="${listaGrupos}"
                               itemValue="idGrupo"
                               itemLabel="descripcionGrupo" id="listaGrupos"
                               cssClass="form-control"></form:select>
                </div>
              </div>
              <div class="col-lg-6 col-md-4 col-xs-12">
                <div class="form-group-lg">
                  <label>Seleccione un formulario</label>
                  <form:select path="formulario" items="${listaFormularios}"
                               itemValue="idFormulario"
                               itemLabel="nombreFormulario" id="listaFormularios"
                               cssClass="form-control"></form:select>
                </div>
              </div>
              <div class="text-center">
                <button class="btn btn-success btn-lg" id="btnGuardar" type="submit">Guardar</button>
              </div>
              </div>
            </div>


            <c:choose>
              <c:when test="${alerta=='exito'}">
                <div class="alert alert-success center-block">
                  Se ha agregado el perfil con éxito!
                </div>
              </c:when>
              <c:when test="${alerta=='error'}">
                <div class="alert alert-danger center-block">
                  Se ha producido un error al agregar el perfil, intentelo nuevamente!
                </div>
              </c:when>
              <c:when test="${alerta=='existe'}">
                <div class="alert alert-danger center-block">
                  Ya existe un perfil con ese grupo y ese formulario.
                </div>
              </c:when>
            </c:choose>
        </div>
      </form:form>
    </div>
  </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
