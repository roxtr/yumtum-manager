<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="common/header.jsp"></jsp:include>

<div class="container" style="padding-top:250px;">


user-${sessionScope['scopedTarget.userPreferences'].name}  <br/><br/>
First Name-${sessionScope['scopedTarget.userPreferences'].fName}  <br/><br/>
Last Name-${sessionScope['scopedTarget.userPreferences'].lName}  <br/><br/>
message: ${sessionScope['scopedTarget.userPreferences'].dispMsg}  <br/><br/>




</div>

<jsp:include page="common/footer.jsp"></jsp:include>
