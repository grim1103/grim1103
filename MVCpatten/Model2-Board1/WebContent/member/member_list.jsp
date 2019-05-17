<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="net.member.db.MemberBean"%>

<%
	List memberList = (List)request.getAttribute("memberlist");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록 보기</title>
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
	color: black;
}

.b {
	font-size: 4rem;
}

body {
	background-image: url("./member/1313.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
</head>
<body>
	<center>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<table border=1 width=300>
			<tr>
				<td class="b" colspan=2>Member List</td>
			</tr>
			<%for (int i=0;i<memberList.size();i++){ 
				MemberBean bean = (MemberBean)memberList.get(i);
	%>
			<tr align=center>
				<td><a
					href="MemberViewAction.me?id=<%=bean.getMember_id() %>"> <%=bean.getMember_id() %></a></td>
				<td><a
					href="MemberDeleteAction.me?id=<%=bean.getMember_id() %>"> 삭제</a></td>
			</tr>
			<%} %>
			<tr align = center> 
        <td colspan="2"> <a href="./BoardList.bo">[게시판 이동]</a> </td> 
    </tr> 
		</table>
	</center>

	</center>
</body>
</html>