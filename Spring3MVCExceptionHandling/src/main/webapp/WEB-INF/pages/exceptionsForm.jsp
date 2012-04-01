<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring 3 MVC - Handling Different Exceptions Example</title>

<style>
	.error {
		color: #ff0000;
	}
</style>

</head>
<body>
<h3>Click one of the button to generate exception!</h3>
<form:form method="post" action="generateUserDefinedException">
	<input type="submit" value="Generate User Defined Exception - GenericException"/>
</form:form>

<form:form method="post" action="generateIllegalArgumentException">
	<input type="submit" value="Generate IllegalArgumentException" />
</form:form>
 
<form:form method="post" action="updateUserInfo">
	<input type="submit" value="Generate 404 Error" />
</form:form>
 
 <form:form method="post" action="securityexception">
	<input type="submit" value="Generate SecurityException" />
</form:form>

<form:form method="post" action="accessDeniedException">
	<input type="submit" value="Generate Spring Security AccessDeniedException" />
</form:form>

<form:form method="post" action="nullPointerException">
	<input type="submit" value="Generate NullPointerException" />
</form:form>
 
</body>
</html>