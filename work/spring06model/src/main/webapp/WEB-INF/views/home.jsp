<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<P>  ${vo2.name} ${vo2.age} </P>
<ul>
<c:forEach var="vo" items="${list}">
	<li><span>${vo.name}</span> &nbsp;<span>${vo.age}</span></li>
</c:forEach>
</ul>
</body>
</html>
