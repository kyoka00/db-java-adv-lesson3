<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>トップ画面</h2>
<div style="padding: 10px; border: 3px solid black">

<h1>検索条件を入力してください</h1>

<form action ="ProductServlet" method = "post">
<label>product_id:</label>
<input type = "number" name = "product_id"><br>
<button type = "submit">検索</button>

</form>

</div>
</body>
</html>