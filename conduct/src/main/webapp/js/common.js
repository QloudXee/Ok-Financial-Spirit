$("document").ready(function(){
	$("#form1").submit(function(){
		var name = document.getElementById("userName").value;
		var passwrod = document.getElementById("userPassword").value;
		var text = document.getElementById("verify").value;
		if(name == null||name == ""){
			alert("用户名不许为空！")
			return false;
		}else if(passwrod == null || passwrod == ""){
			alert("密码不许为空！")
			return false;
		}else if(text == null||text == ""){
			alert("验证码不许为空！")
		}
		else{
			alert("恭喜你，登录成功！！")
		}
	});


$("#form2").submit(function(){
		var name = document.getElementById("name").value;
		var nameRegex = /^[^@#]{3,16}$/;
		var passwrod = document.getElementById("password").value;
		var repeatpassword = document.getElementById("repassword").value;
		var passwordRegex=/^[0-9A-Za-z_]\w{5,19}$/;
		var mail = document.getElementById("email").value;
		if(name == null||name == ""){
			alert("用户名不许为空！")
			return false;
		}else if(passwrod == null || passwrod == ""){
			alert("密码不许为空！")
			return false;
		}else if(repeatpassword == null || repeatpassword == ""){
			alert("重复密码不许为空！")
			return false;
		}else if(mail == null || mail == ""){
			alert("邮箱不许为空！")
			return false;
		}else if(!nameRegex.test(name)){
			alert("用户名为3~16个字符，且不能包含”@”和”#”特殊字符");
			return false;
		}else if(!passwordRegex.test(passwrod)){
			alert("密码长度必须在6个字符到20个字符之间!")
			return false;
		}else if(repeatpassword != passwrod){
			alert("两次输入的密码不一致！请请重新输入！")
			return false;
		}else{
			alert("恭喜你，注册成功！！")
		}

	});
	
var nums = ["1", "2", "3", "4", "5", "6", "7", "8", "9", "0"];  
var rand1 = nums[Math.floor(Math.random() * nums.length)];  
var rand2 = nums[Math.floor(Math.random() * nums.length)];  
var rand3 = nums[Math.floor(Math.random() * nums.length)];  
var rand4 = nums[Math.floor(Math.random() * nums.length)];  
  
window.onload = function() {  
    var canvas = document.getElementById("verifyCanvas");  
    var context = canvas.getContext("2d");  
  
    // Fill the background  
    context.fillStyle = "#FFFFFF";  
    context.fillRect(0, 0, canvas.width, canvas.height);  
  
    var i = 0;  
    // Draw some random lines  
    for (i = 0; i < 4; i++) {  
        drawline(canvas, context);  
    }  
  
    // Sprinkle in some random dots  
    for (i = 0; i < 30; i++) {  
        drawDot(canvas, context);  
    }  
  
    // Draw the pass-phrase string  
    context.fillStyle = "#FF0000";  
    context.font = "25px Arial";  
    context.fillText(rand1, 10, 20);  
    context.fillText(rand2, 30, 20);  
    context.fillText(rand3, 50, 20);  
    context.fillText(rand4, 70, 20);  
}  
  
function drawline(canvas, context) {  
    context.moveTo(0, Math.floor(Math.random() * canvas.height));  
    context.lineTo(canvas.width, Math.floor(Math.random() * canvas.height));  
    context.lineWidth = 0.5;  
    context.strokeStyle = 'rgb(50,50,50)';  
    context.stroke();  
}  
  
function drawDot(canvas, context) {  
    var px = Math.floor(Math.random() * canvas.width);  
    var py = Math.floor(Math.random() * canvas.height);  
    context.moveTo(px, py);  
    context.lineTo(px+1, py+1);  
    context.lineWidth = 0.2;  
    context.stroke();  
} 

});