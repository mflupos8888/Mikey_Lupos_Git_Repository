<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head><title>Student Registration Form</title></head>

<body>

	<form:form action="processForm"  modelAttribute="student">
	First name  : <form:input path="firstName"></form:input>
	<br><br>
	Last name   : <form:input path="lastName"></form:input>
	<br><br>
	Nationality :
	<form:select path="country">
		<form:options items="${theCountryOptions}"></form:options>
	</form:select>
	<br><br>
	Favorite Programming Language : 
	<form:radiobuttons path="favoriteLanguage" items="${theProgrammingLanguageList}"></form:radiobuttons>
	<br><br>
	Operating Systems:
	Linux   <form:checkbox path="operatingSystems" value="Linux"></form:checkbox>
	Windows <form:checkbox path="operatingSystems" value="Windows"></form:checkbox>
	MacOS   <form:checkbox path="operatingSystems" value="MacOS"></form:checkbox>
	<br><br>
	<input type="submit" value="Submit"></input>
	</form:form>

</body>

</html>