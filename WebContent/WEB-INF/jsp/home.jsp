<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="common/header.jsp"></jsp:include>

<div class="container" style="margin-top:150px; position:absolute; margin-left:20px;">
	<h1>Welcome,&nbsp;${sessionScope['scopedTarget.userPreferences'].fName}&nbsp;${sessionScope['scopedTarget.userPreferences'].lName}</h1>
	<div class="well sidebar">
		<ul class="unstyled" >
			<li style="padding-bottom:5px;"><a class="btn btn-large btn-primary" type="button" href="restaurants">My Restaurants</a></li>
			<li style="padding-bottom:5px;"><c:if test="${sessionScope['scopedTarget.userPreferences'].admin}"><a class="btn btn-large btn-primary" href="admin" type="button">Admin Control</a><br/></c:if></li>
			<li style="padding-bottom:5px;"><a class="btn btn-large btn-primary" type="button" href="bookings">Bookings</a></li>
		</ul>
	</div>
	<div class="well bookingstable">
	<h2>Upcoming table bookings</h2>
		<table class="table table-hover" id="bookings">
		        <thead>
		          <tr>
		            
		            <th>Name</th>
		            <th>Persons</th>
		            <th>Time</th>
		            <th>Date</th>
		            <th>Contact Number</th>
		            <th>Email</th>
		
		          </tr>
		        </thead>
	        
	      </table>
	</div>


</div>

<jsp:include page="common/footer.jsp"></jsp:include>