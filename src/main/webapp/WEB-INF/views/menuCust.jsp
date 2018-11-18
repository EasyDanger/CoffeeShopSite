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
<title>This is the menu</title>
</head>
<body>
	<%@include file="partials/header.jsp"%>
	<br>
	<h1>coffee® Menu Items</h1>
	<main class="flex">
	<div class="card1">
		<table class="table">
			<thead>
				<tr>
					<th>Item</th>
					<th>Description</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach
					var="item"
					items="${list}"
				>
					<tr>
						<td>${item.name}</td>
						<td>${item.description}</td>
						<td>$${item.price}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<main class="flux"> <a href="/">
			<button class="botton">coffee® Home</button>
		</a></main>
	</div>
	</main>
</body>
</html>