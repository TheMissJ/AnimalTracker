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
<title>Show Conservation Employee Profile</title>
</head>
<body class="background-img">
	<br />
	<br />

	<div class="jumbotron">
	<h1 class="text-danger text-center"><strong>The Giraffe Tracker Database</strong></h1>
	
	<div class="row">
		<div class="col-md-6">
		
			<h3>User: ${user.firstName} ${user.lastName}</h3>
			<br>
			<h4>Email: ${user.email}</h4>
			<h4>Group: ${user.employer.name }</h4>
		
		</div>
		
		<div class="col-md-6">
			<p><img src="${user.profilePic.image_url}" height="300" width="350"></p>
			<a href="/user/upload/${user.id}" class="btn btn-danger">Edit Picture</a>
		</div>
	</div>

		
		<br />
		<a href="/user/edit/${user.id}" class="btn btn-danger">Edit Account</a>
	
	
	</div>
	<br />
	<a href="/giraffe" class="btn btn-danger">Dashboard</a>
	<a href="/logout" class="btn btn-danger">Logout</a>
</body>
</html>