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
<title>Show User Profile</title>
</head>
<body>

	<h3>User: ${user.firstName} ${user.lastName}</h3>
	<br>
	<h4>Email: ${user.email}</h4>
	<h4>Group: ${user.employer.name }</h4>
	
	<br />
		<button class="btn button-danger"><a href="/user/edit/${user.id}">Edit Account</a></button>
	<br />
	<a href="/giraffe">Dashboard</a>
	<br />
	<a href="/logout">Logout</a>
</body>
</html>