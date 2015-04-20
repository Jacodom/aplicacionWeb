<%--
  Created by IntelliJ IDEA.
  User: Jacobo
  Date: 03/03/2015
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta charset="utf-8">
  <title>::. Perfiles</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap-theme.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/font-awesome/font-awesome.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/modificacion.css">
  <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
  <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
  <script src="${pageContext.request.contextPath}/js/paginacionPerfiles.js"></script>
  <script src="${pageContext.request.contextPath}/js/eliminarPerfil.js"></script>
</head>
<body>
  <jsp:include page="panelUsuario.jsp"></jsp:include>

  <div id="accion" style="display: none;">${accion}</div>

  <div class="container">
    <div class="row">
      <div class="col-xs-12 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1">
        <div class="boxLista">
          <h2>Lista de Perfiles</h2>
          <div id="tablaPerfiles">

          </div>

          <!--paginacion-->
          <div class="text-center">
            <nav>
              <ul class="pagination">
                <li id="anterior">
                  <a href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                  </a>
                </li>
                <c:forEach var="pagina" begin="1" end="${cantPaginas}">
                  <li class="numerador" id="pag${pagina}"><a href="#"><c:out value="${pagina}"></c:out></a></li>
                </c:forEach>
                <li id="siguiente">
                  <a href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                  </a>
                </li>
              </ul>
            </nav>
          </div>


          <div class="row">
            <div class="col-xs-12 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1">
              <div id="detallesPerfil">
                <!--detalles del perfil -->
              </div>
            </div>
          </div>

        </div>
      </div>
    </div>
  </div>

  <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
