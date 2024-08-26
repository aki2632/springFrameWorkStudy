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
<a href="api/json_test.do">api/json_test.do</a>
<a href="api/json_test2.do">api/json_test2.do</a>
<a href="api/json_test3.do">api/json_test3.do</a>
<a href="api/json_test4.do">api/json_test4.do</a>
<a href="api/json_test5.do">api/json_test5.do</a>
<a href="api/json_test6.do">api/json_test6.do</a>
<a href="api/json_idCheck.do?id=admin">api/json_idCheck.do?id=admin</a>
<a href="api/json_idCheck.do?id=aaa">api/json_idCheck.do?id=aaa</a>
</body>
</html>
