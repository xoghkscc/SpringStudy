<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3># CRUD ������ ����ߴ� ���̺��� ���� ������ ������ּ���</h3>
	<ol>
		<li>���� ��ư�� ������ �������� ������ �����鼭 CRUD ���̺��� ��� ������ display ���̺�
			����Ѵ�.(���� �ֱٿ� �߰��� ���� �� ���� ����)</li>
		<li>display ���̺� �� ���ٿ��� ���ο� ���� �߰��� �� �ִ� �Է¶��� �����ϰ� �߰� ��ư�� ������ ��������
			������ �����鼭 �߰��� �Բ� ���̺� ����� ����</li>
		<li>display ���̺��� ������ ���� �� �����ʿ��� ���� ��ư�� �����ϸ� ������ư�� ������ �ش� ���� �����Ǹ�
			���̺� ����� ���ŵȴ�.</li>
	</ol>


	<hr />
	<form id="insert">
	<table id="display" border="1px">
		<tr>
			<th>�й�</th>
			<th>�̸�</th>
			<th>����</th>
			<th>����</th>
		</tr>
		<tr>
			<td><input type="hidden" /> </td>
			<td><input type="text" name="name" autocomplete="off"/> </td>
			<td><input type="text" name="grade" autocomplete="off" /> </td>
		</tr>
	</table>
	
	<button id="insertBtn">�߰�</button>
	</form>
	<button id="selectAll">����</button>
	<br />
	
	<script src="<%=request.getContextPath()%>/resources/js/grade.js"></script>
</body>
</html>