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
	<tbody>
	<c:forEach items="${deltagerliste}" var="deltager">
		<c:choose>
			<c:when test="${deltager.mobilnr.equals(deltager.mobilnr)}">
				<tr bgcolor="#aaffaa">
					<td align="center">${deltager.kjonn.equals("k") ? "&#9792" : "&#9794"}</td>
					<td>${deltager.fornavn}, ${deltager.etternavn}</td>
					<td>${deltager.mobilnr}</td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr bgcolor="#ffffff">
					<td align="center">${deltager.kjonn.equals("k") ? "&#9792" : "&#9794"}</td>
					<td>${deltager.fornavn}, ${deltager.etternavn}</td>
					<td>${deltager.mobilnr}</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	</tbody>
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