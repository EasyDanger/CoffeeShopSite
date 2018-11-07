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
	<h1>Hello, ${ firstName }</h1>
	<h2>Please verify your submission details below.</h2>
	<p>First Name: ${ firstName }</p>
	<p>Last Name: ${ lastName }</p>
	<p>Email Address: ${ email }</p>
	<p>Phone Number: ${ phone }</p>
	<br>
	<br>
	<p>
		If the above information is correct/true,
		<a href="/addTraitor?firstName=${ firstName }">click here to
			continue your submission.</a>
	</p>
	<br>
	<p>
		If the above information is incorrect/false,
		<a href="/traitor">click here to return to your submission form.</a>
	</p>
</body>
</html>