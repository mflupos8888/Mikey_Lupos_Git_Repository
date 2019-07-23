<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>Customer Registration Form</title>
	<style>.error{color:red}</style>
</head>


<body>

	<i>Fill out the form. Fields tagged with asterisk (*) means required.</i>
	<br><br>
	<form:form action="processForm"  modelAttribute="customer">
	First name  : <form:input path="firstName"></form:input>
	<br><br>
	Last name*  : <form:input path="lastName"></form:input>
	<form:errors path="lastName" cssClass="error"></form:errors>
	<br><br>
	Age*        : <form:input path="age"></form:input>
	<form:errors path="age" cssClass="error"></form:errors>
	<br><br>
	Postal Code : <form:input path="postalCode"></form:input>
	<form:errors path="postalCode" cssClass="error"></form:errors>
	<br><br>
	<input type="submit" value="Submit"></input>
	</form:form>

</body>

</html>