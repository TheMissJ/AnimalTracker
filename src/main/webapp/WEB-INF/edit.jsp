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
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2>Edit ${giraffe.name} from the ${giraffe.location}</h2>
		<p>Not all fields can be changed. If data is incorrect, send an
			email to the admin.</p>
		<p>Changing some of this data could corrupt the study. Be careful
			before saving changes!</p>
		<br>
		<form:form method="POST" action="/new" modelAttribute="giraffe">
			<div class="form-group">
				<form:label path="birth_year">Birth Year (approx):     ${giraffe.birth_year}</form:label>


				<div class="form-group">
					<form:label path="height">Height (m):					</form:label>
		<form:errors path="height" />
						<form:input class="form-control" path="height" />

				</div>

				<div class="form-group">
					<form:label path="weight">Weight (kg):					</form:label>
		<form:errors path="weight" />
						<form:input class="form-control" path="weight" />

				</div>
				<div>
					<form:label path="gender"> Gender:   ${giraffe.gender}</form:label>
				</div>
				<div>
					<form:label path="species"> Species:   ${giraffe.species}</form:label>
					<form:label path="subSpecies"> Sub-Species:   ${giraffe.subSpecies}</form:label>
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
					<form:label path="tracker">Tracker:					</form:label>
					<form:errors path="tracker" />
						<form:input class="form-control" path="tracker" />

				</div>

				<h4>Parentage (if known)</h4>

				<div class="form-group">
					<form:label path="mother">Mother:					</form:label>
					<form:errors path="mother" />
						<form:input class="form-control" path="mother" />

				</div>

				<div class="form-group">
					<form:label path="father">Father:					</form:label>
					<form:errors path="father" />
						<form:input class="form-control" path="father" />

				</div>

				<div class="form-group">
					<form:label path="deceased">Deceased?</form:label>
					<form:checkbox path="deceased" />
					<form:errors path="deceased" />
				</div>

				<div class="form-group">
					<form:label path="death_year">Year of Death:					</form:label>
					<form:errors path="death_year" />
						<form:input class="form-control" path="death_year" />

				</div>

				<div class="form-group">
					<form:label path="deathCause">Cause:					</form:label>
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

				<button class="btn btn-danger">Save</button>

			</div>
		</form:form>
	</div>


</body>
</html>