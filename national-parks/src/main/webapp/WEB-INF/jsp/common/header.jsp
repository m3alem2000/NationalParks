<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>National Park Geek</title>
</head>
<body>
	<header>
		<c:url value="/" var="homeLink" />
		<c:url value="/img/logo.png" var="logoSrc" />
		<a href="${homeLink}"> 
			<img id="home-page-logo" src="${logoSrc}"
			alt="NPG Logo" />
		</a>
		<c:url value="/survey" var="surveyLink" />
		<a id="survey-link-anchor" href="${surveyLink}">
			<div id="survey-link">
				<p id="survey-link-text">Take Our Survey!</p>
			</div>
		</a>
	</header>