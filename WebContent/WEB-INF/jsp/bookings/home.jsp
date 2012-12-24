<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"></jsp:include>
<div class="container" style="padding-top:250px;">

<c:forEach var="booking" items="${restBookings}">
	${booking.reserveDate} &nbsp;&nbsp;&nbsp;${booking.noOfPeople} &nbsp;&nbsp;&nbsp;Rest-${booking.restId} &nbsp;&nbsp;&nbsp;Timing-${booking.timing_id} &nbsp;&nbsp;&nbsp;<br/> 
</c:forEach>
	<a href="bookings/new">Create New</a><br/>
</div>

<jsp:include page="../common/footer.jsp"></jsp:include>