<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "회원 목록 페이지" %></h1>
<br/>
<form action="m_searchList.do">
  <select name="searchKey">
    <option value="id">id</option>
    <option value="name">name</option>
  </select>
  <input type="text" name="searchWord" value="ad">
  <input type="submit" value="검색">
</form>
<table  id="insertTable">
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
  <c:forEach var="vo" items="${list}">
    <tr>
      <td><a href="m_selectOne.do?num=${vo.num}">${vo.num}</a></td>
      <td><a href="m_selectOne.do?num=${vo.num}">${vo.id}</a></td>
      <td>${vo.pw}</td>
      <td>${vo.name}</td>
      <td>${vo.tel}</td>
      <td><img src="${pageContext.request.contextPath}/resources/upload_img/thumb_${vo.img_name}" alt="썸네일 이미지" width="50" height="50"></td>
    </tr>
  </c:forEach>

  </tbody>
  <tfoot>
  <tr>
    <td colspan="6">1 2 3 4</td>
  </tr>
  </tfoot>
</table>
</body>
</html>