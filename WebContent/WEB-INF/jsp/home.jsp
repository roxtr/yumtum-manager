<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="common/header.jsp"></jsp:include>

<div class="container" style="padding-top:250px;">

Welcome,&nbsp;${sessionScope['scopedTarget.userPreferences'].fName}&nbsp;Last Name-${sessionScope['scopedTarget.userPreferences'].lName}

<a href="./restaurants">Restaurants Home</a>
<a href="./bookings">Bookings Home</a>

</div>

<jsp:include page="common/footer.jsp"></jsp:include>