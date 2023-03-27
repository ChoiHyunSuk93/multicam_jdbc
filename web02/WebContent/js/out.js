function 로그인() {
	id2 = 'root'
	id = prompt('아이디 입력')
	if (id == id2) {
		alert('로그인 성공')
	} else {
		alert('로그인 실패')
	}
}

function 비교() {
	n1 = 100
	n2 = 200
	if (n1 == n2) {
		alert('같다')
	} else {
		alert('다르다')
	}

	f1 = prompt('친구 기분 어때?')
	f2 = prompt('내 기분 어때?')
	if (f1 == f2) {
		alert('같네')
	} else {
		alert('따로 놀자')
	}
}