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
			<c:choose>
				<c:when test="${ not empty User }">
					<a href="/ill">coffee®</a>
				</c:when>
				<c:otherwise>
					<a href="/">coffee®</a>
				</c:otherwise>
			</c:choose>
		</li>
		<li>
			<c:choose>
				<c:when test="${ not empty Customer }">
			Welcome, <a href="/fixProfile">${ Customer.name }</a>
					<li>
						<a href="/showCart">Cart</a>
					</li>
					<li>
						<a href="/logout">Logout</a>
					</li>
				</c:when>
				<c:when test="${ not empty User }">
			Welcome, <a href="/profile">${ User.name }</a>
					<li>
						<a href="/ill">Menu</a>
					</li>
					<li>
						<a href="/logout">Logout</a>
					</li>
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
