<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container" style="padding-top:250px;">
<c:forEach var="timing" items="${restTimings}">
	${timing.timeOfDay} &nbsp;&nbsp;&nbsp;${timing.reserveTime} &nbsp;&nbsp;&nbsp;<a href="restaurants/${timing.restautant_id}/timings/${timing.timingId}/update">Update</a> &nbsp; 
</c:forEach>
	<a href="restaurants/${timing.restautant_id}/timing/new">Create New</a><br/>
</div>