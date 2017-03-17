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

<<<<<<< HEAD
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
=======
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
	<div class="invitation">
	<h1>Make sure to check out the weather forecast before you visit!</h1>
	</div>

	<div id="five-day-forecast">
		<c:forEach var="weather" items="${weatherForecast}">
<<<<<<< HEAD
			<div class="each-day-forecast">
				<c:set value="${weather.parkCode}" var="parkCode" />
				<c:set value="${fn:toLowerCase(parkCode)}" var="parkCodeLower" />


				<c:if test="${weather.forecast == 'cloudy'}">
=======
			<c:set value="${weather.parkCode}" var="parkCode" />
			<c:set value="${fn:toLowerCase(parkCode)}" var="parkCodeLower" />
			
				
				<c:if test="${weather.forecast == 'snow'}">
>>>>>>> a50f683953af2815b9822d5571b6cb2ab61f5c75
					<c:url value="./img/weather/cloudy.png" var="weatherImgSrc" />
<<<<<<< HEAD
					<img class="weatherImgSrc"  src="${weatherImgSrc}">
					
=======
>>>>>>> e4988e7eae77142067cbea33f83004cd5c6196b5
				</c:if>
				<c:if test="${weather.forecast == 'partly cloudy'}">
					<c:url value="./img/weather/partlyCloudy.png" var="weatherImgSrc" />
					<img class="weatherImgSrc" src="${weatherImgSrc}">
				</c:if>
				<c:if test="${weather.forecast == 'rain'}">
					<c:url value="./img/weather/rain.png" var="weatherImgSrc" />
					<img class="weatherImgSrc" src="${weatherImgSrc}">
				</c:if>
				<c:if test="${weather.forecast == 'snow'}">
					<c:url value="./img/weather/snow.png" var="weatherImgSrc" />
					<img class="weatherImgSrc" src="${weatherImgSrc}">
				</c:if>
				<c:if test="${weather.forecast == 'sunny'}">
					<c:url value="./img/weather/sunny.png" var="weatherImgSrc" />
					<img class="weatherImgSrc" src="${weatherImgSrc}">
				</c:if>
				<c:if test="${weather.forecast == 'sunny'}">
					<c:url value="./img/weather/thunderstorms.png"
						var="weatherImgSrc" />
						<img class="weatherImgSrc" src="${weatherImgSrc}">
				</c:if>
<<<<<<< HEAD


				<c:url value="/weatherDetail" var="weatherDetailUrl">
					<c:param name="fiveDayForecastValue"
						value="${weather.fiveDayForecastValue}" />
					<c:param name="parkCode" value="${weather.parkCode}" />
				</c:url>
				<a href="${weatherDetailUrl}"><img class="weatherImgSrc"
					src="${weatherImgSrc}" /></a>
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
=======
			
		
			<c:url value="/weatherDetail" var="weatherDetailUrl">
<<<<<<< HEAD
			<c:param name="fiveDavForecastValue" value="${weather.fiveDavForecastValue}"/>
=======
			<c:param name="fiveDayForecastValue" value="${weather.fiveDayForecastValue}"/>
			<c:param name="parkCode" value="${weather.parkCode}"/>
>>>>>>> e4988e7eae77142067cbea33f83004cd5c6196b5
			</c:url>
			<a href="${weatherDetailUrl}"><img class="weather-detail-img"
				src="${weatherImgSrc}" /></a>
			<div class="weather-detail">
				<h3>
					<c:out value="${weather.fiveDayForecastValue}" />
				</h3>
				<p>
					<c:out value="${weather.lowF}" />
				</p>
				<p>
					<c:out value="${weather.highF}" />
				</p>
>>>>>>> a50f683953af2815b9822d5571b6cb2ab61f5c75
			</div>
		</c:forEach>
	</div>
>>>>>>> c263a9926d37fbfc208973d8e61b06ac19748331

<span><input type="submit" value="Change to °C"></span>
<div class="five-day-forecast">
    <c:forEach var="weather" items="${weatherForecast}">
    <div class="each-day-forecast">
        <c:set value="${weather.parkCode}" var="parkCode" />
        <c:set value="${fn:toLowerCase(parkCode)}" var="parkCodeLower" />
        
            
            <c:if test="${weather.forecast == 'cloudy'}">
                <c:url value="./img/weather/cloudy.png" var="weatherImgSrc" />
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
        <c:param name="parkCode" value="${weather.parkCode}"/>
        </c:url>
        <a href="${weatherDetailUrl}"><img class="weatherImgSrc" src="${weatherImgSrc}" /></a>
        <div class="weather-detail">
        <c:url value="/parkDetail?parkCode=${parkCode}&temp=C" var="weatherDetailUrlF"/>
        <c:url value="/parkDetail?parkCode=${parkCode}&temp=F" var="weatherDetailUrlC"/>
        <c:out value="${temp}"/>
        <c:if test="${tempSession=='C'}"><a href="${weatherDetailUrlC}">°F </a>/ °C</c:if>
        <c:if test="${tempSession=='F'}"><a href="${weatherDetailUrlF}">°C </a>/ °F</c:if>
        
            <h3>
                <c:out value="Day: ${weather.fiveDayForecastValue}" />
            </h3>
            <p>
                <c:out value="Low: ${weather.lowC}°F" />
            </p>
            <p>
                <c:out value="High: ${weather.highF}°F" />
            </p>
        </div>
        </div>
    </c:forEach>
</div>
</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />