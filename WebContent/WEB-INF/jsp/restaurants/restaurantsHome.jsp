<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../common/header.jsp"></jsp:include>

<div class="container" style="padding-top:250px;">
<c:forEach var="restaurant" items="${restaurants}">
	${restaurant.name} &nbsp;<a href="restaurants/${restaurant.restId}/update">Update</a> &nbsp; <a href="restaurants/${restaurant.restId}/timings">Timings</a>
	<a href="restaurants/${restaurant.restId}/update">${restaurant.name}</a><br/>
</c:forEach>
	<a href="restaurants/new">Create New</a><br/>
</div>

<jsp:include page="../common/footer.jsp"></jsp:include>