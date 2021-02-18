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
<title>Show Conservation Group Information</title>
</head>
<body>
	<h2>${congroup.name}</h2>
	<br>
	<h4>Email: ${congroup.email}</h4>
	<h4>Phone: ${congroup.phone}</h4>
	<br />
	<h4>Street: ${congroup.street1}</h4>
	<h4>Street (cont): ${congroup.street2 }</h4>
	<h4>City:  ${congroup.city }</h4>
	<h4>State:  ${congroup.state }</h4>
	<h4>Country:  ${congroup.country }</h4>
	<h4>Postal Code: ${congroup.postalcode }</h4>
	
	<p>To change your contact info, please email <a href:"mailto:jess@jess.com">the admin</a>.</p>
	
	<br />
	<br />
	<a href="/giraffe">Dashboard</a>
	<br />
	<a href="/logout">Logout</a>
</body>
</html>