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
<title>Add A New Tracker</title>
</head>
<body class="background-img">
	<br />
	<br />
	<div class="jumbotron">
			<h2>Add A New Tracker</h2>

		<form:form method="POST" action="/new" modelAttribute="tracker">
			<div class="form-group">
				<form:label path="serialNum">Serial Number:</form:label>
				<form:errors path="serialNum" />
				<form:input class="form-control" path="serialNum" />
			</div>
			
						<div class="form-group">
				<form:label path="lat_degrees">Latitude Degrees:</form:label>
				<form:errors path="lat_degrees" />
				<form:input class="form-control" path="lat_degrees" />
			</div>
			
						<div class="form-group">
				<form:label path="lat_minutes">Latitude Minutes:</form:label>
				<form:errors path="lat_minutes" />
				<form:input class="form-control" path="lat_minutes" />
			</div>
			
						<div class="form-group">
				<form:label path="lat_seconds">Latitude Seconds:</form:label>
				<form:errors path="lat_seconds" />
				<form:input class="form-control" path="lat_seconds" />
			</div>
			
						<div class="form-group">
				<form:label path="lon_degrees">Longitude Degrees:</form:label>
				<form:errors path="lon_degrees" />
				<form:input class="form-control" path="lon_degrees" />
			</div>
			
						<div class="form-group">
				<form:label path="lon_minutes">Longitude Minutes:</form:label>
				<form:errors path="lon_minutes" />
				<form:input class="form-control" path="lon_minutes" />
			</div>
			
						<div class="form-group">
				<form:label path="lon_seconds">Longitude Seconds:</form:label>
				<form:errors path="lon_seconds" />
				<form:input class="form-control" path="lon_seconds" />
			</div>
			
			
			
			
		<button class="btn btn-danger">Save</button>
		</form:form>
	</div>
	<br />
	<a href="/giraffe" class="btn btn-danger">Dashboard</a>
	<br />
	<a href="/logout" class="btn btn-danger">Logout</a>
</body>
</html>