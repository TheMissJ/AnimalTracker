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
<title>Edit Giraffe Page</title>
</head>
<body class="background-img">
	<br />
	<br />
	<div class="jumbotron">
		<h2 class="text-center">Edit ${giraffe.name} from the ${giraffe.location.name}</h2>
		<p class="text-center">
			Not all fields can be changed. If data is incorrect, send an email to
			<a href="mailto:jess@jess.com">the admin</a>.
		</p>
		<p class="text-center">Changing some of this data could corrupt
			the study. Be careful before saving changes!</p>
		<br>

		<form:form method="POST" action="/giraffe/edit/${giraffe.id}" modelAttribute="giraffe">

			<div class="row">
				<div class="col-md-6">

					<div class="form-group">
						<form:label path="birth_year">Birth Year (approx): ${giraffe.birth_year}</form:label> 
						<form:errors path="birth_year" />
						<form:input type="hidden" class="form-control" path="birth_year" />
					</div>
					
					<div class="form-group">
						<form:label path="gender">Gender: ${giraffe.gender}</form:label>
						<form:errors path="gender" />
						<form:input type="hidden" class="form-control" path="gender" />
					</div>
					
					<div class="form-group">
						<form:label path="species">Species: ${giraffe.species}</form:label>
						<form:errors path="species" />
						<form:input type="hidden" class="form-control" path="species" />
					</div>
					
					<div class="form-group">
						<form:errors path="name" />
						<form:input type="hidden" class="form-control" path="name" />
					</div>
					
					<div class="form-group">
						<form:errors path="notes" />
						<form:input type="hidden" class="form-control" path="notes" />
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
						<form:label path="location">Location:</form:label>
						<form:errors path="location" />
						<form:select class="form-control" path="location">
							<option value="${giraffe.location.id}">${giraffe.location.name}</option>
							<c:forEach items="${locations}" var="location">
								<c:choose>
									<c:when test="${location.id == giraffe.location.id}">
									</c:when>
									<c:otherwise>
										<option value="${location.id}">${location.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</form:select>
					</div>
				</div>

				<div class="col-md-6">
					<div class="form-group">
						<form:label path="myTracker">Tracker:</form:label>
						<form:errors path="myTracker" />
						<form:select class="form-control" path="myTracker">
							<c:forEach items="${trackers}" var="tracker">
								<option value="${tracker.id}">${tracker.name}</option>
							</c:forEach>
						</form:select>

					</div>

					<h4>Parentage (if known)</h4>

					<div class="form-group">
						<form:label path="mother">Mother:</form:label>
						<form:errors path="mother" />
						<form:select class="form-control" path="mother" >
							<option value="${giraffe.mother.id}">${giraffe.mother.name} of ${giraffe.mother.location.name}</option>
							<c:forEach items="${giraffes}" var="giraffes">
								<c:choose>
									<c:when test="${giraffes.gender == 'M'}">
									</c:when>
									<c:otherwise>
										<option value="${giraffes.id}">${giraffes.name} of ${giraffes.location.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</form:select>
					</div>

					<div class="form-group">
						<form:label path="father">Father:</form:label>
						<form:errors path="father" />
						<form:select class="form-control" path="father" >
							<option value="${giraffe.father.id}">${giraffe.father.name} of ${giraffe.father.location.name}</option>
							<c:forEach items="${giraffes}" var="giraffes">
								<c:choose>
									<c:when test="${giraffes.gender == 'F'}">
									</c:when>
									<c:otherwise>
										<option value="${giraffes.id}">${giraffes.name} of ${giraffes.location.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</form:select>
					</div>
	</div>
	</div>
	<div class="row">
	<div class="col-md-6">
					<div class="form-group">
						<form:label path="deceased">Deceased?</form:label>
						<form:select path="deceased">
							<option value="No">No</option>
							<option value="Yes">Yes</option>
						</form:select>
						<form:errors path="deceased" />
					</div>
				</div>
				
				<div class="container">
					<c:if test="${this.deceased == true}">
						<div class="form-group">
							<form:label path="death_year">Year of Death:</form:label>
							<form:errors path="death_year" />
							<form:input class="form-control" path="death_year" />

						</div>

						<div class="form-group">
							<form:label path="deathCause">Cause:</form:label>
							<form:errors path="deathCause" />
							<form:select class="form-control" path="deathCause">
								<option value="unknown">Unknown</option>
								<option value="natureTrauma">Trauma:Nature</option>
								<option value="humanTrauma">Trauma:Human</option>
								<option value="neonatal">Neonatal Incident</option>
								<option value="infection">Infection</option>
								<option value="disease">Disease</option>
								<option value="otherTrauma">Trauma:Other</option>
							</form:select>
						</div>
					</c:if>
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