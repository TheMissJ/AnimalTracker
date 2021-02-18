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
<title>Animal Tracker Dashboard Page</title>
</head>
<body>
	<h3>Welcome, <a href="/user/${user.id}"	>${user.firstName} ${user.lastName}</a></h3>
	<a href="/logout">Logout</a>

	<hr />

	<table class="table table-dark table-hover">
		<thead>
			<tr>
				<th>Name</th>
				<th>Species</th>
				<th>Age</th>
				<th>Location</th>
				<th>Last Updated</th>
				<th>Updated By</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${giraffes}" var="giraffe">
				<tr>
					<td><a href="/giraffe/${giraffe.id}">${giraffe.name}</a></td>
					<td>${giraffe.species}</td>
					<td>${giraffe.location}</td>
					<td>${giraffe.updated_at }</td>
					<td>${giraffe.updatedBy.employer.name}</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

	<a href="giraffe/new" class="btn btn-danger">Add New Giraffe</a>
		<a href="congroup/new" class="btn btn-danger">Add New Group</a>

</body>
</html>