<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- saved from url=(0032)http://localhost:8080/paamelding -->
<html lang="no">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="./css/simple.css" rel="stylesheet" type="text/css">
	<script src="PaameldingScript.js"></script>
	<title>Påmelding</title>
</head>

<body>

<h2>Påmelding</h2>

<c:out value="error"/>

<form:form id="deltagerFormBean" action="registerUser" method="post">
	<fieldset>

		<label for="fornavn">Fornavn</label>
		<!-- NB! Spring sin (form:input)-tag støtter ikke required alene,
             men greit med required="noe"! -->
		<input id="fornavn" name="fornavn" title="..." pattern=".*" placeholder="Fyll inn fornavn" required="required" type="text" value="">


		<label for="etternavn">Etternavn</label>
		<input id="etternavn" name="etternavn" title="..." pattern=".*" placeholder="Fyll inn etternavn" required="required" type="text" value="">


		<label for="mobil">Mobil (8 siffer)</label>
		<input id="mobil" name="mobil" title="..." pattern=".*" placeholder="Fyll inn telefonnummer" required="required" type="text" value="">


		<label for="passord">Passord</label>
		<input id="passord" name="passord" title="..." pattern=".*" placeholder="Velg et passord" type="password" required="required" value="">


		<label for="passordRepetert">Passord repetert</label>
		<input id="passordRepetert" name="passordRep" title="..." pattern=".*" placeholder="Gjenta passord" type="password" required="required" value="">


		<%--			<label for="kjonn">Kjønn:</label> --%>
		<%--			<input id="kjonn1" name="kjonn" checked="checked" type="radio" value="mann">mann--%>
		<%--			<input id="kjonn2" name="kjonn" type="radio" value="kvinne">kvinne--%>

<%--		<p>Kjønn:--%>
<%--			<input type="radio" id="man" name="gender" value="Mann"/> <label for="man">Mann</label>--%>
<%--			<input type="radio" id="woman" name="gender" value="Kvinne"> <label for="woman">Kvinne</label>--%>
<%--		</p>--%>
		<p>Kjønn: </p>
		<label for="man">Mann
			<input type="radio" id="man" name="gender" value="Mann"/>
			<span></span>
		</label>

		<label for="woman">Kvinne
			<input type="radio" id="woman" name="gender" value="Kvinne"/>
			<span></span>
		</label>

		<br><br><p><input type="submit" value="register"></p>
	</fieldset>
</form:form>

<%--<form:form action="registerUser" method="post" class="pure-form pure-form-aligned" >--%>
<%--	<fieldset>--%>
<%--		<div class="pure-control-group">--%>
<%--			<label for="fornavn">Fornavn:</label> <input type="text"--%>
<%--														 name="fornavn" id="fornavn" value="${skjema.fornavn}"--%>
<%--														 onkeyup="fornavnSjekk()" /> <font color="red" id="fn">${skjema.fornavnFeilmelding}</font>--%>
<%--		</div>--%>
<%--		<div class="pure-control-group">--%>
<%--			<label for="etternavn">Etternavn:</label> <input type="text"--%>
<%--															 name="etternavn" id="etternavn" value="${skjema.etternavn}"--%>
<%--															 onkeyup="etternavnSjekk()" /> <font color="red" id="en">${skjema.etternavnFeilmelding}</font>--%>
<%--		</div>--%>
<%--		<div class="pure-control-group">--%>
<%--			<label for="mobil">Mobil (8 siffer):</label> <input type="text"--%>
<%--																name="mobil" id="mobil" value="${skjema.telefon}"--%>
<%--																onkeyup="mobilSjekk()" /> <font id="mob" color="red">${skjema.telefonFeilmelding}</font>--%>
<%--		</div>--%>
<%--		<div class="pure-control-group">--%>
<%--			<label for="passord">Passord:</label> <input type="password"--%>
<%--														  name="passord" id="passord" value="${skjema.passord}"--%>
<%--														  onkeyup="passordSjekk()" /> <font id="pass" color="red">${skjema.passordFeilmelding}</font>--%>
<%--		</div>--%>
<%--		<div class="pure-control-group">--%>
<%--			<label for="passordRep">Repeter Passord:</label> <input--%>
<%--				type="password" id="passordRep" name="passordRep"--%>
<%--				value="${skjema.passordKopi}" onkeyup="passordRepSjekk()" /> <font--%>
<%--				color="red" id="passRep">${skjema.passordKopiFeilmelding}</font>--%>
<%--		</div>--%>
<%--&lt;%&ndash;		<div class="pure-control-group">&ndash;%&gt;--%>
<%--&lt;%&ndash;			<label for="kjonn">Kjønn:</label> <input type="radio" name="kjonn" id="kjonn"&ndash;%&gt;--%>
<%--&lt;%&ndash;													 value="mann" ${skjema.kjonn.equals("mann") ? "checked" : ""} />mann&ndash;%&gt;--%>
<%--&lt;%&ndash;			<input type="radio" name="kjonn" value="kvinne"&ndash;%&gt;--%>
<%--&lt;%&ndash;			${skjema.kjonn.equals("kvinne") ? "checked" : ""} />kvinne&ndash;%&gt;--%>
<%--&lt;%&ndash;			<font color="red">${skjema.kjonnFeilmelding}</font>&ndash;%&gt;--%>
<%--&lt;%&ndash;		</div>&ndash;%&gt;--%>
<%--		<div class="pure-control-group">--%>
<%--			<label for="man">Mann:</label>--%>
<%--			<input type="radio" name="gender" value="Mann" id="man">--%>

<%--			<label for="woman">Kvinne:</label>--%>
<%--			<input type="radio" name="gender" value="Kvinne" id="woman">--%>
<%--		</div>--%>
<%--		<div class="pure-controls">--%>
<%--			<button type="submit" value="Meld på">Meld på</button>--%>
<%--		</div>--%>
<%--	</fieldset>--%>
<%--</form:form>--%>
</body>
</html>
