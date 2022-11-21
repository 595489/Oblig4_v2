<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- saved from url=(0032)http://localhost:8080/paamelding -->
<html lang="no">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="./css/simple.css" rel="stylesheet" type="text/css">
	<script src="./js/validation.js"></script>
	<title>Påmelding</title>
</head>

<body>

<h2>Påmelding</h2>


<form:form action="registerUser" method="post" modelAttribute="deltager">
	<fieldset>
		<c:out value="${error}"/>
		<form:label path="fornavn" for="fn">Fornavn</form:label>
		<!-- NB! Spring sin (form:input)-tag støtter ikke required alene,
             men greit med required="noe"! -->
		<form:input path="fornavn" id="fn" name="fornavn" title="..." pattern=".*" placeholder="Fyll inn fornavn" required="required" type="text" value=""/>
		<form:errors path="fornavn"></form:errors>


		<form:label path="etternavn" for="en">Etternavn</form:label>
		<form:input path="etternavn" id="en" name="etternavn" title="..." pattern=".*" placeholder="Fyll inn etternavn" required="required" type="text" value=""/>
		<form:errors path="etternavn"></form:errors>


		<form:label path="mobil" for="mob">Mobil (8 siffer)</form:label>
		<form:input path="mobil" id="mob" name="mobil" title="..." pattern=".*" placeholder="Fyll inn telefonnummer" required="required" type="text" value=""/>
		<form:errors path="mobil"></form:errors>


		<label for="pass">Passord</label>
		<input id="pass" name="passord" title="..." pattern=".*" placeholder="Velg et passord" type="password" required="required" value="">


		<label for="passRep">Passord repetert</label>
		<input id="passRep" name="passordRep" title="..." pattern=".*" placeholder="Gjenta passord" type="password" required="required" value="">

		<p>Kjønn: </p>
		<label for="man">Mann
			<input type="radio" id="man" name="gender" value="Mann" checked/>
			<span></span>
		</label>

		<label for="woman">Kvinne
			<input type="radio" id="woman" name="gender" value="Kvinne"/>
			<span></span>
		</label>

		<br><br><p><input type="submit" value="register"></p>
	</fieldset>
</form:form>
<form:form action="login" method="get">
	<button type="submit" value="">Logg inn</button>
</form:form>
</body>
</html>
