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
<title>Deltakerliste</title>
</head>
<body>
	<h2>Deltakerliste</h2>
	<table class="pure-table">
		<tr bgcolor="#cccccc">
			<th>Kjønn</th>
			<th align="left">Navn</th>
			<th align="left">Mobil</th>
		</tr>
		<c:forEach var="deltaker" items="${liste}">
		
		<tr ${(deltaker.mobil == mobil) ? 'bgcolor="#aaffaa"' : 'bgcolor="ffffff"' }>
		
			<c:choose>
				<c:when test="${deltaker.kjonn == 'k' }"><td align="center">&#9792;</td></c:when>
				<c:otherwise><td align="center">&#9794;</td></c:otherwise>
			</c:choose>
			<td>${deltaker.fornavn} ${deltaker.etternavn}</td>
			<td>${deltaker.mobil}</td>
		</tr>
		</c:forEach>
	</table>
	<p>
		<a href="LogoutServlet">Ferdig</a>
	</p>
</body>
</html>