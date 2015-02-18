<%--
  Created by IntelliJ IDEA.
  User: Jacobo
  Date: 10/02/2015
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>::. Panel de Usurio</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap-theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/font-awesome/font-awesome.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/modificacion.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</head>
<body>
  <jsp:include page="panelUsuario.jsp"></jsp:include>
    <!--contenido -->
  <div class="jumbotron">
      <div class="container">
          <div class="row">
              <div class="col-xs-12 col-md-12 col-lg-12">
                  <div class="banner">
                      <i class="fa fa-shield fa-5x"></i>
                      <h2>Modulo de Seguridad</h2>
                      <p>Administre su sitio</p>
                  </div>
              </div>
          </div>
      </div>
  </div>
  <div class="container-fluid">
      <div class="row">
          <div class="col-xs-12 col-md-6 col-lg-3 infoModulo">
            <h2>Responsive</h2>
              <i class="fa fa-mobile fa-4x"></i>
              <p>Diseño adaptable al dispositivo del cual se accede al sitio.</p>
          </div>

          <div class="col-xs-12 col-md-6 col-lg-3 infoModulo">
              <h2>Dinámico</h2>
              <i class="fa fa-refresh fa-4x"></i>
              <p>Capacidad para gestionar las acciones de los distintos grupos de usuarios y los niveles de acceso.</p>
          </div>

          <div class="col-xs-12 col-md-6 col-lg-3 infoModulo">
              <h2>Confiable</h2>
              <i class="fa fa-check fa-4x"></i>
              <p>Control de acceso y de transacciones a los distintos módulos y páginas.</p>
          </div>

          <div class="col-xs-12 col-md-6 col-lg-3 infoModulo">
              <h2>Potente</h2>
              <i class="fa fa-database fa-4x"></i>
              <p>Utilizando MySql+Hibernate logra un desempeño óptimo.</p>
          </div>

      </div>

  </div>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
