<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- saved from url=(0035)http://localhost:8080/deltagerliste -->
<html lang="no">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="./css/simple.css" rel="stylesheet" type="text/css">
	<script src="./js/validation.js" defer></script>
	<title>Deltagerliste</title>
</head>
<body>
<h2>Deltagerliste</h2>
<table class="pure-table">
	<tr bgcolor="#cccccc">
		<th>Kjønn</th>
		<th align="left">Navn</th>
		<th align="left">Mobil</th>
	</tr>
	<c:forEach var="d" items="${list}">
		<c:choose>
			<c:when test="${d.mobil.equals(user.mobil)}">
				<tr style="background-color: #aaffaa">
					<td>${d.kjonn}</td>
					<td>${d.fornavn}, ${d.etternavn}</td>
					<td>${d.mobil}</td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr style="background-color: #ffffff">
					<td>${d.kjonn}</td>
					<td>${d.fornavn}, ${d.etternavn}</td>
					<td>${d.mobil}</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</table>
<br/>
<form:form action="logout" method="get">
	<fieldset>
		<input type="hidden" name="hiddenLogout" value="hiddenLogout"/>
		<p><input type="submit" value="Logg ut" /></p>
	</fieldset>
</form:form>
</body>
</html>