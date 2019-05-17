<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="net.member.db.*"%>
<%
	MemberBean bean = (MemberBean) request.getAttribute("memberList");
	MemberDAO MD=(MemberDAO)request.getAttribute("member_id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 상세보기</title>
<style type="text/css">
table {
	width: 1000px;
}

td {
	text-align: center;
	font-weight: bold;
	font-size: 2rem;
}

.aa {
	font-size: 3rem;
}

body {
	background-image: url("./member/1313.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
<script type="text/javascript">
	function back() {
		window.history.back();
	}
</script>
</head>
<body>
	<center>
		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br>
		<table border=1 width=300>
			<tr>
				<td class="aa"><center>ID</center> </font></td>
				<td><%=bean.getMember_id()%></td>
			</tr>
			<tr>
				<td class="aa"><center>PASS</center> </font></td>
				<td><%=bean.getMember_pw()%></td>
			</tr>
			<tr>
				<td class="aa"><center>E-MAIL</center> </font></td>
				<td><%=bean.getMember_email()%></td>
			</tr>
			<tr>
				<td class="aa"><center>NAME</center> </font></td>
				<td><%=bean.getMember_name()%></td>
			</tr>
			<tr>
				<td class="aa"><center>IDENTIFICATION NUM</center> </font></td>
				<td><%=bean.getMember_jumin()%></td>
			</tr>
			<tr>
				<td class="aa"><center>BIRTH</center> </font></td>
				<td><%=bean.getMember_birth()%></td>
			</tr>
			<tr>
				<td class="aa"><center>INTEREST</center> </font></td>
				<td><%=bean.getMember_hobby()%></td>
			</tr>
			<tr>
				<td class="aa"><center>MEMO</center> </font></td>
				<td><%=bean.getMember_mempr()%></td>
			</tr>
			<tr>
				<td colspan=2 align="center"><a href="MemberListAction.me">리스트로
						보기</a></td>
			</tr>
		</table>
	</center>
</body>
</html>