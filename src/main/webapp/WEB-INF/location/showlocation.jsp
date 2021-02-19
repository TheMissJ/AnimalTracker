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
<title>Display Location Information</title>
</head>
<body>


	<div class="container">
		<h2>Location: ${location.name}</h2>
		<br>
		
		<h4>Giraffe Currently at This Location</h4>
		<table class="table">
			<thead>
				<tr>
					<th>Giraffe Name</th>
				</tr>
				<tr>
					<th>Species</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${location.giraffes}" var="giraffes">
					<tr>
						<td><c:out value="${giraffes.name}"></c:out></td>
						<td><c:out value="${giraffes.species}"></c:out></td>
						<td><c:out value="${giraffes.subSpecies}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</div>		

		<br /> 
		<a href="/giraffe">Dashboard</a> 
		<br /> 
		<a href="/logout">Logout</a>
</body>
</html>