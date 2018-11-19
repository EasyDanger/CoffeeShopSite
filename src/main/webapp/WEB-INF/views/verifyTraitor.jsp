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
	href="styles.css"
>
<meta charset="UTF-8">
<title>Verify</title>
</head>
<body>
	<%@include file="partials/header.jsp"%><br>
	<h1>Hello, ${ Name }</h1>
	<h2>Please verify your submission details below.</h2>
	<p>First Name: ${ firstName }</p>
	<p>Last Name: ${ lastName }</p>
	<p>Email Address: ${ email }</p>
	<p>Phone Number: ${ phone }</p>
	<br>
	<br>
	<p>
		If the above information is correct/true,
		<!--&firstName=Edward&lastName=Carter&email=carteroffice%40gmail.com&phone=%28313%29+867-5309&Name=EasyDanger&passWord=HomeRow-->
		<a
			href="/addTraitor?firstName=${ firstName }&Name=${ Name }&lastName=${ lastName }&email=${ email }&phone=${ phone }&passWord=${ passWord }"
		>click here to continue your submission.</a>
	</p>
	<br>
	<p>
		If the above information is incorrect/false,
		<a href="/traitor">click here to return to your submission form.</a>
	</p>
</body>
</html>