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
<meta charset="UTF-8">
<title>We Need Your DATA.</title>
</head>
<body>
	<%@include file="partials/header.jsp"%>
	<br>
	<p>
		To continue your submission, please complete the following form
		entering only accurate data.
		<br>
		We will know if you enter false data.
		<br>
		<br>
		<br>
		Your data is safe with coffee®
	</p>
	<main class="flex">
	<div class="card">
		<form action="/signupCustomer" method="post">
			<p class="message">${ message }</p>
			<p>
				First Name:
				<span style="float: right;">
					<input
						name="firstName"
						required
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
						placeholder="everythingisfine@coffee®.com"
						pattern="[a-zA-Z\\d]+@[a-zA-Z\\d]{4,10}.[a-zA-Z\\d]{2,3}"
						class="input"
					/>
				</span>
			</P>
			<P>
				Credit Card Number:
				<span style="float: right;">
					<input
						name="cardNum"
						placeholder="#### #### #### ####"
						pattern="\d{4} \d{4} \d{4} \d{4}"
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
						maxlength="16"
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
						onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Must have at least 6 characters' : '')"
						required
						class="input"
						placeholder="a-Z,0-9,!@#$%^&*"
					/>
				</span>
			</P>
			<P>
				Please Re-enter Password:
				<span style="float: right;">
					<input
						id="passWord2"
						name="passWord2"
						type="password"
						pattern="^\S{6,}$"
						onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Please enter the same Password as above' : '');"
						placeholder="Enter same password"
						required
						class="input"
					/>
				</span>
			</P>
			<p>
				<input
					type="checkbox"
					name="box"
					value="true"
					required
				>
				<span style="float: right;">
					* I agree to all terms of submission.
					<br>
				</span>
			</p>
			<br>
			<br>
			<div style="text-align: center">
				<button>SUBMIT.</button>
			</div>
		</form>
	</div>
	</main>
</body>
</html>