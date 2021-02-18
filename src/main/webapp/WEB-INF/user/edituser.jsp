<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="author" content="Jessica LaPlante">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/simplex/bootstrap.min.css">
<title>Edit Conservation Staff Page</title>
</head>
<body>

	<h1>Edit Your Account, ${user.firstName} ${user.lastName}</h1>

	<br />
	<br />

	<form:form method="POST" action="/user/edit/${user.id}" modelAttribute="user">
		<div class="form-group">
			<form:label path="firstName">First Name:</form:label>
				<form:errors path="firstName" />
				<form:input class="form-control" path="firstName" />

		</div>

		<div class="form-group">
			<form:label path="lastName">Last Name:</form:label>
			<form:errors path="lastName" />
			<form:input class="form-control" path="lastName"></form:input>
		</div>
		
				<div class="form-group">
			<form:label path="email">Email:</form:label>
			<form:errors path="email" />
			<form:input class="form-control" path="email"></form:input>
		</div>

		<div class="form-group">
			<form:label path="employer">Group:</form:label>
			<form:errors path="employer" />
			<form:select class="form-control" path="employer">
				<option value="${user.employer }">${user.employer.name}</option>
				<c:forEach items="${congroups }">
					<c:choose>
						<c:when test="${user.employer == congroup.id }">
						</c:when>
						<c:otherwise>
							<option value="${congroup.id }">${congroup.name }</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</form:select>
		</div>
		
		<button class="btn button-danger">Save</button>
	</form:form>

	<br>
	<br>

	<a href="/giraffe">Dashboard</a>
	<hr />
	<a href="/logout">Logout</a>

</body>
</html>