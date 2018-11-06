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