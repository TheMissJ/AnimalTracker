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
<title>Add A New Note</title>
</head>
<body class="background-img">
	<br />
	<br />

	<div class="container">
		<h2>Add Note for ${note.giraffe.name}</h2>
		
		<form:form method="POST" action="/edit/{giraffe.id}/note/add" modelAttribute="note">
		<div class="form-group">
			<form:label path="content">Note Content:</form:label>
			<form:errors path="content"/> 
			<form:textarea class="form-control" path="content" rows="8" cols="40"/>
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