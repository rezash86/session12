<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>updating a student</title>
</head>
<body>
	<div align="center">
		<form:form action="updateStudent" method="post" 
			modelAttribute="editedstudent">
			<table>
					<form:hidden path="id" />
				
				<tr>
					<td>First Name</td>
					<td><form:input path="firstName" /></td>
				</tr>

				<tr>
					<td>Last Name</td>
					<td><form:input path="lastName" /></td>
				</tr>

				<tr>
					<td>Age</td>
					<td><form:input path="age" /></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="update student"></td>
				</tr>
			</table>

		</form:form>
	</div>
</body>
</html>