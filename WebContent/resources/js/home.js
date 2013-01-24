$(document).ready(function(e){
	var data = { "bookings" : [ ["Sripathi", 2,1300,13/01/2013,123456789,"sripathi@gmail.com"],["Sriram", 4,1330,13/01/2013,123456789,"sriram@gmail.com"],["Shaila", 2,1430,13/01/2013,123456789,"sriram@gmail.com"],["Hareesh", 4,1530,13/01/2013,123456789,"hareesh@gmail.com"], ["Prady", 8,1830,14/01/2013,123456789,"prady@gmail.com"], ["Sadashiva", 14,1930,14/01/2013,123456789,"saddy@gmail.com"], ["Bhargava", 9,2130,15/01/2013,123456789,"bhargava@gmail.com"] ]};
	
	$(data.bookings).each(function(index, element){  
	     $('#bookings').append('<tr><td> '+element[0]+' </td> <td> '+element[1]+' </td> <td> '+element[2]+' </td> <td> '+element[3]+' </td> <td> '+element[4]+' </td> <td> '+element[5]+' </td> </tr>');       
	})
		
});