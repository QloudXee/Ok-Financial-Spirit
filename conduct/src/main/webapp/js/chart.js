$(document).ready(function(){

	$(".chart1").click(function(){
		if($("#chart").is(":hidden")){
			$("#chart").show();
			$("#chart").animate(2000);
		}else{	
				$("#chart").hide();				
				$("#chart").animate(2000);
				
			}
	});

	$(".chart2").click(function(){
		if($("#chartOne").is(":hidden")){
			$("#chartOne").show();
			$("#chartOne").animate(2000);
		}else{	
				$("#chartOne").hide();				
				$("#chartOne").animate(2000);
				
			}
	});



});