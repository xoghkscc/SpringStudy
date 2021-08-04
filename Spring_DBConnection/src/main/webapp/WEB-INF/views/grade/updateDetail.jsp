<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="updateDb" method="post">
	<div>
		<input type="hidden" name="student_id" value="${updateGrade.student_id }"/>
		학생이름: <input type="text" name="student_name" value="${updateGrade.student_name }"
			autocomplete="off" />
	</div>
	<div>
		성적: <input type="text" name="grade" value="${updateGrade.grade }" autocomplete="off" />
	</div>
	<input type="submit" value="성적 수정" />
	</form>
</body>
</html>