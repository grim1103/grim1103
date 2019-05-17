<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!doctype html>
<html lang="ko">
<head>

<meta charset="euc-kr">
<title>NogiCoffee</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="css/style.css" />
</head>
<body>

	
	<div id="container">
		
		<div><jsp:include page="header.jsp" flush="false"></jsp:include></div>
		<div><jsp:include page="banner.jsp" flush="false"></jsp:include></div>
		<div><jsp:include page="board_1.jsp" flush="false"></jsp:include></div>

		<div><jsp:include page="best.jsp" flush="false"></jsp:include></div>
		<div><jsp:include page="bottom1.jsp" flush="false"></jsp:include></div>
		<div><jsp:include page="bottom.jsp" flush="false"></jsp:include></div>
			

	</div>
</body>