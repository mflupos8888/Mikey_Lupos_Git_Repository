<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>Student Registration Form</title>
	<style>.error{color:red}</style>
</head>

<body>

	<form:form action="processForm"  modelAttribute="student">

	First name  : <form:input path="firstName"></form:input>
		<form:errors path="firstName" cssClass="error"></form:errors>
	<br><br>

	Last name   : <form:input path="lastName"></form:input>
		<form:errors path="lastName" cssClass="error"></form:errors>
	<br><br>

	Nationality :
	<form:select path="country">
		<form:options items="${countryOptions}"></form:options>
	</form:select>
	    <form:errors path="country" cssClass="error"></form:errors>
	<br><br>

	Favorite Programming Language :
	<form:radiobuttons path="favoriteLanguage" items="${programmingLanguageList}"></form:radiobuttons>
	<form:errors path="favoriteLanguage" cssClass="error"></form:errors>
    <br><br> 

	Operating Systems:
	Linux   <form:checkbox path="operatingSystems" value="Linux"></form:checkbox>
	Windows <form:checkbox path="operatingSystems" value="Windows"></form:checkbox>
	MacOS   <form:checkbox path="operatingSystems" value="MacOS"></form:checkbox>
	<form:errors path="operatingSystems" cssClass="error"></form:errors>
	<br><br>

	Course Code : <form:input path="courseCode"></form:input>
	    <form:errors path="courseCode" cssClass="error"></form:errors>
	<br><br>
	
	<input type="submit" value="Submit"></input>
	</form:form>

</body>

</html>