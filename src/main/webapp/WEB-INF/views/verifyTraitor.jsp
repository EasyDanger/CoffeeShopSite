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
<meta charset="ISO-8859-1">
<title>Verify</title>
</head>
<body>
	<h1>Hello, ${ user.name }</h1>
	<h2>Please verify your submission details below.</h2>
	<p>First Name: ${ user.fname }</p>
	<p>Last Name: ${ user.lname }</p>
	<p>Email Address: ${ user.email }</p>
	<p>Phone Number: ${ user.phone }</p>
	<br>
	<br>
	<p>
		If the above information is correct/true,
		<a href="/addTraitor?user=${ user }">click here to
			continue your submission.</a>
	</p>
	<br>
	<p>
		If the above information is incorrect/false,
		<a href="/traitor">click here to return to your submission form.</a>
	</p>
</body>
</html>