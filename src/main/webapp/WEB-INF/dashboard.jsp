<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="author" content="Jessica LaPlante">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/simplex/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<title>Animal Tracker Dashboard Page</title>
</head>
<body class="background-img">
	<br />
	<br />
	<div class="jumbotron">
	<h1 class="text-danger text-center"><strong>Welcome to The Giraffe Tracker Database</strong></h1>
	<h3 class="text-center">Welcome, <a href="/user/${user.id}"	>${user.firstName} ${user.lastName}</a></h3>
	<p class="text-center">Please update your profile if this is your first time logging in</p>

	<hr />

	<table class="table table-hover">
		<thead class="table-dark">
			<tr>
				<th>Name</th>
				<th>Species</th>
				<th>Age</th>
				<th>Location</th>
				<th>Last Updated</th>
				<th>Updated By</th>

			</tr>
		</thead>
		<tbody class="table-danger">
			<c:forEach items="${giraffes}" var="giraffe">
				<tr>
					<td><a href="/giraffe/${giraffe.id}"><strong>${giraffe.name}</strong></a></td>
					<td>${giraffe.species}</td>
					<td>${giraffe.birth_year}</td>
					<td><a href="/location/${giraffe.location.id}"><strong>${giraffe.location.name}</strong></a></td>
					<td>
						<c:choose>
							<c:when test="${giraffe.updatedAt != null}">${giraffe.updatedAt}</c:when>
							<c:otherwise>${giraffe.createdAt}</c:otherwise>
						</c:choose>
					</td> 
					<td>
						<c:choose>
							<c:when test="${giraffe.updatedAt != null}"> <a href="/congroup/${giraffe.updatedBy.employer.id}"><strong>${giraffe.updatedBy.employer.name}</strong></a></c:when>
							<c:otherwise><a href="/congroup/${giraffe.giraffeCreator.employer.id}"><strong>${giraffe.giraffeCreator.employer.name}</strong></a></c:otherwise>
						</c:choose>
					</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>

	<a href="/giraffe/new" class="btn btn-danger">Add New Giraffe</a>
	<a href="/congroup/new" class="btn btn-danger">Add New Group</a>
	<a href="/location/new" class="btn btn-danger">Add New Location</a>
	<a href="/tracker/new" class="btn btn-danger">Add New Tracker</a>
	
	<hr />
			<a href="/logout" class="btn btn-danger">Logout</a>

</body>
</html>