<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="URF-8">
	<title>title</title>
	<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
<div id="header">
	<tiles:insertAttribute name="header"></tiles:insertAttribute>
</div>
<div id="content">
	<tiles:insertAttribute name="content"></tiles:insertAttribute>
</div>
<div id="footer">
	<tiles:insertAttribute name="footer"></tiles:insertAttribute>
</div>

</body>
</html>
