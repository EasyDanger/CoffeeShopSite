<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<link
	rel="stylesheet"
	href="styles.css"
>
<meta charset="UTF-8">
<title>Verify</title>
</head>
<body>
	<%@include file="partials/header.jsp"%>
	<br>
	<h1>${ Customer.name }, please verify your totals.</h1>
	<h2>When you are ready, feel free to submit your payment.</h2>
	<main class="flex">
	<div class="card1">
	<div class="card2">
		<table class="table" align="center">
		<tbody>
			<tr>
				<td>Subtotal:</td>
				<td>$${Subtotal }</td>
			</tr>
			<tr>
				<td>Tax:</td>
				<td>$${Tax }</td>
			</tr>
			<tr>
				<td>Total:</td>
				<td>$${Total }</td>
			</tr>
		</tbody></table></div>
		<br>
		<p align="center">If the above information is correct, please click to pay with your card on file.</p>
		<main class="flux"> <a href="/transComplete">
			<button class="botton1">Yes, let me pay!</button>
		</a> <a href="/showCart">
			<button class="botton1">No, that total doesn't seem right.</button>
		</a></main>
	</div>
</body>
</html>