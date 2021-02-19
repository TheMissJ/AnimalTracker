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

		<h2>Meet ${giraffe.name} from the ${giraffe.location}</h2>
		<br>
		<h4>Birth Year (approx):  ${giraffe.birth_year}</h4>
		<h4>Height (m):  ${giraffe.height}</h4>
		<h4>Weight (kg):  ${giraffe.weight}</h4>
		<h4>Gender:  ${giraffe.gender}</h4>
		<h4>Species:  ${giraffe.species }</h4>
		<h4>Sub-Species:  ${giraffe.subSpecies}</h4>
		<h4>Location:   ${giraffe.location}</h4>
		<h4>Tracker: ${tracker}</h4>
		
		<h3>Parentage (if known</h3>
		<h4>Mother:  ${giraffe.mother}</h4>
		<h4>Father:  ${giraffe.father}</h4>
		
		<h4>Year of Death (approx): ${giraffe.death_year}</h4>
		<h4>Cause of Death:  ${giraffe.deathCause}</h4>
		
<button class="btn btn-danger"><a href="/giraffe/edit/{giraffe.id}">Edit This Giraffe</button>	


</div>
</body>
</html>