<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
	<head>
		<link rel="stylesheet" href="<spring:theme code='styleSheet'/>" type="text/css"/>
	</head>
<body>

<p>
	<a href="/StudentAdmissionSpringMVC/admissionForm.html?siteTheme=green">Green</a>
	<a href="/StudentAdmissionSpringMVC/admissionForm.html?siteTheme=red">Red</a>
</p>

<a href="/StudentAdmissionSpringMVC/admissionForm.html?siteLanguage=en">English</a>
<a href="/StudentAdmissionSpringMVC/admissionForm.html?siteLanguage=fr">French</a>
	<h1>  <spring:message code="label.header" /></h1>
	<h3>${headerMessage}</h3>
	<form:errors path="student1.*"/>
	
	<form action="/StudentAdmissionSpringMVC/submitAdmissionForm.html" method="post">
		<p>
			<spring:message code="label.studentName" /><input type="text" name="studentName" />
		</p>
		<p>
			<spring:message code="label.studentHobby" /><input type="text" name="studentHobby" />
		</p>
		<p>
			 <spring:message code="label.studentMobile" /> <input type="text" name="studentMobile" />
		</p>
		<p>
			<spring:message code="label.studentDOB" /> <input type="text" name="studentDOB" />
		</p> 
		<p>
			<spring:message code="label.studentSkills" />
			<select name="studentSkills" multiple>
			<option value="java core">JAVA CORE</option>
			<option value="spring core">SPRING CORE</option>
			<option value="spring mvc">SPRING MVC</option>
			</select>
		</p>	
		
		<p>
			<spring:message code="label.studentAddress" />
			<br><br>
			<spring:message code="label.Line1" /> <input type="text" name="address.line1"/>
			<spring:message code="label.City" /> <input type="text" name="address.city"/>
			<spring:message code="label.State" /> <input type="text" name="address.state"/>
			<spring:message code="label.Zip" /> <input type="text" name="address.zip"/>
		</p>
		<input type="submit" value=<spring:message code="label.submit"/>>
	</form>
</body>
</html>