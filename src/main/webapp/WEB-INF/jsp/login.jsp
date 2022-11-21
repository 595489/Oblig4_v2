<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- saved from url=(0032)http://localhost:8080/paamelding -->
<html lang="no">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="./css/simple.css" rel="stylesheet" type="text/css">
    <script src="./js/validation.js" defer></script>
    <title>Logg inn</title>
</head>
<body>
<h2>Logg inn</h2>
<%--<p style="color:red;"></p>--%>
<form:form action="login" method="post">
    <fieldset>
<%--        <label for="mobil">--%>
            Mobil:</label> <input type="text" name="mobil" placeholder="mobil">
<%--        <label for="passord">--%>
            Passord:</label> <input type="password" name="passord" placeholder="passord">
        <br><br><button type="submit" value="Login">Logg inn</button>
    </fieldset>
</form:form>


</body>
<%--</html>--%>

<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <meta charset="UTF-8"/>--%>

<%--    <title>Register</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h4>Registrering</h4>--%>

<%--<c:out value="${success}"/>--%>

<%--<form:form action="register" method="post">--%>
<%--    <fieldset>--%>
<%--        <legend>Registrer</legend>--%>
<%--        <p>Fornavn: <input type="text" name="fName"/></p>--%>
<%--        <p>Etternavn: <input type="text" name="lName"/></p>--%>
<%--        <p>Mobil: <input type="tel" name="userName"/></p>--%>
<%--        <c:out value="${invalid_password}"/>--%>
<%--        <p>Passord: <input type="password" name="password"/></p>--%>
<%--        <p>Gjenta Passord:<input type="password" name="passwordRepeat"/></p>--%>
<%--        <p>Kjønn:--%>
<%--            <input type="radio" id="man" name="gender" value="Mann"/> <label for="man">Mann</label>--%>
<%--            <input type="radio" id="woman" name="gender" value="Kvinne"> <label for="woman">Kvinne</label>--%>
<%--        </p>--%>
<%--        <p><input type="submit" value="Login"></p>--%>
<%--    </fieldset>--%>
<%--</form:form>--%>
<%--</body>--%>
<%--</html>--%>