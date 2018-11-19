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
<meta charset="ISO-UTF-8">
<title>This is you, for Us</title>
</head>
<body>
	<%@include file="partials/header.jsp"%>
	<h1>coffee® Members</h1>
	<main class="flex">
	<div class="card1">
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Species</th>
					<th></th>
					<th></th>
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
						<td>
							<c:set
								var="Admin"
								scope="session"
								value="${item.admin}"
							/>
							<c:if test="${Admin}">
								<p>
									<c:out value="Admin" />
								<p>
							</c:if>

						</td>
						<c:choose>
							<c:when test="${ User.admin }">
								<td>
								<td>
									<a
										href="/member/toggle/${ item.name }"
									><button class="botton">Toggle Admin</button></a>
								</td>
								<td>
									<a
										href="/member/delete/${ item.name }"
									><button class="botton">Delete</button></a>
								</td>
							</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<p>
			<a
				href="/ill/${ Name }"
			><button class="botton">Return to menu.</button></a>
		</p>
	</div>
	</main>
</body>
</html>