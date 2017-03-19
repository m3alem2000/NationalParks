<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section class="section">
	<h1 id="survey-thanks">Thank you for taking the survey!</h1>
	<table id="survey-result">
		<c:set value="${park.parkCode}" var="parkCode" />
		<c:set value="${fn:toLowerCase(parkCode)}" var="parkCodeLower" />
		<tr>
			<td>
			<img class="detail-detail-image" src="./img/parks/${parkCodeLower}.jpg"/>
			</td>
		<td style="padding:20px">
			<h3 id="winner">Park <c:out value="${park.parkName}"/> is the winner with <c:out value="${survey.votes}"/> votes!</h3><br>

		</td>
	</table>
</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />