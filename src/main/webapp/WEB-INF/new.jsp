<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="author" content="Jessica LaPlante">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/simplex/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<title>Add A New Giraffe</title>
</head>
<body class="background-img">
	<br />
	<br />
	<div class="jumbotron">
		<h1 class="text-center">Add Giraffe</h1>

		<form:form method="POST" action="/giraffe/new" modelAttribute="giraffe">
			<div class="row">
				<div class="col-md-6">

					<div class="form-group">
						<form:label path="name">Giraffe Name:</form:label>
						<form:errors path="name" />
						<form:input class="form-control" path="name" />
					</div>

					<div class="form-group">
						<form:label path="birth_year">Birth Year (approx):	</form:label>
						<form:errors path="birth_year" />
						<form:input class="form-control" path="birth_year" />
					</div>

					<div class="form-group">
						<form:label path="height">Height (m):</form:label>
						<form:errors path="height" />
						<form:input class="form-control" path="height" />
					</div>

					<div class="form-group">
						<form:label path="weight">Weight (kg):</form:label>
						<form:errors path="weight" />
						<form:input class="form-control" path="weight" />
					</div>

					<div class="form-group">
						<form:label path="gender">Gender:</form:label>
						<form:errors path="gender" />
						<form:select class="form-control" path="gender">
							<option value="F">F</option>
							<option value="M">M</option>
						</form:select>
					</div>
				</div>
				<div class="column">
					<p></p>
				</div>
				<div class="col-md-6">

					<div class="form-group">
						<form:label path="species">Species:</form:label>
						<form:errors path="species" />
						<form:select class="form-control" path="species">
							<option value="Masai">Masai</option>
							<option value="NorthernKordofan">Northern-Kordofan</option>
							<option value="NorthernNubian">Northern-Nubian</option>
							<option value="NorthernWestAfrican">Northern-West
								African</option>
							<option value="SouthernAngolan">Southern-Angolan</option>
							<option value="SouthernSouthAfrican">Southern-South
								African</option>
							<option value="Reticulated">Reticulated</option>
						</form:select>
					</div>

					<div class="form-group">
						<form:label path="location">Location:</form:label>
						<form:errors path="location" />
						<form:select class="form-control" path="location">
							<c:forEach items="${locations}" var="location">
								<option value="${location.id}">${location.name}</option>
							</c:forEach>
						</form:select>
					</div>

					<div class="form-group">
						<form:label path="myTracker">Tracker:
				<form:errors path="myTracker" />
							<form:select class="form-control" path="myTracker">
								<c:forEach items="${trackers}" var="tracker">
									<option value="${tracker.id}">${tracker.serialNum}</option>
								</c:forEach>
							</form:select>
						</form:label>
					</div>

					<h4>Parentage (if known)</h4>

					<div class="form-group">
						<form:label path="mother">Mother:	</form:label>
						<form:errors path="mother" />
						<form:select class="form-control" path="mother">
							<c:forEach items="${giraffes}" var="females">
								<c:choose>
									<c:when test="${females.gender == 'M' }">
									</c:when>
									<c:otherwise>
										<option value="${females.id}">${females.name} of ${females.location.name}, ${females.gender}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</form:select>

					</div>

					<div class="form-group">
						<form:label path="father">Father:</form:label>
						<form:errors path="father" />
						<form:select class="form-control" path="father">
							<c:forEach items="${giraffes}" var="males">
								<c:choose>
									<c:when test="${males.gender == 'F' }">
									</c:when>
									<c:otherwise>
										<option value="${males.id}">${males.name} of ${males.location.name}, ${males.gender}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</form:select>
					</div>

				</div>
			</div>





			<button class="btn btn-danger">Save</button>
		</form:form>
	</div>
	<br />

	<a href="/giraffe" class="btn btn-danger">Dashboard</a>
	<a href="/logout" class="btn btn-danger">Logout</a>
</body>
</html>