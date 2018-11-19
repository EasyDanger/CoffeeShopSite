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
<title>The Illusion of Choice</title>
</head>
<body>
	<%@include file="partials/header.jsp"%>
	<br>
		<h3 class="message">${ message }</h3>
	
	<h1>What would you like to do?</h1>
	<main class="flex">
	<div class="card">
		<main
			class="flex"
			align="center">
		<div><a href="/profile">
		<button class="botton2">View/Edit your profile</button></a></div>
		 <a href="/menu">
			<button class="botton2">View/Edit the menu</button>
		</a> </main>
		<main
			class="flex"
			align="center"
		> <a href="/members/${ Name }">
			<button class="botton2">View member list</button>
		</a> <a href="/logout">
			<button class="botton2">Logout</button>
		</a>
		</main>
	</div>
	</main>

</body>
</html>