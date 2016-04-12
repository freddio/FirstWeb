<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Affichage de la date du jour</title>
</head>
<body>
<h1>
La date du jour est : ${dateDuJour}
</h1>
<br/>
Les données mesurées par le capteur sont :
<br/>
<h2>
${clim1.getTemperature()}<br/>
${clim1.temperatureFarenheit}<br/>
${clim1.pression}<br/>
${clim1.nomAppareil}<br/>
</h2>
</body>
</html>