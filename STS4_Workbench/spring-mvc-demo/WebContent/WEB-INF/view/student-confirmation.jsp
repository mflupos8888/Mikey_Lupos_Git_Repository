<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head><title>Student Confirmation Form</title></head>

<body>

	Student Confirmed:
	<br><br>
		First name        : ${student.firstName}
	<br><br>
		Last name         : ${student.lastName}
	<br><br>
		Country           : ${student.country}
	<br><br>
		Favorite language : ${student.favoriteLanguage}
	<br><br>
	    Operating Systems Used : 
	<ul>
	  <c:forEach var="temp" items="${student.operatingSystems}">
	  <li>${temp}</li>
	  </c:forEach>
	</ul>
</body>

</html>