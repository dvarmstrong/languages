<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Languages</title>
</head>
<body> 
	<table>
		<tr>
			<th>Name</th>
			<th>Creator</th>
			<th>Version</th>
			<th>Action</th>
		</tr>
		<c:forEach var="language" items="${languages}">
		<tr>
			<td><a href="/languages/${language.id}"><c:out value="${language.name }"></c:out></a></td>
			<td><c:out value="${language.creator }"></c:out></td>
			<td><c:out value="${language.version }"></c:out></td>
			<td><a href="/#">edit</a>
			<a href="/#">delete</a></td>
		</tr>
		</c:forEach>
	</table>
	<br>
	<h1>Enter your Software or Language !</h1>
	<form:form action="/languages" methods="post" modelAttribute="language">
		<p>
			<form:label path="name">Name</form:label>
			<form:errors path="name"/>
			<form:input path="name"/>
		</p>
		<p>
			<form:label path="creator">Creator</form:label>
			<form:errors path="creator"/>
			<form:input path="creator"/>
		</p>
		<p>
			<form:label path="version">Version</form:label>
			<form:errors path="version"/>
			<form:input path="version"/>
		</p>
		<input type="submit" value="Submit"/>
	</form:form>
</body>