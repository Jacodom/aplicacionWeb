<%--
  Created by IntelliJ IDEA.
  User: Aquiles
  Date: 27/02/2015
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>::.Cambiar contraseña</title>
</head>
<body>

        <div>
          <form:form role="form" action="${pageContext.request.contextPath}/Usuarios/cambiarPassword.do" method="POST" modelAttribute="cambiarPass">
            <div>
              <!-- Contraseña anterior -->
                <label for="passAnt">Contraseña anterior </label>
                <div >
                  <form:input type="password" path="passAnt" />


                </div>


              <!-- Contraseña nueva -->
                <label for="passNueva">Contraseña nueva </label>
                <div >
                  <form:input path="passNueva" type="password"/>

                </div>


              <input type="submit" value="Cambiar" id="btnCambiar"/>
<!--

              <div class="alert alert-success center-block">
                El usuario ha sido agregado correctamente, continúe agregando usuarios o
              </div>

              <div class="alert alert-danger center-block">
                El usuario no ha podido ser agregado. Intente nuevamente.
              </div>

-->

            </div>
          </form:form>
        </div>

</body>
</html>
