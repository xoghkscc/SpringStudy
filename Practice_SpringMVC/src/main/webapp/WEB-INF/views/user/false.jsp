<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입에 실패하였습니다</h1>
	
	<button onclick="toGoJoin()">돌아가기</button>
	
	
	<script>
		function toGoJoin() {
			location.replace("./join");
		}
	</script>
</body>
</html>