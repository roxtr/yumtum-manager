<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML >
<html>
	
		<head>
		<meta charset="utf-8">
    <title>YumTum, an awesome way to book tables</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	<!-- HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
	 <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
	<!--link href="/resources/css/bootstrap-responsive.css" rel="stylesheet"-->
	<link href="<c:url value="/resources/css/yumtum-custom.css"/>" rel="stylesheet">
	<link href="<c:url value="resources/css/datepicker.css"/>" rel="stylesheet">
	<script src="<c:url value="/resources/js/jquery.js"/>"></script>
	<script>
		$(document).ready(function (){		
		$('#dp1').datepicker({
    format: 'dd-mm-yyyy'
	});
	
	$('.btn.btn-info').click(function(e){
		var x= ($(this).parent().attr('id'));
		$("#"+x+''+'>'+'p').hide();
		//$('<textarea id ="commentid" rows="10" cols="30">The cat was playing in the garden.</textarea>').appendTo("#"+x+'');
		var y = $('p').text();
		console.log(""+y);
		if($('#commentid').length==0){
			
			$('<textarea id ="commentid" rows="10" cols="30" style="width:700px;height:100px;"></textarea>').appendTo("#"+x+'');
			
		}
		

		
	});
	$(".upcoming-bookings").popover({
				
				content:"Your upcoming table bookings",
				trigger:"hover",
				placement:'top'
	});
	
	$(".past-bookings").popover({
				
				content:"Your past table bookings",
				trigger:"hover",
				placement:'top'
	});
	
	$(".my-reviews").mouseenter( function(event){
		$(this).find(".btn.btn-info").show();
		$(this).find(".btn.btn-danger").show()
	});
	$(".my-reviews").mouseleave( function(event){
		$(this).find(".btn.btn-info").hide();
		$(this).find(".btn.btn-danger").hide()
	});
});
	</script>
	</head>
	<body style="background-image:url('http://subtlepatterns.com/patterns/white_bed_sheet.png');background-repeat:repeat;">
	<div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container" id="loginbar">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="#">yumtum</a>
          <div class="nav-collapse">
            <ul class="nav">
              <li class="active"><a href="#">Home</a></li>
              <li><a href="#about">About</a></li>
              <li><a href="#contact">Pricing</a></li>
			  <li><a href="#contact">How it Works</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        <ul class="nav pull-right" id="loginname"> <li id="fat-menu" class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Sripathi Pai<b class="caret"></b></a><ul class="dropdown-menu"><li><a href="profile.html">My Profile</a></li><li><a href="#">My Bookings</a></li><li class="divider"></li><li id="logout"><a href="#">Logout</a></li></ul></li></ul></div>
      </div>
	  </div>
	  
	  