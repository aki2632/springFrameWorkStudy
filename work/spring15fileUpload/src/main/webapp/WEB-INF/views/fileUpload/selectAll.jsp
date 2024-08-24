<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>JSP - Hello World</title>
<style>
input[type=text], textarea, select {
	padding: 8px 8px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ff8f8f;
	border-radius: 14px;
	box-sizing: border-box;
}

input[type=submit], a {
	width: 15%;
	background-color: #4CAF50;
	color: white;
	padding: 8px 8px;
	margin: 8px 0px;
	border: none;
	border-radius: 14px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #b7e5b9;
}

div {
	border-radius: 15px;
	background-color: #f0f0f0;
	margin: 20px;
}

#insertTable {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#insertTable td, th {
	border: 1px solid #ddd;
	padding: 8px;
}

#insertTable tr:nth-child(even) {
	background-color: #ebebeb;
}

#insertTable tr:hover {
	background-color: #ffc6c6;
}
</style>
</head>
<body>
	<h1><%="상품 목록 페이지"%></h1>
	<br />
	<jsp:include page="../top_menu.jsp" />
	<form action="s_searchList.do">
		<select name="searchKey">
			<option value="model">model</option>
			<option value="pname">pname</option>
		</select> <input type="text" name="searchWord" value="GV"> <input
			type="submit" value="검색">
	</form>
	<table id="insertTable">
		<thead>
			<tr>
				<th>상품번호</th>
				<th>상품명</th>
				<th>모델명</th>
				<th>가격</th>
				<th>수량</th>
				<th>판매자</th>
				<th>상품사진</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vo" items="${list}">
				<tr>
					<td><a href="s_selectOne.do?num=${vo.num}">${vo.num}</a></td>
					<td><a href="s_selectOne.do?num=${vo.num}">${vo.pname}</a></td>
					<td>${vo.model}</td>
					<td>${vo.price}</td>
					<td>${vo.count}</td>
					<td>${vo.user_id}</td>
					<td><img src="${pageContext.request.contextPath}/resources/upload_img/thumb_${vo.img_name}" alt="썸네일 이미지" width="50" height="50"></td>
					
				</tr>
			</c:forEach>

		</tbody>
		<tfoot>
			<tr>
				<td colspan="7">1 2 3 4</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>