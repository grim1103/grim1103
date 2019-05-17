<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%
	int num=Integer.parseInt(request.getParameter("num"));
%>
<html>
<head>
<title>MVC 게시판</title>
</head>
<body>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<center><form name="deleteForm" action="./BoardDeleteAction.bo?num=<%=num %>" 
	method="post">
<table>
<tr>
	<td style="font-size:17pt;">
		<font size=5>글 비밀번호 : </font>
	</td>
	<td >
		<input name="BOARD_PASS" type="password" style="font-size:17pt;">
	</td>
</tr>
<tr>
	<td colspan=2 align=center>
	<font size=4>
		<a href="javascript:deleteForm.submit()">삭제</a>
		&nbsp;&nbsp;
		<a href="javascript:history.go(-1)">돌아가기</a>
		</font>
	</td>
</tr>
</table>
</form></center>
</body>
</html>