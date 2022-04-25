<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<form action="/web_2022-04-25/member/login" method="POST">
		<div> <label> ID : <input type="text" name="id" placeholder="아이디"> </label></div>
		<div> <label> PW : <input type="password" name="pw" placeholder="비밀번호"> </label></div>
		<input type="submit" value="로그인">
	</form>
</body>
</html>