<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
	<link rel="stylesheet" type="text/css" href="skjema.css">
	
<title>Påmelding</title>
</head>
<body>
	<h2>Påmelding</h2>
	<form id="skjema" name="skjema" method="post" action="PaameldingServlet" class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-control-group">
				<label for="fornavn">Fornavn:</label> <input id="fornavn" type="text"
					name="fornavn" value="${skjema.fornavn}" /> 
					<div class="feil">${skjema.fornavnFeilmelding}</div>
					
					<p id="fornavnFeil" class="gjemt feil">Ugyldig fornavn!(k)</p>
					
			</div>
			<div class="pure-control-group">
				<label for="etternavn">Etternavn:</label> <input id="etternavn" type="text"
					name="etternavn" value="${skjema.etternavn}" /> 
					<p class="feil">${skjema.etternavnFeilmelding }</p>
					<p id="etternavnFeil" class="gjemt feil">Ugyldig etternavn!</p>
			</div>
			<div class="pure-control-group">
				<label for="mobil">Mobil (8 siffer):</label> <input id="mobil" type="text"
					name="mobil" value="${skjema.mobil}" /> 
					<p class="feil">${skjema.mobilFeilmelding}</p>
					<p id="mobilFeil" class="gjemt feil">Ugyldig mobil!</p>
			</div>
			<div class="pure-control-group">
				<label for="passord">Passord:</label> <input id="passord" type="password"
					name="passord" value="" /> 
					<p class="feil">${skjema.passordFeilmelding}</p>
					<p id="passordFeil" class="gjemt feil">Ugyldig passord!</p>
					<p class="feil" id="passordTilbakemelding"></p>
			</div>
			<div class="pure-control-group">
				<label for="passordRepetert">Passord repetert:</label> <input id="passordRepetert"
					type="password" name="passordRepetert"
					value="" /> 
					<p class="feil">${skjema.passordRepetertFeilmelding}</p>
					<p id="passordRepetertFeil" class="gjemt feil">Passord må være like!</p>
			</div>
			<div class="pure-control-group">
				<label for="kjonn">Kjønn:</label> <input id="kjonn" type="radio" name="kjonn"
					value="m"/>mann
				<input type="radio" name="kjonn" value="k"/>kvinne
				<p class="feil">${skjema.kjonnFeilmelding}</p>
				<p id="kjonnFeil" class="gjemt feil">Må velge kjønn!</p>
			</div>
			<div class="pure-controls">
				<button id="knapp" type="submit" class="pure-button pure-button-primary">Meld
					meg på</button>
			</div>
		</fieldset>
	</form>
	<p><a href="LoginServlet">Jeg har allerede meldt meg på, jeg vil heller logge inn!</a></p>
	
	<script src="scripts/InputValidering.js"></script>
</body>
</html>