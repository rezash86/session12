<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">

<body>
	<div>
		<a href="addstudent">Add a new student</a>
	</div>

	<div align="center">
		Cool Student List
		<table border="1">
			<tr>
				<th>first name</th>
				<th>last name</th>
				<th>age</th>
			</tr>

			<c:forEach var="student" items="${studList}">
				<tr>
					<td><c:out value="${student.firstName}"></c:out></td>
					<td><c:out value="${student.lastName}"></c:out></td>
					<td><c:out value="${student.age}"></c:out></td>
					<td><a href="editstudent?studentId=${student.id}">update
							me!</a></td>
					<td><a href="deletestudent?studentId=${student.id}">delete
							me</a></td>
				</tr>
			</c:forEach>

		</table>
	</div>

</body>
</html>