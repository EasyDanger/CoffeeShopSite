<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"
%>
<!DOCTYPE html>
<html>
<head>
<link
	rel="stylesheet"
	href="styles.css"
>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<%@include file="partials/header.jsp"%>
	<br>
<h1> Log in</h1>

	<main class="flex">
	<div class="card2">
		<form action="/login"
		method="post">
			<p class="message">${ message }</p>
		
			<p>
				User Name:
				<span style="float: right;">
					<input
						name="userName"
						required
						placeholder="Human"
						class="input"
					/>
				</span>
			</p>
					<P>
				Password:
				<span style="float: right;">
					<input
						id="passWord"
						name="passWord"
						type="password"
						pattern="^\S{6,}$"
						placeholder="a-Z,0-9,!@#$%^&*"
						onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Must have at least 6 characters' : '')"
						required
						class="input"
					/>
				</span>
			</P>
			
			<br>
			<br>
			<div style="text-align: center">
				<button class="botton2">Login.</button>
			</div>
		</form>

</body>
</html>