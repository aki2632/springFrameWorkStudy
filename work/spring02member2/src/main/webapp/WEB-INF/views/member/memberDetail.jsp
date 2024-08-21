<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Member Detail</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
    <h2>Member Detail</h2>
    <jsp:include page="../top_menu.jsp"></jsp:include>
    <table border="1">
        <tr>
            <th>Number</th>
            <td><c:out value="${member.num}"/></td>
        </tr>
        <tr>
            <th>ID</th>
            <td><c:out value="${member.id}"/></td>
        </tr>
        <tr>
            <th>Name</th>
            <td><c:out value="${member.name}"/></td>
        </tr>
        <tr>
            <th>Telephone</th>
            <td><c:out value="${member.tel}"/></td>
        </tr>
    </table>
    <form action="${pageContext.request.contextPath}/memberEdit.do/${member.num}" style="display:inline;">
        <input type="submit" value="Edit" />
    </form>
    <form action="${pageContext.request.contextPath}/memberDelete.do/${member.num}" method="post" style="display:inline;">
        <input type="submit" value="Delete" />
    </form>
</body>
</html>
