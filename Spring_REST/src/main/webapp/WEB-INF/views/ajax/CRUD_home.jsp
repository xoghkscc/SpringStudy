<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3># CRUD 연습에 사용했던 테이블을 통해 다음을 만들어주세요</h3>
	<ol>
		<li>갱신 버튼을 누르면 페이지가 변하지 않으면서 CRUD 테이블의 모든 내용을 display 테이블에
			출력한다.(가장 최근에 추가한 것이 맨 위에 등장)</li>
		<li>display 테이블 맨 윗줄에는 새로운 행을 추가할 수 있는 입력란이 존재하고 추가 버튼을 누르면 페이지가
			변하지 않으면서 추가와 함께 테이블 목록이 갱신</li>
		<li>display 테이블의 데이터 행의 맨 오른쪽에는 삭제 버튼이 존재하며 삭제버튼을 누르면 해당 행이 삭제되며
			테이블 목록이 갱신된다.</li>
	</ol>


	<hr />
	<form id="insert">
	<table id="display" border="1px">
		<tr>
			<th>학번</th>
			<th>이름</th>
			<th>성적</th>
			<th>삭제</th>
		</tr>
		<tr>
			<td><input type="hidden" /> </td>
			<td><input type="text" name="name" autocomplete="off"/> </td>
			<td><input type="text" name="grade" autocomplete="off" /> </td>
		</tr>
	</table>
	
	<button id="insertBtn">추가</button>
	</form>
	<button id="selectAll">갱신</button>
	<br />
	
	<script src="<%=request.getContextPath()%>/resources/js/grade.js"></script>
</body>
</html>