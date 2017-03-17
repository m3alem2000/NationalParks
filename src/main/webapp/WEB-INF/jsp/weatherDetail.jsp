<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section>
	<div>
		<h1>
			<c:out value="${park.parkName}" />
		</h1>
		<h3>
			Day
			<c:out value="${weather.fiveDayForecastValue}" />
			Forecast
		</h3>

		<c:set value="${weather.forecastPngString}" var="forecastPngString" />
		<c:url value="./img/weather/${forecastPngString}.png"
			var="weatherImgSrc" />
		<img src="${weatherImgSrc}" alt="${forecastPngString}" />

		<c:if test="${tempSession}">
			<p>
				<c:out value="Low: ${weather.lowF}°F" />
			</p>
			<p>
				<c:out value="High: ${weather.highF}°F" />
			</p>
		</c:if>
		<c:if test="${!tempSession}">
			<p>
				<c:out value="Low: ${weather.lowC}°C" />
			</p>
			<p>
				<c:out value="High: ${weather.highC}°C" />
			</p>
		</c:if>
		
		<c:url var="weatherDetailPost" value="/weatherDetail">
			<c:param name="parkCode" value="${park.parkCode}"/>
			<c:param name="fiveDayForecastValue" value="${weather.fiveDayForecastValue}"/>
		</c:url>
		<form action="${weatherDetailPost}" method="POST">
			<c:if test="${tempSession}">
				<input type="hidden" name="temp" value=false>
				<input type="submit" value="Change to C">
			</c:if>
			<c:if test="${!tempSession}">
				<input type="hidden" name="temp" value=true>
				<input type="submit" value="Change to F">
			</c:if>
		</form>
		
		
		
		
		
		<ul>
			<c:if test="${weather.extremeWeather}">
				<li><c:out value="${weather.extremeWeatherAdvisory}" /></li>
			</c:if>
			<c:if test="${weather.tempDiffGreaterThan20Fahr}">
				<li><c:out value="${weather.tempDiffAdvisory}" /></li>
			</c:if>
			<c:if test="${weather.tempBelow20Fahr}">
				<li><c:out value="${weather.tempBelow20FahrAdvisory}" /></li>
			</c:if>
		</ul>
		<c:url value="/parkDetail" var="parkDetailUrl">
			<c:param name="parkCode" value="${park.parkCode}"/>
		</c:url>
		<a href="${parkDetailUrl}">Return to Previous Page</a>
	</div>
</section>

















<c:import url="/WEB-INF/jsp/common/footer.jsp" />