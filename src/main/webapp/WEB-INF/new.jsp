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
<title>Add a New Giraffe</title>
</head>
<body>
<div class="container">
	<h2>Add Giraffe</h2>
	
	<form:form method="POST" action="/new" modelAttribute="giraffe">
	<div class="form-group">
		<form:label path="name">Giraffe Name:
		<form:errors path="name"/> 
		<form:input class="form-control" path="name"/></form:label>
	</div>
	
	<div class="form-group">
		<form:label path="birth_year">Birth Year (approx):
		<form:errors path="birth_year"/> 
		<form:input class="form-control" path="birth_year"/></form:label>
	</div>	
	
	<div class="form-group">
		<form:label path="height">Height (m):
		<form:errors path="height"/> 
		<form:input class="form-control" path="height"/></form:label>
	</div>
	
	<div class="form-group">
		<form:label path="weight">Weight (kg):
		<form:errors path="weight"/> 
		<form:input class="form-control" path="weight"/></form:label>
	</div>
	
	<div class="form-group">
		<form:label path="gender">Gender:</form:label>
		<form:errors path="gender"/> 
		<form:select class="form-control" path="gender">
			<option value="F">F</option>
			<option value="M">M</option>
		</form:select>
	</div>
	
	<div class="form-group">
		<form:label path="location">Location:</form:label>
		<form:errors path="location"/> 
		<form:select class="form-control" path="location">
			<option:
		</form:select>
	</div>
	
	<div class="form-group">
		<form:label path="tracker">Tracker:
		<form:errors path="tracker"/> 
		<form:input class="form-control" path="tracker"/></form:label>
	</div>
	
	<div class="form-group">
		<form:label path="species">Species:
		<form:errors path="species"/> 
		<form:input class="form-control" path="species"/></form:label>
	</div>
	
	<div class="form-group">
		<form:label path="subSpecies">Sub-Species:
		<form:errors path="subSpecies"/> 
		<form:input class="form-control" path="subSpecies"/></form:label>
	</div>
		
	<button>Save</button> 
	</form:form>
</div>
</body>
</html>