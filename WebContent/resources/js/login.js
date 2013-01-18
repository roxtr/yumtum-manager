$(document).ready(function(){
	$('input[name=submit]').click(function(){
		if (($('input[name=userName]').val())==""|| ($('input[name=password]').val())=="") 
		 {
			 $('input[name=userName]').addClass("control-group error");
			 $('input[name=password]').addClass("control-group error");
		 }
		 
		 else
			 {
			 $.ajax({
			        url: 'loginvalidation.jsp',
			        type: 'post',
			        dataType: 'json',
			        data: $('form #loginForm').serialize(),
			        success: function(response) 
			        {
			        	if(response=="success")
			        		{
			        			
			        		}
			        	else
			        		{
			        		 $('input[name=userName]').addClass("control-group error");
			    			 $('input[name=password]').addClass("control-group error");
			        		}
			                   
			        }
			    });
			 }
			
				
	});
	
});