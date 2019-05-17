<%@page import="java.util.List"%>
<%@page import="net.member.db.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="euc-kr"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%request.setCharacterEncoding("UTF-8"); %>
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
	font-size: 15pt;
}

.aa {
	font-size: 15pt;
}

.b {
	font-size: 20pt;
}



table.style_Table th {
	width: 150px;
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
}

table.style_Table td {
	width: 350px;
	padding: 10px;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
}
</style>
</head>
<body>


	<div id="container">
		<div><jsp:include page="/header.jsp"></jsp:include></div>
<br><br><br><br><br><br><br>
	<div style="font-size:30pt; font-weight: bold" align="center">Member List</div>
		<table class="style_Table" align="center">

			<%List<MemberBean> beans = (List<MemberBean>)session.getAttribute("memberbean");
   for(MemberBean bean : beans){ %>
			<tr>
				<td class="aa" style="color: black;"><a
					href="MemberInfoAction.mo?id=<%=bean.getMember_id() %>"> <%=bean.getMember_id() %>
				</a></td>
				<td style="color: black;"><a
					href="MemberDeleteAction.mo?id=<%=bean.getMember_id()%>">Delete</a></td>
			</tr>
			<%}%>
		</table>
	</div>
</body>

</html>