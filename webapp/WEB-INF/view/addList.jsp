<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전화번호</title>
</head>
<body>

	<form action="/guestbook3/guestboard/add" method="get">
	<fieldset style = "width:500px">
		이름 : <input type="text" name="name"> 
		비밀번호 : <input type="text" name="password"><br><br>
		<textarea name="content" cols="70" rows="10"></textarea><br>
		<button type="submit" style='float: right;'>확인</button>
		</fieldset>
	</form>
	<c:forEach items="${gList}" var="vo">
	
	<table border='1'>
		<colgroup>
			<col style="width: 120px">
			<col style="width: 170px">
		</colgroup>
		<tbody>
			<tr>
				<td>${vo.number}</td>
				<td>${vo.name}</td>
				<td>${vo.reg_date}</td>
				<td><a href = "/guestbook3/guestboard/deleteForm?no=${vo.number}">삭제</a>
			</td>

			<tr>
			<td colspan="4">${vo.content}</td>
			</tr>
		</tbody>
	</table>
	</c:forEach>
	<br>

</body>
</html>