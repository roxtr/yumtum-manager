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
	
	
	
});