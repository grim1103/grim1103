<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ page import = "net.member.db.*" %>
<%@ page import = "net.review.db.*" %>
<html>
<head>
<title>MVC 게시판</title>
<script language="javascript">
	function addreview() {
		reviewform.submit();
	}
</script>
<style>

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
<% String id = (String)session.getAttribute("id"); 
ReviewBean review = (ReviewBean)request.getAttribute("reviewdata");
%>
</head>

<body>

	<div id="container">
		<div><jsp:include page="/header.jsp"></jsp:include></div>

		<!-- 게시판 등록 -->
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<center>
			<div style="font-size:35pt; font-weight: bold">글쓰기</div>
			<form action="./ReviewAddAction.re" method="post" name="reviewform">
				<table class="style_table" cellpadding="0" cellspacing="0">
					
					<tr>
						<td style="font-family: 돋음; font-size: 20" height="16">
							<div align="center">글쓴이</div>
						</td>
						<td style="font-size: 20";>
						<input name="REVIEW_NAME" type="hidden" size="10" maxlength="10" value="<%=id %>"><%=id %>
						</td>
					</tr>
				
					<tr>
						<td style="font-family: 돋음; font-size: 20" height="16">
							<div align="center">비밀번호</div>
						</td>
						<td><input name="REVIEW_PASS" style="font-size: 20"
							;type="password" size="20" maxlength="20" value="" /></td>
					</tr>
				
					<tr>
						<td style="font-family: 돋음; font-size: 20" height="16">
							<div align="center">제 목</div>
						</td>
						<td><input name="REVIEW_SUBJECT" type="text" size="50"
							maxlength="100" style="font-size: 20" ;
				value="" /></td>
					</tr>
					
					<tr>
						<td style="font-family: 돋음; font-size: 20">
							<div align="center">내 용</div>
						</td>
						<td><textarea name="REVIEW_CONTENTS" cols="90" rows="30"></textarea>
						</td>
					</tr>
					
					
				</table>
				<a href="javascript:addreview()"><img
								src="image/o.PNG"></a>&nbsp;&nbsp; <a
							href="javascript:history.go(-1)"><img src="image/c.PNG"></a>
				<div><jsp:include page="/bottom.jsp"></jsp:include></div>
			</form>
		</center>
	</div>
	<!-- 게시판 등록 -->
</body>
</html>