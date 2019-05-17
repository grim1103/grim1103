<%@ page language="java" contentType="text/html; charset=euc-kr"
	pageEncoding="euc-kr"%>
<%@ page import="net.news.db.*" %>
<%
	NewsBean news = (NewsBean)request.getAttribute("newsdata");
%>

<html>
<head>
	<title>MVC 게시판</title>
	<link rel="stylesheet" href="css/style.css" />
	<style type="text/css">

	
	
</style>
</head>

<body>
<div id="container">
<div><jsp:include page="/header.jsp"></jsp:include></div>
<!-- 게시판 수정 -->
<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br><br>
		<br>
		<br>
		
<center><table cellpadding="0" cellspacing="0">
	
	
	<tr>
		<td style="font-family:돋음; font-size:20" height="16">
			<div align="center">제 목&nbsp;&nbsp;</div>
		</td>
		
		<td style="font-family:돋움; font-size:20">
		<%=news.getNEWS_SUBJECT()%>
		</td>
	</tr>
	
	<tr bgcolor="cccccc">
		<td colspan="2" style="height:1px;">
		</td>
	</tr>
	
	<tr>
		<td style="font-family:돋음; font-size:20">
			<div align="center">내 용</div>
		</td>
		<td style="font-family:돋음; font-size:20">
			<table border=0 width=700 height=400 style="table-layout:fixed">
				<tr>
					<td valign=top style="font-family:돋음; font-size:20">
					<%=news.getNEWS_CONTENTS() %>
					</td>
				</tr>
			</table>
		</td>
	</tr>

	<tr bgcolor="cccccc">
		<td colspan="2" style="height:1px;"></td>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	
	<tr align="center" valign="middle">
		<td colspan="5">
			<font size=4>
			</a>&nbsp;&nbsp;
			<a href="NewsListAction.ne">[목록]</a>&nbsp;&nbsp;
			</font>
		</td>
	</tr>
</table></center>
<!-- 게시판 수정 -->
</div>
</body>
</html>