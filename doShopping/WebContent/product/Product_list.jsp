<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="net.product.db.ProductBean"%>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<%
	List<ProductBean> beans = (List<ProductBean>)session.getAttribute("productbean");
%>
<br><br><br><br><br>
<div style="font-size:35pt;font-weight: bold" align="center">상품 목록</div>
<br><br>
<table class="style_Table" border="0"align="center">

	<tr align="center" style=font-size:20pt ;>
		<td>코드</td>
		<td>상품이름</td>
		<td>가격</td>
		<td>재고</td>
		<td>상품등록일</td>
		<td>상품삭제</td>
	</tr>
	<%for(ProductBean bean : beans){ %>

	<tr align="center" style="font-size:18pt">
		<td><a href="ProductDetailAction.po?code=<%=bean.getProduct_code() %>">
         	<%=bean.getProduct_code() %>
         	</a></td>

		<td><%=bean.getProduct_name() %></td>
		<td><%=bean.getProduct_count() %></td>
		<td><%=bean.getProduct_price() %></td>
		<td><%=bean.getProduct_date() %></td>
		<td><a href = "ProductDeleteAction.po?code=<%=bean.getProduct_code() %>">
			Delete
			</a></td>
	</tr>
	<%} %>

</table>
<a href="ProductAddForm.po"><button>등록</button></a>
<a href="AdminPage.mo"><button>돌아가기</button></a>


</body>
</html>