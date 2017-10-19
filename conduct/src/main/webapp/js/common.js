$("document").ready(function(){
	/*$("#form1").submit(function(){
		var name = document.getElementById("userName").value;
		var passwrod = document.getElementById("userPassword").value;
		if(name == null||name == ""){
			alert("用户名不能为空！")
			return false;
		}else if(passwrod == null || passwrod == ""){
			alert("密码不能为空！")
			return false;
		}
		else{
			alert("恭喜你，登录成功！！")
		}
	});*/

$("#login").click(function(){
		var name = document.getElementById("userName").value;
		var nameRegex = /^[^@#]{3,16}$/;
		var passwrod = document.getElementById("userPassword").value;
		var repeatpassword = document.getElementById("repeatPassword").value;
		var passwordRegex=/^[0-9A-Za-z_]\w{5,19}$/;
		var mail = document.getElementById("email").value;
		if(name == null||name == ""){
			alert("用户名能许为空！")
			return false;
		}else if(passwrod == null || passwrod == ""){
			alert("密码不能为空！")
			return false;
		}else if(repeatpassword == null || repeatpassword == ""){
			alert("重复密码不能为空！")
			return false;
		}else if(mail == null || mail == ""){
			alert("邮箱不能为空！")
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
			var username1 = $("#name").val();
			var password1 = $("#password").val();
			var repassword1 = $("#repassword").val();
			var email1 = $("#eamil").val();
			var sex1 = $("#sex").val();
			window.location.href = "regiest.do?name="+username1+"&password="+password1+"&repassword1="+repassword1+"&email="+email1;
		}
	});

});