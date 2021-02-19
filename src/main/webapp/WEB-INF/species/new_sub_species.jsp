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
<title>Add New Sub-Species</title>
</head>
<body>

<div class="container">
	<h2>Add Sub-Species</h2>
	
	<form:form method="POST" action="/species/add_subspecies" modelAttribute="subspecies">
		<div class="form-group">
		<form:label path="species">Sub-Species Of:</form:label>
		<form:errors path="species"/>
		<form:select class="form-control" path="species">
			<c:forEach items="${species}" var="species">
			<option value="${species.id }">${species.name}</option>
			</c:forEach>
			</form:select>

	</div>
	
	
	<div class="form-group">
		<form:label path="name">Sub-Species Name:
		<form:errors path="name"/> 
		<form:input class="form-control" path="name"/></form:label>
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