<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head><title>Customer Confirmation Form</title></head>

<body>

	Customer Confirmed:
	<br><br>
		First name        : ${customer.firstName}
	<br><br>
		Last name         : ${customer.lastName}
	<br><br>
        Age               : ${customer.age}
	<br><br>
	    Postal Code       : ${customer.postalCode}
	<br><br>

</body>

</html>