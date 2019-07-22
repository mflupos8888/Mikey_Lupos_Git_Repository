<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head><title>Student Registration Form</title></head>

<body>

	<form:form action="processForm"  modelAttribute="student">
	First name: <form:input path="firstName"></form:input>
	<br><br>
	Last name : <form:input path="lastName"></form:input>
	<br><br>
	<form:select path="country">
		<form:option value="Singapore"    label="Singapore"></form:option>
		<form:option value="Japan"        label="Japan"></form:option>
		<form:option value="Korea"        label="Korea"></form:option>
		<form:option value="India"        label="India"></form:option>
		<form:option value="Philippines"  label="Philippines"></form:option>
	</form:select>
	<br><br>
	<input type="submit" value="Submit"></input>
	</form:form>

</body>

</html>