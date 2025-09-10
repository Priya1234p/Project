<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee</title>
</head>
<body>
	<h2>View Registrations</h2>

	<table>
		<tr>
			<th>First name</th>
			<th>Last name</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Delete</th>
		</tr>

		<c:forEach var="emp" items="${employees}">
			<tr>
				<td>${emp.firstName}</td>
				<td>${emp.lastName}</td>
				<td>${emp.email}</td>
				<td>${emp.mobile}</td>

			</tr>

		</c:forEach>
	</table>

</body>
</html>