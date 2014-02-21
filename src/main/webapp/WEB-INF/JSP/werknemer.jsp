<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<c:set var='contextPath'
	value='${pageContext.servletContext.contextPath}' />
<!doctype html>
<html lang='nl'>
<head>

<title>Toys for Boys - Werknemer</title>
<link rel='stylesheet' href='${contextPath}/styles/default.css' />
</head>

<body>

	<h1>Werknemer ${werknemer.volledigeNaam}</h1>

	Voornaam
	<h4>${werknemer.voornaam}</h4>
	Familienaam
	<h4>${werknemer.familienaam}</h4>
	Email adres
	<h4>${werknemer.emailAdres.adres}</h4>
	Salaris
	<h4><fmt:formatNumber>${werknemer.salaris}</fmt:formatNumber></h4> 
	Jobtitel
	<h4>${werknemer.jobTitel.naam}</h4>
	<c:url value="/werknemer.htm" var="URLmetChefNr">
		<c:param name="werknemersNr" value="${werknemer.chef.werknemersNr}" />
	</c:url>
	<c:if test="${not empty werknemer.chef}">
	Chef
			<h4>
			<a href="${URLmetChefNr}">${werknemer.chef.volledigeNaam}</a>
		</h4>
	</c:if>
	<c:if test="${not empty werknemer.ondergeschikten}">
		
	Ondergeschikten
	<ul class="zonderbolletjes">

			<c:forEach items="${werknemer.ondergeschikten}" var="ondergeschikte">
				<c:url value="/werknemer.htm" var="URLmetondergeschikteNr">
					<c:param name="werknemersNr" value="${ondergeschikte.werknemersNr}" />
				</c:url>
				<li><a href="${URLmetondergeschikteNr}">${ondergeschikte.volledigeNaam}</a></li>
			</c:forEach>
		</ul>
	</c:if>
	Foto
	<div>
		<img alt="${werknemer.volledigeNaam}"
			src="${contextPath}/images/${werknemer.werknemersNr}.jpg"
			title="${werknemer.volledigeNaam}">
	</div>
	<c:url value="/opslag.htm" var="opslagURL">
					<c:param name="werknemersNr" value="${werknemer.werknemersNr}" />
				</c:url>
				<a href="${opslagURL}">Opslag</a>
</body>

</html>