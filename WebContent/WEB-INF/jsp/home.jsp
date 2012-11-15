<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="common/header.jsp"></jsp:include>

<div class="container" style="padding-top:250px;">

Welcome,&nbsp;${sessionScope['scopedTarget.userPreferences'].fName}&nbsp;${sessionScope['scopedTarget.userPreferences'].lName}
<br/><br/>
<a href="restaurants">My Restaurants</a>
<a href="bookings">Bookings</a>

</div>

<jsp:include page="common/footer.jsp"></jsp:include>