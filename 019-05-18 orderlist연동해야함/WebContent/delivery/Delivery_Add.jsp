<%@page import="net.Order.db.OrderBean"%>
<%@page import="net.member.db.MemberDAO"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="net.Delivery.db.*"%>
<%@page import="java.util.List"%>
<%@page import="net.product.db.ProductDAO"%>
<%@page import="net.product.db.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

String id=(String)session.getAttribute("id");
MemberDAO md=new MemberDAO();
 
OrderBean bean=(OrderBean)session.getAttribute("orderbean");
int point=md.getMemDetail(id).getMember_point();

%>

<%request.setCharacterEncoding("UTF-8"); %>  
<!DOCTYPE html>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
<html>
<head>
<meta charset="UTF-8">
<title>주문 확인</title>
<script language="javascript">
//textBox에 jdk's blog를 추가합니다.
function input_Text(){
	
	var change= document.getElementById("gogo").value;	
	
	var delivery_id= document.getElementById("delivery_id").value;
	var delivery_code= document.getElementById("delivery_code").value;
	var delivery_address= document.getElementById("delivery_address").value;
	var delivery_name= document.getElementById("delivery_name").value;
	var delivery_image= document.getElementById("delivery_image").value;
	var delivery_count= document.getElementById("delivery_conut").value;
	var delivery_price= document.getElementById("delivery_price").value; 
	var delivery_hap= document.getElementById("delivery_hap").value;
	var delivery_result= document.getElementById("delivery_result").value;
	var delivery_date= document.getElementById("delivery_date").value;
	var delivery_point=<%=point%>-change;	

 	
 	
 	
		localStorage.setItem('set1', delivery_id);
		localStorage.setItem('set2', delivery_code);
		localStorage.setItem('set3', delivery_address);
		localStorage.setItem('set4', delivery_name);
		localStorage.setItem('set5', delivery_image);
		localStorage.setItem('set6', delivery_count);
		localStorage.setItem('set7', delivery_price);
		localStorage.setItem('set8', delivery_hap);
		localStorage.setItem('set9', delivery_result);
		localStorage.setItem('set10', delivery_date);
		localStorage.setItem('set11', delivery_point);
	
		
		var a=localStorage.getItem('set11');
		document.getElementById("a").value=a;
		
		document.getElementById("b").innerHTML =a;
		
}

</script>

</head>
<body>
<center>
<form method="post" action="OrderAddAction.oo">
	<table border="1">
		<tr>
			<td>배송지</td><td><input type="text" value="<%=md.getMemDetail(id).getMember_address()%>" name="delivery_address" id="delivery_address"></td>
		</tr>
		<tr>
			<td>받는분 성함</td><td><input type="text" value="<%=md.getMemDetail(id).getMember_name()%>" name="delivery_name" id="delivery_name"></td>
		</tr>
		<tr>
			<td>받는분 연락처</td><td><input type="text" value="<%=md.getMemDetail(id).getMember_phone()%>" name="delivery_phone" id="delivery_phone"></td>
		</tr>
		<tr>
			<td>배송자ID</td><td><%=md.getMemDetail(id).getMember_id()%><input type="hidden" value="<%=md.getMemDetail(id).getMember_id()%>" name="delivery_id" id="delivery_id"></td>
		</tr>
		<tr>
			<td>배송메모</td><td><input type="text" name="delivery_memo"></td>
		</tr>
		<tr>
			<td>상품이름</td><td><input type="text" value="<%=bean.getOrder_name()%>" name="delivery_name"></td>
		</tr>
		<tr>
			<td>상품이미지</td><td><img src="<%=bean.getOrder_image()%>" name="delivery_image" width="100" height="100"></td>
		</tr>
		<tr>
			<td>구매 수량</td><td><%=bean.getOrder_count()%>개<input type="hidden" value="<%=bean.getOrder_count()%>" name="delivery_count" id="delivery_count"></td>
		</tr>
		<tr>
			<td>구매금액 금액(배송비3000원이 차감됩니다.)</td>
			<td><%=bean.getOrder_price()%>x<%=bean.getOrder_count()%>=<%=(bean.getOrder_hap())-3000 %>원
				
			</td>
		</tr>
		<tr>
			<td>포인트를 사용</td>
			
			<td>보유 포인트:<%=point%><br>
			상품금액:<%=(bean.getOrder_hap())-3000 %>원
			<br>
			사용하실 포인트:<input type="number" id="gogo"  value="<%=point%>"><button  onchange="input_Text()"><value>사용</value></button>
			<br>
			차감후 포인트:<b id=b></b>
			
			<br>
			합계:<%=(bean.getOrder_hap()-3000)-point%>				
				<input type="hidden" value="<%=(bean.getOrder_hap())-3000 %>" name="delivery_hap" id="delivery_hap">
				<input type="hidden" value="<%=bean.getOrder_code() %>" name="delivery_code" id="delivery_code">
				<input type="hidden" value="<%=bean.getOrder_result() %>" name="delivery_result" id="delivery_result">
				<input type="hidden" value="${date}" name="delivery_date" id="delivery_date">
				<input type="hidden" value="<%=point%>" name="delivery_point" id="delivery_point">
				<input type="hidden" value="<%=bean.getOrder_count() %>" name="delivery_count" id="delivery_count">
				
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" value="주문하기"></td>
		</tr>
	</table>
</form>	
</center>
</body>
</html>