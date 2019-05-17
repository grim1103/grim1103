<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="net.board.db.*" %>

<%
	List boardList=(List)request.getAttribute("boardlist");
	int listcount=((Integer)request.getAttribute("listcount")).intValue();
	int nowpage=((Integer)request.getAttribute("page")).intValue();
	int maxpage=((Integer)request.getAttribute("maxpage")).intValue();
	int startpage=((Integer)request.getAttribute("startpage")).intValue();
	int endpage=((Integer)request.getAttribute("endpage")).intValue();
%>

<html>
<head>

	<title>Q&A</title>
	<link rel="stylesheet" href="css/style.css"/>
	<style>
	
	Button {
 	background-color: transparent;
 	border: 0px none;
}

.btnImage {
 	background-color: transparent;
 	vertical-align: middle;
	/* background: url("loginButton.png") no-repeat; */
	border: 0px none;
	cursor: pointer;
	clear: none;
	float: none;
}
	
	</style>
</head>



<body>	
<div id="container">
      
         <div><jsp:include page="/header.jsp" flush="false"></jsp:include></div>
         <div><jsp:include page="anq.jsp" flush="false"></jsp:include></div>

         <div><jsp:include page="/bottom1.jsp" flush="false"></jsp:include></div>
         <div><jsp:include page="/bottom.jsp" flush="false"></jsp:include></div>

   </div>

</body>
</html>