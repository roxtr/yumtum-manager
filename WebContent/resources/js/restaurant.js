// TO do add validations for the submit button and add ajax form submission
$(document).ready(function(){
	
	$('input[type=text]').blur(function(e)
			{
			    if( !$(this).val() ) {
			          $("#"+e.target.id).parent('div').addClass('control-group error');
			    }
			    
			    
			});
	$('input[type=text]').click(function(e)
			{
				id =e.target.id;
				$("#"+id).focus();
			   $("#"+id).tooltip({
				   title:"Please enter your"+" "+$("#"+id).parent('div').children().text(),
					trigger:"focus",
					placement:'right',
			   });
			  
			   if($("#"+id).parent('div').hasClass('control-group error'))
				{
				   $("#"+id).parent('div').removeClass('control-group error').addClass('input-xlarge');
				}
			    
			});
	
	$("form").submit(function() {
	    var isFormValid = true;
	    $(".input-xlarge").each(function() {
	        if ($.trim($(this).val()) == "") {
	            $(this).addClass("control-group error");
	            isFormValid = false;
	        } else {
	            $(this).removeClass("control-group error").addClass('input-xlarge');
	        }
	    });
	    // the following lines should be placed here
	    if (!isFormValid) {
	        alert("Please fill in all the required fields (indicated by *)");
	    }
	    return isFormValid;
	});
	
	
	
});