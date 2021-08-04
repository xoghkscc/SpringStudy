<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="insert" method="post">
		<div>
			학생이름: <input type="text" name="student_name" value="" autocomplete="off" />
		</div>
		<div>
			성적: <input type="text" name="grade" value="" autocomplete="off" />
		</div>
		<input type="submit" value="성적 기입" />
	</form>
</body>
</html>