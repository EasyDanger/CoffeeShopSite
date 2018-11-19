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
<title>This is your cart®</title>
</head>
<body>
	<%@include file="partials/header.jsp"%>
	<br>
	<h1>${Customer.name }</h1>
	<main class="flex">
	<div class="card1">
		<table class="table">
			<thead>
				<tr>
					<th>Item</th>
					<th>Quantity</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach
					var="item"
					items="${Cart}"
				>
					<tr>
						<td>${item.menuId}</td>
						<td>${item.quant}</td>
						<td>$${item.price}</td>
						<td>
							<a href="/plusCart/${item.menuId}">
								<button class="botton">+</button>
							</a>
							<c:choose>
								<c:when test="${ item.quant > 1 }">
									<td>
										<a href="/minusCart/${item.menuId}">
											<button class="botton">-</button>
										</a>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<a href="/removeCart/${item.menuId}">
											<button class="botton">-</button>
										</a>
									</td>
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<a href="/removeCart/${item.menuId}">
								<button class="botton">Remove from cart®</button>
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h3>Your subtotal is: $${ Subtotal }</h3>
		<main class="flux"> <a href="/">
			<button class="botton">coffee® Home</button>
		</a>
		<a href="/menuCustomer">
			<button class="botton">Continue shopping</button>
		</a>
				<a href="/checkout">
			<button class="botton">Checkout!</button>
		</a>
		</main>
	</div>
	</main>
</body>
</html>