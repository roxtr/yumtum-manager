<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="common/header.jsp"></jsp:include>

<div class="container" style="padding-top:250px;">
<c:choose>
	<c:when test="${user['new']}"><c:set var="method" value="post"/>
<form:form modelAttribute="user" method="post">
	<div class="controls">
        <label>login</label> <form:errors path="name" cssClass="errors"/>
        <form:input path="login"  cssClass="input-xlarge" id="index1"/>
              
    </div>
	<div class="controls">
              	<label>Password</label><form:errors path="name" cssClass="errors"/>
              <form:password path="password" cssClass="input-xlarge" id=""/> 
              
    </div>
	
</form:form>
</c:when>
<c:otherwise>
Nothing as of Now
</c:otherwise>
</c:choose>	
</div>

<jsp:include page="common/footer.jsp"></jsp:include>