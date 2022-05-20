<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>検索画面</h2>
<div style="padding: 10px; border: 3px solid black">

<h1>検索結果</h1>

<h3>${msg}</h3>

<style>
	td, th{
		padding:5px;
	}
</style>
<table border ="1">
<tr>
<th>商品番号</th>
<th>商品名</th>
<th>値段</th>
</tr>
<c:forEach var= "p" items="${result}">
	<tr>
	<td>${fn:escapeXml(p.productId)}</td>
	<td>${fn:escapeXml(p.productName)}</td>
	<td>${fn:escapeXml(p.price)}</td>
	</tr>

</c:forEach>
</table>
<a href = "top.jsp">戻る</a>
</div>
</body>
</html>