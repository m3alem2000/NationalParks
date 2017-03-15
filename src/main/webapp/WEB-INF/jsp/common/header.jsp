<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>National Park Geek</title>
</head>
<body>
	<header>
		<c:url value="/" var="homeLink"/>
		<c:url value="/img/logo.png" var="logoSrc"/>
		<a href="${homeLink}">
			<img id="home-page-logo" src="${logoSrc}" alt="NPG Logo"/>
		</a>
	</header>
	<nav>
	
	</nav>