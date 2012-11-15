<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../common/header.jsp"></jsp:include>

<div class="container" style="padding-top:250px;">
<form:form modelAttribute="restaurant" method="post">
		<div class="controls">
              <label>Restaurant Name</label>
              <form:input path="name" cssClass="input-xlarge" id="input01"/>
        </div>
		<div class="controls">
              	<label>Contact Numbers</label>
              <form:input path="phones" cssClass="input-xlarge" id="input02"/>
        </div>
		<div class="controls">
              	<label>City</label>
              <form:input path="city" cssClass="input-xlarge" id="input02"/>
         </div>
		<div class="controls">
              	<label>Locality</label>
              <form:input path="locality" cssClass="input-xlarge" id="input02"/>
        </div>
		<div class="controls">
              	<label>Address</label>
              <form:input path="address" cssClass="input-xlarge" id="input02"/>
        </div>
        <div class="controls">
           	<label>Latitude</label>
             <form:input path="latitude" cssClass="input-xlarge" id="input04"/>
	    </div>
	    <div class="controls">
              	<label>Longitude</label>
              <form:input path="longitude" cssClass="input-xlarge" id="input04"/>
		</div>
		<div class="controls">
         	<label>Average Cost for Two</label>
            <form:input path="avgCostForTwo" cssClass="input-xlarge" id="input02"/>   
        </div>
	    <div class="controls">
            <form:checkbox path="hasWifi" label="Has Wifi" value="0"/>    
        </div>
		
		<div class="controls">
            <form:checkbox path="acceptCC" label="Accepts CC"  value="0"/>    
        </div>
        
		<div class="controls">
            <form:checkbox path="isVeg" label="Serves NonVeg"  value="0"/>    
        </div>
        
		<div class="controls">
            <form:checkbox path="hasAC" label="Has AC"  value="0"/>    
        </div>
        <div class="controls">
        	<label>Notification Phone Number</label>
            <form:input path="nfsPhone" cssClass="input-xlarge" id="input02"/>
        </div>
        <form:button name="Submit" value="Submit"/>
</form:form>
</div>

<jsp:include page="../common/footer.jsp"></jsp:include>