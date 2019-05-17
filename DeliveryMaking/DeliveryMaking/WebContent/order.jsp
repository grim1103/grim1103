<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css"/>
<!-- <style>
h1 {
	padding: 50px 0;
	font-weight: 400;
	text-align: center;
}

p {
	margin: 0 0 20px;
	line-height: 1.5;
}

.main {
	min-width: 320px;
	max-width: 850px;
	padding: 50px;
	margin: 0 auto;
	background: #ffffff;
}

section {
	display: none;
	padding: 20px 0 0;
	border-top: 1px solid #ddd;
}

/*라디오버튼 숨김*/
#tab1, #tab2 {
	display: none;
}

label {
	display: inline-block;
	margin: 0 0 -1px;
	padding: 15px 25px;
	font-weight: 600;
	text-align: center;
	color: #bbb;
	border: 1px solid transparent;
}

label:hover {
	color: #2e9cdf;
	cursor: pointer;
}

/*input 클릭시, label 스타일*/
input:checked+label {
	color: #555;
	border: 1px solid #ddd;
	border-top: 2px solid #2e9cdf;
	border-bottom: 1px solid #ffffff;
}

#tab1:checked ~ #content1, #tab2:checked ~ #content2 {
	display: block;
}
</style> -->

<title>Document</title>
</head>
<body>

	<div id="container">
		<div><jsp:include page="header.jsp"></jsp:include></div>
		<br>
		<br>
		<br>
		<br>
		<div class="main">


			<div>
				<div>
					<div>
						<h2>
							<span>ORDER</span>
						</h2>
					</div>

					<ul>



						<input id="tab1" type="radio" name="tabs" checked>
						<label for="tab1">주문내역조회</label>



						<input id="tab2" type="radio" name="tabs">
						<label for="tab2">취소 반품 교환내역</label>


						<section id="content1">
							<div>

								<select>
									<option>전체 주문처리상태</option>
									<option>입금전</option>
									<option>배송준비중</option>
									<option>배송중</option>
									<option>배송완료</option>
									<option>취소</option>
									<option>교환</option>
									<option>반품</option>
								</select>

								<form method="post" action="Order.jsp">
									<input type="button" value="오늘" name="Todate" id="date">
									<input type="button" value="1주일" name="week" id="date">
									<input type="button" value="1개월" name="month" id="date">
									<input type="button" value="3개월" name="3month" id="date">
									<input type="button" value="6개월" name="date" id="date">
									<input type="date" name="Firstday" id="Firstday"> -<input
										type="date" name="Lastday"> <input type="submit"
										value="조회">
								</form>

								<p>
								<li>기본적으로 최근 3개월간의 자료가 조회되며, 기간 검색시 지난 주문내역을 조회하실 수 있습니다.</li>
								<li>주문번호를 클릭하시면 해당 주문에 대한 상세내역을 확인하실 수 있습니다.</li> <br> <b>주문상품정보</b>
								<hr>
								<table border="1">
									<tr>
										<td>주문일자</td>
										<td>주문번호</td>
										<td>이미지</td>
										<td>상품정보 수량</td>
										<td>상품정보</td>
										<td>수량</td>
										<td>상품구매금액</td>
										<td>주문처리상태</td>
										<td>취소/교환/반품</td>
									</tr>
									<tr>
										<td align="center"></td>
										<td align="center"></td>
										<td align="center"></td>
										<td align="center"></td>
										<td align="center"></td>
										<td align="center"></td>
										<td align="center"></td>
										<td align="center"></td>
										<td align="center"></td>
									</tr>
								</table>

							</div>
							</p>
						</section>

						<section id="content2">
							<p>
							<div>
								<form method="post" action="Order.jsp">
									<input type="button" value="오늘" name="Todate" id="date">
									<input type="button" value="1주일" name="week" id="date">
									<input type="button" value="1개월" name="month" id="date">
									<input type="button" value="3개월" name="3month" id="date">
									<input type="button" value="6개월" name="date" id="date">
									<input type="date" name="Firstday" id="Firstday"> -<input
										type="date" name="Lastday"> <input type="submit"
										value="조회">
							</div>
							<br>
							<li>기본적으로 최근 3개월간의 자료가 조회되며, 기간 검색시 지난 주문내역을 조회하실 수 있습니다.</li>
							<li>주문번호를 클릭하시면 해당 주문에 대한 상세내역을 확인하실 수 있습니다.</li> <br> <b>취소/반품/교환</b>
							<hr>
							<table border="1">
								<tr>
									<td>주문일자</td>
									<td>주문번호</td>
									<td>이미지</td>
									<td>상품정보 수량</td>
									<td>상품정보</td>
									<td>수량</td>
									<td>상품구매금액</td>
									<td>주문처리상태</td>
									<td>취소/교환/반품</td>
								</tr>
								<tr>
									<td align="center"></td>
									<td align="center"></td>
									<td align="center"></td>
									<td align="center"></td>
									<td align="center"></td>
									<td align="center"></td>
									<td align="center"></td>
									<td align="center"></td>
									<td align="center"></td>
								</tr>
							</table>


						</section>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>