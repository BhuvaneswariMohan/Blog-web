<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<a href="/">Home</a>
	<h3>User List JSP</h3>
	<table>
		<tr>
			<td>id</td>
			<td>name</td>
			<td>emailId</td>
			<td>password</td>
			<td>roleId</td>
		</tr>
		<c:forEach var="c" items="${USER_LIST}" varStatus="i">
			<tr>
				<td>${c.id}</td>
				<td>${c.name}</td>
				<td>${c.emailid}</td>
				<td>${c.password}</td>
				<td>${c.role.id}</td>
				<!-- <td><a href="users/update?id=${c.id}">Update</a></td>-->
				<!-- <td><a href="users/delete?id=${c.id}">Delete</a></td>-->
			</tr>
		</c:forEach>
	</table>
</body>
</html>