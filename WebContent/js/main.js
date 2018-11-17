function swap_register() {
	var login = document.getElementById("login");
	login.style.display = "none";
	var register = document.getElementById("register");
	register.style.display = "block";
	var con=document.getElementById("container");
	con.style.top="0";
}

function swap_login() {
	var register = document.getElementById("register");
	register.style.display = "none";
	var login = document.getElementById("login");
	login.style.display = "block";
	var con=document.getElementById("container");
	con.style.top="50px";
}

function setVCode()
{
	var vCode = document.getElementById('vCode');
	vCode.src="ValidateImageServlet"+"?"+(new Date()).valueOf();
	//vCode.src="validateImage";
}	

function check() {
	var pd1 = document.getElementById("password").value;
	var pd2 = document.getElementById("password2").value;
	var sp = document.getElementById("sp");
	if(pd1 != pd2) {
		span.style.color="#ff0000";
		span.style.padding="0";
		span.innerHTML = "错误";
	} else {
		span.innerHTML = "";
	}
}

function notnull() {
	var name = document.getElementById("username").value;
	var spname = document.getElementById("spname");
	if(name == "") {
		spname.style.color="#ff0000";
		spname.style.padding="0";
		spname.innerHTML = "不可为空";
	} else {
		spname.innerHTML = "";
	}
	
	var password = document.getElementById("password").value;
	var sppwd = document.getElementById("sppwd");
	if(password == "") {
		sppwd.style.color="#ff0000";
		sppwd.style.padding="0";
		sppwd.innerHTML = "不可为空";
	} else {
		sppwd.innerHTML = "";
	}
}

//function typeSerch() {
//	var type = document.getElementsByName("type");
//	alert(type);
//}

