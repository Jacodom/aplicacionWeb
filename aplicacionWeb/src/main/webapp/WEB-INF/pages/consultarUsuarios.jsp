<%--
  Created by IntelliJ IDEA.
  User: Jacobo
  Date: 17/02/2015
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>::. Usuarios</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap-theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/font-awesome/font-awesome.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/modificacion.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/js/paginacion.js"></script>
</head>
<body>
    <jsp:include page="panelUsuario.jsp"></jsp:include>

    <!--contenido-->
    <div class="container">
      <div class="row">
        <div class="col-xs-12 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1">
          <div class="boxLista">
            <h2>Lista de usuarios</h2>

            <!--aca va la tabla -->

            <div id="tablaUsuarios">

            </div>


              <!--prueba pagination-->
            <div class="text-center">
              <nav>
                <ul class="pagination">
                  <li>
                    <a href="#" aria-label="Previous">
                      <span aria-hidden="true">&laquo;</span>
                    </a>
                  </li>
                  <c:forEach var="pagina" begin="1" end="${cantPaginas}">
                    <li class="numerador" id="pag${pagina}"><a><c:out value="${pagina}"></c:out></a></li>
                  </c:forEach>
                  <li>
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
    </div>

    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
