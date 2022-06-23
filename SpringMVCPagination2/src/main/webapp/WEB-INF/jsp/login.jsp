<%@ page isELIgnored="false"%>



<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Spring MVC user registration and login example using JdbcTemplate + MySQL</title>
</head>
<body>
<h3>Welcome</h3>



<form:form method="post">


User Id: <input type="text" name="userId" />

Password: <input type="password" name="password" />



<input type="submit" value="Submit" />

</form:form>
${msg}
</body>
</html>