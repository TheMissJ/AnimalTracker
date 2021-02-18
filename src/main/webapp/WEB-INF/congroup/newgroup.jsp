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
	<h2>Add Group</h2>
	
	<form:form method="POST" action="/congroup/new" modelAttribute="congroup">
	<div class="form-group">
		<form:label path="name">Group Name:
		<form:errors path="name"/> 
		<form:input class="form-control" path="name"/></form:label>
	</div>
	
	<div class="form-group">
		<form:label path="email">Email Address:
		<form:errors path="email"/> 
		<form:input class="form-control" path="email"/></form:label>
	</div>	
	
	<div class="form-group">
		<form:label path="phone">Phone Number:
		<form:errors path="phone"/> 
		<form:input class="form-control" path="phone"/></form:label>
	</div>
	
	<div class="form-group">
		<form:label path="street1">Street Address:
		<form:errors path="street1"/> 
		<form:input class="form-control" path="street1"/></form:label>
	</div>
	
	<div class="form-group">
		<form:label path="street2">Street (cont):
		<form:errors path="street2"/> 
		<form:input class="form-control" path="street2"/></form:label>
	</div>
	
	<div class="form-group">
		<form:label path="city">City:
		<form:errors path="city"/> 
		<form:input class="form-control" path="city"/></form:label>
	</div>
	
	<div class="form-group">
		<form:label path="state">State/Province:
		<form:errors path="state"/> 
		<form:input class="form-control" path="state"/></form:label>
	</div>
	
		<div class="form-group">
		<form:label path="country">Country:
		<form:errors path="country"/> 
		<form:input class="form-control" path="country"/></form:label>
	</div>
	
	<div class="form-group">
		<form:label path="postalcode">Postal Code:
		<form:errors path="postalcode"/> 
		<form:input class="form-control" path="postalcode"/></form:label>
	</div>
		
	<button>Save</button> 
	</form:form>
</div>
</body>
</html>