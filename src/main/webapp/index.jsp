<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<c:set var='contextPath'
	value='${pageContext.servletContext.contextPath}' />
<!doctype html>
<html lang='nl'>
<head>

<title>Toys for Boys - Menu</title>
<link rel='stylesheet' href='${contextPath}/styles/default.css' />
</head>
<body>

	<h1>Menu</h1>

	<ul>
		<li><a href='<c:url value="/werknemer.htm" />'>Werknemershiërarchie</a></li>
		<li><a href='<c:url value="/jobtitels.htm" />'>Jobtitels</a></li>
	</ul>
</body>
</html>