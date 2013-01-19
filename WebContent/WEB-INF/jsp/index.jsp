<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="common/header.jsp"></jsp:include>

<div class="container" style="padding-top:150px; padding-right:120px;">
<%-- <c:set var="user" value="${sessionScope.userPreferences.user}"></c:set> 

<c:choose>
	<c:when test="${user.isEmpty()}"> --%>
<form:form action="login" commandName="loginForm" method="post" class="hero-unit form-horizontal">
	<div class="control-group">
		
	   <label class="control-label" for="userName">User Name</label> <form:errors path="userName" cssClass="errors"/>
	        <div class="controls">
	        	<form:input path="userName"  cssClass="input-xlarge" placeholder="Username"/>
	              
	   		 </div>
    </div>
    <div class="control-group">
	
              	<label class="control-label" for="password">Password</label><form:errors path="password" cssClass="errors"/>
              	<div class="controls">
              <form:password path="password" cssClass="input-xlarge" placeholder="Password"/> 
              
    </div>
    </div>
    <div class="control-group">
    <div class="controls controls-row">
    <label class="checkbox">
        <input  type="checkbox"> Remember me
       <a style="padding:0 1px 0 67px; display:inline" href="/account/resend_password">Forgot password?</a> 
      </label>
      
    
   <button class="btn btn-large btn-block btn-primary" type="submit">Sign in</button>
    </div>
    </div>

</form:form>
<%-- </c:when>
<c:otherwise>
Nothing as of Now
</c:otherwise>
</c:choose> --%>
	
</div>
<div id="footer">
	      
	         <a style="padding-right: 50px; padding-top:100px;"class="pull-right" href="http://roxtr.com">a roxtr product</a>
	     
	    </div>	

<jsp:include page="common/footer.jsp"></jsp:include>