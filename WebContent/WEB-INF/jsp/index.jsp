<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="common/header.jsp"></jsp:include>

<div class="container" style="padding-top:250px;">
<%-- <c:set var="user" value="${sessionScope.userPreferences.user}"></c:set> 

<c:choose>
	<c:when test="${user.isEmpty()}"> --%>
<form:form action="login" commandName="loginForm" method="post">
	<div class="controls">
        <label>User Name</label> <form:errors path="userName" cssClass="errors"/>
        <form:input path="userName"  cssClass="input-xlarge"/>
              
    </div>
	<div class="controls">
              	<label>Password</label><form:errors path="password" cssClass="errors"/>
              <form:password path="password" cssClass="input-xlarge"/> 
              
    </div>
    <div class="controls">
    
    <input type="submit" value="Submit" />
    </div>

</form:form>
<%-- </c:when>
<c:otherwise>
Nothing as of Now
</c:otherwise>
</c:choose> --%>	
</div>

<jsp:include page="common/footer.jsp"></jsp:include>