<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register Member</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
    <h2>Register New Member</h2>
    <jsp:include page="../top_menu.jsp"></jsp:include>
    <form action="registerMember.do" method="post">
        <label for="id">ID:</label>
        <input type="text" id="id" name="id" required/><br/>
        <label for="pw">Password:</label>
        <input type="password" id="pw" name="pw" required/><br/>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required/><br/>
        <label for="tel">Telephone:</label>
        <input type="text" id="tel" name="tel" required/><br/>
        <input type="submit" value="Register"/>
    </form>
</body>
</html>