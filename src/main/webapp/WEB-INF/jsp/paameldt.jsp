<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- saved from url=(0030)http://localhost:8080/paameldt -->
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<link rel="stylesheet" href="simple.css">
<title>Påmeldingsbekreftelse</title>
</head>
<body>
	<h2>Påmeldingsbekreftelse</h2>
	<p>Påmeldingen er mottatt for</p>
	<p>
		<c:out value="${deltager.fornavn}"/><br>
		<c:out value="${deltager.etternavn}"/><br>
		<c:out value="${deltager.kjonn}"/><br>
		<c:out value="${deltager.mobil}"/><br>

	</p>
	<form:form action="deltagerliste" method="get">
		<fieldset>
			<input type="hidden" name="hiddenLogout" value="hiddenLogout"/>
			<p><input type="submit" value="Gå til deltagerliste" /></p>
		</fieldset>
	</form:form>
</body>
</html>