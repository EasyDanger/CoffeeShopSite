<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"
%>
<div class="main-nav">
	<ul class="nav">
		<li class="name">
			<a href="/">coffee®</a>
		</li>
		<li>
			<c:choose>
				<c:when test="${ not empty Customer }">
			Welcome, ${ Customer.name }
			<li>
			<a href="/logout">Logout</a></li>
				</c:when>
				<c:otherwise>
					<li>
						<a href="/loginCustomer">Login</a>
					</li>
					<li>
						<a href="/signupCustomer">Sign Up</a>
					</li>
				</c:otherwise>
			</c:choose>
		</li>
	</ul>
</div>
