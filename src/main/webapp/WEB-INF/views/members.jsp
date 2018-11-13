<%@ page
	language="java"
	contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
%>
<%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"
%>
<!DOCTYPE html>
<html>
<head>
<link
	rel="stylesheet"
	href="http://localhost:8080/styles.css"
>
<meta charset="ISO-8859-1">
<title>This is you, for Us</title>
</head>
<body>
	<h1>coffee� Members</h1>
	<main class="flex">
	<div class="card1">
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Species</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach
					var="item"
					items="${list}"
				>
					<tr>
						<td>${item.name}</td>
						<td>${item.email}</td>
						<td>Human</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	
	<p><a href="/ill/${ Name }">Return to menu.</a></p>
	</div>
	</main>
</body>
</html>