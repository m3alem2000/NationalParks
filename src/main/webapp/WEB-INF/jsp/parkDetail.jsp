<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section>
	<h1 id="detail-title">${park.parkName}</h1>

	<div class="detail-pic-and-quote">
		<div class="park-image-detail">
			<c:set value="${park.parkCode}" var="parkCode" />
			<c:set value="${fn:toLowerCase(parkCode)}" var="parkCodeLower" />
			<img class="park-detail-image" src="./img/parks/${parkCodeLower}.jpg" />
		</div>

		<p id="inspirational-quote">
			<c:out value="${park.inspirationalQuote}" />
		</p>

		<p id="inspirational-quote-source">
			<c:out value="${park.inspirationalQuoteSource}" />
		</p>
	</div>

	<div class="park-detail-description">
		<p id="park-text">Founded in ${park.yearFounded}, ${park.parkCode}
			is located in the state of ${park.state} and has ${park.mileOfTrail}
			miles of trails spread out in its ${park.acreage} acres of natural
			landscapes. With a typical ${park.climate} climate and an elevation
			of ${park.elevation} feet, ${park.numberOfAnimalSpecies} different
			species of animals can be spotted in the park. This park attracts
			around ${park.annualVisitors} visitors every year, who can choose
			from ${park.numberOfCampSites} different camp sites.</p>
	</div>


	<div class="five-day-forecast">
		<c:forEach var="weather" items="${weatherForecast}">
		<div class="each-day-forecast">
			<c:set value="${weather.parkCode}" var="parkCode" />
			<c:set value="${fn:toLowerCase(parkCode)}" var="parkCodeLower" />
			
				
				<c:if test="${weather.forecast == 'cloudy'}">
					<c:url value="./img/weather/cloudy.png" var="weatherImgSrc" />
					<a href="${detailWeather}"><img class="weatherImgSrc"  src="${weatherImgSrc}"></a>
					
				</c:if>
				<c:if test="${weather.forecast == 'partly cloudy'}">
					<c:url value="./img/weather/partlyCloudy.png" var="weatherImgSrc" />
				</c:if>
				<c:if test="${weather.forecast == 'rain'}">
					<c:url value="./img/weather/rain.png" var="weatherImgSrc" />
				</c:if>
				<c:if test="${weather.forecast == 'snow'}">
					<c:url value="./img/weather/snow.png" var="weatherImgSrc" />
				</c:if>
				<c:if test="${weather.forecast == 'sunny'}">
					<c:url value="./img/weather/sunny.png" var="weatherImgSrc" />
				</c:if>
				<c:if test="${weather.forecast == 'thunderstorms'}">
					<c:url value="./img/weather/thunderstorms.png" var="weatherImgSrc" />
				</c:if>
			
		
			<c:url value="/weatherDetail" var="weatherDetailUrl">
			<c:param name="fiveDayForecastValue" value="${weather.fiveDayForecastValue}"/>
			</c:url>
			<a href="${weatherDetailUrl}"><img class="weatherImgSrc" src="${weatherImgSrc}" /></a>
			<div class="weather-detail">
				
				<h3>
					<c:out value="Date: ${weather.fiveDayForecastValue}" />
				</h3>
				<p>
					<c:out value="Low temp: ${weather.lowF}°F" />
				</p>
				<p>
					<c:out value="High temp: ${weather.highF}°F" />
				</p>
			</div>
			</div>
		</c:forEach>
	</div>

</section>



<c:import url="/WEB-INF/jsp/common/footer.jsp" />