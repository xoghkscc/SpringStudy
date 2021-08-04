<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="search">
		<div>
			검색할 학생 ID: <input type="text" name="student_id" value="" autocomplete="off" />
		<input type="submit" value="검색" />
		</div>
	</form>
	
	<hr />
	<c:forEach items="${gradeList }" var="grade">
	${grade } <br />
	</c:forEach>
</body>
</html>