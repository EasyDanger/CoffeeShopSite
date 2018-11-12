<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link
	rel="stylesheet"
	href="styles.css"
>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<h1> Log in</h1>

	<main class="flex">
	<div class="card">
		<form action="/login">
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
				<button>Login.</button>
			</div>
		</form>

</body>
</html>