<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
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
<meta charset="UTF-8">
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
					<th>
						Price
						<br>
						<br>
					</th>

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
						<c:choose>
							<c:when test="${ not empty Customer }">
								<td>
									<a href="/addToCart/${item.name}">
										<button class="botton1">Add to cart</button>
									</a>
								</td>
							</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose>
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