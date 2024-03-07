function loginCheck() {

	console.log("loginCheck");

	if (document.frm.userid.value.length == 0) {
		alert("아이디를 써주세요");
		frm.userid.focus();
		return false;
	}
	if (document.frm.pwd.value == "") {
		alert("암호는 반드시 입력해야 됩니다.");
		frm.pwd.focus();
		return false;
	}
	return true;

}


function idCheck() {

	if (document.frm.userid.value == "") {
		alert("아이디 입력해 주십시오.");
		document.frm.userid.focus();
		return false;
	}
	
	// idCheck.do?userid=user
	let url = "idCheck.do?userid=" + document.frm.userid.value;
	window.open(url, "_blank_1", "width=450, height=200");
	
}

function idok() {
	opener.frm.userid.value = document.frm.userid.value;
	opener.frm.reid.value = document.frm.userid.value;
	self.close();
}

function joinCheck(){
	
	if (document.frm.name.value.length == 0) {
		alert("이름을 써주세요.");
		document.frm.name.focus();
		return false;
	}
	
	if (document.frm.userid.value.length == 0) {
		alert("아이디를 써주세요.");
		document.frm.userid.focus();
		return false;
	}
	
	if (document.frm.userid.value.length < 0) {
		alert("아이디는 4글자 이상이여야만 합니다.");
		document.frm.userid.focus();
		return false;
	}
	
	if (document.frm.pwd.value == "") {
		alert("암호를 반드시 입력해 주십시오.");
		document.frm.pwd.focus();
		return false;
	}

	// 비밀번호 재확인
	if (document.frm.pwd.value != document.frm.pwd_check.value) {
		alert("암호가 일치하지 않습니다.");
		document.pwd.pwd.focus();
		return false;
	}
	
	if(document.frm.reid.value.length == 0){
		alert("중복 체크를 하지 않았습니다.");
		frm.userid.focus();
		return false;
	}
	
	return true;
}



