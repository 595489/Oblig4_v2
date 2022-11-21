<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- saved from url=(0032)http://localhost:8080/paamelding -->
<html lang="no">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="./css/simple.css" rel="stylesheet" type="text/css">
<%--    <script src="./js/loginValidation.js" defer></script>--%>
    <title>Logg inn</title>
</head>
<body>
<h2>Logg inn</h2>
<%--<p style="color:red;"></p>--%>

<form:form action="loggedIn" method="post">
    <fieldset>
        <label for="mob">
            Mobil:</label> <input id="mob" type="text" name="mobil" placeholder="mobil">
        <label for="pass">
            Passord:</label> <input id="pass" type="password" name="passord" placeholder="passord">
        <c:out value="${error}"></c:out>
        <br><br><button type="submit" value="Login">Logg inn</button>
    </fieldset>
</form:form>
<form:form action="paamelding" method="get">
    <button type="submit" value="">Registrer deg</button>
</form:form>
</body>
