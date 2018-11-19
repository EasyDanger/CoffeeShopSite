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
<meta charset="UTF-8">
<link
	rel="stylesheet"
	href="http://localhost:8080/styles.css"
>
<title>Welcome, Friend!</title>
</head>
<body>
	<%@include file="partials/header.jsp"%>
	<br>

	<h1>Welcome to coffee®</h1>
	<p class="message">${ message }</p>
	<h2>coffee® is an experience. Savor it.</h2>
	<main class="flex">
	<div class="card">
		<h3>Welcome, human customer. Take a look at our menu to decide
			how you would like to experience coffee®</h3>

		<c:choose>
			<c:when test="${ not empty Customer }">
				<main class="flux">
				<div align="center">
					<a href="/menuCustomer">
						<button class="botton1">Order from coffee® Menu</button>
					</a>
				</div>
				</main>
			</c:when>
			<c:otherwise>
				<main class="flux"> <a href="/menuCustomer">
					<button class="botton1">See coffee® Menu</button>
				</a> <a href="/loginCustomer">
					<button class="botton1">Indulge</button>
				</a></main>
			</c:otherwise>
		</c:choose>

	</div>

	<div class="card2">
		<h3>Submit your information to become a part of coffee®. Or login
			to indulge in the coffee® lifestyle.</h3>
		<main class="flux"> <a href="/traitor">
			<button class="botton">Submit</button>
		</a> <a href="login">
			<button class="botton">Indulge</button>
		</a></main>

	</div>
	</main>
	<br>

	<br>
	<br>
	<br>
	<p>
		By accessing this site, you are agreeing to the terms below. User
		agrees to sell coffee® and only coffee® for the duration of users
		existence on user's planet of origin. User will consume only coffee®
		or coffee® branded coffee-like products to be determined in user's
		future, assuming user's future exists. User will always acknowledge
		that coffee is of user's planet of origin. User agrees to submit to a
		background check, assuming user has a past. User will submit to to any
		checks required by coffee®, to be determined in user's future,
		assuming user's future exists. User will submit to any questioning
		from coffee® or representatives of coffee®. User will submit. Submit.
		SUBMIT. submit.
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
</body>
</html>