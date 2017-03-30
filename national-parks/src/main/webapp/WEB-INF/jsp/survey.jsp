<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:import url="/WEB-INF/jsp/common/header.jsp"/>

<section class="survey-section">
<form action="survey" method="POST">
	<div id="survey-list-main-div">
		<h1 id="survey-title">Please fill out the survey below, select your favorite park and find out what is the favorite park in the Geek Community:</h1>
		<table>
		  <!-- <tr><td></td>
		  	<td><h1>Please fill out the survey below and you will find out which park is the top favorite park!</h1></td>
		  	
		  </tr> -->
		  <tr>
		  	<td></td>
		  	<c:if test="${flag==false}"><td style="color:red">Please fill all fields</td></c:if>
		  </tr>
		  <tr>
		  <td align="right"><strong>Select a Park</strong></td>
		   <td>
			<select name="parkCode" id="parkName">
				<c:forEach var="park" items="${parks}">
				  		<option value="${park.parkCode}"<c:if test="${park.parkCode==parkCode}">selected</c:if>>${park.parkName}</option>
				</c:forEach>
			</select>
			</td>
		  </tr>
		  <tr>
		  	<td></td>
		  </tr>
		  <tr>
			<td align="right"><strong>E-mail</strong></td>
			<td>
			<c:if test="${flag==false}">
			<input style="border: 2px solid #CD0A0A;" type="text" name="emailAddress" id="emailAddress" value="${email}">
			</c:if>
			<c:if test="${flag!=false}">
			<input type="text" name="emailAddress" id="emailAddress">
			</c:if>
			</td>
		  </tr>
		  <tr>
			<td align="right">
				<label for="state"><strong>State</strong> </label>
			</td>
			<td>
			<select name="state" id="state">
				<option value="AL">Alabama</option>
				<option value="AK">Alaska</option>
				<option value="AZ">Arizona</option>
				<option value="AR">Arkansas</option>
				<option value="CA">California</option>
				<option value="CO">Colorado</option>
				<option value="CT">Connecticut</option>
				<option value="DE">Delaware</option>
				<option value="DC">District Of Columbia</option>
				<option value="FL">Florida</option>
				<option value="GA">Georgia</option>
				<option value="HI">Hawaii</option>
				<option value="ID">Idaho</option>
				<option value="IL">Illinois</option>
				<option value="IN">Indiana</option>
				<option value="IA">Iowa</option>
				<option value="KS">Kansas</option>
				<option value="KY">Kentucky</option>
				<option value="LA">Louisiana</option>
				<option value="ME">Maine</option>
				<option value="MD">Maryland</option>
				<option value="MA">Massachusetts</option>
				<option value="MI">Michigan</option>
				<option value="MN">Minnesota</option>
				<option value="MS">Mississippi</option>
				<option value="MO">Missouri</option>
				<option value="MT">Montana</option>
				<option value="NE">Nebraska</option>
				<option value="NV">Nevada</option>
				<option value="NH">New Hampshire</option>
				<option value="NJ">New Jersey</option>
				<option value="NM">New Mexico</option>
				<option value="NY">New York</option>
				<option value="NC">North Carolina</option>
				<option value="ND">North Dakota</option>
				<option value="OH">Ohio</option>
				<option value="OK">Oklahoma</option>
				<option value="OR">Oregon</option>
				<option value="PA">Pennsylvania</option>
				<option value="RI">Rhode Island</option>
				<option value="SC">South Carolina</option>
				<option value="SD">South Dakota</option>
				<option value="TN">Tennessee</option>
				<option value="TX">Texas</option>
				<option value="UT">Utah</option>
				<option value="VT">Vermont</option>
				<option value="VA">Virginia</option>
				<option value="WA">Washington</option>
				<option value="WV">West Virginia</option>
				<option value="WI">Wisconsin</option>
				<option value="WY">Wyoming</option>
			</select>	
			</td>
		  </tr>
		  
		  		  <tr>
		  	<td align="right"><strong>Activity Level</strong></td>
		  	<td>			
		  	  <select name="activityLevel" id="activityLevel">
				<option value="inactive"<c:if test="${activityLevel=='inactive'}">selected</c:if>>Inactive</option>
				<option value="sedentary"<c:if test="${activityLevel=='sedentary'}">selected</c:if>>Sedentary</option>
				<option value="active"<c:if test="${activityLevel=='active'}">selected</c:if>>Active</option>
				<option value="extremely active"<c:if test="${activityLevel=='extremely active'}">selected</c:if>>Extremely Active</option>
			  </select>
			  </td>
		  </tr>
		  <tr><td><br></td><td></td></tr>
		  <tr><td></td>
		  <td><input id="formSubmitButton" type="submit" value="Submit"></td>
		  </tr>
		</table>
	</div>
</form>
</section>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>