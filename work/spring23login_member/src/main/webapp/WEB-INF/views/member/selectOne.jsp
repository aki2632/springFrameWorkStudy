<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>JSP - Hello World</title>
</head>
<body>
	<h1>회원 정보 페이지</h1>
	<br />
	<div>
		<table id="insertTable">
			<thead>
				<tr>
					<th>NUM</th>
					<th>ID</th>
					<th>PW</th>
					<th>NAME</th>
					<th>TEL</th>
					<th>IMG</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${vo2.num}</td>
					<td>${vo2.id}</td>
					<td>${vo2.pw}</td>
					<td>${vo2.name}</td>
					<td>${vo2.tel}</td>
					<td><img
						src="${pageContext.request.contextPath}/resources/upload_img/${vo2.img_name}"
						alt="상품 이미지" width="100"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<c:if test="${sessionScope.user_id == 'admin'}">
		<a href="m_update.do?num=${vo2.num}">회원수정</a>
		<a href="m_delete.do?num=${vo2.num}">회원삭제</a>
	</c:if>
</body>
</html>