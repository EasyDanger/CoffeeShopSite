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
<title>We Need Your DATA.</title>
</head>
<body>
	<%@include file="partials/header.jsp"%>
	<br>
	<p>
		We told you we'd know.
		<br>
		Do not make this mistake again.
		<br>
		<br>
		coffee® is a privilege. 
		<br>
		Your data is safe with coffee®
	</p>
	<main class="flex">
	<div class="card">
		<form
			action="/profile"
			method="post"
		>
			<p class="message">${ message }</p>
			<p>
				First Name:
				<span style="float: right;">
					<input
						name="firstName"
						required
						value="${ User.fname }"
						placeholder="Human"
						class="input"
					/>
				</span>
			</p>
			<p>
				Last Name:
				<span style="float: right;">
					<input
						name="lastName"
						required
						value="${ User.lname }"
						placeholder="Name"
						class="input"
					/>
				</span>
			</p>
			<P>
				Email Address:
				<span style="float: right;">
					<input
						name="email"
						required
						value="${ User.email }"						
						placeholder="everythingisfine@coffee®.com"
						pattern="[a-zA-Z\\d]+@[a-zA-Z\\d]{4,10}.[a-zA-Z\\d]{2,3}"
						class="input"
					/>
				</span>
			</P>
			<P>
				Phone Number:
				<span style="float: right;">
					<input
						name="phone"
						value="${ User.phone }"						
						placeholder="(###) ###-####"
						pattern="\(\d{3}\) \d{3}-\d{4}"
						class="input"
					/>
				</span>
			</P>
			<p>
				User Name:
				<span style="float: right;">
					<input
						name="Name"
						required
						value="${ User.name }"
						maxlength="16"
						placeholder="Human"
						class="input"
					/>
				</span>
			</p>
			<P>
				Please Re-enter Password:
				<span style="float: right;">
					<input
						id="passWord"
						name="passWord"
						type="password"
						pattern="^\S{6,}$"
						placeholder="Enter your password"
						required
						class="input"
					/>
				</span>
			</P>
			<P>
				Enter new password here to change:
				<span style="float: right;">
					<input
						id="passWord"
						name="newWord"
						type="password"
						pattern="^\S{6,}$"
						placeholder="New Password"
						class="input"
					/>
				</span>
			</P>
			<br>
			<br>
			<div style="text-align: center">
				<button class="botton2">SUBMIT.</button>
			</div>
		</form>
	</div>
	</main>
</body>
</html>