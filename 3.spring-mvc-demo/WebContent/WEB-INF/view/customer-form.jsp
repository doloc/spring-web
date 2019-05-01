<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE>
<html>
<head>
	<style type="text/css">
		.error{
			color: red;
		}
	</style>
	<title>Customer Registration Form</title>
</head>

<body>
<i>Fill out the form. Asterisk (*) means required</i>
<br/><br/>
	<form:form action="processForm" modelAttribute="customer">
		First name: <form:input path="firstName" />
		<br/><br/>
		Last name (*): <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error"></form:errors>
		<br/><br/>
		<input type="submit" value="Submit">
	</form:form>
</body>

</html>