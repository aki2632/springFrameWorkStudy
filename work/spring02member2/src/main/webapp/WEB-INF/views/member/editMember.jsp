<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Member</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
    <h2>Edit Member</h2>
    <jsp:include page="../top_menu.jsp"></jsp:include>
    <form action="${pageContext.request.contextPath}/memberEdit.do" method="post">
        <input type="hidden" name="num" value="${member.num}" />
        <table>
            <tr>
                <td>ID:</td>
                <td><input type="text" name="id" value="${member.id}" required /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="pw" value="${member.pw}" required /></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" value="${member.name}" required /></td>
            </tr>
            <tr>
                <td>Telephone:</td>
                <td><input type="text" name="tel" value="${member.tel}" required /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Update" />
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
