<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript" src="Climatisation.js"></script>

</head>
<body>
<c:if test="${not empty sessionScope.pseudo}">
<div>${sessionScope.pseudo} est connecté</div>
<a href="LogoutController">se déconnecter</a><br/>
</c:if>
<c:if test="${empty sessionScope.pseudo}">
<a href="LoginController">se connecter</a><br/>
</c:if>
<a href="ListClimatisationController">liste des climatisations</a><br/>
<br/>
<br/>

<form action="ClimatisationController" method="POST">
	<label>nom appareil</label>
	<input id="sourceNbId" type="text" value="${appareil}" name="appareil"/>
	<span style="color:red">${appareilErreur}</span>
	<span id="nbId" style="color:blue"></span>
	
	<br/>
	<label>temperature</label><input type="text" value="${temperature}" name="temperature"/><span style="color:red">${temperatureErreur}</span><br/>
	<label>pression</label><input type="text" value="${pression}" name="pression"/><span style="color:red">${pressionErreur}</span><br/>
	<label>humidite</label><input type="text" value="${humidite}" name="humidite"/><span style="color:red">${humiditeErreur}</span><br/>
	<input type="submit" value="enregistrer" name="action"/><span style="color:red">${sauvegardeErreur}</span>
</form>


</body>
</html>