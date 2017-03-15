<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section>
	<h1>${park.parkName}</h1>
	<div class="park_image_detail">
	<c:set value="${park.parkCode}" var="parkCode" />
				<c:set value="${fn:toLowerCase(parkCode)}" var="parkCodeLower" />
		<img class="park_detail_image" src="./img/parks/${parkCodeLower}.jpg"/>
	</div>

<div class="inspirational_quote">
	<c:out value="${park.inspirationalQuote}" />
</div>

<div class="inspirational_quote_source">
	<c:out value="${park.inspirationalQuoteSource}" />
</div>

<div class="park_details">
<p id="park_text">Founded in ${park.yearFounded}, ${park.parkCode} is located in the state of ${park.state} and has ${park.mileOfTrail} miles of trails spread out in its ${park.acreage} acres of natural landscapes. With a typical ${park.climate} climate and an elevation of ${park.elevation} feet, ${park.numberOfAnimalSpecies} different species of animals can be spotted in the park. This park attracts around ${park.annualVisitors} visitors every year, who can choose from ${park.numberOfCampSites} different camp sites.</p>
</div>



</section>





<c:import url="/WEB-INF/jsp/common/footer.jsp" />