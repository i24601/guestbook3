<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/guestbook3/guestboard/delete" method="get">
		비밀번호 : <input type = "text" name="password"><br>
		<input type = "hidden" name="no" value="${no}"><br>
		<button type="submit">확인</button>
	</form>
</body>
<a href="/guestbook3/guestboard/addlist">메인으로 돌아가기</a>
</html>