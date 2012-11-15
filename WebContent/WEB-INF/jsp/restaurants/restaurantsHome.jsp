<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../common/header.jsp"></jsp:include>

<div class="container" style="padding-top:250px;">

Object :<c:out value="${restaurants}"></c:out><br/>
Name :<c:out value="${restaurants.name}"></c:out><br/>
Locality :<c:out value="${restaurants.locality}"></c:out><br/>
City :<c:out value="${restaurants.city}"></c:out><br/>

</div>

<jsp:include page="../common/footer.jsp"></jsp:include>