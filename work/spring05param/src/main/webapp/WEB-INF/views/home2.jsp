<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home2</title>
</head>
<body>
<h1>
	Home2 ${param.name} ${param.age}
</h1>

<a href="home.do?name=kim&age=33">home</a>
<a href="home2.do?name=lee&age=44">home2</a>

</body>
</html>
