<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Ajax Home</title>
</head>
<body>
	<h1># Ajax</h1>

	<ul>
		<li>�������� ��� �ε�ǰ� �� �Ŀ� ������ �����͸� ��û�� �� �ֽ��ϴ�.</li>
		<li>�������� �ٽ� �ε��� �ʿ���� ������Ʈ �� �� �ֽ��ϴ�</li>
		<li>��׶���� ������ �����͸� ������ �� �־��ϴ�.</li>
	</ul>

	<hr />

	<div id="test">
		<h4>�޾ƿ� �����͸� �̰��� ����� ����</h4>
	</div>
	
	<ul id="testList">
		<li>������ ����ִ� ����Ʈ</li>
	</ul>
	
	<button onclick="loadStr()">getSrt()���� ������ ��������</button> <br /><br />
	<button id="sampleAsyncBtn">getSample()���� ������ ��������</button> <br /><br />
	<button id="asyncJsonDataBtn">JSON �����Ϳ� �Բ� �񵿱��û ������</button> <br /><br />
	
	
	
	<!-- ������ �ڿ��� ����� ���� servlet-context�� �ڿ� ��θ� ����ؾ� �Ѵ�.	 -->
	<script src="<%=request.getContextPath()%>/resources/js/ajax_home.js"></script>

</body>
</html>