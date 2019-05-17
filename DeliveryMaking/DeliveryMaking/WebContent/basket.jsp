<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%String id =null; 
   session.setAttribute("id",id);
   
   
   %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<style>
/* body {
	color: #555;
	background: #eeeeee;
	margin: 0;
	padding: 0;
	box-sizing: border-box;
} */

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
input {
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
</style>

<title>Document</title>
</head>
<body>



	<div id="container">
	<div><jsp:include page="header.jsp"></jsp:include></div>
		<div class="main">


			<div>
				<div>
					<div>
						<h2>
							<span>SHOPPING CART</span>
						</h2>
						<%if(id==null){
                  %>
						로그인을 해주세요. <br> <a href="Login_Join.jsp"><img alt=""
							src=""></a>
						<%} else
               {%>
						<%=id %>님 반갑습니다.
						<%} %>
					</div>
					
					<div class="description">
						<div class="member ">

							<ul>



								<input id="tab1" type="radio" name="tabs" checked>
								<label for="tab1">국내 배송상품</label>



								<input id="tab2" type="radio" name="tabs">
								<label for="tab2">해외 배송상품</label>


								<section id="content1">

									일반상품 (기본배송)
									<table border="1" summary="" class="basket">
										<!-- <colgroup>
                              <col style="width: 27px" />
                              <col style="width: 55px" />
                              <col style="width: 90px" />
                              <col style="width: 80px" />
                              <col style="width: 38px" />
                              <col style="width: 70px" />
                              <col style="width: 70px" />
                              <col style="width: 85px" />
                              <col style="width: 98px" />
                              <col style="width: 110px" />
                           </colgroup> -->

										<thead>
											<tr>
												<th scope="col"><h5>상품코드</h5></th>
												<th scope="col"><h5>이미지</h5></th>
												<th scope="col"><h5>상품이름</h5></th>
												<th scope="col"><h5>판매가</h5></th>
												<th scope="col"><h5>수량</h5></th>
												<th scope="col"><h5>배송구분</h5></th>
												<th scope="col"><h5>배송비</h5></th>
												<th scope="col"><h5>합계</h5></th>
												<th scope="col"><h5>선택</h5></th>
											</tr>
											<tr>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
											</tr>
										</thead>
									</table>
									<br> <br>
									<th>

										<table border="1">
											<thead>
												<th>총 상품금액</th>
												<th>총 배송비</th>
												<th>결제예정 금액</th>
											</thead>
											<tr>
												<td></td>
												<td></td>
												<td></td>
											</tr>
										</table>


									</th>
									</table>


									</th>
								</section>

								<section id="content2">
									해외상품 (기본배송)
									<table border="1" summary="" class="basket">
										<!-- <colgroup>
                              <col style="width: 27px" />
                              <col style="width: 55px" />
                              <col style="width: 90px" />
                              <col style="width: 80px" />
                              <col style="width: 38px" />
                              <col style="width: 70px" />
                              <col style="width: 70px" />
                              <col style="width: 85px" />
                              <col style="width: 98px" />
                              <col style="width: 110px" />
                           </colgroup> -->

										<thead>
											<tr>
												<th scope="col"><h5>상품코드</h5></th>
												<th scope="col"><h5>이미지</h5></th>
												<th scope="col"><h5>상품이름</h5></th>
												<th scope="col"><h5>판매가</h5></th>
												<th scope="col"><h5>수량</h5></th>
												<th scope="col"><h5>배송구분</h5></th>
												<th scope="col"><h5>배송비</h5></th>
												<th scope="col"><h5>합계</h5></th>
												<th scope="col"><h5>선택</h5></th>
											</tr>
											<tr>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
											</tr>
										</thead>
									</table>
									<br> <br>
									<th>

										<table border="1">
											<thead>
												<th>총 상품금액</th>
												<th>총 배송비</th>
												<th>결제예정 금액</th>
											</thead>
											<tr>
												<td></td>
												<td></td>
												<td></td>
											</tr>
										</table>


									</th>
								</section>
						</div>



						<!-- 이용안내 -->
						<div>
							<h3>이용안내</h3>
							<div class="inner">
								<h5>*장바구니 이용안내*</h5>
								<ol>
									<li class="item1">해외배송 상품과 국내배송 상품은 함께 결제하실 수 없으니 장바구니 별로
										따로 결제해 주시기 바랍니다.</li>
									<li class="item2">해외배송 가능 상품의 경우 국내배송 장바구니에 담았다가 해외배송
										장바구니로 이동하여 결제하실 수 있습니다.</li>
									<li class="item3">선택하신 상품의 수량을 변경하시려면 수량변경 후 [변경] 버튼을 누르시면
										됩니다.</li>
									<li class="item4">[쇼핑계속하기] 버튼을 누르시면 쇼핑을 계속 하실 수 있습니다.</li>
									<li class="item5">장바구니와 관심상품을 이용하여 원하시는 상품만 주문하거나 관심상품으로
										등록하실 수 있습니다.</li>
									<li class="item6">파일첨부 옵션은 동일상품을 장바구니에 추가할 경우 마지막에 업로드 한
										파일로 교체됩니다.</li>
								</ol>
								<h5>무이자할부 이용안내</h5>
								<ol>
									<li class="item1">상품별 무이자할부 혜택을 받으시려면 무이자할부 상품만 선택하여
										[주문하기] 버튼을 눌러 주문/결제 하시면 됩니다.</li>
									<li class="item2">[전체 상품 주문] 버튼을 누르시면 장바구니의 구분없이 선택된 모든
										상품에 대한 주문/결제가 이루어집니다.</li>
									<li class="item3">단, 전체 상품을 주문/결제하실 경우, 상품별 무이자할부 혜택을 받으실
										수 없습니다.</li>
								</ol>
								<form action="Shop_basket.jsp" method="post">
									<input type="submit" value="결제하기" />
								</form>
							</div>
							<br> <br>
							<!-- 주문 버튼 -->
							<div align="center"
								class="xans-element- xans-order xans-order-totalorder ec-base-button justify">
								<a href="#none" onclick="Basket.orderAll(this)"
									link-order="/order/orderform.html?basket_type=all_buy"
									link-login="/member/login.html" class=" "><img src="image/1.jpg"
									alt="전체상품주문" /></a> <a href="#none"
									onclick="Basket.orderSelectBasket(this)"
									link-order="/order/orderform.html?basket_type=all_buy"
									link-login="/member/login.html" class=""><img src="image/2.jpg"
									alt="선택상품주문" /></a><span class="gRight"> <a href="/"><img
										src="image/3.jpg" alt="쇼핑계속하기" /></a>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>