<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Comments</title>
</head>
<body>
<h3>Comments</h3>
	<table>
		<tr>
			<td>AUTHOR NAME&nbsp;&nbsp;</td>
			<td>ARTICLE TITLE&nbsp;&nbsp;</td>
			<td>COMMENT&nbsp;&nbsp;</td>
			
		</tr>
	
		<c:forEach var="c" items="${COMMENTS_LIST}" varStatus="i">
			<tr>
				<td>${c.commentUserId.name}</td>
				<td>${c.commentArticleId.title}</td>
				<td>${c.commentText}</td>
			</tr>
			 
		</c:forEach>
		
	</table>
</body>
</html>