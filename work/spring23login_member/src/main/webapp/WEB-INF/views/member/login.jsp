<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>JSP - Hello World</title>
</head>
<body>
	<h1>로그인 페이지</h1>
	<br />
	<form action="m_loginOK.do" method="post">
		<table id="insertTable">
			<tr>
				<td><label for="id">ID</label></td>
				<td><input type="text" name="id" value="admin"></td>
			</tr>
			<tr>
				<td><label for="pw">PW</label></td>
				<td><input type="password" name="pw" value="hi1111"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="로그인"></td>
			</tr>
		</table>
	</form>
</body>
</html>