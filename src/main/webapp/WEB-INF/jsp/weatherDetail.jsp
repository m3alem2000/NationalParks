<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section>
	<div>
		<h1><c:out value="${park.parkName}"/></h1>
		<h3>Day <c:out value="${weather.fiveDayForecastValue}"/></h3>
		<c:set value="${weather.forecastPngString}" var="forecastPngString"/>
		<c:url value="./img/weather/${forecastPngString}.png" var="weatherImgSrc"/>
		<img src="${weatherImgSrc}" alt="${forecastPngString}"/>

	</div>
</section>

















<c:import url="/WEB-INF/jsp/common/footer.jsp" />