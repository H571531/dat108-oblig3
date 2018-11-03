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
<title>Påmeldingsbekreftelse</title>
</head>
<body>
	<h2>Påmeldingsbekreftelse</h2>
	<p>Påmeldingen er mottatt for</p>
	<p>
		&nbsp;&nbsp;&nbsp;${bekreftet.fornavn}<br />
		&nbsp;&nbsp;&nbsp;${bekreftet.etternavn}<br />
		&nbsp;&nbsp;&nbsp;${bekreftet.mobil}<br /> &nbsp;&nbsp;&nbsp;${(bekreftet.kjonn == 'k') ? "Kvinne" : "Mann" }
	</p>
	<a href="DeltakerListeServlet">Gå til deltagerlisten</a>
</body>
</html>