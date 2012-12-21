<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<jsp:include page="../common/header.jsp"></jsp:include>


<script type="text/javascript">
  /*  function getTimings(selectObj){
	   var idx = selectObj.selectedIndex; 
	   // get the value of the selected option 
	   var restId = selectObj.options[idx].value; 
	   
	   $.getJSON(restId+'/timings/', function(data){
	   
	     var cSelect = document.getElementById("timings"); 
		   // remove the current options from the country select 
		   var len=cSelect.options.length; 
		   while (len > 0) { 
		   cSelect.remove(0); 
		   len = len-1;
		   }	
		   var newOption; 
		   // create new options 
		   $(data).each(function(k,v){  
		   newOption = document.createElement("option"); 
		   newOption.value = k;  // assumes option string and value are the same 
		   newOption.text=v; 
		   // add the new option 
		   try { 
		   cSelect.add(newOption);  // this will fail in DOM browsers but is needed for IE 
		   }
		   catch (e) { 
		   cSelect.appendChild(newOption); 
		   } 
		   }); 
	   });
	   }
	 */
   
	 
	   function getTimings(selectObj){
		   var idx = selectObj.selectedIndex; 
		   // get the value of the selected option 
		   var restId = selectObj.options[idx].value; 
		   $.getJSON(restId+'/timings/', function(data) {
			  /*  var cSelect = document.getElementById("timings"); 
			   var len=cSelect.options.length; 
			   while (len > 0) { 
			   cSelect.remove(0); 
			   } 
			   var optionStr = "";
			   $(data).each(function(i,val){
				    $.each(val,function(k,v){    
				          var o = new Option(v, k);
				        /// jquerify the DOM object 'o' so we can use the html method
				        $(o).html(v);
				        $('#timings').append(o);
				});



				});*/

			   var cSelect = document.getElementById("timings"); 
			   // remove the current options from the country select 
			   var len=cSelect.options.length; 
			   while (len > 0) { 
			   cSelect.remove(0); 
			   len=len-1;
			   } 
			   var newOption; 
			   // create new options 
			   $(data).each(function(k,val){  
				   
				   $.each(val,function(k,v){    
				          var o = new Option(v, k);
				        /// jquerify the DOM object 'o' so we can use the html method
				        $(o).html(v);
				        $('#timings').append(o);
				});
				   /* 
			   newOption = document.createElement("option"); 
			   newOption.value = k;  // assumes option string and value are the same 
			   newOption.text=v; 
			   // add the new option 
			   try { 
			   cSelect.add(newOption);  // this will fail in DOM browsers but is needed for IE 
			   } 
			   catch (e) { 
			   cSelect.appendChild(newOption); 
			   }  */
			   }); 

	   });
	   }
    
</script>
<div class="container" style="padding-top:250px;">
<form:form modelAttribute="restBooking" method="post">
		<div class="controls">
              <label>Restaurants</label>
              <form:select path="restId" id="select01" onchange="getTimings(this);">
	              <c:forEach begin="0" items="${restaurants}" var="restaurant">
	              	<form:option value="${restaurant.restId}">${restaurant.name}</form:option>
	              </c:forEach>
	          </form:select>
        </div>
        <div class="controls">
        <form:select path="timing_id" id="timings">
        </form:select>
        </div>
        <div class="controls">
        <form:input path="reserveDate" type="text" value="16-02-2012" class="datepicker" id="dp1" />
        </div>
        <div class="controls"> 
        <form:select path="noOfPeople" id="select01">
	              <c:forEach begin="2" end="15" var="seat" step="1">
	              	<form:option value="${seat}">${seat}</form:option>
	              </c:forEach>
	          </form:select> 
        </div>
        <input type="Submit" name="Submit" value="Add Booking"/>
</form:form>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>