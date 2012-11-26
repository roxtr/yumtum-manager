<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../common/header.jsp"></jsp:include>


<div class="container" style="padding-top:250px;">
<form:form modelAttribute="restTiming" method="post">
		<div class="controls">
              <label>Time of Day</label>
              <form:select path="timeOfDay" id="select01">
	              <form:option value="Breakfast"></form:option>
	              <form:option value="Lunch"></form:option>
	              <form:option value="Dinner"></form:option>
	          </form:select>
        </div>
		<div class="controls">
              <label>Time of Day</label>
              <form:select path="reserveTime" id="select01">
	            <form:option value="12:00">12:00PM</form:option>
				<form:option value="01:00">01:00PM</form:option>
				<form:option value="02:00">02:00PM</form:option >
				<form:option value="07:00">07:00PM</form:option>
				<form:option value="08:00">08:00PM</form:option>
				<form:option value="09:00">09:00PM</form:option>
				<form:option value="10:00">10:00PM</form:option>
	          </form:select>
        </div>
		<div class="controls">
              <label>Total Seats</label>
              <form:input path="totalSeats" cssClass="input-xlarge" id="input01"/>
        </div>
		<div class="controls">
              <label>Available Seats</label>
              <form:input path="availableSeats" cssClass="input-xlarge" id="input01"/>
        </div>
        <form:hidden path="timingId"/>
        <form:hidden path="restaurant_id"/>
        <form:hidden path="createdBy"/>
		<input type="Submit" name="Submit" value="Add Timing"/>
</form:form>
</div>
<jsp:include page="../../common/footer.jsp"></jsp:include>