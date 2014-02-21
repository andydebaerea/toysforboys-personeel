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

	<h1>Opslag voor ${werknemer.volledigeNaam}</h1>
	
	Huidig salaris
	<h4>
		<fmt:formatNumber>${werknemer.salaris}</fmt:formatNumber>
	</h4>

	<c:url value='/opslag.htm' var='opslagURL'>
		<c:param name='werknemersNr' value='${werknemer.werknemersNr}' />
	</c:url>
	<form action='${opslagURL}' method='post'>
		<label>Bedrag: <input name='opslagBedrag' size='6'
			value='${param.opslagBedrag}' type='number' autofocus />
		</label> <input type='submit' value='Opslag' />
	</form>
	<c:forEach items="${fouten}" var="fout">
	<div class="fouten">${fout}</div>
	
	</c:forEach>

</body>
</html>