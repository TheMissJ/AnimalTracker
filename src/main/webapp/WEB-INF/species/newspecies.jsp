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
<title>Insert title here</title>
</head>
<body>

<div class="container">
	<h2>Add Species</h2>
	
	<form:form method="POST" action="/species/new" modelAttribute="species">
	<div class="form-group">
		<form:label path="name">Species Name:</form:label>
		<form:errors path="name"/> 
		<form:input class="form-control" path="name"/>
	</div>
		
	<button>Save</button> 
	</form:form>
</div>
	<br />
	<a href="/giraffe">Dashboard</a>
	<br />
	<a href="/logout">Logout</a>
</body>
</html>