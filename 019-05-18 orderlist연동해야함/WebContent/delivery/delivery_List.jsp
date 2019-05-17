<%@page import="java.util.List"%>
<%@page import="net.Delivery.db.DeliveryBean"%>
<%@page import="net.Delivery.db.DeliveryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    List<DeliveryBean> beans = (List<DeliveryBean>)session.getAttribute("deliverybean");
%>
<%request.setCharacterEncoding("UTF-8"); %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문목록</title>
</head>
<body>
<center>
	<b>배달 정보입니다</b>
	<table>
		<%for(DeliveryBean bean : beans){ %>
		<tr>
			<td>주문번호</td><td><%=bean.getDelivery_num()%></td>
		</tr>
		<tr>
			<td>배달원</td><td><%=bean.getDelivery_name()%></td>
		</tr>
		<tr>
			<td>주문지</td><td><%=bean.getDelivery_address()%></td>
		</tr>
		<tr>
			<td>배달원 전화번호</td><td><%=bean.getDelivery_phone()%></td>
		</tr>
		
		<%} %>
	</table>
</center>

</body>
</html>