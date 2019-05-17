<%@ page language="java" contentType="text/html; charset=EUC-KR"%>

<html>
<head>
<title>MVC 게시판</title>
<script language="javascript">
	function addboard() {
		boardform.submit();
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
			<form action="./BoardAddAction.bo" method="post"
				enctype="multipart/form-data" name="boardform">
				<table class="style_table" cellpadding="0" cellspacing="0">
					
					<tr>
						<td style="font-family: 돋음; font-size: 20" height="16">
							<div align="center">글쓴이</div>
						</td>
						<td style="font-size: 20">${id} <input name="BOARD_NAME"
							type="hidden" size="10" maxlength="10" value="${id}" readonly />
						</td>
					</tr>
				
					<tr>
						<td style="font-family: 돋음; font-size: 20" height="16">
							<div align="center">비밀번호</div>
						</td>
						<td><input name="BOARD_PASS" style="font-size: 20"
							type="password" size="20" maxlength="20" value="" /></td>
					</tr>
				
					<tr>
						<td style="font-family: 돋음; font-size: 20" height="16">
							<div align="center">제 목</div>
						</td>
						<td><input name="BOARD_SUBJECT" type="text" size="50"
							maxlength="100" style="font-size: 20" ;
				value="" /></td>
					</tr>
					
					<tr>
						<td style="font-family: 돋음; font-size: 20">
							<div align="center">내 용</div>
						</td>
						<td><textarea name="BOARD_CONTENT" cols="90" rows="30"></textarea>
						</td>
					</tr>
					<tr>
						<td style="font-family: 돋음; font-size: 20">
							<div align="center">파일 첨부&nbsp;</div>
						</td>
						<td><input name="BOARD_FILE" type="file"
							style="font-size: 20" ;/></td>
					</tr>
					
					
				</table>
				<a href="javascript:addboard()"><img
								src="image/o.PNG"></a>&nbsp;&nbsp; <a
							href="javascript:history.go(-1)"><img src="image/c.PNG"></a>
				<div><jsp:include page="/bottom.jsp"></jsp:include></div>
			</form>
		</center>
	</div>
	<!-- 게시판 등록 -->
</body>
</html>