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
			<p class="message">${ message }</p>
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
							<c:when test="${ User.admin }">
								<td>
									<a href="/removeMenu/${item.name}">
										<button class="botton1">Remove from menu</button>
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
		<main class="flex">
		<c:choose>
			<c:when test="${ User.admin }">
				
					<a href="/addItem">
						<button class="botton1">Add item to this menu</button>
					</a>
				
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
		
			<a href="/ill">
				<button class="botton1">Return to menu</button>
			</a>
		</main>
	</div>
	</main>
</body>
</html>