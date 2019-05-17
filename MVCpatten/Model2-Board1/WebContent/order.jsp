<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

h1 {font-size: 3em; margin: 20px 0; color: #FFF;}
.container {width: 1300px; margin: 10px auto;}
ul.tabs {
	margin: 0;
	padding: 0;
	float: left;
	list-style: none;
	height: 32px;
	border-bottom: 1px solid #999;
	border-left: 1px solid #999;
	width: 100%;
}
ul.tabs li {
	
	float: left;
	margin: 0;
	padding: 0;
	height: 31px;
	line-height: 31px;
	border: 1px solid #999;
	border-left: none;
	margin-bottom: -1px;
	background: #F0F0F0;
	overflow: hidden;
	position: relative;
}
ul.tabs li a {
	text-decoration: none;
	color: #000;
	display: block;
	font-size: 1.2em;
	padding: 0 20px;
	border: 1px solid #fff;
	outline: none;
}
ul.tabs li a:hover {
	background: #ccc;
}	
html ul.tabs li.active, html ul.tabs li.active a:hover  {
	background: #fff;
	border-bottom: 1px solid #fff;
}
.tab_container {
	border: 1px solid #999;
	border-top: none;
	clear: both;
	float: left; 
	width: 100%;
	background: #fff;
	-moz-border-radius-bottomright: 5px;
	-khtml-border-radius-bottomright: 5px;
	-webkit-border-bottom-right-radius: 5px;
	-moz-border-radius-bottomleft: 5px;
	-khtml-border-radius-bottomleft: 5px;
	-webkit-border-bottom-left-radius: 5px;
}
.tab_content {
	padding: 20px;
	font-size: 1.2em;
}
.tab_content h2 {
	font-weight: normal;
	padding-bottom: 10px;
	border-bottom: 1px dashed #ddd;
	font-size: 1.8em;
}
.tab_content h3 a{
	color: #254588;
}
.tab_content img {
	float: left;
	margin: 0 20px 20px 0;
	border: 1px solid #ddd;
	padding: 5px;
}
</style>
</head>

<body>
<div align="center"><b>ORDER</b></div>
<div class="container">


    <ul class="tabs">
        <li><a href="#tab1">주문내역조회(0)</a></li>
        <li><a href="#tab2">취소 반품 교환내역(0)</a></li>
		<li><a href="#gogo.jsp">zz</a></li>

    </ul>
    <div class="tab_container">
        <div id="tab1" class="tab_content">
        
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
			 <form method="get" action="order.jsp">              	
				<input type="button" value="오늘" name="Todate" id="date"><input type="button" value="1주일" name="week" id="date"><input type="button" value="1개월" name="month" id="date"><input type="button" value="3개월" name="3month" id="date"><input type="button" value="6개월" name="date" id="date">
				<input type="date" name="Firstday" id="Firstday">-<input type="date" name="Lastday"><input type="submit" value="조회">
 </form>   
				<ul>
<li>기본적으로 최근 3개월간의 자료가 조회되며, 기간 검색시 지난 주문내역을 조회하실 수 있습니다.</li>
        <li>주문번호를 클릭하시면 해당 주문에 대한 상세내역을 확인하실 수 있습니다.</li>
    </ul>
	

<div class="title">
        <h3>주문 상품 정보</h3>
    </div>
<table border="1" >


<thead><tr>
<th scope="col">주문일자<br/>[주문번호]</th>
                <th >이미지</th>
                <th >상품정보</th>
                <th >수량</th>
                <th >상품구매금액</th>
                <th >주문처리상태</th>
                <th >취소/교환/반품</th>
            </tr></thead>
<tbody class="center displaynone">
<tr class="">
<td  class="number displaynone">
                <p><a href="detail.html" class="line">[]</a></p>
                    <a href="#none" class="displaynone" onclick=""><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_order_cancel.gif" alt="주문취소"/></a>
                    <a href="cancel.html" class="displaynone button"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_order_cancel2.gif" alt="취소신청"/></a>
                    <a href="exchange.html" class="displaynone button"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_order_exchange.gif" alt="교환신청"/></a>
                    <a href="return.html" class="displaynone button"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_order_return.gif" alt="반품신청"/></a>
                </td>
                <td class="thumb"><a href="/product/detail.html"><img src="" onerror="this.src='//img.echosting.cafe24.com/thumb/img_product_small.gif';" alt=""/></a></td>
                <td class="product left top">
                    <a href="/product/detail.html"><strong></strong></a>
                    <div class="option displaynone"></div>
                    <ul class="xans-element- xans-myshop xans-myshop-optionset option"><li class="">
<strong></strong> (개)</li>
</ul>
<p class="gBlank5 displaynone">무이자할부 상품</p>
                </td>
                <td>갯수</td>
                <td class="right">
<strong></strong><div class="displaynone"></div>
</td>
                <td class="state">
                    <p class="txtEm"></p>
                    <p class="displaynone"><a href="" target=""></a></p>
                    <p class="displaynone"><a href="#none" class="line" onclick="">[]</a></p>
                    <a href="/board/product/write.html" class="displaynone"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_order_comment.gif" alt="구매후기"/></a>
                    <a href="#none" class="displaynone" onclick=""><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_order_retract.gif" alt="취소철회"/></a>
                    <a href="#none" class="displaynone" onclick=""><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_order_retract2.gif" alt="교환철회"/></a>
                    <a href="#none" class="displaynone" onclick=""><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_order_retract3.gif" alt="반품철회"/></a>
                </td>
                <td>
                    <p class="displaynone"><a href="#none" class="line" onclick="">[상세정보]</a></p>
                    <p class="displaynone">-</p>
                </td>
            </tr>
<tr class="">
<td  class="number displaynone">
                                        <p><a href="detail.html" class="line">[]</a></p>
                    <a href="#none" class="displaynone" onclick=""><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_order_cancel.gif" alt="주문취소"/></a>
                    <a href="cancel.html" class="displaynone button"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_order_cancel2.gif" alt="취소신청"/></a>
                    <a href="exchange.html" class="displaynone button"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_order_exchange.gif" alt="교환신청"/></a>
                    <a href="return.html" class="displaynone button"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_order_return.gif" alt="반품신청"/></a>
                </td>
                <td class="thumb"><a href="/product/detail.html"><img src="" onerror="this.src='//img.echosting.cafe24.com/thumb/img_product_small.gif';" alt=""/></a></td>
                <td class="product left top">
                    <a href="/product/detail.html"><strong></strong></a>
                    <div class="option displaynone"></div>
                    <ul class="xans-element- xans-myshop xans-myshop-optionset option"><li class="">
<strong></strong> (개)</li>
</ul>
<p class="gBlank5 displaynone">무이자할부 상품</p>
                </td>
               <td>갯수</td>
                <td class="right">
<strong></strong><div class="displaynone"></div>
</td>
                <td class="state">
                    <p class="txtEm"></p>
                    <p class="displaynone"><a href="" target=""></a></p>
                    <p class="displaynone"><a href="#none" class="line" onclick="">[]</a></p>
                    <a href="/board/product/write.html" class="displaynone"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_order_comment.gif" alt="구매후기"/></a>
                    <a href="#none" class="displaynone" onclick=""><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_order_retract.gif" alt="취소철회"/></a>
                    <a href="#none" class="displaynone" onclick=""><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_order_retract2.gif" alt="교환철회"/></a>
                    <a href="#none" class="displaynone" onclick=""><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_order_retract3.gif" alt="반품철회"/></a>
                </td>
                <td>
                    <p class="displaynone"><a href="#none" class="line" onclick="">[상세정보]</a></p>
                    <p class="displaynone">-</p>
                </td>
            </tr>
            
</tbody>
</table>
<p class="message ">주문 내역이 없습니다.</p>
</div>

        </div>
        </div>
        <%--2번째 --%>
     
            




<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function() {

	//Default Action
	$(".tab_content").hide(); //Hide all content
	$("ul.tabs li:first").addClass("active").show(); //Activate first tab
	$(".tab_content:first").show(); //Show first tab content
	
	//On Click Event
	$("ul.tabs li").click(function() {
		$("ul.tabs li").removeClass("active"); //Remove any "active" class
		$(this).addClass("active"); //Add "active" class to selected tab
		$(".tab_content").hide(); //Hide all tab content
		var activeTab = $(this).find("a").attr("href"); //Find the rel attribute value to identify the active tab + content
		$(activeTab).fadeIn(); //Fade in the active content
		return false;
	});

});
</script>
</body></html>