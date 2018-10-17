<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Student</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
</head>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Student Form</h2>
		</div>
	</div>
	<div id="container">
		<form:form action="submitform" modelAttribute="student" method="POSt">
			<table>
				<tbody>
					<tr>
						<td>First Name</td>
						<td><form:input path="firstName" /></td>
						<td><form:errors path="firstName" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Last Name</td>
						<td><form:input path="lastName" /></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><form:input path="emailId" />
					</tr>
					<tr>
						<td><label></label></td>
						<td>
						<input type="submit" value="Submit" class="save" /></td>
					</tr>
				</tbody>
			</table>

		</form:form>
	</div>
	<div style="clear;both;">
	<p>
	<a href="${pageContext.request.contextPath}">Back to home page</a>
	</p>
	
</div>
</body>
</html>