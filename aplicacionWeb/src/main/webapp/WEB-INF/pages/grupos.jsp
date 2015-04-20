<%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 09/03/2015
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta charset="utf-8">
  <title>::. Grupos</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap-theme.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/font-awesome/font-awesome.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/modificacion.css">
  <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
  <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
  <script src="${pageContext.request.contextPath}/js/paginacionGrupos.js"></script>
</head>
<body>
        <jsp:include page="panelUsuario.jsp"></jsp:include>

        <div id="accion" style="display: none;">${accion}</div>
        <!--contenido-->
        <div class="container">
          <div class="row">
            <div class="col-xs-12 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1">
              <div class="boxLista">
                <h2>Lista de grupos</h2>

                <!--aca va la tabla -->

                <div id="tablaGrupos"><!--nombre de la table-->

                </div>


                <!--pagination-->
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


              </div>
            </div>
          </div>

          <div class="row">
            <div class="col-xs-12 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1">
              <div id="datosGrupo">
                <!--aca van los detalles del usuario -->
              </div>
            </div>
          </div>

          <!--aca van los errores de modificar el usuario-->
          <c:choose>
            <c:when test="${alerta=='exito'}">
              <div class="alert alert-success center-block">
                El grupo ha sido modificado correctamente, continúe modificando grupos o
                <a href="${pageContext.request.contextPath}/Usuarios/usuario.do">vuelva al inicio.</a>
              </div>
            </c:when>
            <c:when test="${alerta=='error'}">
              <div class="alert alert-danger center-block">
                El grupo no ha podido ser modificado. Intente nuevamente.
              </div>
            </c:when>
          </c:choose>
        </div>

        <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
