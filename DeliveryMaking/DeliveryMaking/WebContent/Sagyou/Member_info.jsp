<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@page import="java.util.List"%>
<%@page import="net.member.db.MemberBean"%>
<%request.setCharacterEncoding("UTF-8"); %>

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
	font-size: 15pt;
}

.aa {
	font-size: 20pt;
}
.b {
	font-size: 25pt;
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
<script type="text/javascript">

	function back(){
		window.history.back();
	}

</script>
</head>
<body>
	<div id="container">
		<div><jsp:include page="/header.jsp"></jsp:include></div>
<br><br><br><br><br><br><br>
<div style="font-size:40pt; font-weight: bold" align="center">Member Information</div>
		<table class="style_Table" align="center">			
			<tr>
				<td class="aa"><center>ID</center> </td>
				<td><%=((MemberBean)session.getAttribute("memberDetail")).getMember_id()%></td>
			</tr>
			<tr>
				<td class="aa"><center>PASS</center> </td>
				<td><%=((MemberBean)session.getAttribute("memberDetail")).getMember_pw()%></td>
			</tr>
			<tr>
				<td class="aa"><center>E-MAIL</center> </td>
				<td><%=((MemberBean)session.getAttribute("memberDetail")).getMember_email()%></td>
			</tr>
			<tr>
				<td class="aa"><center>NAME</center> </td>
				<td><%=((MemberBean)session.getAttribute("memberDetail")).getMember_name()%></td>
			</tr>
			<tr>
				<td class="aa"><center>IDENTIFICATION NUM</center> </td>
				<td><%=((MemberBean)session.getAttribute("memberDetail")).getMember_jumin()%></td>
			</tr>
			<tr>
				<td class="aa"><center>BIRTH</center> </td>
				<td><%=((MemberBean)session.getAttribute("memberDetail")).getMember_birth()%></td>
			</tr>
			<tr>
				<td class="aa"><center>ADDRESS</center> </td>
				<td><%=((MemberBean)session.getAttribute("memberDetail")).getMember_address()%></td>
			</tr>
			<tr>
				<td class="aa"><center>PHONE</center> </td>
				<td><%=((MemberBean)session.getAttribute("memberDetail")).getMember_phone()%></td>
			</tr>
			<tr>
				<td class="aa"><center>POINT</center> </font></td>
				<td><%=((MemberBean)session.getAttribute("memberDetail")).getMember_point()%></td>
			</tr>
			<tr>
				<td class="aa"><center>DATE</center> </font></td>
				<td><%=((MemberBean)session.getAttribute("memberDetail")).getMember_date()%></td>
			</tr>
			
		</table>
		<br>
		<div align="center">
		<input type="button" value="BACK"
					onclick="back()"
					style="width: 80pt; height: 30pt; font-size: 18pt; background-color: transparent;" />
					</div>
	</div>
</body>
</html>