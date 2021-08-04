<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>수정할 학생의 정보를 클릭하세요</h1>
	<c:forEach items="${gradeList }" var="grade">
		<a href="update?student_id=${grade.student_id }">${grade }</a>
		<br />
	</c:forEach>
</body>
</html>