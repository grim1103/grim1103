<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ page import="net.review.db.*" %>
<%
	ReviewBean review =(ReviewBean)request.getAttribute("reviewdata");
	String id = (String) session.getAttribute("id");
%>

<html>
<head>
	<title>MVC 게시판</title>
	<script language="javascript">
	function replyreview(){
		reviewform.submit();
	}
	</script>
	<style type="text/css">
	
</style>
</head>
<body>
<div id="container">
      
         <div><jsp:include page="/header.jsp" flush="false"></jsp:include></div>

<!-- 게시판 답변 -->
<form action="./ReviewReplyView.re" method="post" name="reviewform">
<input type="hidden" name="REVIEW_NUM" value="<%=review.getREVIEW_NUM() %>">
<input type="hidden" name="REVIEW_RE_REF" value="<%=review.getREVIEW_RE_REF() %>">
<input type="hidden" name="REVIEW_RE_LEV" value="<%=review.getREVIEW_RE_LEV() %>">
<input type="hidden" name="REVIEW_RE_SEQ" value="<%=review.getREVIEW_RE_SEQ() %>">

<table cellpadding="0" cellspacing="0">
	<tr align="center" valign="middle">
		<td colspan="5">답글 달기</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12" height="16">
			<div align="center">글쓴이</div>
		</td>
		<td>
			<input name="REVIEW_NAME" type="hidden" value = "<%=id%>"/><%=id %>
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12" height="16">
			<div align="center">제 목</div>
		</td>
		<td>
			<input name="REVIEW_SUBJECT" type="text" size="50" 
				maxlength="100" value="Re: <%=review.getREVIEW_SUBJECT() %>"/>
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12">
			<div align="center">내 용</div>
		</td>
		<td>
			<textarea name="REVIEW_CONTENTS" cols="67" rows="15"></textarea>
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12">
			<div align="center">비밀번호</div>
		</td>
		<td>
			<input name="REVIEW_PASS" type="password">
		</td>
	</tr>
	
	<tr bgcolor="cccccc">
		<td colspan="2" style="height:1px;">
		</td>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	
	<tr align="center" valign="middle">
		<td colspan="5">
		<a href="javascript:replyreview()">[등록]</a>&nbsp;&nbsp;
		<a href="javascript:history.go(-1)">[뒤로]</a>
		</td>
	</tr>
</table>
</form>
<!-- 게시판 답변 -->
</div>
</body>
</html>