<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>상품등록</title>


</head>
<body>
<div><jsp:include page="/header.jsp" flush="false"></jsp:include></div>
<h2>상품등록</h2>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss" var="today"/>

<form method="post" action="ProductAddAction.po" name = "productaddform">
<input type="hidden" name = "image" id = "image" value="<%=request.getParameter("image")%>" readonly/>
<table border="1">


   <tr>
      <td>상품분류</td><td colspan="3"><input type="text" name="category" id="category"></td>
   </tr>
   <tr>
      <td>상품이름</td><td colspan="3"><input type="text" name="name" id="name"></td>
   </tr>
   <tr>
      <td>원가</td><td><input type="text" name="cost" id="cost"></td>
      <td>판매가</td><td><input type="text" id="price" name="price"></td>
   </tr>
   <tr>
      <td colspan="4">상품상세 설명</td>
   </tr>
   <tr>
      <td colspan="4"><textarea rows="10" cols="110" name="detail" id="detail"></textarea></td>
   </tr>
   <tr>

      <td colspan="4"><a href="imageAdd.po">이미지</a></td>
   </tr>
   <tr>
      <td><img src="<%=request.getParameter("image")%>"></td>
   </tr>
   <tr>
      <td>수량</td><td><input type="text" id="count" name="count"></td><td>상품등록일</td>
      <td>
         <input type="text" name="date" id="date" value="${today}" readonly>
      </td>
   </tr>
   <tr align="left">
      <td><input type="submit" value="완료" ></td>
   </tr>

</table>
</form>
<a href ="ProductList.po"><button>목록</button></a>

</body>
</html>