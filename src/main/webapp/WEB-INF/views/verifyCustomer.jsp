<%@ page
	language="java"
	contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
%>
<!DOCTYPE html>
<html>
<head>
<link
	rel="stylesheet"
	href="styles.css"
>
<meta charset="ISO-8859-1">
<title>Verify</title>
</head>
<body>
	<%@include file="partials/header.jsp"%>
	<br>
	<h1>Hello, ${ Name }</h1>
	<h2>Please verify your submission details below.</h2>
	<main class="flex">
	<div class="card">

		<p align="center">First Name: ${ firstName }</p>
		<p align="center">Last Name: ${ lastName }</p>
		<p align="center">Email Address: ${ email }</p>
		<br>
		<p align="center">Is the above information correct?</p>
		<main class="flux"> <a href="/addCustomer?firstName=${ firstName }&Name=${ Name }&lastName=${ lastName }&email=${ email }&cardNum=${ cardNum }&passWord=${ passWord }">
			<button class="botton1">Yes!</button>
		</a> <a href="signupCustomer">
			<button class="botton1">No.</button>
		</a></main></div>
</body>
</html>