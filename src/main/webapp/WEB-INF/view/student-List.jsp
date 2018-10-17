<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>List Student</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Student List</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<button class="add-button"
				onclick="window.location.href='StudentForm';return false;">Add
				Student</button>
			<br>
			<form:form action="search" method="POST">
				Search Student : <input type="text" name="searchName" />
				<input type="submit" value="Search" class="add-button" />
			</form:form>
			<table class="table table-striped">
				<caption>
					<h3>Result (Student):</h3>
				</caption>

				<tr class="tr tr-success">
					<th>Id</th>
					<th>Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<tbody>
					<c:forEach items="${studentList}" var="temp">
						<c:url var="updateLink" value="/updateStuent">
							<c:param name="studentId" value="${temp.id}"></c:param>
						</c:url>
						<tr>
							<td>${temp.id}</td>
							<td>${temp.firstName} ${temp.lastName}</td>
							<td>${temp.emailId}</td>
							<%-- 	<td><a class="btn btn-info"
								href="${pageContext.request.contextPath}/update-person?id=${temp.id}">Update</a>
								<a class="btn btn-danger"
								onclick="return confirm('Are you sure you want to delete?')"
								href="/StudentRegistration/delete-person?id=${temp.id}">Delete</a>
							</td> --%>
							<td><a href="${updateLink}">Update</a> <a
								class="btn btn-danger"
								onclick="return confirm('Are you sure you want to delete?')"
								href="${pageContext.request.contextPath}/delete-person?id=${temp.id}">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
				<tr>
					<td><a class="btn btn-info" href='getAllStudent'>refresh</a></td>
					<td><a class="btn btn-info" href='/StudentRegistration'>Home</a></td>
				</tr>
			</table>
		</div>
		<a href="${pageContext.request.contextPath}/viewemp/1">1</a> 
		<a href="/SpringMVC/viewemp/2">2</a>
		<a href="/SpringMVC/viewemp/3">3</a>
	</div>
</body>
</html>