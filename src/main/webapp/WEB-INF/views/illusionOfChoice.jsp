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
<title>The Illusion of Choice</title>
</head>
<body>
	<h3>Welcome, ${ Name }!</h3>
	<h1>What would you like to do?</h1>
	<main class="flex">
	<button class="butt">
		<div class="card">View/Edit your profile</div>
	</button>
	<a href="/menu/${ Name }"><button class="butt">
		<div class="card2">View/Edit the menu</div>
	</button></a>
	</main>
	<br>
	<main class="flex">
	<a href="/members/${ Name }"><button class="butt">
		<div class="card1">View member list</div>
	</button></a>
	<a href="/"><button class="butt">
		<div class="card">Logout</div>
	</button></a>
	</main>

</body>
</html>