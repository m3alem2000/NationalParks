<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section>

<div class="home-title">
	<h1>The top 10 National parks to visit in America</h1>
	</div>
	<c:forEach var="park" items="${parks}">
		<div class="park-list-div">
			<div class="park-list-snippet-div">
				<c:set value="${park.parkCode}" var="parkCode" />
				<c:set value="${fn:toLowerCase(parkCode)}" var="parkCodeLower" />
				
				<c:url value="/img/parks/${parkCodeLower}.jpg" var="parkImgSrc"/>
				<c:url value="/parkDetail" var="parkDetailUrl">
					<c:param name="parkCode" value="${parkCode}" />
				</c:url>
				<a href="${parkDetailUrl}"><img id="${parkCode}" class="park-list-img" src="${parkImgSrc}" /></a>

				<h3><c:out value="${park.parkName}"/></h3>
				<p><c:out value="${park.state}"/></p>
				<p><c:out value="${park.description}"/></p>
			</div>
		</div>
	</c:forEach>
</section>









<c:import url="/WEB-INF/jsp/common/footer.jsp" />