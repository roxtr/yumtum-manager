<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="common/header.jsp"></jsp:include>

<div class="container" style="padding-top:250px;">

<h1>Welcome,&nbsp;${sessionScope['scopedTarget.userPreferences'].fName}&nbsp;${sessionScope['scopedTarget.userPreferences'].lName}</h1>
<ul class="unstyled" >
<li style="padding-bottom:5px;"><a class="btn btn-large btn-primary" type="button" href="restaurants">My Restaurants</a></li>
<li style="padding-bottom:5px;"><c:if test="${sessionScope['scopedTarget.userPreferences'].admin}"><a class="btn btn-large btn-primary" href="admin" type="button">Admin Control</a><br/></c:if></li>
<li style="padding-bottom:5px;"><a class="btn btn-large btn-primary" type="button" href="bookings">Bookings</a></li>
</ul>
</div>

<jsp:include page="common/footer.jsp"></jsp:include>