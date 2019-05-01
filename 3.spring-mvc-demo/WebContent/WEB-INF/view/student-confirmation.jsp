<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE>
<html>

<head>
	<title>Student Confirmation Form</title>
</head>

<body>
	The student is confirmed: ${student.firstName} ${student.lastName}
	<br><br>
	Country: ${student.country}
	<br><br>
	Favorite language: ${student.favoriteLanguage}
	<br><br>
	Operating systems:
	<ul>
		<c:forEach var="temp" items="${student.operatingSystems}">
			<li>${temp}</li>
		</c:forEach>
	</ul> 
</body>

</html>