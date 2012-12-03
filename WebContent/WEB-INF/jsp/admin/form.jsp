<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../common/header.jsp"></jsp:include>


<div class="container" style="padding-top:250px;">
<form:form modelAttribute="user" method="post">
		<div class="controls">
              <label>Name</label>
              <form:input path="name" cssClass="input-xlarge" id="input01"/>
        </div>
        <div class="controls">
              <label>Password</label>
              <form:password path="password" cssClass="input-xlarge" id="input01"/>
        </div>
        <div class="controls">
              <label>First Name</label>
              <form:input path="fName" cssClass="input-xlarge" id="input01"/>
        </div>
        <div class="controls">
              <label>Last Name</label>
              <form:input path="lName" cssClass="input-xlarge" id="input01"/>
        </div>
        <div class="controls">
              <label>Locality</label>
              <form:input path="locality" cssClass="input-xlarge" id="input01"/>
        </div>
        <div class="controls">
              <label>Address</label>
              <form:input path="address" cssClass="input-xlarge" id="input01"/>
        </div>
        <div class="controls">
              <label>E-mail</label>
              <form:input path="email" cssClass="input-xlarge" id="input01"/>
        </div>
        <div class="controls">
              <label>Phone</label>
              <form:input path="phone" cssClass="input-xlarge" id="input01"/>
        </div>
        <div class="controls">
              <label>Admin Privileges</label>
              <form:checkbox path="admin" cssClass="input-xlarge" id="input01"/>
        </div>
        <div class="controls">
              <label>Can Create Restaurants?</label>
              <form:input path="restaurantCreate" cssClass="input-xlarge" id="input01"/>
        </div>
        <input type="submit" value="Create User"/>
</form:form>
</div>

<jsp:include page="../common/footer.jsp"></jsp:include>