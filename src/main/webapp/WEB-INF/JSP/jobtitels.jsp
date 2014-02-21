<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<c:set var='contextPath'
	value='${pageContext.servletContext.contextPath}' />
<!doctype html>
<html lang='nl'>
<head>

<title>Toys for Boys - Jobtitels</title>
<link rel='stylesheet' href='${contextPath}/styles/default.css' />
</head>
<body>

	<h1>Jobtitels</h1>
	<ul class="zonderbolletjes">
		<c:forEach items="${jobTitels}" var="jobtitel">
			<c:url value="/jobtitels.htm" var="jobtitelURL">
				<c:param name="jobTitelNr" value="${jobtitel.id}" />
			</c:url>
			<li class="titels"><a href="${jobtitelURL}">${jobtitel.naam}</a>
			</li>
		</c:forEach>
	</ul>

	<h1>${jobTitel.naam}</h1>

	<c:if test="${not empty jobTitel.werknemers}">
			<c:forEach items="${jobTitel.werknemers}" var="werknemer">
				<c:url value="/werknemer.htm" var="werknemerURL"> 
					<c:param name="werknemersNr" value="${werknemer.werknemersNr}" />
				</c:url>
				<li><a href="${werknemerURL}">${werknemer.volledigeNaam}</a></li>
			</c:forEach>

	</c:if>
</body>
</html>