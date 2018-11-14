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
	<div class="card">
		<main
			class="flex"
			align="center">
		<div>
		<button class="botton2">View/Edit your profile</button></div>
		 <a href="/menu/${ Name }">
			<button class="botton2">View/Edit the menu</button>
		</a> </main>
		<main
			class="flex"
			align="center"
		> <a href="/members/${ Name }">
			<button class="botton2">View member list</button>
		</a> <a href="/">
			<button class="botton2">Logout</button>
		</a>
		</main>
	</div>
	</main>

</body>
</html>