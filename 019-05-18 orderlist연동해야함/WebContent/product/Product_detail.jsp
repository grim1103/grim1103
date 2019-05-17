<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import = "net.product.db.ProductBean" %>
       <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>상품목록</title>
<style type="text/css">
img {
	image-rendering: auto;
	
}

table, tr, td {
	border: 1px #000000;
	vertical-align: top;
	text-align: center;
	font-size: 25pt;
}

th {
	/*        border: 1px solid #000000; */
	font-weight: bold;
	vertical-align: top;
	background: #ededed;
}

a {
	font-size: 25pt;
	color: #000000;
}

</style>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="css/style.css" />
</head>
<body>

	<div><jsp:include page="/header.jsp" flush="false"></jsp:include></div>
	<jsp:useBean id="now" class="java.util.Date" />
	<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss" var="date" />
	<img style="width: 360px; height: 360px;" src="<%=((ProductBean) session.getAttribute("detailProduct")).getProduct_image()%>" />
	<form method = "post" action="ProdcutUpdateView.po">
	<table>
	
		<tr>
			<th colspan="2">상품등록</th>
		<tr>
			<th>상품코드</th>
			<td><%=((ProductBean) session.getAttribute("detailProduct")).getProduct_code()%>
			</td>
		</tr>

		<tr>
			<th>상품분류</th>
			<td><%=((ProductBean) session.getAttribute("detailProduct")).getProduct_category()%></td>
		</tr>

		<tr>
			<th>상품이름
			</td>
			<td><%=((ProductBean) session.getAttribute("detailProduct")).getProduct_name()%></td>
		</tr>

		<tr>
			<th>수량</th>
			<td><%=((ProductBean) session.getAttribute("detailProduct")).getProduct_count()%></td>
		</tr>


		<tr>
			<th>원가</th>
			<td><%=((ProductBean) session.getAttribute("detailProduct")).getProduct_cost()%></td>
		</tr>

		<tr>
			<th>판매가</th>
			<td><%=((ProductBean) session.getAttribute("detailProduct")).getProduct_price()%>
			</td>
		</tr>

		<tr>

			<th>순수익</th>
			<td><%=((ProductBean) session.getAttribute("detailProduct")).getProduct_price()
					- ((ProductBean) session.getAttribute("detailProduct")).getProduct_cost()%></td>
		</tr>

		<tr>
			<th>&emsp; 상품상세 설명 &emsp;</th>
			<td><%=((ProductBean) session.getAttribute("detailProduct")).getProduct_detail()%>
			</td>
		</tr>

		<tr>
			<th>상품등록일</th>
			<td>&emsp; ${date } &emsp;</td>
		</tr>

	</table>
	<br>
	<br>
	<a href="ProductUpdateView.po?code=<%=((ProductBean) session.getAttribute("detailProduct")).getProduct_code()%>">수정</a> &emsp; &emsp;
	<a href="ProductList.po">목록</a>
	

		<div><jsp:include page="/NewFile.jsp" flush="false"></jsp:include></div>
	 
		<div><jsp:include page="/bottom1.jsp" flush="false"></jsp:include></div>
		<div><jsp:include page="/bottom.jsp" flush="false"></jsp:include></div>
		


	<tr>
		<td>수량</td><td colspan="3">&nbsp;:&nbsp;<%=((ProductBean)session.getAttribute("detailProduct")).getProduct_count() %></td>
		<td>상품등록일</td>
		<td>
			<input type="text" name="date" id="date" value="${date}" readonly>
		</td>
	</tr>
</table>
</form>
</body>
</html>