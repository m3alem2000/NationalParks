<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:import url="/WEB-INF/jsp/common/header.jsp"/>

<section>
	<c:forEach var="park" items="${parks}">
	<div class="park-list-div">
		<div class="park-list-img-div">
		<c:set value="${park.parkCode}" var="parkCode"/>
			<c:set value="${fn:toLowerCase(parkCode)}" var="parkCodeLower"/>
			<c:url value="/img/parks/${parkCodeLower}.jpg" var="parkImgSrc"/>
			<img class="park-list-img" src="${parkImgSrc}"/>
		</div>
		<div class="park-list-snippet-div">
			<h3>${park.parkName}</h3>
			<p>${park.parkName}</p>
			<p>${park.description}</p>
		</div>
	</div>
	</c:forEach>
</section>









<c:import url="/WEB-INF/jsp/common/footer.jsp"/>