<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../common/header.jsp"></jsp:include>

<div class="container" style="padding-top:250px;">
<form:form modelAttribute="restaurant" method="post">
		<div class="controls">
              <label for="input01">Restaurant Name</label>
              <form:input path="name" cssClass="input-xlarge" id="input01"/>
        </div>
		<div class="controls">
              	<label>Contact Numbers</label>
              <form:input path="phones" cssClass="input-xlarge" id="input02"/>
        </div>
		<div class="controls">
              	<label>City</label>
              <form:input path="city" cssClass="input-xlarge" id="input03"/>
         </div>
		<div class="controls">
              	<label>Locality</label>
              <form:input path="locality" cssClass="input-xlarge" id="input04"/>
        </div>
		<div class="controls">
              	<label>Address</label>
              <form:input path="address" cssClass="input-xlarge" id="input05"/>
        </div>
        <div class="controls">
           	<label>Latitude</label>
             <form:input path="latitude" cssClass="input-xlarge" id="input06"/>
	    </div>
	    <div class="controls">
              	<label>Longitude</label>
              <form:input path="longitude" cssClass="input-xlarge" id="input07"/>
		</div>
		<div class="input-prepend">
         	<label>Average Cost for Two</label>
         	<span class="add-on">$</span>
            <form:input path="avgCostForTwo" cssClass="input-xlarge" id="input08"/>   
            
        </div>
	    <label class="checkbox inline">
            <form:checkbox path="hasWifi" label="Has Wifi" value="1"/>    
        </label>
		
		<label class="checkbox inline">
            <form:checkbox path="acceptCC" label="Accepts CC"  value="1"/>    
        </label>
        
		<label class="checkbox inline">
            <form:checkbox path="isVeg" label="Serves NonVeg"  value="1"/>    
        </label>
        
		<label class="checkbox inline">
            <form:checkbox path="hasAC" label="Has AC"  value="1"/>    
        </label>
        <div class="controls">
        	<label>Notification Phone Number</label>
            <form:input path="nfsPhone" cssClass="input-xlarge" id="input02"/>
        </div>
        <form:hidden path="rest_createdBy" value="${sessionScope['scopedTarget.userPreferences'].userId}"/>
        <input type="Submit" name="Submit" value="Add/Update Restaurant" class="btn btn-large btn-primary"/>
        
</form:form>
</div>

<jsp:include page="../common/footer.jsp"></jsp:include>