<%@ page
	language="java"
	contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
%>
<!DOCTYPE html>
<html>
<head>
<link
	rel="stylesheet"
	href="http://localhost:8080/styles.css"
>
<meta charset="ISO-8859-1">
<title>We Need Your DATA.</title>
</head>
<body>
	<p>
		<h1>What item would you like to add ... ${ Name }?</h1>
		<br>
		
		<br>
		
	</p>
	<main class="flex">
	<div class="card">
		<form action="/menuAdd/${ Name }" method="post">
			<p>
				Name of item:
				<span style="float: right;">
					<input
						name="itemName"
						required
						placeholder="Human consumption item"
						class="input"
					/>
				</span>
			</p>
			<p>
				Item description:
				<span style="float: right;">
					<input
						name="Description"
						required
						placeholder="Describe it here"
						class="input"
					/>
				</span>
			</p>
			<P>
				Price of item:
				<span style="float: right;">
					$<input
						name="Price"
						required
						type="number"
						step="0.01"
						placeholder="#.##"
						class="input"
					/>
				</span>
			</P>
			
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