<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
	<h3>#연습문제</h3>
	<ul>
		<li>다양한 회원정보를 입력받는다.(생일 포함)</li>
		<li>POST방식으로 회원정보와 함께 요청하면 전달한 회원 정보를 서버의 data/user에 파일 형태로 저장</li>
		<li>파일 이름은 중복이 생기지 않도록 조심해야한다.</li>
		<li>누락된 정보가 있는경우 회원가입 실패 페이지로 넘어가야 한다.</li>
		<li>회원가입에 성공하면 회원가입 성공페이지를 5초간 보여준 후 다시 홈으로 이동</li>
	</ul>
	<hr />

	<form action="./controller" method="post">
		<div>
			아이디: <input type="text" name="id" value="" autocomplete="off" />
		</div>
		<div>
			비밀번호: <input type="password" name="pw" value="" />
		</div>
		<div>
			이름: <input type="text" name="name" value="" autocomplete="off" />
		</div>
		<div>
			나이: <input type="number" name="age" value="0" autocomplete="off" />
		</div>
		<div>
			생일: <input type="date" name="birth" value="" />
		</div>
		<div>
			취미: 
			<label for="baseball" >야구</label><input id="baseball" type="checkbox" name="hobby" value="야구" />
			<label for="soccer" >축구</label><input type="checkbox" id="soccer" name="hobby" value="축구" />
			<label for="basketball" >농구</label><input type="checkbox" id="basketball" name="hobby" value="농구" />
		</div>
		<input type="submit" value="회원가입" />		
	</form>
</body>
</html>