<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:choose>
<c:when test="${not empty sessionScope.pseudo}">
<div>${sessionScope.pseudo} est connecté</div>
<a href="LogoutController">se déconnecter</a><br/>
</c:when>
<c:otherwise>
<a href="LoginController">se connecter</a><br/>
</c:otherwise>
</c:choose>
<a href="ClimatisationController">saisie d'une climatisation</a><br/>
<br/>
<br/>
	
	<span style="color:red">${rechercheDataErreur}</span>
	<c:forEach var="clim" items="${climatisations}">
		<!--  il appelle getPression() -->
		<h2>${clim.nomAppareil} ------ ${clim.pression}</h2>
	
	</c:forEach>
	
	
	
	
</body>
</html>