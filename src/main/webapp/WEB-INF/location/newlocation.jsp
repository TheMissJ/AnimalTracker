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
<title>Add A New Location</title>
</head>
<body class="background-img">
	<br />
	<br />

<div class="container">
	<h2>Add Location</h2>
	
	<form:form method="POST" action="/location/new" modelAttribute="location">
	<div class="form-group">
		<form:label path="name">Location Name:</form:label>
		<form:errors path="name"/> 
		<form:input class="form-control" path="name"/>
	</div>
		
	<button>Save</button> 
	</form:form>
</div>
	<br />
	<a href="/giraffe" class="btn btn-danger">Dashboard</a>
	<br />
	<a href="/logout" class="btn btn-danger">Logout</a>
	
</body>
</html>