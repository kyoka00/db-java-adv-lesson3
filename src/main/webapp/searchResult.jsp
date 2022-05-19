<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

<p>product_id : ${id}</p>
<p>product_name : ${name}</p>
<p>price: ${price}</p>

<a href = "top.jsp">戻る</a>
</div>
</body>
</html>