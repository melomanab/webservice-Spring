<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>webservice Spring</title>
</head>

<body>
	<h1>Bienvenue sur l'application webservice-Spring</h1>
	
		
	<h2>
	<c:url value="/api/client" var="webserviceUrl" />
	<a href="${webserviceUrl}">Acceder à la liste de clients depuis l'application </a>
	</h2>
	
	<h2>
	<a href="http://localhost:8080/webservice_1.0/api/client">Acceder à la liste de clients depuis une autre application</a>
	</h2>
	<p>(depuis la même machine)</p>
	

</body>
</html>