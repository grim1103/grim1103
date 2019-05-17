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

String id=request.getParameter("id");
MemberDAO md=new MemberDAO();


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
	
	var change=$('#gogo').val();
    document.getElementById("gogo").value =change;
}
</script>

</head>
<body>
<center>
<form method="post"  action="OrderAddAction.oo">
	<table border="1">
		<tr>
			<td>배송지</td><td><input type="text" value="<%=md.getMemDetail(id).getMember_address()%>" name="delivery_address"></td>
		</tr>
		<tr>
			<td>받는분 성함 ㅋ</td><td><input type="text" value="<%=md.getMemDetail(id).getMember_name()%>" name="delivery_name"></td>
		</tr>
		<tr>
			<td>배송자ID</td><td><%=md.getMemDetail(id).getMember_id()%><input type="hidden" value="<%=md.getMemDetail(id).getMember_id()%>" name="delivery_id"></td>
		</tr>
		<tr>
			<td>상품이미지</td><td><img src="<%=request.getParameter("image")%>" name="delivery_image" width="100" height="100"></td>
		</tr>
		<tr>
			<td>구매 수량</td><td><%=request.getParameter("count")%>개<input type="hidden" value="<%=request.getParameter("count")%>" name="delivery_count"></td>
		</tr>
		<tr>
			<td>구매금액 금액(배송비3000원이 차감됩니다.)</td>
			<td><%=request.getParameter("price")%>x<%=request.getParameter("count")%>=<%=Integer.parseInt(request.getParameter("hap"))-3000 %>원
				<input type="hidden" value="<%=request.getParameter("price") %>" name="delivery_price">
				<input type="hidden" value="<%=request.getParameter("count") %>" name="delivery_count">
			</td>
		</tr>
		<tr>
			<td>포인트를 사용</td>
			<%int point=(int)Double.parseDouble((request.getParameter("point")));%>
			<td>보유 포인트:<%=point%><br>
				<%	
				if(0<point){%>
					상품금액:<%=Integer.parseInt(request.getParameter("hap"))-3000 %>원-Point:<input type="text" id="gogo"  value="<%=point%>"><button onchange="input_Text()"><value>입력</value></button>
					합계:<%=(Integer.parseInt(request.getParameter("hap"))-3000)-point%>				
				<%} %>
				<input type="hidden" value="<%=Integer.parseInt(request.getParameter("hap"))-3000 %>" name="delivery_hap">
				<input type="hidden" value="<%=request.getParameter("code") %>" name="delivery_code">
				<input type="hidden" value="<%=request.getParameter("result") %>" name="delivery_result">
				<input type="hidden" value="${date}" name="delivery_date">
				
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