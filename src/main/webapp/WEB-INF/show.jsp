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
<title>Display Giraffe Details</title>
</head>
<body class="background-img">
	<br />
	<br />

	<div class="jumbotron">
			<h1 class="text-danger text-center"><strong>The Giraffe Tracker Database</strong></h1>
			<h2 class="text-center">Meet <strong class="text-danger">${giraffe.name}</strong> from the <strong class="text-danger">${giraffe.location.name}</strong></h2>
	</div>
	
	<div class="card border-danger mb-3 mx-auto" style="max-width: 20rem;">
 			<div class="card-body">
   		<h4 class="card-header bg-danger">Details</h4>
   		<h6 class="card-title">Birth Year (approx):  ${giraffe.birth_year}</h6>
   		<h6 class="card-title">Height (m):  ${giraffe.height}</h6>
		<h6 class="card-title">Weight (kg):  ${giraffe.weight}</h6>
		<h6 class="card-title">Gender:  ${giraffe.gender}</h6>
		<h6 class="card-title">Species:  ${giraffe.species}</h6>
		<h6 class="card-title">Tracker: ${giraffe.myTracker.name}</h6>
		<hr />
		<h4 class="card-header">Parentage (if known)</h4>
		<h6 class="card-title">Mother:  ${giraffe.mother.name} of ${giraffe.mother.location.name}</h6>
		<h6 class="card-title">Father:  ${giraffe.father.name} of ${giraffe.father.location.name}</h6>
		<hr />
		<h6 class="card-title">Year of Death (approx): ${giraffe.death_year}</h6>
		<h6 class="card-title">Cause of Death:  ${giraffe.deathCause}</h6>
		
			</div>
	</div>
		
	<button class="btn btn-danger"><a href="/giraffe/edit/${giraffe.id}">Edit This Giraffe</a></button>	

	<a href="/giraffe" class="btn btn-danger">Dashboard</a>
	<a href="/logout" class="btn btn-danger">Logout</a>
</body>
</html>