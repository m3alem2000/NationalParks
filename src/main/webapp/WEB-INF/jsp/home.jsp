<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp"/>

<section>
	<c:forEach var="park" items="${parks}">
	<div class="park-list-div">
		<div class="park-list-img-div">
			<c:set value="enp" var="parkCode"/>
			<c:url value="/img/parks/${parkCode}.jpg" var="parkImgSrc"/>
			<img class="park-list-img" src="${parkImgSrc}"/>
		</div>
		<div class="park-list-snippet-div">
			<h3>Example National Park</h3>
			<p>Somewhere, Some State</p>
			<p>Here is a short summary of the park</p>
		</div>
	</div>
	</c:forEach>
</section>









<c:import url="/WEB-INF/jsp/common/footer.jsp"/>