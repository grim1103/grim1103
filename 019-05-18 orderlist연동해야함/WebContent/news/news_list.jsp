<%@ page language="java" contentType="text/html; charset=euc-kr"
	pageEncoding="euc-kr"%>
<%@ page import="java.util.*"%>
<%@ page import="net.news.db.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="euc-kr">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css" />
<%
	List newslist = (List) request.getAttribute("newslist");
	int listcount = ((Integer) request.getAttribute("listcount")).intValue();
	int nowpage = ((Integer) request.getAttribute("page")).intValue();
	int maxpage = ((Integer) request.getAttribute("maxpage")).intValue();
	int startpage = ((Integer) request.getAttribute("startpage")).intValue();
	int endpage = ((Integer) request.getAttribute("endpage")).intValue();	
	
	request.setCharacterEncoding("UTF-8");
	
%>
</head>
<body onload = "check()">


	<div id="container">

		<div><jsp:include page="/header.jsp" flush="false"></jsp:include></div>
		<body>
			<!-- 게시판 리스트 -->
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<table width=75% border="0" cellpadding="0" cellspacing="0"
				align="center">

				<tr align="center" valign="middle">

				</tr>
				<tr align="center" valign="middle" bordercolor="#333333">
					<td style="font-family: Tahoma; font-size: 17pt;" width="8%"
						height="26">
						<div align="center">번호</div>
					</td>
					<td style="font-family: Tahoma; font-size: 17pt;" width="50%">
						<div align="center">제목</div>
					</td>
					<td style="font-family: Tahoma; font-size: 17pt;" width="17%">
						<div align="center">날짜</div>
					</td>
					<td style="font-family: Tahoma; font-size: 17pt;" width="11%">
						<div align="center">조회수</div>
					</td>
				</tr>

				<%
					for (int i = 0; i < newslist.size(); i++) {
						NewsBean bl = (NewsBean)newslist.get(i);
				%>
				<tr align="center" valign="middle" bordercolor="#333333"
					onmouseover="this.style.backgroundColor='F8F8F8'"
					onmouseout="this.style.backgroundColor=''">
					<td height="23" style="font-family: Tahoma; font-size: 15pt;">
						<%=bl.getNEWS_NUM()%>
					</td>

					<td style="font-family: Tahoma; font-size: 15pt;">
						<div align="left">
							<a href="./NewsDetailAction.ne?num=<%=bl.getNEWS_NUM()%>"> <%=bl.getNEWS_SUBJECT()%>
							</a>
						</div>
					</td>

					<td style="font-family: Tahoma; font-size: 15pt;">
						<div align="center"><%=bl.getNEWS_DATE()%></div>
					</td>
					<td style="font-family: Tahoma; font-size: 15pt;">
						<div align="center"><%=bl.getNEWS_READCOUNT()%></div>
					</td>
				</tr>
				<%
					}
				%>
				<tr align=center height=20>
					<td colspan=7 style="font-family: Tahoma; font-size: 15pt;">
						<%
							if (nowpage <= 1) {
						%> [이전]&nbsp; <%
 	} else {
 %> <a href="./NewsList.ne?page=<%=nowpage - 1%>">[이전]</a>&nbsp; <%
 	}
 %> <%
 	for (int a = startpage; a <= endpage; a++) {
 		if (a == nowpage) {
 %> [<%=a%>] <%
 	} else {
 %> <a href="./NewsList.ne?page=<%=a%>">[<%=a%>]
					</a>&nbsp; <%
 	}
 %> <%
 	}
 %> <%
 	if (nowpage >= maxpage) {
 %> [다음] <%
 	} else {
 %> <a href="./NewsList.ne?page=<%=nowpage + 1%>">[다음]</a> <%
 	}
 %>
					</td>
				</tr>
			<%if(session.getAttribute("id").equals("admin")) {%>	
			<tr align="right">		
				<td colspan="5">
					<a href="NewsWrite.ne">	 <img
							class="btnImage" src="image/write.PNG">
					</a>
				</td>
			</tr>
			<%}%>
			</table>

		<div><jsp:include page="/bottom1.jsp" flush="false"></jsp:include></div>
		<div><jsp:include page="/bottom.jsp" flush="false"></jsp:include></div>

	</div>

</body>
</html>
