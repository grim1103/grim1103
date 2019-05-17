<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h2 {
	text-align: center;
}

table {
	position: absolute;
	top: 180px;
	left: 900px;
	text-align: center;
}
</style>
</head>
<body>

	<div id="container">
		<div><jsp:include page="/header.jsp"></jsp:include></div>
		<div align="center">
			<table>
			
				<tr>
					<td>
					<br><br>
						<h1>관리자 페이지 입니다.</h1>
					</td>
				</tr>
				<tr>
					<td><a href="ProductListAction.po"><h2>상품리스트</h2></a></td>
				</tr>
				<tr>
					<td><a href="MemberListViewAction.mo"><h2>회원리스트</h2></a></td>
				</tr>
				<tr>
					<td><a href="Product_list.po"><h2>매출현황</h2></a></td>
				</tr>
				<tr>
					<td><a href="Product_list.po"><h2>배송리스트</h2></a></td>
				</tr>

			</table>
		</div>
	</div>
</body>
</html>