<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  ${param.name} ${param.age}
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="home.do?name=kim&age=33">home</a>
<a href="home2.do?name=lee&age=44">home2</a>

</body>
</html>
