<%--
  Created by IntelliJ IDEA.
  User: Jacobo
  Date: 03/03/2015
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="utf-8">
  <title>::. Perfiles</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap-theme.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/font-awesome/font-awesome.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/modificacion.css">
  <script src="${pageContext.request.contextPath}/js/detallesPerfil.js"></script>
  <script src="${pageContext.request.contextPath}/js/eliminarPerfil.js"></script>
</head>
<body>
<div class="table-responsive">
  <table class="table table-bordered table-hover" id="tableP">
    <thead>
    <tr class="text-center">
      <th>ID</th>
      <th>Grupo</th>
      <th>Formulario</th>
      <th>URL</th>
      <c:if test="${accion=='B'}">
        <th>Eliminar</th>
      </c:if>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="perfil" items="${listaPerfiles}">
      <tr>
        <td class="infoP"><c:out value="${perfil.idPerfil}"></c:out></td>
        <td class="infoP"><c:out value="${perfil.grupo.descripcionGrupo}"></c:out></td>
        <td class="infoP"><c:out value="${perfil.formulario.nombreFormulario}"></c:out></td>
        <td class="infoP"><c:out value="/${perfil.formulario.urlFormulario}"></c:out></td>
        <c:if test="${accion=='B'}">
          <td>
            <div class="text-center">
              <a href="#confirmarModal" data-toggle="modal" data-target="#confirmarModal" class="btn btn-danger btn-sm text-center" data-perfil-id=${perfil.idPerfil}><i class="fa fa-times"></i></a>
            </div>
          </td>
        </c:if>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>


<!-- modal -->
<form  id="formEliminar" action="${pageContext.request.contextPath}/Perfiles/eliminarPerfiles.do" method="post">
    <div class="modal fade" id="confirmarModal">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Cerrar</span></button>
            <h4 class="modal-title text-center">Eliminar Perfil</h4>
          </div>
          <div class="modal-body">
            <div id="mensajeModal" class="text-center">
              <h3>¿Realmente desea eliminar el perfil seleccionado?&nbsp</h3>
              <i id="iconoAceptar"></i>
            <p name="perfilID" id="perfilID"><p>
            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-success" value="Eliminar" id="aceptarModal"></button>
            <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
          </div>
        </div>
      </div>
    </div>
</form>

<div id="detalles"></div>
</body>
</html>
