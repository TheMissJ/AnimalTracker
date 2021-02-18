<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="author" content="Jessica LaPlante">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/simplex/bootstrap.min.css">
<title>Animal Tracker Login Page</title>
</head>
<body>

<div class="jumbotron">
		<h1 class="text-danger text-center"><strong>Welcome to The Giraffe Tracker Database</strong></h1>
		<h3 class="text-danger text-center">User Login & Registration Page</h3>
		<div class="row">
			<div class="col">
				<h4>Login</h4>
				<p>${ loginError }</p>
				<form method="POST" action="/login">
					<div class="form-group">
						<label>Email:</label> <input type="email" class="form-control"
							type="email" name="lemail">
					</div>
					<div class="form-group">
						<label>Password:</label> <input class="form-control"
							type="password" name="lpassword">
					</div>
					<button type="password" class="btn btn-danger">Login</button>
				</form>
			</div>
			<div class="col">
				<h4>Register</h4>
				<form:form action="/user/register" method="post" modelAttribute="user">
					<div class="form-group">
						<form:label path="firstName">First Name</form:label>
						<form:errors path="firstName" />
						<form:input type="first-name" class="form-control"
							path="firstName" />
					</div>
					<div class="form-group">
						<form:label path="lastName">Last Name</form:label>
						<form:errors path="lastName" />
						<form:input type="last-name" class="form-control" path="lastName" />
					</div>
					<div class="form-group">
						<form:label path="email">Email</form:label>
						<form:errors path="email" />
						<form:input type="email" class="form-control" path="email" />
					</div>
					<div class="form-group">
						<form:label path="password">Password</form:label>
						<form:errors path="password" />
						<form:input type="password" class="form-control" path="password" />
					</div>
					<div class="form-group">
						<form:label path="confirmPassword">Confirm Password</form:label>
						<form:errors path="confirmPassword" />
						<form:input type="password" class="form-control"
							path="confirmPassword" />
					</div>
					<input class="btn btn-danger" type="submit" value="Submit" />
				</form:form>

</body>
</html>