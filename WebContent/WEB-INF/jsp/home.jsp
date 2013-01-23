<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="common/header.jsp"></jsp:include>

<div class="container" style="margin-top:150px;">
<h1>Welcome,&nbsp;${sessionScope['scopedTarget.userPreferences'].fName}&nbsp;${sessionScope['scopedTarget.userPreferences'].lName}</h1>
<table class="table">
        <thead>
          <tr>
            <th>#</th>
            <th>Name</th>
            <th>Persons</th>
            <th>Time</th>
            <th>Contact Number</th>

          </tr>
        </thead>
        <tbody>
          <tr class="upcoming-bookings">
            <td>1</td>
            <td>Sripathi Pai</td>
            <td>2</td>
            <td>1230</td>
			<td>123456789
          
          
        
		</td>
          </tr>
          <tr class="upcoming-bookings">
            <td>2</td>
            <td>Hareesh</td>
            <td>2</td>
            <td>1300</td>
			<td>
          9980638839
          
        
		</td>
          </tr>
          <tr class="past-bookings">
            <td>3</td>
            <td>Bhargava</td>
            <td>10</td>
            <td>1930</td>
			<td>
          9316802797
          
        
		</td>
          </tr>
        </tbody>
      </table>


<ul class="unstyled" >
<li style="padding-bottom:5px;"><a class="btn btn-large btn-primary" type="button" href="restaurants">My Restaurants</a></li>
<li style="padding-bottom:5px;"><c:if test="${sessionScope['scopedTarget.userPreferences'].admin}"><a class="btn btn-large btn-primary" href="admin" type="button">Admin Control</a><br/></c:if></li>
<li style="padding-bottom:5px;"><a class="btn btn-large btn-primary" type="button" href="bookings">Bookings</a></li>
</ul>
</div>

<jsp:include page="common/footer.jsp"></jsp:include>