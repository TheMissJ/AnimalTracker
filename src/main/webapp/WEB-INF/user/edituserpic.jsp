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
<link rel="stylesheet" href="/css/style.css">
<title>Edit Conservation Staff Picture</title>
</head>
<body class="background-img">
	<br />
	<br />

	<div class="jumbotron">
		<h1 class="text-center">Edit Your Picture, ${user.firstName}
			${user.lastName}</h1>

		<br />
		<h4>Staff Photo</h4>
			<p><img src="${user.profilePic}" height="300" width="350"></p>
			<form method="POST" action="/user/upload/{id}" enctype="multipart/form-data">
				<div class="form-data">Select File: <input type="file" name="pic" class="form-control-file" id="inlineFormInput">
				</div>
				<button class="btn btn-danger">Upload Picture</button>
			</form>
	</div>
				

	<br />
	<a href="/giraffe" class="btn btn-danger">Dashboard</a>
	<a href="/logout" class="btn btn-danger">Logout</a>

</body>
</html>