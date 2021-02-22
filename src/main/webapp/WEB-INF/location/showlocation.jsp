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
<link rel="stylesheet" href="/css/style.css">
<title>Show Location Information</title>
</head>
<body class="background-img">
	<br />
	<br />


	<div class="jumbotron">
		<h1 class="text-center">Location: ${location.name}</h1>
		<br>
		
		<h4>Giraffe Currently at This Location</h4>
		<table class="table table-hover">
			<thead class="table-dark">
				<tr>
					<th>Giraffe Name</th>
					<th>Species</th>
					<th>Age</th>
				</tr>
			</thead>
			<tbody class="table-danger">
				<c:forEach items="${location.giraffes}" var="giraffe">
					<tr>
						<td><a href="/giraffe/${giraffe.id}"><c:out value="${giraffe.name}"></c:out></a></td>
						<td><c:out value="${giraffe.species}"></c:out></td>
						<td><c:out value="${giraffe.birth_year}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</div>		

	<br />
	<a href="/giraffe" class="btn btn-danger btn-small">Dashboard</a>
	<a href="/logout" class="btn btn-danger btn-small">Logout</a>
	</body>
</html>