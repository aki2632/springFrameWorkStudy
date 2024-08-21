<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Member List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
    <h2>Member List</h2>
    <jsp:include page="../top_menu.jsp"></jsp:include>
    <table border="1">
        <thead>
            <tr>
                <th>Number</th>
                <th>ID</th>
                <th>Name</th>
                <th>Tel</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="member" items="${members}">
                <tr>
                    <td><c:out value="${member.num}"/></td>
                    <td><c:out value="${member.id}"/></td>
                    <td><c:out value="${member.name}"/></td>
                    <td><c:out value="${member.tel}"/></td>
                    <td>
                        <a href="memberDetail.do?num=${member.num}">Details</a>
                        <!-- Add more actions if needed -->
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>