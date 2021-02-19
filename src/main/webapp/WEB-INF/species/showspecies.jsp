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
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<h2>Species: ${species.name}</h2>
		<br>

		<h4>Sub-Species</h4>
		<table class="table">
			<thead>
				<tr>
					<th>Sub-Species Name</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${species.mySubSpecies}" var="subSpecies">
					<tr>
						<td><c:out value="${subSpecies.name}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<br>
		
		<h4>Giraffe Registered with this Species</h4>
		<table class="table">
			<thead>
				<tr>
					<th>Giraffe Name</th>
				</tr>
				<tr>
					<th>Location</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${species.giraffeInSpecies}" var="speciesGiraffe">
					<tr>
						<td><c:out value="${speciesGiraffe.name}"></c:out></td>
						<td><c:out value="${speciesGiraffe.location}"></c:out></td>
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